public class Exam0101BookStore {
    /*Fields*/
    private String name;
    private String address;

    /*constructor*/
    public Exam0101BookStore() {
        System.out.printf("Book Store Constructor Invoke.. %n");
    }

    /*Method Setter name*/
    public void setName(String name) {
        this.name = name;
    }

    /*Method Getter name*/
    public String getName() {
        return this.name;
    }

    /*Method Setter address*/
    public void setAddress(String address) {
        this.address = address;
    }

    /*Method Getter address*/
    public String getAddress() {
        return this.address;
    }
}
