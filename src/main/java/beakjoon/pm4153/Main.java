package beakjoon.pm4153;

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

        StringBuilder result = new StringBuilder();

        while (true) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(arr[0] == 0 && arr[1] == 0 &&  arr[2] == 0){
                break;
            }

            Arrays.sort(arr);

            if(((arr[0] * arr[0]) + (arr[1] * arr[1])) == (arr[2] * arr[2])){
                result.append("right");
            } else{
                result.append("wrong");
            }

            result.append("\n");
        }

        bw.write(result.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
}
