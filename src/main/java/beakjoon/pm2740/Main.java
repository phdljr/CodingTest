package beakjoon.pm2740;

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

        String[] str =  br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[][] m1 = new int[n][m];
        for(int i=0;i<n;i++){
            m1[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        str =  br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        int[][] m2 = new int[n][m];
        for(int i=0;i<n;i++){
            m2[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] result = multi(m1, m2);
        StringBuilder r = new StringBuilder();
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[i].length;j++){
                r.append(result[i][j]).append(" ");
            }
            r.append("\n");
        }

        bw.write(r.toString().trim());
        bw.flush();
    }

    private static int[][] multi(int[][] m1, int[][] m2) {
        int n = m1.length;
        int m = m1[0].length;
        int k = m2[0].length;
        int[][] result = new int[n][k];
        for(int i=0;i<n;i++){
            for (int j=0;j<k;j++){
                for(int l=0;l<m;l++){
                    result[i][j] += m1[i][l] * m2[l][j];
                }
            }
        }

        return result;
    }
}

