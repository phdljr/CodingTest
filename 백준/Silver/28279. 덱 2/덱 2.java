
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            String command = str[0];
            switch (command){
                case "1":
                    int num = Integer.parseInt(str[1]);
                    deque.addFirst(num);
                    break;
                case "2":
                    int num2 = Integer.parseInt(str[1]);
                    deque.addLast(num2);
                    break;
                case "3":
                    if(deque.isEmpty())
                        result.append("-1").append("\n");
                    else
                        result.append(deque.removeFirst()).append("\n");
                    break;
                case "4":
                    if(deque.isEmpty())
                        result.append("-1").append("\n");
                    else
                        result.append(deque.removeLast()).append("\n");
                    break;
                case "5":
                    result.append(deque.size()).append("\n");
                    break;
                case "6":
                    result.append((deque.isEmpty() ? 1 : 0)).append("\n");
                    break;
                case "7":
                    result.append((deque.isEmpty() ? -1 : deque.getFirst())).append("\n");
                    break;
                case "8":
                    result.append((deque.isEmpty() ? -1 : deque.getLast())).append("\n");
                    break;
            }
        }

        bw.write(result.toString().trim());
        bw.flush();
    }
}


