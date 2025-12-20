public interface PolicyService {

    Policy createPolicy(Policy policy);

    List<Policy> getPoliciesByUser(Long userId);
}
