import java.util.*;

class Solution {
    public int solution(String s) {
        if(s.length() == 1){
            return 1;
        }
        
        int answer = 100000;
        for(int len=1;len<=s.length()/2;len++){
            ArrayList<String> list = new ArrayList<>();

            // 분할
            int start = 0;
            boolean stop = false;
            while(!stop){
                int end = start + len;
                if(end >= s.length()){
                    end = s.length();
                    stop = true;
                }
                String str = s.substring(start, end);
                list.add(str);
                start += len;
            }

            // 큐에 넣고 앞글자부터 순서대로 압축 진행
            Queue<String> queue = new LinkedList<>(list);
            String previous = queue.poll();
            String now = null;
            int count = 1;
            int length = 0;
            int numLength = 0;
            while(!queue.isEmpty()){
                now = queue.poll();
                // 다음 문자가 현재 문자랑 같다면 압축
                if(now.equals(previous)){
                    count++;
                } else{ // 다르다면 길이 추가 및 타켓 변경
                    numLength = count == 1 ? 0 : String.valueOf(count).length();
                    length += previous.length() + numLength;
                    count = 1;
                }
                previous = now;
            }

            numLength = count == 1 ? 0 : String.valueOf(count).length();
            length += previous.length() + numLength;
            
            if(answer > length){
                answer = length;
            }
        }

        return answer;
    }
}