
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        int[] weight = new int[n];
        int[] value = new int[n];
        for(int i=0;i<n;i++){
            str =  br.readLine().split(" ");
            weight[i] = Integer.parseInt(str[0]);
            value[i] = Integer.parseInt(str[1]);
        }

        int[][] d = new int[n+1][k+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<k+1;j++){
                d[i][j] = d[i-1][j]; // 아무것도 안집었다고 가정
                if(j >= weight[i-1] && d[i-1][j-weight[i-1]] + value[i-1] > d[i][j]){
                    d[i][j] = d[i-1][j-weight[i-1]] + value[i-1];
                }
            }
        }

        bw.write(d[n][k] + "");
        bw.flush();
    }
}


