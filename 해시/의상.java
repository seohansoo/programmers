import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        int answer = 1;
        Map<String, Integer> clothesMap = new HashMap();
        
        for(String[] item : clothes){
            if(clothesMap.containsKey(item[1])){
                clothesMap.put(item[1], clothesMap.get(item[1])+1);
            } else {
                clothesMap.put(item[1], 1);
            }
        }
        
        for(String key : clothesMap.keySet()){
            answer *= clothesMap.get(key)+1;    
        }
        return answer-1;
    }
}
