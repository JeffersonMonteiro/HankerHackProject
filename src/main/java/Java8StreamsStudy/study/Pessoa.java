package Java8StreamsStudy.study;

public class Pessoa {

    private String name;

    private int age;

    public Pessoa(String name) {
        this.name = name;
    }

    public Pessoa(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Pessoa() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
