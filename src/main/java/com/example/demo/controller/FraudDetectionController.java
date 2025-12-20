@RestController
@RequestMapping("/api/fraud-check")
public class FraudDetectionController {

    private final FraudDetectionService fraudDetectionService;

    public FraudDetectionController(FraudDetectionService fraudDetectionService) {
        this.fraudDetectionService = fraudDetectionService;
    }

    @PostMapping("/evaluate/{claimId}")
    public FraudCheckResult evaluateClaim(@PathVariable Long claimId) {
        return fraudDetectionService.evaluateClaim(claimId);
    }

    @GetMapping("/result/claim/{claimId}")
    public FraudCheckResult getResult(@PathVariable Long claimId) {
        return fraudDetectionService.getResultByClaim(claimId);
    }
}
