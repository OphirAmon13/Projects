package edu.yu.intro;

import java.util.Scanner;

public class ObjectifiedQuizGenerator {
    public final static int N_QUIZ_QUESTIONS = 10;

    public static void main(String[] args) {
        AdditionQuestion[] additionQuestions = new AdditionQuestion[N_QUIZ_QUESTIONS];
        int[] userAnswers = new int[N_QUIZ_QUESTIONS];

        createQuiz(additionQuestions);
        administerQuiz(additionQuestions, userAnswers);
        boolean[] answers = gradeQuiz(additionQuestions, userAnswers);
        printTestResults(additionQuestions, userAnswers, answers);
    }

    public static void createQuiz(AdditionQuestion[] additionQuestions){
        for(int i = 0; i < N_QUIZ_QUESTIONS; i++){
            AdditionQuestion additionQuestion = new AdditionQuestion();
            additionQuestions[i] = additionQuestion;
        }
    }

    public static void administerQuiz(AdditionQuestion[] additionQuestions, int[] userAnswers){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the addition quiz! \n");
        for(int i = 1; i <= N_QUIZ_QUESTIONS; i++){
            AdditionQuestion additionQuestion = additionQuestions[i - 1];
            System.out.print("Question " + i + ": What is " + additionQuestion.getQuestion() + " ? ");
            userAnswers[i - 1] = scanner.nextInt();
        }
        System.out.println("");
    }

    public static boolean[] gradeQuiz(AdditionQuestion[] additionQuestions, int[] userAnswers){
        boolean[] answers = new boolean[N_QUIZ_QUESTIONS];
        for(int i = 0; i < N_QUIZ_QUESTIONS; i++){
                AdditionQuestion additionQuestion = additionQuestions[i];
            if(additionQuestion.getCorrectAnswer() == userAnswers[i]) {
                answers[i] = true;
            }
        }
        return answers;
    }

    public static void printTestResults(AdditionQuestion[] additionQuestions, int[] userAnswers, boolean[] answers){
        System.out.println("Here are the correct answers:");
        int counter = 0;
        for(int i = 1; i <= N_QUIZ_QUESTIONS; i++) {
            AdditionQuestion additionQuestion = additionQuestions[i - 1];
            if (answers[i - 1]) {
                System.out.println("Question " + i + ": " + additionQuestion.getQuestion() + " = "
                        + additionQuestion.getCorrectAnswer() + ". " + "You were CORRECT.");
                counter++;
            } else {
                System.out.println("Question " + i + ": " + additionQuestion.getQuestion() + " = "
                        + additionQuestion.getCorrectAnswer() + ". " + "You said " + userAnswers[i - 1]
                        + ", which is INCORRECT.");
            }
        }
        System.out.println("You got " + counter + " questions correct.");
        System.out.println("Your grade on the quiz is " + (counter * 10));
    }

}
