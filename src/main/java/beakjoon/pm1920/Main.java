package beakjoon.pm1920;

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

        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        br.readLine();
        int[] find =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuilder result = new StringBuilder();
        for(int f: find){
            int i = Arrays.binarySearch(arr, f);
            if(i <= -1){
                result.append(0 + "\n");
            } else{
                result.append(1 + "\n");
            }
        }

        bw.write(result.toString().trim());
        bw.flush();
    }
}



