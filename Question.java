package com.company;

import java.util.*;

public class Question {
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

    public Answer getAnswer() {
        return this.answer;
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
            int guess = Helper.getRandomTo(answers.size());
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

