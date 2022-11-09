package beakjoon.pm15990;

import java.util.Scanner;

public class Main {

    static long[][] d = new long[100001][4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        int mod = 1000000009;
        for(int i=1;i<=100000;i++){
            for(int j=1;j<=3;j++){
                if(j == 1 && i-1>=0){
                    d[i][1] = (d[i-1][2] + d[i-1][3]) % mod;
                    if(i==1){
                        d[1][1] = 1;
                    }
                } else if(j==2 && i-2>=0){
                    d[i][2] = (d[i-2][1] + d[i-2][3]) % mod;
                    if(i==2){
                        d[2][2] = 1;
                    }
                } else if (j==3 && i-3>=0) {
                    d[i][3] = (d[i-3][1] + d[i-3][2]) % mod;
                    if(i==3){
                        d[3][3] = 1;
                    }
                }
            }
        }

        for(int i=0;i<t;i++){
            int n = Integer.parseInt(sc.nextLine());
            System.out.println((d[n][1] + d[n][2] + d[n][3])% mod);
        }
    }
}
