package edu.yu.intro;

import java.util.Random;
import java.util.Scanner;

public class InterfacedQuizGenerator {
    public final static int N_QUIZ_QUESTIONS = 10;

    public static void main(String[] args) {
        IntQuestion[] intQuestions = new IntQuestion[N_QUIZ_QUESTIONS];
        int[] userAnswers = new int[N_QUIZ_QUESTIONS];

        createQuiz(intQuestions);
        administerQuiz(intQuestions, userAnswers);
        boolean[] answers = gradeQuiz(intQuestions, userAnswers);
        printTestResults(intQuestions, userAnswers, answers);
    }

    public static void createQuiz(IntQuestion[] intQuestions){
        Random random = new Random();
        for(int i = 0; i < N_QUIZ_QUESTIONS; i++){
            if(random.nextInt(2) == 0){
                AdditionQuestion additionQuestion = new AdditionQuestion();
                intQuestions[i] = additionQuestion;
            }
            else{
                SubtractionQuestion subtractionQuestion = new SubtractionQuestion();
                intQuestions[i] = subtractionQuestion;
            }
        }
    }

    public static void administerQuiz(IntQuestion[] intQuestions, int[] userAnswers){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the addition quiz! \n");
        for(int i = 1; i <= N_QUIZ_QUESTIONS; i++){
            IntQuestion intQuestion = intQuestions[i - 1];
            System.out.print("Question " + i + ": What is " + intQuestion.getQuestion() + " ? ");
            userAnswers[i - 1] = scanner.nextInt();
        }
        System.out.println("");
    }

    public static boolean[] gradeQuiz(IntQuestion[] intQuestions, int[] userAnswers){
        boolean[] answers = new boolean[N_QUIZ_QUESTIONS];
        for(int i = 0; i < N_QUIZ_QUESTIONS; i++){
            IntQuestion intQuestion = intQuestions[i];
            if(intQuestion.getCorrectAnswer() == userAnswers[i]) {
                answers[i] = true;
            }
        }
        return answers;
    }

    public static void printTestResults(IntQuestion[] intQuestions, int[] userAnswers, boolean[] answers){
        System.out.println("Here are the correct answers:");
        int counter = 0;
        for(int i = 1; i <= N_QUIZ_QUESTIONS; i++) {
            IntQuestion intQuestion = intQuestions[i - 1];
            if (answers[i - 1]) {
                System.out.println("Question " + i + ": " + intQuestion.getQuestion() + " = "
                        + intQuestion.getCorrectAnswer() + ". " + "You were CORRECT.");
                counter++;
            } else {
                System.out.println("Question " + i + ": " + intQuestion.getQuestion() + " = "
                        + intQuestion.getCorrectAnswer() + ". " + "You said " + userAnswers[i - 1]
                        + ", which is INCORRECT.");
            }
        }
        System.out.println("You got " + counter + " questions correct.");
        System.out.println("Your grade on the quiz is " + (counter * 10));
    }
}
