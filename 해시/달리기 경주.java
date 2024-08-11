import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> playerIndexMap = new HashMap<>();
        String[] answer = players.clone();

        for (int i = 0; i < players.length; i++) {
            playerIndexMap.put(players[i], i);
        }

        for (String call : callings) {
            int index = playerIndexMap.get(call);
            String temp = answer[index];
            
            answer[index] = answer[index-1];
            answer[index-1] = temp;

            playerIndexMap.put(answer[index-1], index-1);
            playerIndexMap.put(answer[index], index);
        }

        return answer;
    }
}
