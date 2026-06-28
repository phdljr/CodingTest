package beakjoon.pm9063;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int minx = 20000, miny = 20000, maxx = -20000, maxy = -20000;
        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);

            if(minx > x)
                minx = x;
            if(miny > y)
                miny = y;
            if(maxx < x)
                maxx = x;
            if(maxy < y)
                maxy = y;
        }

        int result = (maxx - minx) * (maxy - miny);

        bw.write(result + "");
        bw.flush();
    }
}

