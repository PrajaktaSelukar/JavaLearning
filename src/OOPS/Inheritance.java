package OOPS;

public class Inheritance {
    static class  Animal {
        private String name;

        public Animal(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public void sound() {
            System.out.println("Some generic sound");
        }
        public void eat() {
            System.out.println(name+" is eating");
        }
    }
    static class Dog extends Animal {
        private String breed;
        public Dog(String name, String breed) {
            super(name);
            this.breed = breed;
        }
        public String getBreed() {
            return breed;
        }
        @Override
        public void sound() {
            System.out.println(getName() +" says: Woof!");
        }
        public void fetch() {
            System.out.println(getName() + " is fetching the ball");
        }
    }
    static class Cat extends Animal {
        private boolean isIndoor;
        public Cat(String name, boolean isIndoor) {
            super(name);
            this.isIndoor = isIndoor;
        }
        public boolean getIsIndoor() {
            return isIndoor;
        }
        @Override
        public void sound() {
            System.out.println(getName() +" says: Meow!");
        }
        public void purr() {
            System.out.println(getName() + " is purring");
        }
    }
    public static void main(String[] args) {
        // Problem 3 — Inheritance
        Animal a = new Animal("Generic");
        Dog d    = new Dog("Bruno", "Labrador");
        Cat c    = new Cat("Whiskers", true);

        a.sound();
        d.sound();
        c.sound();
        a.eat();
        d.eat();
        c.eat();

        System.out.println("Breed of dog is "+ d.getBreed());

        boolean isIndoor = c.getIsIndoor();
        if(isIndoor) {
            System.out.println("Cat is indoor");
        } else {
            System.out.println("Cat is NOT indoor");
        }

        Animal polymorphic = new Dog("Rex", "Poodle");
        polymorphic.sound();
        // uses Dog's method -> uses Polymorphism
    }
}
