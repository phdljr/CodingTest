
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=0;tc<T;tc++) {
            int fc =  Integer.parseInt(br.readLine());
            HashMap<String, String> parent = new HashMap<>();
            HashMap<String, Integer> size = new HashMap<>();
            for(int i=0;i<fc;i++) {
                String[] str = br.readLine().split(" ");
                String from = str[0];
                String to = str[1];
                parent.putIfAbsent(from, from);
                parent.putIfAbsent(to, to);
                size.putIfAbsent(from, 1);
                size.putIfAbsent(to, 1);

                int count = union(parent, size, from, to);
                result.append(count).append("\n");
            }
        }

        bw.write(result.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }

    private static String find(HashMap<String, String> parent, String from) {
        if(!parent.get(from).equals(from)){
            parent.put(from, find(parent, parent.get(from)));
        }

        return parent.get(from);
    }

    private static int union(HashMap<String, String> parent, HashMap<String, Integer> size, String from, String to) {
        String p1 = find(parent, from);
        String p2 = find(parent, to);
        if(!p1.equals(p2)){
            parent.put(p2, p1);
            size.put(p1, size.get(p1) + size.get(p2));
        }

        return size.get(p1);
    }
}