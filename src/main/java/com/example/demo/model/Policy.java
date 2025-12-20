@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank
    private String policyNumber;

    @NotBlank
    private String policyType;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private List<Claim> claims = new ArrayList<>();

    @AssertTrue(message = "invalid date")
    public boolean isValidDate() {
        return endDate.isAfter(startDate);
    }

    // getters & setters
}
