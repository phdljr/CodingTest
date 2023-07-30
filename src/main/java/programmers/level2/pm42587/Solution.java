package programmers.level2.pm42587;

import java.util.*;

class Node{
    int priority;
    int firstIndex;

    public Node(int priority, int firstIndex){
        this.priority = priority;
        this.firstIndex = firstIndex;
    }
}

public class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Node> queue = new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            queue.add(new Node(priorities[i], i));
        }

        // 꺼낸다
        // 안의 큐 확인
        // 더 높은게 있다면 카운트 x, 다시 집어넣음
        while(!queue.isEmpty()){
            Node node = queue.poll();
            boolean flag = false;
            for(Node process: queue){
                if(process.priority > node.priority){
                    queue.add(node);
                    flag = true;
                    break;
                }
            }
            if(flag == true){
                continue;
            }

            answer++;
            if(flag == false && node.firstIndex == location){
                break;
            }
        }

        return answer;
    }
}