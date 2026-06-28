package beakjoon.pm1181;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Node implements Comparable<Node> {

    private int age;
    private String name;

    public Node(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(age, o.age);
    }

    @Override
    public String toString() {
        return age + " " + name;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Node[] arr = new Node[n];
        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            arr[i] = new Node(Integer.parseInt(str[0]), str[1]);
        }

        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            bw.write(arr[i].toString() + "\n");
        }
        bw.flush();
    }
}
