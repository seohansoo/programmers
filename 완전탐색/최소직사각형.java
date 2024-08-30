import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int widthMax = 0, heightMax = 0;
        for(int[] size : sizes){
            widthMax = Math.max(widthMax, Math.max(size[0], size[1]));
            heightMax = Math.max(heightMax, Math.min(size[0], size[1]));
        }
        return widthMax * heightMax;
    }
}
