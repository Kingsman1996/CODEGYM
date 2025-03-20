public class Student {
    private int age;
    private String address;
    private String name;

    public Student() {
    }

    public Student(String name, int age, String address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student [age = " + age + ", name = " + name + ", address = " + address + "]";
    }
}
