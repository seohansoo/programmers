import java.util.*;

class Solution {
    int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        calc(k, visited, dungeons, 0);
        
        return max;
    }
    
    public void calc(int k, boolean[] visited, int[][] dungeons, int count){
        max = Math.max(count, max);
        
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i]) continue;
            if(dungeons[i][0] <= k){
                visited[i] = true;
                calc(k - dungeons[i][1], visited, dungeons, count+1);
            }
            visited[i] = false;
        }
    }
 }
