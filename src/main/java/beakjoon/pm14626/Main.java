package beakjoon.pm14626;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = br.readLine().toCharArray();

        int idx = 0;
        int sum = 0;
        for(int i=0;i<arr.length - 1;i++){
            if(arr[i] == '*'){
                idx = i;
                continue;
            }
            sum += (i % 2 == 0 ? 1 : 3) * (arr[i] - '0');
        }
        int x = (sum + arr[arr.length - 1] - '0') % 10;
        if(idx % 2 != 0)
            x /= 3;

        bw.write(x + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
