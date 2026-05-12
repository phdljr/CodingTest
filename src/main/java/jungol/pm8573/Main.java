package jungol.pm8573;

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

        String result = "";
        if (n % 2 == 1) {
            result += arr[n / 2];
        } else {
            if(arr[n / 2 - 1] != arr[n / 2])
                result += arr[n / 2 - 1] + " " + arr[n / 2];
            else
                result += arr[n / 2];
        }

        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }
}