@Entity
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String ruleName;

    @NotBlank
    private String conditionField;

    @NotBlank
    private String operator;

    @NotBlank
    private String value;

    @NotBlank
    private String severity;

    // ✅ REQUIRED by JPA
    public FraudRule() {}

    // ✅ Used by controller
    public FraudRule(String ruleName,
                     String conditionField,
                     String operator,
                     String value,
                     String severity) {
        this.ruleName = ruleName;
        this.conditionField = conditionField;
        this.operator = operator;
        this.value = value;
        this.severity = severity;
    }

    // getters & setters
}
