@Service
public class PolicyServiceImpl implements PolicyService {

    private final PolicyRepo policyRepo;
    private final UserRepo userRepo;

    public PolicyServiceImpl(PolicyRepo policyRepo,
                             UserRepo userRepo) {
        this.policyRepo = policyRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Policy createPolicy(Policy policy) {
        return policyRepo.save(policy);
    }

    @Override
    public List<Policy> getPoliciesByUser(Long userId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        return user.getPolicies();
    }
}
