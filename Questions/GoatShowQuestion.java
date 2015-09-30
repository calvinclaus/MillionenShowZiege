package Questions;


public class GoatShowQuestion extends Question {
    private final int NUMBEROFANSWERS = 3;

    @Override
    public void fillAnswers() {
        for (int i = 0; i < NUMBEROFANSWERS; i++) {
            answers.add(i);
        }
    }

    public void setPlayerGuess(Integer guess) {
        eliminator.makeAnswerUnremovable(guess);
    }

}

