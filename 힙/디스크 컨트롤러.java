import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> hardDisk = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] job1, int[] job2) {
                return job1[1] - job2[1];
            }
        });
        LinkedList<int[]> jobList = new LinkedList<>();

        for(int[] item : jobs){
            jobList.add(item);
        }

        int[] job;
        int cnt = 0, time = 0, sum = 0;
        while(cnt != jobs.length){
            for(int i = 0; i < jobList.size(); i++){
                if(jobList.get(i)[0] <= time){
                    hardDisk.add(jobList.get(i));
                    jobList.remove(i);
                    i--;
                }
            }

            if(!hardDisk.isEmpty()){
                job = hardDisk.poll();
                sum += job[1]+time-job[0];
                time += job[1];
                cnt++;
            } else {
                time++;
            }
        }

        return sum/cnt;
    }
}
/*
* Comparator의 작동 원리
*
* compare(T o1, T o2)메서드는 두 개의 값을 비교하여, 이 값을 기준으로 그 순서를 결정한다.
*
* 오름차순
* o1 - o2 (작은 값이 우선순위가 높음)
* 음수 : o1이 o2보다 작은 경우 -> o1이 o2보다 우선순위가 높음
* 0 : o1과 o2가 같은 경우 -> 순서 변경 없음
* 양수 : o1이 o2보다 큰 경우 -> o1이 o2보다 우선순위가 낮다
*
* 내림차순
* o2 - o1 (큰 값이 우선순위가 높음)
* 음수 : o1이 o2보다 큰 경우 -> o1이 o2보다 우선순위가 높음
* 0 : o1과 o2가 같은 경우 -> 순서 변경 없음
* 양수 : o1이 o2보다 작은 경우 -> o1이 o2보다 우선순위가 낮다
*
* 계산순서만 바꿔준다고 오름차순, 내림차순으로 바뀌는 이유
* compare 메서드가
* 음수를 반환할 때 첫 번째 인자(o1)를 더 높은 우선순위로 간주하고,
* 양수를 반환할 때는 두 번째 인자(o2)를 더 높은 우선순위로 간주하기 때문
*
* */
