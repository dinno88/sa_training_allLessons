public class Student {
    /*fields*/
    private String nisn;
    private String name;
    private String gender;
    private String address;

    /*Constructor*/
    public Student() {
        System.out.printf("Student Constructor Invoke... %n");
    }

    /*Method Setter*/
    public void setNisn(String nisn) {
        this.nisn = nisn;
    }
    /*Method Getter*/    
    public String getNisn() {
        return this.nisn;
    }

    /*Method Setter*/
    public void setName(String name) {
        this.name = name;
    }

    /*Method Getter*/
    public String getName() {
        return this.name;
    }

    /*Method Setter*/
    public void setGender(String gender) {
        this.gender = gender;
    }

    /*Method Getter*/
    public String getGender() {
        return this.gender;
    }

    /*Method Setter*/
    public void setAddress(String address) {
        this.address = address;
    }

    /*Method Getter*/
    public String getAddress() {
        return this.address;
    }
}
