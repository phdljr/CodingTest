package beakjoon.pm2164;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>();

        String[] str =br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        for(int i=1;i<=n;i++){
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        int index = k - 1;
        while (true){
            sb.append(list.remove(index)).append(" ");
            if(list.isEmpty())
                break;

            index = (index + k - 1) % list.size();
        }

        String result = String.join(", ", sb.toString().split(" "));

        bw.write("<"+ result + ">");
        bw.flush();
    }
}


