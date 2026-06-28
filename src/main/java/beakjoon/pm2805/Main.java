package beakjoon.pm2805;

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
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long min = 0;
        long max = 0;
        for(int i=0;i<arr.length;i++){
            if(max < arr[i])
                max = arr[i];
        }

        while(min <= max){
            long sum = 0;
            long target = min + (max - min) / 2;

            for(int i=0;i<arr.length;i++){
                sum += Math.max((arr[i] - target), 0);
            }

            if(sum >= m) {
                min = target + 1;
            } else{
                max = target - 1;
            }
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

