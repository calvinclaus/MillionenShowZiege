package AnswerEliminator;
import java.util.LinkedList;
import java.util.List;
import Helpers.*;

public class AnswerEliminator {
    private List<Integer> answers;
    private List <Integer> unremovables = new LinkedList<>();


    public AnswerEliminator(List<Integer> answers, Integer answer) {
        this.answers = answers;
        this.unremovables.add(answer);
    }

    public void makeAnswerUnremovable(Integer answer) {
        this.unremovables.add(answer);
    }

    public void elminateAnswers(int i) {
        for (int j = 0; j < i; j++) {
            eliminateAnswer();
        }
    }

    protected void eliminateAnswer() {
        while (true) {
            int guess = Random.getRandomTo(answers.size());
            if (!unremovables.contains(answers.get(guess))) {
                answers.remove(guess);
                return;
            }
        }
    }
}

