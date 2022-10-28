package beakjoon.pm6064;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int temp = num;
        ArrayList<Integer> arr = new ArrayList<>();
        while (temp > 0){
            arr.add(temp % 10);
            temp /= 10;
        }
        int result = 0;
        int v = 9;
        for(int i=1;i<=arr.size();i++){
            if(i != arr.size()){
                result += v*i;
                v*=10;
            }
            else {
                result += (num - (v/9) + 1) * i;
            }
        }

        System.out.println(result);
    }
}
