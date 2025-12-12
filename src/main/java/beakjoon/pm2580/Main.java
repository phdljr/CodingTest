package beakjoon.pm2580;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0;i<9;i++){
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[i] = row;
        }

//        placeNum();

        StringBuilder result = new StringBuilder();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                result.append(map[i][j]).append(" ");
            }
            result = new StringBuilder(result.toString().trim() + "\n");
        }

        bw.write(result.toString());
        bw.flush();
    }

    private static void placeNum(int count, int n, int r) {
        if(count == n){
            return;
        }

        for(int num=1;num<=9;num++){
            for(int i=0;i<n;i++){
                if(!canPlace(num, r, i))
                    continue;

                map[r][i] = num;
                placeNum(num, n, r+1);
                map[r][i] = 0;
            }
        }
    }

    private static boolean canPlace(int num, int r, int c){
        int size = 9;
        for(int i=0;i<size;i++){
            if(map[i][c] == num)
                return false;
        }

        for(int i=0;i<size;i++){
            if(map[r][i] == num)
                return false;
        }



        return true;
    }
}

