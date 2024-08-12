import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int item : scoville){
            minHeap.add(item);
        }
        
        int answer = 0;
        while(minHeap.size() > 1 && minHeap.peek() < K){
            minHeap.add(minHeap.poll() + (minHeap.poll() * 2));
            answer++;
        }
        
        return minHeap.peek() >= K ? answer : -1;
    }
}
