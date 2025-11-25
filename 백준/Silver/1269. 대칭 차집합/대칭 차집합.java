
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        Set<String> set1 = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toSet());
        Set<String> copySet1 = new HashSet<>(set1);
        Set<String> set2 = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toSet());

        set1.removeAll(set2);
        set2.removeAll(copySet1);

        bw.write(set1.size() + set2.size() + "");
        bw.flush();
    }

}
