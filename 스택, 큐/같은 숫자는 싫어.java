import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> answer = new ArrayList<Integer>();
        for(int arr_ : arr){
            if(answer.size() == 0 || answer.lastIndexOf(arr_) != answer.size()-1){
                answer.add(arr_);
            }
        }

        int[] result = answer.stream()
                            .mapToInt(Integer::intValue)
                            .toArray();
        return result;
    }
}
