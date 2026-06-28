package beakjoon.pm2580;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static int[][] map = new int[9][9];
    static int[][] blanks = new int[81][2]; // 빈칸 개수만큼 빈칸의 r, c 좌표
    static int blankCount = 0;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<9;i++){
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[i] = row;
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(map[i][j]==0){
                    blanks[blankCount][0] = i;
                    blanks[blankCount][1] = j;
                    blankCount++;
                }
            }
        }

        run(0);
    }

    private static void run(int currentPlaceCount) throws IOException {
        if(currentPlaceCount == blankCount){
            printAndExit();
            return;
        }

        int r = blanks[currentPlaceCount][0];
        int c = blanks[currentPlaceCount][1];

        for(int num=1;num<=9;num++){
            if(!canPlace(num, r, c))
                continue;

            map[r][c] = num;
            run(currentPlaceCount+1);
            map[r][c] = 0;
        }
    }

    private static void printAndExit() throws IOException {
        StringBuilder result = new StringBuilder();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                result.append(map[i][j]).append(" ");
            }
            result.append("\n");
        }
        bw.write(result.toString().trim());
        bw.flush();

        System.exit(0);
    }

    private static boolean canPlace(int num, int r, int c){
        int size = 9;
        for(int i=0;i<size;i++){
            if(map[i][c] == num)
                return false;
            if(map[r][i] == num)
                return false;
        }

        int minr = r / 3 * 3;
        int minc = c / 3 * 3;
        for(int i=minr;i<minr + 3;i++){
            for(int j=minc;j<minc + 3;j++){
                if(map[i][j] == num)
                    return false;
            }
        }

        return true;
    }
}

