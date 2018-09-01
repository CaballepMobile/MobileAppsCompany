package com.example.admin.week5test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) {

        //Uncomment to run

        //First problem                       {        [(    )    ]}
        System.out.println(checkSyntax("{somecode[(code)code]}morecode"));

        //Second problem
        System.out.println(getSubstringOcurrencies("cat_cat+-63c7a4t3c767 cat", "cat"));
    }

    public static class MyFastMap {
        public char value1;
        public char value2;

        public MyFastMap(char value1, char value2) {
            this.value1 = value1;
            this.value2 = value2;
        }
    }

    private static boolean checkSyntax(String code) {

        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        List<MyFastMap> myFastMapList = new ArrayList<>();
        myFastMapList.add(new MyFastMap('{', '}'));
        myFastMapList.add(new MyFastMap('[', ']'));
        myFastMapList.add(new MyFastMap('(', ')'));

        int firstPos = 0;
        int lastPos = code.length() - 1;

        List<Character> openItems = new ArrayList<>();
        List<Character> closeItems = new ArrayList<>();

        //fill open list only with { [ ( characters
        for (firstPos = 0; firstPos < code.length(); firstPos++) {

            if (map.containsKey(code.charAt(firstPos))) {
                openItems.add(code.charAt(firstPos));

            } else {
                if (map.containsValue(code.charAt(firstPos))) {
                    break;
                }
            }
        }

        //fill close list only with } ] ) characters
        for (lastPos = code.length() - 1; lastPos > 0; lastPos--) {

            if (map.containsValue(code.charAt(lastPos))) {
                closeItems.add(code.charAt(lastPos));

            } else {
                if (map.containsKey(code.charAt(lastPos))) {
                    break;
                }
            }
        }

        //now that we have 2 lists with the opening and closing symbols, it just to make sure they match one with the other
        for (int i = 0; i < openItems.size(); i++) {

            for (MyFastMap myFastMap : myFastMapList) {
                if (!(openItems.get(i) == myFastMap.value1) && (closeItems.get(i) == myFastMap.value2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int getSubstringOcurrencies(String string, String subString) {

        int lastPos = 0;
        int count = 0;

        while (lastPos != -1) {

            lastPos = string.indexOf(subString, lastPos);

            if (lastPos != -1) {

                lastPos += subString.length();
                count++;

            }
        }

        return count;
    }


}
