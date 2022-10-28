package beakjoon.pm3085;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] map = initMap();

        int max = 0;
        int temp = 0;
        int n = map.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                // 행 바꿈
                if(j < n - 1) {
                    swap(map, i, j, i, j + 1);
                    temp = check(map, i, i, j, j + 1);
                    if(max < temp)
                        max = temp;
                    swap(map, i, j + 1, i, j);
                }
                // 열 바꿈
                if(i < n - 1) {
                    swap(map, i, j, i+1, j);
                    temp = check(map, i, i+1, j, j);
                    if(max < temp)
                        max = temp;
                    swap(map, i+1, j, i, j);
                }
            }
        }
        System.out.println(max);
    }

    private static int check(char[][] map, int startRow, int endRow, int startCol, int endCol) {
        int cnt = 1;
        int max = 0;
        int len = map.length;

        // 행
        for(int i=startRow; i<=endRow; i++){
            cnt = 1;
            for(int j=0;j<len-1;j++){
                if(map[i][j] == map[i][j+1])
                    cnt++;
                else
                    cnt = 1;
                if(cnt > max)
                    max = cnt;
            }
        }

        // 열
        for(int i=startCol;i<=endCol;i++){
            cnt = 1;
            for(int j=0;j<len-1;j++){
                if(map[j][i] == map[j+1][i])
                    cnt++;
                else
                    cnt = 1;
                if(cnt > max)
                    max = cnt;
            }
        }

//        for(int i=0;i<map.length;i++){
//            // 행 검사
//            for(int j=0;j<map.length-1;j++){
//                if(map[i][j] == map[i][j+1])
//                    cnt++;
//                else
//                    cnt = 1;
//                if(max < cnt)
//                    max = cnt;
//            }
//            cnt = 1;
//
//            // 열 검사
//            for(int j=0;j<map.length-1;j++){
//                if(map[j][i] == map[j+1][i])
//                    cnt++;
//                else
//                    cnt = 1;
//                if(max < cnt)
//                    max = cnt;
//            }
//            cnt = 1;
//        }

        return max;
    }

    private static void swap(char[][] map, int x1, int y1, int x2, int y2){
        char temp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = temp;
    }

    private static char[][] initMap(){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        char[][] arr = new char[n][n];

        for(int i=0;i<arr.length;i++) {
            arr[i] = sc.nextLine().toCharArray();
        }

        return arr;
    }
}
