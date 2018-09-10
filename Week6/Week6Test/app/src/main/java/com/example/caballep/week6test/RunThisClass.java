package com.example.caballep.week6test;

public class RunThisClass {

    public static void main(String[] args) {

        //INPUT
        int k = 3;
        int[] array = {10, 15, 20, 25, 30, 35, 40, 45, 50};

        //CALLING METHOD
        int[] result = rotateArray(array, k);

        //PRINTING RESULT
        System.out.println("\nProblem result (K = " + k + "):");
        for (int r : result) {
            System.out.print(r + " ");
        }
        System.out.print(" <- Result\n");

        //PRINTING ORIGINAL
        for (int r : array) {
            System.out.print(r + " ");
        }
        System.out.print(" <- Original");
    }

    private static int[] rotateArray(int[] array, int k) {

        int[] resultArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if ((i + k) < array.length) {
                resultArray[i + k] = array[i];
            } else {
                int newPos = (i + k) - (array.length);
                resultArray[newPos] = array[i];
            }
        }

        return resultArray;
    }
}
