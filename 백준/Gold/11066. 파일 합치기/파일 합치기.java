
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T =  Integer.parseInt(br.readLine());
        String result = "";
        for(int t=0;t<T;t++){
            int k = Integer.parseInt(br.readLine());
            int[] arr = new int[k+1];
            int[][] dp = new int[k+1][k+1];
            int[] sum =  new int[k+1];

            String[] str = br.readLine().split(" ");
            for(int i=1;i<=k;i++){
                arr[i] = Integer.parseInt(str[i-1]);
                sum[i] = sum[i-1] + arr[i];
            }

            for(int len = 2; len <= k; len++){ // bottom-up
                for(int i = 1; i <= k - len + 1; i++){ // 나눌 위치
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;

                    for(int x=i; x<j; x++){
                        int temp = dp[i][x] + dp[x+1][j] + (sum[j] - sum[i-1]);
                        dp[i][j] = Math.min(temp, dp[i][j]);
                    }
                }
            }

            result += dp[1][k] + "\n";
        }

        bw.write(result.trim());
        bw.flush();
        bw.close();
        br.close();
    }
}