package beakjoon.pm30802;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n =  Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] str = br.readLine().split(" ");
        int t =  Integer.parseInt(str[0]);
        int p =  Integer.parseInt(str[1]);

        int r1 = 0;
        for(int num: arr){
            r1 += num/t + (num%t == 0 ? 0 : 1);
        }

        int r2 = n / p;
        int r3 = n % p;

        bw.write(r1+"\n" + r2 + " " + r3);
        bw.flush();
    }
}


