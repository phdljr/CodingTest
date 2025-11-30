package beakjoon.pm11478;

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

        String str = br.readLine();

        Set<String> set = new HashSet<>();
        int len = 1;
        int index = 0;
        while(true){
            if(index+len <= str.length()){
                set.add(str.substring(index, index+len));
                index++;
            } else{
                index = 0;
                len++;
            }

            if(len > str.length())
                break;
        }


        bw.write(set.size() + "");
        bw.flush();
    }

}
