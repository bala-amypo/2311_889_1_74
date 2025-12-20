public interface ClaimService {

    Claim createClaim(Claim claim);

    Claim getClaim(Long claimId);

    List<Claim> getAllClaims();
}
