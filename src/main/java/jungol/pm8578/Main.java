package jungol.pm8578;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n =  Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        int diff = Integer.MAX_VALUE;

        for(int i = 0; i < n-1; i++){
            int temp = arr[i+1] - arr[i];
            if(diff > temp){
                diff = temp;
            }
        }

        bw.write(diff + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

