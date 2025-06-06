import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        int op = 0;
        int num = 0;
        String[] arr = my_string.split(" ");
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("+")){
                op = 1;
                continue;
            } else if(arr[i].equals("-")){
                op = 2;
                continue;
            } else{
                if(op == 0){
                    answer = Integer.parseInt(arr[i]);
                } else if(op == 1){
                    answer += num + Integer.parseInt(arr[i]);
                } else if(op == 2){
                    answer += num - Integer.parseInt(arr[i]);
                }
            }
        }
        return answer;
    }
}