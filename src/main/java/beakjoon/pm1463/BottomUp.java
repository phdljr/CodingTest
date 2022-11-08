package beakjoon.pm1463;

import java.util.Scanner;

public class BottomUp {
    static int[] d = new int[1000001];
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        d[1] = 0;
        for(int i=2;i<=n;i++){
            d[i] = d[i-1] + 1;
            if(i % 2 == 0 && d[i] > d[i/2] + 1){
                d[i] = d[i/2] + 1;
            }
            if(i % 3 == 0 && d[i] > d[i/3] + 1 ){
                d[i] = d[i/3] + 1;
            }
        }
        System.out.println(d[n]);
    }

}
