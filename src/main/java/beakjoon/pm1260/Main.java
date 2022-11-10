package beakjoon.pm1260;

import java.util.*;

public class Main {

    static List<Integer>[] a;
    static boolean[] c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        int start = Integer.parseInt(s1[2]);
        a = new List[n+1];

        for(int i=1;i<=n;i++){
            a[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            String[] s = sc.nextLine().split(" ");
            int from = Integer.parseInt(s[0]);
            int to = Integer.parseInt(s[1]);
            a[from].add(to);
            a[to].add(from);
        }
        for(int i=1;i<=n;i++){
            Collections.sort(a[i]);
        }

        c = new boolean[n+1];
        dfs(start);
        System.out.println();
        c = new boolean[n+1];
        bfs(start);
        System.out.println();
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        c[start] = true;
        while(!q.isEmpty()){
            int x = q.remove();
            System.out.print(x + " ");
            for(int y: a[x]){
                if(c[y] == false){
                    c[y] = true;
                    q.add(y);
                }
            }
        }
    }

    private static void dfs(int x) {
        if(c[x] == true){
            return;
        }
        c[x] = true;
        System.out.print(x + " ");
        for(int y: a[x]){
            if(c[y] == false){
                dfs(y);
            }
        }
    }
}
