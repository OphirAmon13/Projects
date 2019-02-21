package edu.yu.intro;

import java.util.Random;
import java.util.Scanner;

/** "StaticQuizGenerator" for Yeshiva University.
*
* @author Ophir Amon
*/
public class StaticQuizGenerator{
    public final static int N_QUIZ_QUESTIONS = 10;

    public static void main(String[] args) {
        int[] firstNumbers = new int[N_QUIZ_QUESTIONS];
        int[] secondNumbers = new int[N_QUIZ_QUESTIONS];
        int[] userAnswers = new int[N_QUIZ_QUESTIONS];

        createQuiz(firstNumbers, secondNumbers);
        administerQuiz(firstNumbers, secondNumbers, userAnswers);
        boolean[] answers = gradeQuiz(firstNumbers, secondNumbers, userAnswers);
        printTestResults(firstNumbers, secondNumbers, userAnswers, answers);
    }

    public static void createQuiz(int[] firstNumbers, int[] secondNumbers){
        Random random = new Random();
        for(int i = 0; i < N_QUIZ_QUESTIONS; i++){
           firstNumbers[i] = random.nextInt(100);
           secondNumbers[i] = random.nextInt(100);
        }
    }

    public static void administerQuiz(int[] firstNumbers, int[] secondNumbers, int[] userAnswers){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the addition quiz! \n");
        for(int i = 1; i <= N_QUIZ_QUESTIONS; i++){
            System.out.print("Question " + i + ": What is " + firstNumbers[i - 1] + " + " + secondNumbers[i - 1] + " ? ");
            userAnswers[i - 1] = scanner.nextInt();
        }
        System.out.println("");
    }

    public static boolean[] gradeQuiz(int[] firstNumbers, int [] secondNumbers, int[] userAnswers){
        boolean[] answers = new boolean[N_QUIZ_QUESTIONS];
        for(int i = 0; i < N_QUIZ_QUESTIONS; i++){
            if(firstNumbers[i] + secondNumbers[i] == userAnswers[i]) {
                answers[i] = true;
            }
        }
        return answers;
    }

    public static void printTestResults(int[] firstNumbers, int[] secondNumbers, int[] userAnswers, boolean[] answers){
        System.out.println("Here are the correct answers:");
        int counter = 0;
        for(int i = 1; i <= N_QUIZ_QUESTIONS; i++) {
            if (answers[i - 1]) {
                System.out.println("Question " + i + ": " + firstNumbers[i - 1] + " + " + secondNumbers[i - 1] + " = "
                        + (firstNumbers[i - 1] + secondNumbers[i - 1]) + ". " + "You were CORRECT.");
                counter++;
            } else {
                System.out.println("Question " + i + ": " + firstNumbers[i - 1] + " + " + secondNumbers[i - 1] + " = "
                        + (firstNumbers[i - 1] + secondNumbers[i - 1]) + ". " + "You said " + userAnswers[i - 1]
                        + ", which is INCORRECT.");
            }
        }
        System.out.println("You got " + counter + " questions correct.");
        System.out.println("Your grade on the quiz is " + (counter * 10));
    }
}
