package beakjoon.pm14391;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            String[] s = br.readLine().split("");
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        int max = 0;
        for(int s=0;s<(1<<(n*m));s++){
            int sum = 0;
            for(int i=0;i<n;i++){
                int cur = 0;
                for(int j=0;j<m;j++){
                    int k = i*m+j;
                    if((s&(1<<k)) == 0){
                        cur = cur*10+arr[i][j];
                    } else{
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            for(int j=0;j<m;j++){
                int cur = 0;
                for(int i=0;i<n;i++){
                    int k = i*m+j;
                    if((s&(i<<k)) != 0){
                        cur = cur*10 + arr[i][j];
                    } else{
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            if(max < sum)
                max = sum;
        }
        System.out.println(max);
    }
}
