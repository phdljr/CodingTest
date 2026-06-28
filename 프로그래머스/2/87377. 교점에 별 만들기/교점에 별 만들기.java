import java.util.*;

class Point {
    long x, y;
    
    Point(long x, long y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public String[] solution(int[][] line) {
        List<Point> list = new ArrayList<>();
        
        for(int i=0;i<line.length;i++){
            for(int j=i+1;j<line.length;j++){
                getPoint(list, line[i], line[j]);        
            }
        }
        
        Point minPoint = getMinPoint(list);
        Point maxPoint = getMaxPoint(list);
        
        int w = (int)(maxPoint.x - minPoint.x + 1);
        int h = (int)(maxPoint.y - minPoint.y + 1);
        
        char[][] arr = new char[h][w];
        for(char[] a: arr){
            Arrays.fill(a, '.');
        }
        
        for(Point p: list){
            int ha = (int)(maxPoint.y - p.y);
            int wa = (int)(p.x - minPoint.x);
            arr[ha][wa] = '*';
        }
        
        String[] result = new String[arr.length];
        for(int i=0;i<result.length;i++){
            result[i] = new String(arr[i]);
        }
        
        return result;
    }
    
    private void getPoint(List<Point> list, int[] l1, int[] l2){
        double x = (double)((long)l1[1] * (long)l2[2] - (long)l1[2] * (long)l2[1]) / ((long)l1[0] * (long)l2[1] - (long)l1[1] * (long)l2[0]);
        double y = (double)((long)l1[2] * (long)l2[0] - (long)l1[0] * (long)l2[2]) / ((long)l1[0] * (long)l2[1] - (long)l1[1] * (long)l2[0]);
        
        if(x % 1 != 0 || y % 1 != 0){
            return;
        }
        
        list.add(new Point((long)x, (long)y));
    }
    
    private Point getMinPoint(List<Point> list){
        long mx = list.get(0).x;
        long my = list.get(0).y;
        
        for(Point p: list){
            if(mx > p.x){
                mx = p.x;
            }
            if(my > p.y){
                my = p.y;
            }
        }
        
        return new Point(mx, my);
    }
    
    private Point getMaxPoint(List<Point> list){
        long mx = list.get(0).x;
        long my = list.get(0).y;
        
        for(Point p: list){
            if(mx < p.x){
                mx = p.x;
            }
            if(my < p.y){
                my = p.y;
            }
        }
        
        return new Point(mx, my);
    }
}
