package beakjoon.pm1009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static int k;
    static char[] arr;
    static boolean[] check;
    static int[] numArr;
    static long answer = 1;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        k = Integer.parseInt(sc.nextLine()); // 부등호 개수
        numArr = new int[k+1];
        arr = sc.nextLine().toCharArray(); // 부등호 배열
        check = new boolean[10]; // 사용된 숫자 사용 여부

        go(0, 0, 9);
    }

    private static void go(int index, int bigger, int less){
        // 종료 조건
        if(index == k){

        }

        // 실패 조건
    }
}
