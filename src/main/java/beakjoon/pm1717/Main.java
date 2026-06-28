package beakjoon.pm1717;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[] p = new int[n+1];
        for(int i=1;i<=n;i++){
            p[i] = i;
        }

        for(int i=0;i<m;i++){
            str = br.readLine().split(" ");
            int c = Integer.parseInt(str[0]);
            int a = Integer.parseInt(str[1]);
            int b = Integer.parseInt(str[2]);

            if(c == 0){
                union(p, a, b);
            } else{
                int pa = find(p, a);
                int pb = find(p, b);
                if(pa == pb){
                    result.append("YES\n");
                }
                else{
                    result.append("NO\n");
                }
            }
        }

        bw.write(result.toString().trim());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void union(int[] p, int a, int b) {
        int aRoot = find(p, a);
        int bRoot = find(p, b);

        if(aRoot != bRoot){
            if(aRoot < bRoot){ // 숫자가 작은 쪽을 부모로
                p[bRoot] = aRoot;
            } else{
                p[aRoot] = bRoot;
            }
        }
    }

    private static int find(int[] p, int a) {
        if(p[a] == a){
            return a;
        } else{
            return p[a] = find(p, p[a]); // 경로 압축
        }
    }
}
