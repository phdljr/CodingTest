package pm6588;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int m, n;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        int[] arr = new int[n+1];
        for(int i=2;i<=n;i++)
            arr[i] = i;
        arr[0] = arr[1] = 0;

        for(int i=2;i*i<=n;i++){
            if(arr[i] != 0){
                for(int j=i*i;j<=n;j+=i){
                    arr[j] = 0;
                }
            }
        }
    }
}
