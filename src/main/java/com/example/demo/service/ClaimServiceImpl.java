@Service
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepo claimRepo;
    private final PolicyRepo policyRepo;

    public ClaimServiceImpl(ClaimRepo claimRepo,
                            PolicyRepo policyRepo) {
        this.claimRepo = claimRepo;
        this.policyRepo = policyRepo;
    }

    @Override
    public Claim createClaim(Claim claim) {

        if (claim.getPolicy() == null ||
            claim.getPolicy().getId() == null) {
            throw new IllegalArgumentException("invalid policy");
        }

        Policy policy = policyRepo.findById(claim.getPolicy().getId())
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        claim.setPolicy(policy);
        claim.setStatus("PENDING");
        return claimRepo.save(claim);
    }

    @Override
    public Claim getClaim(Long claimId) {
        return claimRepo.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public List<Claim> getAllClaims() {
        return claimRepo.findAll();
    }
}
