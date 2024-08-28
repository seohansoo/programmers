import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] numStrs = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));

        String answer = String.join("", numStrs);

        if (answer.charAt(0) == '0') {
            answer = "0";
        }
        
        return answer;
    }
}
