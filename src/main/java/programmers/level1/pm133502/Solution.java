package programmers.level1.pm133502;

import java.util.ArrayList;

public class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<ingredient.length;i++){
            list.add(ingredient[i]);
            int size = list.size();
            if(size >= 4){
                if(list.get(size-1) == 1 && list.get(size-2) == 3 && list.get(size-3) == 2 && list.get(size-4) == 1){
                    for(int j=0;j<4;j++){
                        list.remove(list.size()-1);
                    }
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,1,2,3,1,2,3,1};
        System.out.println(new Solution().solution(arr));
    }
}