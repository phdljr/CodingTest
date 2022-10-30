package beakjoon.pm18290;

import java.util.Scanner;

public class Main {

    static int[][] map;
    static int k;
    static int n;
    static int m;

    public static void main(String[] args) {
        initMap();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

            }
        }
    }

    private static void initMap() {
        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        k = Integer.parseInt(temp[2]);
        map = new int[n][m];
        for(int i=0;i<n;i++){
            temp = sc.nextLine().split(" ");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
    }

}

