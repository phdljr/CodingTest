package beakjoon.pm11659;

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

        String[] str = br.readLine().split(" ");
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sumArr = new int[arr.length+1];
        sumArr[0] = 0;
        for(int i=1;i<arr.length+1;i++){
            sumArr[i] = sumArr[i-1] + arr[i-1];
        }

        int m = Integer.parseInt(str[1]);
        StringBuilder result = new StringBuilder();
        for(int i=0;i<m;i++){
            str = br.readLine().split(" ");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);
            int sum = sumArr[end] - sumArr[start-1];
            result.append(sum).append("\n");
        }

        bw.write(result.toString().trim());
        bw.flush();
    }
}