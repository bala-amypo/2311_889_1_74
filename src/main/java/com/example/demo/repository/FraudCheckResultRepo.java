public interface FraudCheckResultRepo
        extends JpaRepository<FraudCheckResult, Long> {

    Optional<FraudCheckResult> findByClaimId(Long claimId);
}
