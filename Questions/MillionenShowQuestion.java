package Questions;

public class MillionenShowQuestion extends Question {
    private final int NUMBEROFANSWERS = 4;
    @Override
    public void fillAnswers() {
        for (int i = 0; i < NUMBEROFANSWERS; i++) {
            answers.add(i);
        }
    }

}


