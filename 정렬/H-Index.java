import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for(int i = citations[citations.length-1]; i >= 0; i--){
            for(int j = 0; j < citations.length; j++){
                if(citations[j] > i){
                    if(j <= i && citations.length-j >= i){
                        answer = answer < i ? i : answer;
                    }
                } else if(citations[j] == i){
                    if(j+1 <= i && citations.length-j >= i){
                        answer = answer < i ? i : answer;
                    }
                }
            }
        }
        return answer;
    }
}
/*
모범답안

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++){
            int smaller = Math.min(citations[i], citations.length-i);
            answer = Math.max(answer, smaller);
        }
        return answer;
    }
}
*/
