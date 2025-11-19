package beakjoon.pm5086;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 0;

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        int count = 0;

        for(int i=1;i<=n;i++){
            if(n % i == 0){
                count++;
                if(count == k){
                    result = i;
                    break;
                }
            }
        }

        bw.write(result + "");
        bw.flush();
    }
}
