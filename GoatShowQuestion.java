package com.company;


public class GoatShowQuestion extends Question {
    private Answer playerGuess;

    public GoatShowQuestion() {
        //Only 3 possible Answers, Parent adds 4
        answers.remove(answers.size()-1);
        this.answer = Answer.getRandomAnswer(3);
    }

    public void setPlayerGuess(Answer guess) {
        this.playerGuess = guess;
    }

    /**
     * Player Guess must be set before calling this method
     */
    @Override //Only to use new private method eliminateAnswer()
    public void elminateAnswers(int i) {
        for (int j = 0; j < i; j++) {
            eliminateAnswer();
        }
    }

    //removes an answer that is not guessed by the player and is not the answer
    private void eliminateAnswer() {
        while (true) {
            int guess = Helper.getRandomTo(answers.size());
            if (answers.get(guess) != answer && /*Change here*/ answers.get(guess) != playerGuess) {
                answers.remove(guess);
                return;
            }
        }
    }

    public String toString() {
        String string = "";
        string += "answer = " + answer + "\n";
        string += "player Guess = " + playerGuess + "\n";
        string += "answers:" + "\n";
        string += answers;
        return string;
    }

}
