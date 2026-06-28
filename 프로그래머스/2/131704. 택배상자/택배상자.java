import java.util.*;

class Solution {
    public int solution(int[] order) {
        int[] conv = new int[order.length];
        for(int i=0;i<conv.length;i++){
            conv[order[i]-1] = i+1;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        int next = 1;
        for(int i=0;i<conv.length;i++){
            if(conv[i] == next){
                next++;
                while(!stack.isEmpty()){
                        if(stack.peek() == next){
                            stack.pop();
                            next++;
                        } else{
                            break;
                        }
                    }
            } else{
                if(stack.isEmpty()){
                    stack.push(conv[i]);
                }
                else if(stack.peek() == next){
                    while(!stack.isEmpty()){
                        if(stack.peek() == next){
                            stack.pop();
                            next++;
                        } else{
                            break;
                        }
                    }
                } else{
                    stack.push(conv[i]);
                }
            }
        }
        
        while(!stack.empty()){
            if(stack.peek() == next){
                stack.pop();
                next++;
            } else{
                break;
            }
        }
        
        return next-1;
    }
}