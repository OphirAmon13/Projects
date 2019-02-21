package edu.yu.intro;

import java.util.Random;

public class AdditionQuestion implements IntQuestion{
    private int firstNumber;
    private int secondNumber;

    public AdditionQuestion(){
        Random random = new Random();
        this.firstNumber = random.nextInt(100);
        this.secondNumber = random.nextInt(100);
    }

    public String getQuestion(){
        return firstNumber + " + " + secondNumber;
    }

    public int getCorrectAnswer(){
        return firstNumber + secondNumber;
    }
}
