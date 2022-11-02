package programmers.pm12911;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int solution = new Solution().solution(10);
    }

    public int solution(int n) {
        String strBin = Integer.toString(n, 2);
        int count = getCountOne(strBin);

        StringBuilder sb = new StringBuilder(strBin);

        while(true){
//            int index = getLastOneIndex(sb);
            // 맨 마지막이 1이라면
                // 그 앞자리가 0이라면 서로 바꿈
                //
        }


    }

    public int getCountOne(String str){
        int count = str.length();
        count -= str.replaceAll("1", "").length();
        return count;
    }
}
