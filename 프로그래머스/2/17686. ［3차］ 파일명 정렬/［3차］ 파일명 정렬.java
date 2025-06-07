import java.util.regex.*;
import java.util.*;

class MyFile implements Comparable<MyFile>{
    String origin;
    String head;
    int number;
    String tail;
    
    public MyFile(String name){
        this.origin = name;
        Pattern pattern = Pattern.compile("^([^\\d]+)(\\d{1,5})(.*)$");
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            this.head = matcher.group(1);
            this.number = Integer.parseInt(matcher.group(2));
            this.tail = matcher.group(3);
        }
    }
    
    public int compareTo(MyFile other){
        int headResult = head.toLowerCase().compareTo(other.head.toLowerCase());
        if(headResult != 0)
            return headResult;
            
        if(number != other.number){
            if(number > other.number)
                return 1;
            else
                return -1;
        }
        
        return 0;
    }
}

class Solution {
    public String[] solution(String[] files) {
        MyFile[] fileList = new MyFile[files.length];
        for(int i=0;i<files.length;i++){
            fileList[i] = new MyFile(files[i]);
        }
        
        Arrays.sort(fileList);
        
        String[] answer = new String[fileList.length];
        for(int i=0;i<answer.length;i++){
            answer[i] = fileList[i].origin;
        }
        
        return answer;
    }
}