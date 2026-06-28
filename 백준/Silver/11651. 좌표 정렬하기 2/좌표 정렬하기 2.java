
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

class Node implements Comparable<Node>, Comparator<Node> {

    private int x;
    private int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compare(Node o1, Node o2) {
        return 0;
    }

    @Override
    public int compareTo(Node o) {
        if(y < o.y)
            return -1;
        else if(y == o.y){
            if(x < o.x)
                return -1;
            else if(x == o.x)
                return 0;
            return 1;
        } else
            return 1;
    }

    @Override
    public String toString() {
        return x + " " + y;
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
            arr[i] = new Node(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        }

        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            bw.write(arr[i].toString() + "\n");
        }
        bw.flush();
    }
}
