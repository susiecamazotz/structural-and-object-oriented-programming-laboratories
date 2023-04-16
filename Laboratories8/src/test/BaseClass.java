package test;

public class BaseClass {
    String name;
    int age;

    public BaseClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "BaseClass{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    public void printNumber(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(number);
        }
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
}
