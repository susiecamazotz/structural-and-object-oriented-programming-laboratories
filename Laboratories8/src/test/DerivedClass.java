package test;

public class DerivedClass extends BaseClass {
    String surname;

    public DerivedClass(String name, String surname, int age) {
        super(name, age);
        this.surname = surname;
    }


    public void presentYourself() {
        System.out.println("I'm " + this.name + " " + surname);
    }

    @Override
    public String toString() {
        return "DerivedClass{" + "name='" + name + '\'' + ", age=" + age + ", surname='" + surname + '\'' + '}';
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
