import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i=0;i<discount.length - want.length;i++){
            // 1. 해당 날부터 10일간 원하는 제품이 모두 할인하는지 확인
            int lastIndex = i + 10 >= discount.length ? discount.length : i + 10;
            
            List<String> list = new ArrayList<>();
            for(int j=i;j<lastIndex;j++){
                list.add(discount[j]);
            }
            HashSet<String> set = new HashSet<>(list);
            
            boolean flag = false;
            for(int j=0;j<want.length;j++){
                if(!set.contains(want[j])){
                    flag = true;
                    break;   
                }
            }
            if(flag == true){
                continue;
            }
            
            // 1-2. 모두 있다면 개수 확인
            int[] checkNumber = new int[number.length];
            for(int j=0;j<list.size();j++){
                for(int k=0;k<want.length;k++){
                    if(list.get(j).equals(want[k])){
                        checkNumber[k]++;
                    }
                }
            }
            
            flag = false;
            for(int j=0;j<number.length;j++){
                if(number[j] != checkNumber[j]){
                    flag = true;
                    break;   
                }
            }
            if(flag == true){
                continue;
            } else{
                answer++;
            }
        }
        
        return answer;
    }
}