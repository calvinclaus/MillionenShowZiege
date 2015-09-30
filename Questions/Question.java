package Questions;

import AnswerEliminator.AnswerEliminator;
import Helpers.Random;

import java.util.*;

public abstract class Question {
    protected Integer answer;
    protected List<Integer> answers = new LinkedList<>();
    protected AnswerEliminator eliminator;

    public Question() {
        fillAnswers();
        this.answer = Random.getRandomTo(answers.size() - 1);
        eliminator = new AnswerEliminator(answers, answer);

    }

    /*Fills in the answers list*/
    protected abstract void fillAnswers();

    public boolean isRightAnswer(Integer answer) {
        return this.answer.equals(answer);
    }

    public boolean isAvailableAnswer(Integer answer) {
        return answers.contains(answer);
    }

    public void elminateAnswers(int i) {
        eliminator.elminateAnswers(i);
    }

    public Integer chooseAnyAvailableOtherThan(Integer thisOne) throws Exception {
        for (Integer sampleAnswer : answers) {
            if (!thisOne.equals(sampleAnswer)) {
                return sampleAnswer;
            }
        }
        throw new Exception("No answer except " + thisOne);
    }

    public Integer getNewRandomAnswer() {
        return answers.get(Random.getRandomTo(answers.size()));
    }

}

