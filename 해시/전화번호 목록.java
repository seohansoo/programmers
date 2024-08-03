import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] phone_book = {"123", "119562442", "97674223", "1195524421", "1"};
        System.out.println(solution(phone_book));
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map phoneMap = new HashMap();

        for(String phone : phone_book) {
            phoneMap.put(phone, phone);
        }

        for(String phone : phone_book){
            for(int i = 1; i<phone.length(); i++){
                if(phoneMap.get(phone.substring(0, i)) != null){
                    answer = false;
                    break;
                }
            }
            if(!answer) break;
        }
        return answer;
    }
}