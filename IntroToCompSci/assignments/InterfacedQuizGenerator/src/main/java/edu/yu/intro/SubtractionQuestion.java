package edu.yu.intro;

import java.util.Random;

public class SubtractionQuestion implements IntQuestion{
    private int firstNumber;
    private int secondNumber;

    public SubtractionQuestion(){
        Random random = new Random();
        this.firstNumber = random.nextInt(100);
        this.secondNumber = random.nextInt(100);

        if(firstNumber < secondNumber){
            int temp = firstNumber;
            firstNumber = secondNumber;
            secondNumber = temp;
        }
    }

    public String getQuestion(){
        return firstNumber + " - " + secondNumber;
    }

    public int getCorrectAnswer(){
        return firstNumber - secondNumber;
    }
}
