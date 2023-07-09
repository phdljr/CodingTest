package programmers.level1.pm159994;

public class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0;
        int index2 = 0;
        for (String s : goal) {
            if (cards1.length > index1 && s.equals(cards1[index1])) {
                index1++;
            } else if (cards2.length > index2 && s.equals(cards2[index2])) {
                index2++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}
