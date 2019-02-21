package edu.yu.intro;

public class Human extends Animal{
    private String name;
    private String language;

    public Human(String name, String language){
        super();

        this.name = name;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public String introduce(){
        return "My name is " + name + " and I speak " + language;
    }

    @Override
    public String makeSound() {
        return "I'm a human";
    }

    @Override
    public String respond(String othersName) {
        return "Hello " + othersName + ", I'm " + name + ".";
    }

    public static void main(String[] args) {
        System.out.println("Animal is the base class and Human is the subclass\n");

        System.out.println("Output for Animal methods:");
        Animal animal = new Animal();
        System.out.println("Animal's initial age is: " + animal.getAge());
        animal.incrementAge();
        System.out.println("After incrementing, Animal's age is: " + animal.getAge());
        System.out.println("Animal's alive status: " + animal.isAlive());
        animal.dead();
        System.out.println("Animal's alive status after dead() is called: " + animal.isAlive());

        System.out.println("\nOutput for Human's inherited methods:");
        Human human = new Human("Bob", "English");
        System.out.println("Human's initial age is: " + human.getAge());
        human.incrementAge();
        System.out.println("After incrementing, Human's age is: " + human.getAge());
        System.out.println("Human's alive status: " + human.isAlive());
        human.dead();
        System.out.println("Human's alive status after dead() is called: " + human.isAlive());

        System.out.println("\nAnimal's makeSound() vs Human's overridden makeSound()");
        System.out.println("Animal makes this sound: " + animal.makeSound());
        System.out.println("Human makes this sound: " + human.makeSound());

        System.out.println("\nAnimal's respond() vs Human's overridden respond()");
        System.out.println("Animal's response to Joe: " + animal.respond("Joe"));
        System.out.println("Human's response to Joe: " + human.respond("Joe"));

        System.out.println("\nOutput for Human's exclusive method:");
        System.out.println(human.introduce());
    }
}
