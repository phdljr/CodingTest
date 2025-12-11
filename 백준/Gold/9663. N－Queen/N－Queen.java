
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static boolean[][] map;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];

        placeQueen(0, n, 0);

        bw.write(count + "");
        bw.flush();
    }

    private static void placeQueen(int numOfQueen, int n, int r) {
        if(numOfQueen == n){
            count++;
            return;
        }

        for(int i=0;i<n;i++){
            if(!canPlace(r, i))
                continue;

            map[r][i] = true;
            placeQueen(numOfQueen + 1, n, r+1);
            map[r][i] = false;
        }
    }

    private static boolean canPlace(int r, int c){
        int n = map.length;
        for(int i=0;i<n;i++){
            if(map[r][i] == true)
                return false;
        }
        for(int i=0;i<n;i++){
            if(map[i][c] == true)
                return false;
        }
        int i=0;
        while(true){
            if(r-i >= 0 && c-i >= 0){
                if(map[r-i][c-i] == true)
                    return false;
            } else{
                break;
            }
            i++;
        }

        i=0;
        while(true){
            if(r+i < n && c-i >= 0){
                if(map[r+i][c-i] == true)
                    return false;
            } else{
                break;
            }
            i++;
        }

        i=0;
        while(true){
            if(r+i < n && c+i < n){
                if(map[r+i][c+i] == true)
                    return false;
            } else{
                break;
            }
            i++;
        }

        i=0;
        while(true){
            if(r-i >= 0 && c+i < n){
                if(map[r-i][c+i] == true)
                    return false;
            } else{
                break;
            }
            i++;
        }

        return true;
    }
}
