package beakjoon.pm1182;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int s = Integer.parseInt(str[1]);
        int[] arr = new int[n];
        str = sc.nextLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        go(arr, s, 0, 0);
        if(s==0)
            answer--;
        System.out.println(answer);
    }

    static int answer = 0;
    private static void go(int[] arr, int sum, int currSum, int index){
        if(currSum == sum && index == arr.length){
            answer++;
        }
        if(index == arr.length){
            return;
        }
        go(arr, sum, currSum + arr[index], index+1);
        go(arr, sum, currSum, index+1);
    }
}
