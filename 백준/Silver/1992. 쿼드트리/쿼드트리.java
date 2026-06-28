
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static String result = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for(int i=0;i<n;i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        run(0, 0, n, map);

        bw.write(result);
        bw.flush();
    }

    private static void run(int x, int y, int n, int[][] map) {
        if(isOneColorBox(map,x,y,n)){
            result += map[x][y];
        } else{
            result += "(";
            run(x, y, n/2, map);
            run(x, y + n/2, n/2, map);
            run(x + n/2, y, n/2, map);
            run(x + n/2, y + n/2, n/2, map);
            result += ")";
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
