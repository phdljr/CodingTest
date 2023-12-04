import java.util.*;

class Node{
    int x, y;
    
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {0,0,0,0};
        List<Node> list = new ArrayList<>();

        for(int i=0;i<wallpaper.length;i++){
            if(wallpaper[i].contains("#")){
                for(int j=0;j<wallpaper[i].length();j++)
                    if(wallpaper[i].charAt(j) == '#')
                        list.add(new Node(i, j));
            }
        }

        int minx = list.get(0).x,
                miny = list.get(0).y,
                maxx = list.get(0).x,
                maxy = list.get(0).y;

        for(int i=1;i<list.size();i++){
            if(minx > list.get(i).x){
                minx = list.get(i).x;
            }
            if(miny > list.get(i).y){
                miny = list.get(i).y;
            }
            if(maxx < list.get(i).x){
                maxx = list.get(i).x;
            }
            if(maxy < list.get(i).y){
                maxy = list.get(i).y;
            }
        }

        answer[0] = minx;
        answer[1] = miny;
        answer[2] = maxx+1;
        answer[3] = maxy+1;

        return answer;
    }
}