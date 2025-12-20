public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
