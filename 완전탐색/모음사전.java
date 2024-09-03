import java.util.*;

class Solution {
    String[] array = {"A", "E", "I", "O", "U"};
    int count = 0;
    int answer = 0;
    public int solution(String word) {
        calc("", word);
        return answer;
    }
    
    public void calc(String prefix, String word){
        if(prefix.equals(word)){
            answer = count;
            return;
        }
        if(prefix.length() == 5) return;
        for(int i = 0; i < array.length; i++){
            count++;
            calc(prefix+array[i], word);
        }
    } 
}
