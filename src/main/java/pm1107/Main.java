package pm1107;

import java.util.Scanner;

public class Main {
    static boolean[] brokenArr = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int curCh = 100;
        int aimCh = sc.nextInt();
        int brokenCnt = sc.nextInt();
        for (int i = 0; i < brokenCnt; i++)
            brokenArr[sc.nextInt()] = true;

        int ans = Math.abs(aimCh - curCh);

        // c : 이동 체널
        // press : + - 누른 횟수
        for(int i=0;i<=1000000;i++){
            int c=i;
            int len = possible(c);
            if(len > 0){
                int press = c-aimCh;
                if(press < 0){
                    press = -press;
                }
                if(ans > len + press){
                    ans = len + press;
                }
            }
        }
        System.out.println(ans);
    }

    // 이동할 수 있으면 숫자 버튼을 누른 횟수를 반환, 못하면 0
    private static int possible(int c) {
        if(c == 0){
            if(brokenArr[0])
                return 0;
            else
                return 1;
        }
        int len = 0;
        while(c>0){
            if(brokenArr[c%10]){
                return 0;
            }
            len++;
            c/=10;
        }
        return len;
    }


}
