package pm1476;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int[] arr_esm = {1, 1, 1};
        final int[] MAX_ARR = {15, 28, 19};
        int year = 1;
        while(true){
            if(arr_esm[0] == E && arr_esm[1] == S && arr_esm[2] == M)
                break;

            for(int i=0;i<arr_esm.length;i++){
                arr_esm[i] = arr_esm[i] % MAX_ARR[i] + 1;
            }
            year++;
        }

        System.out.println(year);
    }
}
