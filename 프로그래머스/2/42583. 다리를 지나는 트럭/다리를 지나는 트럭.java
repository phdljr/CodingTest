class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int[] end_truck = new int[truck_weights.length];
        int[] start_truck = new int[truck_weights.length];
        int[] distance = new int[truck_weights.length]; //각 트럭별로 움직인 거리
        
        int sum_weight = 0; //다리 위 트럭의 무게 합
        int count_start = 0; //현재 다리 위 트럭 수
        int count_end = 0; //다 지나간 트럭 수
        int num = 0; //트럭 번호
        
        while(count_end != truck_weights.length)
        {
            if(distance[count_end] == bridge_length)
            {
                end_truck[count_end] = truck_weights[count_end];
                sum_weight -= truck_weights[count_end++];
            }
            
            if(num < truck_weights.length && sum_weight + truck_weights[num] <= weight)
            {
                start_truck[count_start++] = truck_weights[num];
                sum_weight += truck_weights[num++];
            }
            
            for(int i=count_end;i<count_start;i++)
            {
                distance[i]++;
            }
            
            answer++;
        }
        return answer;
    }
}