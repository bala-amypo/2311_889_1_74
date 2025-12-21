@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {

    private final ClaimRepo claimRepo;
    private final FraudRuleRepo fraudRuleRepo;
    private final FraudCheckResultRepo fraudCheckResultRepo;

    public FraudDetectionServiceImpl(ClaimRepo claimRepo,
                                     FraudRuleRepo fraudRuleRepo,
                                     FraudCheckResultRepo fraudCheckResultRepo) {
        this.claimRepo = claimRepo;
        this.fraudRuleRepo = fraudRuleRepo;
        this.fraudCheckResultRepo = fraudCheckResultRepo;
    }

    @Override
    @Async
    public FraudCheckResult evaluateClaim(Long claimId) {

        Claim claim = claimRepo.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        FraudCheckResult result = new FraudCheckResult();
        result.setClaim(claim);

        for (FraudRule rule : fraudRuleRepo.findAll()) {

            if ("claimAmount".equals(rule.getConditionField())) {

                double limit = Double.parseDouble(rule.getValue());

                if (claim.getClaimAmount() > limit) {
                    result.setIsFraudulent(true);
                    result.setTriggeredRuleName(rule.getRuleName());
                    result.setRejectionReason("High claim amount");
                    return fraudCheckResultRepo.save(result);
                }
            }
        }

        result.setIsFraudulent(false);
        return fraudCheckResultRepo.save(result);
    }

    @Override
    public FraudCheckResult getResultByClaim(Long claimId) {
        return fraudCheckResultRepo.findByClaimId(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }
}
