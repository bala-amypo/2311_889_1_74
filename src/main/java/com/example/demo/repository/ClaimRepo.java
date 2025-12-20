public interface ClaimRepo extends JpaRepository<Claim, Long> {

    Optional<Claim> findById(Long id);
}
