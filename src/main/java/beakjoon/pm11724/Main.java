package beakjoon.pm11724;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] a;
    static boolean[] c;
    static int answer = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        c = new boolean[n+1];
        a = new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            a[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            s = sc.nextLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            a[u].add(v);
            a[v].add(u);
        }

        for(int i=1;i<=n;i++) {
            if(c[i] == false) {
                answer++;
                dfs(i);
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int s) {
        if(c[s] == true){
            return;
        }
        c[s] = true;
        for(int ss: a[s]){
            dfs(ss);
        }
    }
}
