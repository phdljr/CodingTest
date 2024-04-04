import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> stack = new ArrayList<Integer>();
        
        int row = 0;
        int col = 0;
        int item = 0;
        
        for(int i=0; i<moves.length; i++)
        {
            col = moves[i] - 1;
            
            for(row = 0;row < board.length; row++)
            {
            	item = board[row][col];
            	if(item != 0)
            		break;
            }
            
            if(item == 0) continue;
            board[row][col] = 0;
            
            stack.add(item);
            
            while(check(stack) == true)
                answer+=2;
        }
        
        return answer;
    }
    
    public boolean check(ArrayList<Integer> stack)
    {
        for(int i = 0;i<stack.size() - 1;i++)
        {
            if(stack.get(i) == stack.get(i+1))
            {
                stack.remove(i);
                stack.remove(i);
                return true;
            }
        }
        return false;
    }
}