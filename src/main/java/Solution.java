import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt(); sc.nextLine();
            int[][] a = new int[n][n];
            for(int i=0;i<n;i++){
                String[] split = sc.nextLine().split("");
                for(int j=0;j<n;j++){
                    a[i][j] = Integer.parseInt(split[j]);
                }
            }

            int ans = 0;
            int start = n/2;
            int end = n/2;
            for(int i=0;i<n;i++){
                for(int j=start;j<=end;j++)
                    ans += a[i][j];
                if(i < n/2){
                    start--;
                    end++;
                } else{
                    start++;
                    end--;
                }
            }


            System.out.printf("#%d %d\n", test_case, ans);
        }
    }
}