@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping
    public Policy createPolicy(@Valid @RequestBody Policy policy) {
        return policyService.createPolicy(policy);
    }

    @GetMapping("/user/{userId}")
    public List<Policy> getUserPolicies(@PathVariable Long userId) {
        return policyService.getPoliciesByUser(userId);
    }
}
