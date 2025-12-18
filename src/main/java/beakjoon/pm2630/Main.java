package beakjoon.pm2630;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

class Node{
    int x;
    int y;
    int size;

    Node(int x,int y,int size){
        this.x=x;
        this.y=y;
        this.size=size;
    }
}

public class Main {

    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for(int i=0;i<n;i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Stack<Node> stack = new Stack<>();
        stack.add(new Node(0,0,n));
        while(!stack.isEmpty()){
            Node node = stack.pop();
            int nx = node.x;
            int ny = node.y;
            int size = node.size;

            if(isOneColorBox(map, nx, ny, size)){
                if(map[nx][ny] == 1){
                    blue++;
                } else{
                    white++;
                }
            } else{
                stack.push(new Node(nx, ny, size/2));
                stack.push(new Node(nx + size/2, ny, size/2));
                stack.push(new Node(nx + size/2, ny + size/2, size/2));
                stack.push(new Node(nx, ny + size/2, size/2));
            }
        }

        bw.write(white + "\n" + blue);
        bw.flush();
    }

    private static boolean isOneColorBox(int[][] map, int nx, int ny, int size) {
        int init = map[nx][ny];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(map[nx+i][ny+j] != init){
                    return false;
                }
            }
        }

        return true;
    }
}