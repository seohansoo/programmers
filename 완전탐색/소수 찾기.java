import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        calc("", numbers, visited, set);
        int answer = 0;
        
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            if(isPrime(iterator.next())){
                answer++;
            }
        }
        return answer;
    }
    
    public void calc(String prefix, String numbers, boolean[] visited, Set set){
        if(!prefix.isEmpty()){
            set.add(Integer.parseInt(prefix));
        }
        for(int i = 0; i < numbers.length(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            calc(prefix+numbers.charAt(i), numbers, visited, set);
            visited[i] = false;
        }
    }
    
    public boolean isPrime(int number){
        if(number < 2) return false;
        for(int i = 2; i * i <= number; i++){
            if(number%i == 0) return false;
        }
        return true;
    }
}
