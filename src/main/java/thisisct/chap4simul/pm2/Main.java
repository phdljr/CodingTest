package thisisct.chap4simul.pm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int x, y;
        String data = in.readLine();
        x = data.charAt(0) - 96;
        y = data.charAt(1) - 48;

        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

        int res = 0;
        int nx = x, ny = y;
        for(int i=0;i<8;i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(1 <= nx && nx <= 8 && 1 <= ny && ny <= 8)
                res++;

            nx = x;
            ny = y;
        }
        System.out.println(res);
    }
}
