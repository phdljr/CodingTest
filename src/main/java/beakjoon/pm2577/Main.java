package beakjoon.pm2577;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a =  Integer.parseInt(br.readLine());
        int b =  Integer.parseInt(br.readLine());
        int c =  Integer.parseInt(br.readLine());

        int[] arr = new int[10];
        char[] str = (((long)a * b * c) + "").toCharArray();

        for(char ch: str){
            arr[ch - '0']++;
        }

        StringBuilder result = new StringBuilder();
        for(int i=0;i<10;i++){
            result.append(arr[i]).append("\n");
        }

        bw.write(result.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
}



