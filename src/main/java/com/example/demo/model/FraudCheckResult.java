@Entity
public class FraudCheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Claim claim;

    private Boolean isFraudulent;
    private String triggeredRuleName;
    private String rejectionReason;

    private LocalDateTime checkedAt;

    @PrePersist
    public void onCreate() {
        checkedAt = LocalDateTime.now();
    }

    // getters & setters
}
