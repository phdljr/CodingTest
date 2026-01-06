package beakjoon.pm7568;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Node {
    int x;
    int y;
    int order;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n =  Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];
        Node[] origin = new Node[n];
        for(int i=0;i<n;i++) {
            String[] str = br.readLine().split(" ");
            nodes[i] = new Node(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
            origin[i] = new Node(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
        }

        for(int j=0;j<n-1;j++){
            for(int i=0;i<n-1-j;i++){
                Node temp;
                if(nodes[i].x < nodes[i+1].x){
                    temp = nodes[i];
                    nodes[i] = nodes[i+1];
                    nodes[i+1] = temp;
                }
            }
        }

        for(int i=0;i<n;i++) {
            nodes[i].order = i+1;
        }

        for(int j=0;j<n-1;j++){
            for(int i=0;i<n-1-j;i++){
                Node temp;
                if(nodes[i].y < nodes[i+1].y){
                    nodes[i+1].order = nodes[i].order;
                    temp = nodes[i];
                    nodes[i] = nodes[i+1];
                    nodes[i+1] = temp;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for(int j=0;j<n;j++){
            for(int i=0;i<n;i++){
                if(nodes[i].x == origin[j].x && nodes[i].y == origin[j].y){
                    result.append(nodes[i].order).append(" ");
                }
            }
        }

        bw.write(result.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
}