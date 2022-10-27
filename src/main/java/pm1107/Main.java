package pm1107;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int curCh = 100;
        int aimCh = sc.nextInt();
        int brokenCnt = sc.nextInt();
        int clickCnt = 0;
        int[] brokenArr = null;
        if(brokenCnt != 0) {
            brokenArr = new int[brokenCnt];
            for (int i = 0; i < brokenCnt; i++)
                brokenArr[i] = sc.nextInt();
        }

        int result = 0;
        // 버튼이 고장난 경우가 아니라면


    }
}
