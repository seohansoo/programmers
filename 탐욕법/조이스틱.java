import java.util.*;

class Solution {
    public int solution(String name) {
        int length = name.length();
        int answer = 0;
        
        for (int i = 0; i < length; i++) {
            int difference = name.charAt(i) - 'A';
            answer += Math.min(difference, 26 - difference);
        }

        int minMove = length - 1; // 커서를 오른쪽으로만 이동할 때
        for (int i = 0; i < length; i++) {
            int nextIndex = i + 1;
            while (nextIndex < length && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }
            int backRoot = length - nextIndex; // A가 아닌 다음 글자에서 마지막 글자 까지의 길이
            minMove = Math.min(minMove, i + backRoot + Math.min(i, backRoot));
            // (minMove) vs (0에서 i(현재위치)와 backRoot중 짧은 쪽을 왔다갔다 하는 것)
        }
        answer += minMove;
        
        return answer;
    }
}
