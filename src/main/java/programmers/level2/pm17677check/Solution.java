package programmers.level2.pm17677check;

import java.math.BigInteger;
import java.util.*;

public class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = makeList(str1);
        List<String> list2 = makeList(str2);

        return check(list1, list2);
    }

    public int check(List<String> list1, List<String> list2){
        if(list1.size() == 0 && list2.size()==0){
            return 65536;
        }

        int min = 0;
        int max = list1.size() + list2.size();
        for(String str1: list1){
            for(String str2: list2){
                if(str1.equals(str2)){
                    min++;
                    list2.remove(str2);
                    break;
                }
            }
        }

        max -= min;
        return (int)((float)min/max * 65536);
    }

    public List<String> makeList(String str){
        str = str.toUpperCase();
        List<String> list = new ArrayList<>();
        for(int i=0;i<str.length()-1;i++){
            String subStr = str.substring(i, i+2).replaceAll("[^A-Z]", "");
            if(subStr.length() != 2)
                continue;
            list.add(subStr);
        }
        return list;
    }
}