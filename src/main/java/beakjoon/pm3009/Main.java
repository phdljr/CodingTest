package beakjoon.pm3009;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int resx = 0, resy = 0;
        HashMap<Integer, Integer> xm = new HashMap<>();
        HashMap<Integer, Integer> ym = new HashMap<>();
        for(int i=0;i<3;i++){
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            if(xm.containsKey(x))
                xm.replace(x, 2);
            else{
                xm.put(x, 1);
            }

            if(ym.containsKey(y))
                ym.replace(y, 2);
            else{
                ym.put(y, 1);
            }
        }

        for (Map.Entry<Integer, Integer> xe : xm.entrySet()){
            if(xe.getValue() == 1)
                resx = xe.getKey();
        }

        for (Map.Entry<Integer, Integer> ye : ym.entrySet()){
            if(ye.getValue() == 1)
                resy = ye.getKey();
        }

        bw.write(resx + " " + resy);
        bw.flush();
    }
}
