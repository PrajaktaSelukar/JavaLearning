package OOPS;

import javax.xml.namespace.QName;

public class ClassConstructors {
    static class Person {
        private String name;
        private int age;
        private String city;

        public Person(String name, int age, String city) {
            this.name = name;
            this.age = age;
            this.city = city;
        }
        public Person(String name, int age) {
            this(name, age, "Unknown");
        }

        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }
        public String getCity() {
            return city;
        }
        public void setCity(String city) {
            if(city == null || city.isBlank()) return;
            this.city = city;
        }
        public void introduce() {
            System.out.println("Hi, I'm " + name + ", " + age + " years old from " + city + ".");
        }
        @Override
        public String toString() {
            return "Person{name="+name+", age="+age+", city="+city+"}";
        }
    }
    public static void main(String[] args) {
        // Problem 1: Class & Constructor
        Person person1 = new Person("John", 25, "Manhattan");
        person1.introduce();
        Person person2 = new Person("Jason", 30);
        person2.introduce();
        person2.setCity("Seattle");
        System.out.println(person1);
        System.out.println(person2);
    }
}
