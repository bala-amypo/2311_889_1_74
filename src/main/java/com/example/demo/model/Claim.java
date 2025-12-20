@Entity
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Policy policy;

    @NotNull
    private LocalDate claimDate;

    @Positive
    private Double claimAmount;

    private String description;

    private String status = "PENDING";

    @AssertTrue(message = "invalid date")
    public boolean isValidDate() {
        return !claimDate.isAfter(LocalDate.now());
    }

    // getters & setters
}
