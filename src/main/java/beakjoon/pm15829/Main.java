package beakjoon.pm15829;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        char[] arr =  br.readLine().toCharArray();

        long result = 0;
        for(int i=0;i<arr.length;i++){
            long temp = arr[i] - 'a' + 1;
            for(int j=0;j<i;j++){
                temp *= 31;
                temp %= 1234567891;
            }
            result += temp;
        }

        bw.write(result % 1234567891 + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

