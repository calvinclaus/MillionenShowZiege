package com.company;

class MillionenShowTester {

    public void printTestResults() throws Exception {
        int successes = 0;
        for (int i = 0; i < Main.NUMBEROFTRIES; i++) {
            int result = getResultOfSwap();
            if (result == 1) {
                successes++;
            } else if(result == 0) {
                i--;
            }
        }
        System.out.println("Rounds played = " + Main.NUMBEROFTRIES);
        System.out.println("Successes = " + successes);
        System.out.println("That's = " + (((float)successes/(float)Main.NUMBEROFTRIES) * 100.0) + "%");
    }

    //Returns -1 if lost, 1 if won, 0 if 50-50
    private int getResultOfSwap() throws Exception {
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
}

