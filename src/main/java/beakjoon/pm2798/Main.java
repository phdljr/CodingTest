package beakjoon.pm2798;

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
        int m = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");
        int[] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

        int max = -1;

        for(int i=0;i < arr.length;i++){
            for(int j = i+1; j < arr.length; j++){
                for(int k = j+1; k < arr.length; k++){
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum <= m && max < sum)
                        max = sum;
                }
            }
        }

        bw.write(max + "");
        bw.flush();
    }
}