import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        
        for(int r : reserve){
            reserveSet.add(r);
        }
        
        for(int l : lost){
            if(reserveSet.contains(l)){
                reserveSet.remove(l);
                answer++;
            } else {
                lostSet.add(l);
            }
        }
        
        for(int i = 1; i <= n; i++){
            if(lostSet.contains(i)){
                if(reserveSet.contains(i-1)){
                    reserveSet.remove(i-1);
                    answer++;
                } else if(reserveSet.contains(i+1)){
                    reserveSet.remove(i+1);
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
