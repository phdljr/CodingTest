package thisisct.chap4simul.pm1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int x = 1, y = 1;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        String[] dt = {"U", "R", "D", "L"};
        String[] dir = in.readLine().split(" ");

        int nx = x;
        int ny = y;

        for(int i=0;i<dir.length;i++) {
            for (int j=0;j<4;j++) {
                if(dir[i].equals(dt[j])){
                   nx = x + dx[j];
                   ny = y + dy[j];
                   break;
                }
            }
            if(1 <= nx && nx <= n && 1 <= ny && ny <= n){
                x = nx;
                y = ny;
            }
        }

        System.out.printf("%d %d%n", x, y);
    }
}
