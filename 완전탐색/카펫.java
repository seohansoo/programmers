import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] array = new int[yellow];
        for(int i = 1; i <= yellow; i++){
            array[i-1] = i;
        }
        
        int[] answer = new int[2];
        int i = 1;
        int j = yellow;
        while(i <= j){
            int height = array[i-1];
            int width = array[j-1];
            int area = height * width;
            if(area == yellow){
                if((width+2)*2 + (height*2) == brown){
                    answer[0] = width+2;
                    answer[1] = height+2;
                    break;
                }
                i++;
                j--;
            } else if(area > yellow){
                j--;
            } else if(area < yellow){
                i++;
            }
        }
        return answer;
    }
}
