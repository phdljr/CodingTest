import java.util.*;

class Person{
    int id;
    int score;
    int rank;
    
    int getScore() {
        return score;
    }
    
    int getId() {
        return id;
    }
}

class Solution {
    public int[] solution(int[][] score) {
        Person[] people = new Person[score.length];
        
        for(int i=0;i<score.length;i++){
            people[i] = new Person();
            people[i].id = i+1;
            people[i].score = score[i][0] + score[i][1];
        }
        
        Arrays.sort(people, Comparator.comparingInt(Person::getScore).reversed());
        
        int rank = 0;
        for(int i=0;i<people.length;i++){
            rank++;
            
            if(i == 0){
                people[i].rank = rank;
                continue;
            }
            
            if(people[i-1].score == people[i].score){
                people[i].rank = people[i-1].rank;
            } else{
                people[i].rank = rank;
            }
        }
        
        Arrays.sort(people, Comparator.comparingInt(Person::getId));
        
        int[] answer = new int[people.length];
        for(int i=0;i<people.length;i++){
            answer[i] = people[i].rank;
        }
        
        return answer;
    }
}