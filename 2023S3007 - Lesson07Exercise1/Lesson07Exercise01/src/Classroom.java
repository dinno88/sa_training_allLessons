public class Classroom {
    /* Fields */
    private String level;
    private String name;

    /* Constructor */
    public Classroom() {
        System.out.printf("Classroom Constructor invoke... %n");
    }

    /* Method Setter */
    public void setLevel(String level) {
        this.level = level;
    }

    /* Method Getter */
    public String getLevel() {
        return this.level;
    }

    /* Method Setter */
    public void setName(String name) {
        this.name = name;
    }

    /* Method Getter */
    public String getName() {
        return this.name;  // Corrected to return this.name
    }
}
