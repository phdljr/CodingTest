package beakjoon.pm2563;

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
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[100][100];

        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);

            for(int j=0;j<10;j++){
                for(int k=0;k<10;k++){
                    arr[x+j][y+k] = 1;
                }
            }
        }

        for(int j=0;j<100;j++){
            for(int k=0;k<100;k++){
                if(arr[j][k] == 1)
                    result++;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}

