package beakjoon.pm2559;

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

        int m = Integer.parseInt(str[1]);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<=arr.length-m;i++){
            int sum = 0;
            for(int j=i;j<i+m;j++){
                sum += arr[j];
            }

            if(max < sum)
                max = sum;
        }

        bw.write(max + "");
        bw.flush();
    }
}
