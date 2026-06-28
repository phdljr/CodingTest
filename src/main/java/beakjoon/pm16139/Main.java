package beakjoon.pm16139;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int L = s.length();
        int[][] pref = new int[26][L + 1];

        for (int i = 0; i < L; i++) {
            int idx = s.charAt(i) - 'a';
            for (int c = 0; c < 26; c++){
                pref[c][i + 1] = pref[c][i];
            }

            pref[idx][i + 1]++;
        }

        int questions = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (questions-- > 0) {
            String[] token = br.readLine().split(" ");
            int c = token[0].charAt(0) - 'a';
            int start = Integer.parseInt(token[1]);
            int end = Integer.parseInt(token[2]);
            sb.append(pref[c][end + 1] - pref[c][start]).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();
    }
}