
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static int minusOne = 0;
    static int zero = 0;
    static int one = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for(int i=0;i<n;i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        run(0, 0, n, map);

        bw.write(minusOne + "\n" + zero + "\n" + one);
        bw.flush();
    }

    private static void run(int x, int y, int n, int[][] map) {
        if(isOneColorBox(map,x,y,n)){
            if(map[x][y] == -1){
                minusOne++;
            } else if(map[x][y] == 0){
                zero++;
            } else{
                one++;
            }
        } else{
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    run(x + i * n/3, y + j * n/3, n/3, map);
                }
            }
        }
    }

    private static boolean isOneColorBox(int[][] map, int nx, int ny, int size) {
        int init = map[nx][ny];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(map[nx+i][ny+j] != init){
                    return false;
                }
            }
        }

        return true;
    }
}

