package beakjoon.pm1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[][] arr;
    static boolean[][] check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int m;
    static int n;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            result = 0;
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            arr = new int[m][n];
            check = new boolean[m][n];

            int k = Integer.parseInt(st.nextToken()); // 배추 개수
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if(!check[x][y])
                        dfs(new Pair(x, y));
                }
            }

            System.out.println(result);
        }
    }

    public static void dfs(Pair pair) {
        Stack<Pair> stack = new Stack<>();
        stack.add(pair);
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            int x = p.x;
            int y = p.y;
            if (arr[x][y] == 1) {
                if(!check[x][y]) {
                    result++;
                    check[x][y] = true;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                        if(arr[nx][ny] != 1){
                            continue;
                        }
                        if(check[nx][ny]){
                            continue;
                        }
                        check[nx][ny] = true;
                        stack.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }
}
