package beakjoon.pm14889no;

import java.util.Scanner;

public class Main {
    static int[][] map;
    public static void main(String[] args) {

    }

    private static void init(){
        Scanner sc = new Scanner(System.in);
        init();
        int n = sc.nextInt();
        sc.nextLine();
        map = new int[n][n];
        for(int i=0;i<n;i++){
            String[] temp = sc.nextLine().split(" ");
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
    }
}
