package beakjoon.pm2606;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static ArrayList<ArrayList<Integer>> g;
    static int result = 0;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        check = new boolean[v + 1];

        g = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            g.add(new ArrayList<>());
        }

        // 인접 리스트 만들기
        for (int i = 0; i < e; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            ArrayList<Integer> list = g.get(from);
            list.add(to);
            list = g.get(to);
            list.add(from);
        }

        bfs(1);

        System.out.println(result);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer n = queue.remove();
            if (!check[n]) {
                check[n] = true;
                if (n != 1) {
                    result++;
                }
            }
            ArrayList<Integer> list = g.get(n);
            for (int i = 0; i < list.size(); i++) {
                Integer node = list.get(i);
                if (!check[node]) {
                    queue.add(node);
                    check[node] = true;
                    result++;
                }
            }
        }
    }
}
