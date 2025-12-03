package beakjoon.pm24511;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Queue;

enum Type{
    QUEUE, STACK;
}

class Struct{
    Type type;
    int element;

    public Struct(int type, int element) {
        if(type == 0)
            this.type = Type.QUEUE;
        else
            this.type = Type.STACK;
        this.element = element;
    }

    public int pushAndPop(int input){
        int result;
        if(type == Type.QUEUE){
            result = element;
            element = input;
        } else{
            result = input;
        }

        return result;
    }
}

class StructFactory{
    Struct[] structs;

    public StructFactory(int size, int[] types, int[] elements) {
        this.structs = new Struct[size];

        for(int i=0;i<size;i++){
            structs[i] = new Struct(types[i], elements[i]);
        }
    }

    public int pushAndPop(int input){
        int result = input;
        for(int i=0;i<structs.length;i++){
            result = structs[i].pushAndPop(result);
        }

        return result;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] type = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StructFactory structFactory = new StructFactory(n, type, arr);

        n = Integer.parseInt(br.readLine());
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder result = new StringBuilder();
        for(int input: inputs){
            result.append(structFactory.pushAndPop(input)).append(" ");
        }

        bw.write(result.toString().trim());
        bw.flush();
    }
}




