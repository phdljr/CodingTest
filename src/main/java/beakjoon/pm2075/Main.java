package beakjoon.pm2075;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int num = sc.nextInt();
                if(pq.size() == n) {
                    if(pq.peek() < num){
                        pq.poll();
                        pq.add(num);
                    }
                } else{
                    pq.add(num);
                }
            }
        }

        bw.write(pq.peek() + "");
        bw.flush();
        bw.close();
        sc.close();
        br.close();
    }
}
