package beakjoon.pm1991;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Node{
    char c;
    Node left;
    Node right;
    Node(char c){
        this.c=c;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];

        for(int i=0;i<n;i++){
            nodes[i] = new Node((char)('A' + i));
        }

        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            char nodeC = str[0].charAt(0);
            char leftC = str[1].charAt(0);
            char rightC = str[2].charAt(0);

            if(leftC != '.')
                nodes[nodeC - 'A'].left = nodes[leftC - 'A'];

            if(rightC != '.')
                nodes[nodeC - 'A'].right = nodes[rightC - 'A'];
        }

        String result = "";
        result += preOrder(nodes[0]) + "\n";
        result += midOrder(nodes[0]) + "\n";
        result += postOrder(nodes[0]);

        bw.write(result.trim());
        bw.flush();
        bw.close();
        br.close();
    }

    private static String postOrder(Node root) {
        String result = "";

        if(root==null){
            return "";
        }

        result += postOrder(root.left);
        result += postOrder(root.right);
        result += root.c;

        return result;
    }

    private static String midOrder(Node root) {
        String result = "";

        if(root==null){
            return "";
        }

        result += midOrder(root.left);
        result += root.c;
        result += midOrder(root.right);

        return result;
    }

    private static String preOrder(Node root) {
        String result = "";

        if(root==null){
            return "";
        }

        result += root.c;
        result += preOrder(root.left);
        result += preOrder(root.right);

        return result;
    }
}

