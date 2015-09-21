package com.company;

import java.util.*;

public class Main {

    public static final int NUMBEROFTRIES = 1000000000;

    public static void main(String[] args) throws Exception {
        int successes = 0;
        for (int i = 0; i < NUMBEROFTRIES; i++) {
            int result = getResultOfSwap();
            if (result == 1) {
                successes++;
            } else if(result == 0) {
                i--;
            }
        }
        System.out.println("Rounds played = " + NUMBEROFTRIES);
        System.out.println("Successes = " + successes);
        System.out.println("Thats = " + (((float)successes/(float)NUMBEROFTRIES) * 100.0) + "%");
    }

    //Returns -1 if lost, 1 if won, 0 if 50-50
    public static int getResultOfSwap() throws Exception {
        Question question = new Question();
        Answer currentGuess = Answer.getRandomAnswer();
        //Swapping will result in loss if right Answer was guessed
        if (question.isRightAnswer(currentGuess)) {
            return -1;
        }

        question.elminateAnswers(2);

        //We know this case will be 50-50; we ignore it
        if (!question.isAvailableAnswer(currentGuess)) {
            return 0;
        }

        //Could just return 1 here; Using Methods here to really simulate.
        if (question.isRightAnswer(question.chooseAnyAvailableOtherThan(currentGuess))) {
            return 1;
        }
        throw  new Exception("Impossible Case");
    }

    public static int getRandomTo(int to) {
        return (int) (Math.random() * to);
    }

}

class Question {
    Answer answer;
    List<Answer> answers = new LinkedList<>();

    public Question() {
        answers.add(Answer.A);
        answers.add(Answer.B);
        answers.add(Answer.C);
        answers.add(Answer.D);
        this.answer = Answer.getRandomAnswer();
    }

    public boolean isRightAnswer(Answer answer) {
        return this.answer == answer;
    }

    public boolean isAvailableAnswer(Answer answer) {
        return answers.contains(answer);
    }

    public void elminateAnswers(int i) {
        for (int j = 0; j < i; j++) {
            eliminateAnswer();
        }
    }

    private void eliminateAnswer() {
        while (true) {
            int guess = Main.getRandomTo(answers.size());
            if (answers.get(guess) != answer) {
                answers.remove(guess);
                return;
            }
        }
    }

    public Answer chooseAnyAvailableOtherThan(Answer thisOne) throws Exception {
        for (Answer sampleAnswer : answers) {
            if (thisOne != sampleAnswer) {
                return sampleAnswer;
            }
        }
        throw new Exception("Answer not available " + thisOne);
    }

}

enum Answer {
    A, B, C, D;

    public static Answer getRandomAnswer() {
        int random = Main.getRandomTo(Answer.values().length);
        return Answer.values()[random];
    }
}
