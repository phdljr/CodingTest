
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        char[][] map = new char[n][m];

        for(int i=0;i<n;i++){
            char[] chArr = br.readLine().toCharArray();
            for(int j=0;j<m;j++){
                map[i][j] = chArr[j];
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i=0;i<=n-8;i++){
            for(int j=0;j<=m-8;j++){
                int count = countChangeColor(map, i, j);
                if(count < min){
                    min = count;
                }
            }
        }

        bw.write(min + "");
        bw.flush();
    }

    private static int countChangeColor(char[][] map, int r, int c) {
        int min = Integer.MAX_VALUE;
        for(int k=0;k<2;k++){
            int count = 0;
            char rowInitColor = k == 1 ? 'B' : 'W';
            for(int i=0;i<8;i++){

                for(int j=0;j<8;j+=2){
                    if(map[r+i][c+j] != rowInitColor){
                        count++;
                    }
                }

                for(int j=1;j<8;j+=2){
                    if(map[r+i][c+j] == rowInitColor){
                        count++;
                    }
                }

                rowInitColor = rowInitColor == 'B' ? 'W' : 'B';
            }

            if(count < min)
                min = count;
        }

        return min;
    }
}
