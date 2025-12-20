public interface FraudDetectionService {

    FraudCheckResult evaluateClaim(Long claimId);

    FraudCheckResult getResultByClaim(Long claimId);
}
