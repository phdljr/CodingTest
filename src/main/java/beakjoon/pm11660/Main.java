package beakjoon.pm11660;

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

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] sumRow =  new int[n][n+1];
        for(int i=0;i<n;i++){
            sumRow[i][0] = 0;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sumRow[i][j+1] = sumRow[i][j] + arr[i][j];
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i=0;i<m;i++){
            String[] token = br.readLine().split(" ");
            int x1 =  Integer.parseInt(token[0]) - 1;
            int y1 =  Integer.parseInt(token[1]) - 1;
            int x2 =  Integer.parseInt(token[2]) - 1;
            int y2 =  Integer.parseInt(token[3]) - 1;
            int sum = 0;
            for(int r = x1; r<=x2; r++){
                sum += sumRow[r][y2+1] - sumRow[r][y1];
            }

            result.append(sum).append("\n");
        }

        bw.write(result.toString().trim());
        bw.flush();
    }
}

