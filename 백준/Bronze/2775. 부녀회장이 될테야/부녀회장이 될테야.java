
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] d = new int[15][15];

        for(int i=1;i<15;i++){
            d[0][i] = i;
        }

        for(int i=1;i<15;i++){
            for(int j=1;j<15;j++){
                int sum = 0;
                for(int k=1;k<=j;k++){
                    sum += d[i-1][k];
                }
                d[i][j] = sum;
            }
        }

        StringBuilder result = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            result.append(d[k][n]).append("\n");
        }

        bw.write(result.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
}