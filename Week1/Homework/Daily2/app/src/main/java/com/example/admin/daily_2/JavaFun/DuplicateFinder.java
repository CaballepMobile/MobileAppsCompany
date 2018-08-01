package com.example.admin.daily_2.JavaFun;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateFinder {
    public static void PrintDuplicates(List<String> strings){
        List<String> uniqueStringList = new ArrayList<>();
        Set<String> duplicateStringList = new HashSet<>();

        for (String element : strings) {
            boolean isDuplicated = false;
            for(String uniqueElement : uniqueStringList){
                if(element.equals(uniqueElement)){
                    isDuplicated = true;
                    duplicateStringList.add(element);
                    break;
                }
            }
            if(!isDuplicated){
                uniqueStringList.add(element);
            }
        }

        for (String uniqueDuplicatedElement : duplicateStringList){
            System.out.println(uniqueDuplicatedElement);
        }
    }
}
