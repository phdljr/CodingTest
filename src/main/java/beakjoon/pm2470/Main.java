package beakjoon.pm2470;

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

        int n = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        Arrays.sort(arr);

        long prev = Long.MAX_VALUE;
        int left = 0, right = n - 1;
        long a = 0, b = 0;

        while(left != right){
            long sum = Math.abs(arr[left] + arr[right]);
            a = arr[left];
            b = arr[right];
            if(sum < prev){
                right--;
            } else {
                left++;
            }

            prev = sum;
        }


        bw.write(a + " " + b);
        bw.flush();
    }
}

