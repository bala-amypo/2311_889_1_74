@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepo fraudRuleRepo;

    public FraudRuleServiceImpl(FraudRuleRepo fraudRuleRepo) {
        this.fraudRuleRepo = fraudRuleRepo;
    }

    @Override
    public FraudRule addRule(FraudRule rule) {
        return fraudRuleRepo.save(rule);
    }

    @Override
    public List<FraudRule> getAllRules() {
        return fraudRuleRepo.findAll();
    }
}
