package com.company;

public class Main {

    public static final int NUMBEROFTRIES = 1000000;

    public static void main(String[] args) throws Exception {
        System.out.println("Testing Swapping Efficiency in 'Millionen Show':");
        MillionenShowTester millionenShowTester = new MillionenShowTester();
        millionenShowTester.printTestResults();

        System.out.println();

        System.out.println("Testing Swapping Efficiency in 'Goat Show':");
        GoatShowTester goatShowTester = new GoatShowTester();
        goatShowTester.printTestResults();

    }


}

