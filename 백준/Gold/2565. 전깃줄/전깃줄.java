
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    int left;
    int right;

    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node o) {
        return this.left - o.left;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n =  Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];
        for(int i=0;i<n;i++) {
            String[] str = br.readLine().split(" ");
            int left = Integer.parseInt(str[0]);
            int right = Integer.parseInt(str[1]);
            nodes[i] = new Node(left, right);
        }

        Arrays.sort(nodes);

        int[] d = new int[n];
        d[0] = 1;
        for(int i=1;i<n;i++) {
            d[i] = 1;
            int max = 0;
            for(int j=0;j<i;j++) {
                if(nodes[j].right < nodes[i].right && max < d[j]) {
                    max = d[j];
                }
            }
            d[i] = max + 1;
        }

        int max = 0;
        for(int i=0;i<n;i++){
            if(d[i] > max) {
                max = d[i];
            }
        }

        bw.write(n - max + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
