import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] arr = new int[24*60+10];
        for(int i=0;i<book_time.length;i++){
            int inTime = getTime(book_time[i][0]);
            int outTime = getTime(book_time[i][1]) + 10;
            arr[inTime]++;
            arr[outTime]--;
        }

        for(int i=1;i<arr.length;i++){
            arr[i] += arr[i-1];
        }

        for(int i=0;i<arr.length;i++){
            if(answer < arr[i]){
                answer = arr[i];
            }
        }

        return answer;
    }

    public int getTime(String time){
        String[] str = time.split(":");
        return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
    }
}