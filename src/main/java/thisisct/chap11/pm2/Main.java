package thisisct.chap11.pm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] str = in.readLine().split("");
        int[] arr = new int[str.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(arr);

        int answer = 0;

        for(int num: arr){
            if(num <= 1 || answer == 0){
                answer += num;
            } else{
                answer *= num;
            }
        }
        System.out.println(answer);
    }
}
