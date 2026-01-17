package beakjoon.pm1026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        int[] aArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        Integer[] bArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed()
            .sorted(Comparator.reverseOrder()).toArray(Integer[]::new);

        int sum = 0;
        for(int i=0;i<aArr.length;i++){
            sum += aArr[i] * bArr[i];
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
