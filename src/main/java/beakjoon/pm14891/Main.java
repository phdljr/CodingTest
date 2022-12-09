package beakjoon.pm14891;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[4][8];
        Scanner sc = new Scanner(System.in);

        for(int i=0;i<4;i++){
            String[] sp = sc.nextLine().split("");
            for(int j=0;j<8;j++){
                arr[i][j] = Integer.parseInt(sp[j]);
            }
        }

        int k = sc.nextInt();
        for(int i=0;i<k;i++) {
            int pos = sc.nextInt();
            pos--;
            int dir = sc.nextInt();
            // pos 톱니바퀴를 돌릴 때, 같이 돌아가는 톱니의 위치 구하기
            // index(pos)가 1이면 시계방향으로, -1이면 반시계반향으로
            int check[] = new int[4];
            check[pos] = dir;
            // pos의 왼쪽
            int lpos = pos;
            while(lpos != 0) {
                // 현재 톱니와 그 왼쪽의 톱니가 서로 극이 다르다면
                if (arr[lpos][6] != arr[lpos - 1][2]) {
                    // 왼쪽 톱니는 현재 톱니의 반대 방향으로 회전
                    check[lpos - 1] = check[lpos] * -1;
                    lpos--;
                } else {
                    break;
                }
            }

            // pos의 오른쪽
            int rpos = pos;
            while(rpos != 3) {
                if (arr[rpos][2] != arr[rpos + 1][6]) {
                    check[rpos + 1] = check[rpos] * -1;
                    rpos++;
                }
                else {
                    break;
                }
            }

            // 돌리기
            for(int j=0;j<4;j++) {
                rotate(arr, j, check[j]);
            }
        }

        int sum = 0;
        for(int i=0;i<4;i++) {
            if(arr[i][0] == 1){
                sum += Math.pow(2, i);
            }
        }
        System.out.println(sum);
    }

    static void rotate(int[][] arr, int pos, int dir){
        int temp = arr[pos][0];
        if(dir == -1) { // 반시계
            arr[pos][0] = arr[pos][1];
            arr[pos][1] = arr[pos][2];
            arr[pos][2] = arr[pos][3];
            arr[pos][3] = arr[pos][4];
            arr[pos][4] = arr[pos][5];
            arr[pos][5] = arr[pos][6];
            arr[pos][6] = arr[pos][7];
            arr[pos][7] = temp;
        } else if(dir == 1){ // 시계
            arr[pos][0] = arr[pos][7];
            arr[pos][7] = arr[pos][6];
            arr[pos][6] = arr[pos][5];
            arr[pos][5] = arr[pos][4];
            arr[pos][4] = arr[pos][3];
            arr[pos][3] = arr[pos][2];
            arr[pos][2] = arr[pos][1];
            arr[pos][1] = temp;
        }
    }
}
