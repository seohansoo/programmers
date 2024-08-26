import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for(String operation : operations){
            String[] items = operation.split(" ");
            String type = items[0];
            int num = Integer.parseInt(items[1]);
            if(type.equals("I")){
                minHeap.add(num);
                maxHeap.add(num);
            } else if(type.equals("D") && !minHeap.isEmpty()){
                if(num > 0){
                    int maxNum = maxHeap.poll();
                    minHeap.remove(maxNum);
                } else {
                    int minNum = minHeap.poll();
                    maxHeap.remove(minNum);
                }
            }
        }

        int[] answer = {0, 0};
        if(!minHeap.isEmpty()){
            answer[0] = maxHeap.peek();
            answer[1] = minHeap.peek();
        }
        return answer;
    }
}
