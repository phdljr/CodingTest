package pm14500;

import java.util.Scanner;

public class Main {
    //19가지
    static int[][][] arr = {
            {{0,1}, {0,2}, {0,3}},
            {{1,0}, {2,0}, {3,0}},
            {{1,0}, {1,1}, {1,2}},
            {{0,1}, {1,0}, {2,0}},
            {{0,1}, {0,2}, {1,2}},
            {{1,0}, {2,0}, {2,-1}},
            {{0,1}, {0,2}, {-1,2}},
            {{1,0}, {2,0}, {2,1}},
            {{0,1}, {0,2}, {1,0}},
            {{0,1}, {1,1}, {2,1}},
            {{0,1}, {1,0}, {1,1}},
            {{0,1}, {-1,1}, {-1,2}},
            {{1,0}, {1,1}, {2,1}},
            {{0,1}, {1,1}, {1,2}},
            {{1,0}, {1,-1}, {2,-1}},
            {{0,1}, {0,2}, {-1,1}},
            {{0,1}, {0,2}, {1,1}},
            {{1,0}, {2,0}, {1,1}},
            {{1,0}, {2,0}, {1,-1}},
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int M = sc.nextInt();
        final int[][] map = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int max= 0;
        int sum = 0;
        for(int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                for(int k=0;k<19;k++){
                    sum = map[i][j];
                    for(int l=0;l<3;l++){
                        int x = i+arr[k][l][0];
                        int y = j+arr[k][l][1];
                        if(x >= 0 && x < N && y >= 0 && y < M)
                            sum += map[x][y];
                        else {
                            sum = -1;
                            break;
                        }
                    }
                    if(max < sum) {
                        max = sum;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
