package thisisct.chap11.pm3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        int count0 = 0; // 전부 0으로 바뀌는 경우
        int count1 = 0; // 전부 1로 바뀌는 경우

        if(str.charAt(0) == '1'){
            count0++;
        } else{
            count1++;
        }

        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i) != str.charAt(i+1)){ // 현재와 다음 수가 다를 때
                if(str.charAt(i+1) == '1'){ // 01일 때, 1을 0으로 바꿈
                    count0++;
                } else{ // 10일때, 1을 0으로 바꿈
                    count1++;
                }
            }
        }
        System.out.println(Math.min(count0, count1));
    }
}
