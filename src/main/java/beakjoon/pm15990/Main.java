package beakjoon.pm15990;

import java.util.Scanner;

public class Main {

    static int[] d = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        d[1] = 1;
        d[2] = 1;
        d[3] = 3;
        for(int i=4;i<=100000;i++){

        }

        for(int i=0;i<t;i++){
            int n = Integer.parseInt(sc.nextLine());
            System.out.println(d[n]);
        }
    }
}
