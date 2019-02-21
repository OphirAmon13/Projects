package edu.yu.intro;

public class Animal {
    private int age;
    private boolean alive;

    public Animal(){
        age = 0;
        alive = true;
    }

    public int getAge(){
        return age;
    }

    public boolean isAlive(){
        return alive;
    }

    public void incrementAge(){
        age++;
    }

    public void dead(){
        alive = false;
    }

    public String makeSound(){
        return "I'm an animal";
    }

    public String respond(String othersName){
        return makeSound();
    }
}
