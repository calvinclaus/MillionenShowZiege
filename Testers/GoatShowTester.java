package Testers;

import Questions.GoatShowQuestion;

public class GoatShowTester {

    public void printTestResults() throws Exception {
        int successes = 0;
        for (int i = 0; i < Main.NUMBEROFTRIES; i++) {
            if (swappingWon()) {
                successes++;
            }
        }
        System.out.println("Rounds played = " + Main.NUMBEROFTRIES);
        System.out.println("Successes = " + successes);
        System.out.println("That's = " + (((float) successes / (float) Main.NUMBEROFTRIES) * 100.0) + "%");
    }

    //Returns -1 if lost, 1 if won, 0 if 50-50
    private boolean swappingWon() throws Exception {
        GoatShowQuestion question = new GoatShowQuestion();
        Integer currentGuess = question.getNewRandomAnswer();
        question.setPlayerGuess(currentGuess);
        //Swapping will result in loss if right Answer was guessed
        if (question.isRightAnswer(currentGuess)) {
            return false;
        }

        question.elminateAnswers(1);

        //Could just return 1 here; Using Methods here to really simulate.
        if (question.isRightAnswer(question.chooseAnyAvailableOtherThan(currentGuess))) {
            return true;
        }
        throw  new Exception("Impossible Case");
    }
}


