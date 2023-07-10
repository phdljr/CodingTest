package thisisct.chap6sort.pm3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Student implements Comparable<Student>{
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        if(o.score < this.score)
            return 1;
        return -1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(in.readLine());
        Student[] arr = new Student[num];

        for(int i=0;i<arr.length;i++){
            String[] s = in.readLine().split(" ");
            arr[i] = new Student(s[0], Integer.parseInt(s[1]));
        }

        Arrays.sort(arr);

        for(Student s: arr){
            System.out.print(s.name+ " ");
        }
    }
}
