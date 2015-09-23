package com.company;
enum Answer {
    A, B, C, D;

    public static Answer getRandomAnswer() {
        int random = Helper.getRandomTo(Answer.values().length);
        return Answer.values()[random];
    }

    public static Answer getRandomAnswer(int to) {
        int random = Helper.getRandomTo(to);
        return Answer.values()[random];
    }
}

