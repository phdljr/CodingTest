package programmers.pm72410;

import java.util.*;

public class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9_.\\-]", "");
        new_id = new_id.replaceAll("\\.{2,}", ".");
        new_id = new_id.replaceAll("^\\.", "");
        new_id = new_id.replaceAll("\\.$", "");
        if(new_id.length() == 0){
            new_id += "a";
        }
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("\\.$", "");
        }
        if(new_id.length() <= 2){
            char ch = new_id.charAt(new_id.length()-1);
            while(!(new_id.length() == 3))
                new_id += ch;
        }
        return new_id;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("...!@BaT#*..y.abcdefghijklm"));
    }
}
