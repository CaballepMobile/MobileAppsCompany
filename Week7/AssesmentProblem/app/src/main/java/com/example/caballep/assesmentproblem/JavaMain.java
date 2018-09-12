package com.example.caballep.assesmentproblem;

import android.util.Log;

public class JavaMain {

    public static final String TAG = "";

    public static void main(String[] args) {
        encodeString("ABGSH3:G");
    }

    private static String encodeString(String string) {
        char[] One = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] Two = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};

        String result = "";
        System.out.println(string);

        System.out.println(string.length());
        for (int i = 0; i < string.length(); i++) {

            boolean found = false;
            for (int e = 0; e < One.length; e++) {
                if (result.charAt(i) == One[e]) {
                    found = true;
                    break;
                }
            }
            if (!found) {

            }
        }

        return "";
    }
}
