import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] p = new int[n+1];
        for(int i=1;i<=n;i++){
            p[i] = i;
        }

        int[][] g = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            for(int j=0;j<str.length;j++){
                g[i+1][j+1] = Integer.parseInt(str[j]);
            }
        }

        int[] route = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(g[i][j] == 1){
                    union(p, i, j);
                }
            }
        }

        boolean flag = true;
        String result = "";
        for(int i=0;i<m-1;i++){
            int root1 = find(p, route[i]);
            int root2 = find(p, route[i+1]);

            if(root1 != root2){
                flag = false;
                break;
            }
        }

        if(flag){
            result = "YES";
        } else{
            result = "NO";
        }

        bw.write(result);
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

