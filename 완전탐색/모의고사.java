import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] giveUpMath1 = {1, 2, 3, 4, 5};
        int[] giveUpMath2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] giveUpMath3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] results = new int[3];
        results[0] = match(giveUpMath1, answers);
        results[1] = match(giveUpMath2, answers);
        results[2] = match(giveUpMath3, answers);

        int max = Math.max(results[0], Math.max(results[1], results[2]));

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < results.length; i++){
            if(results[i] == max) list.add(i+1);
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }

        return answer;

    }

    public int match(int[] array, int[] answers){
        int result = 0;
        for(int i = 0, target = 0; i < answers.length; i++){
            if(answers[i] == array[target]) result++;
            target++;
            if(target == array.length) target = 0;
        }
        return result;
    }
}

/*
모범 답안

import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answer) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == a[i%a.length]) {score[0]++;}
            if(answer[i] == b[i%b.length]) {score[1]++;}
            if(answer[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}

내가 짠 코드보다 간결하다.
나는 match메서드를 만들어서 for문을 3번 돌렸는데
for문 한번으로 세가지 값을 계산해 계산속도를 단축시킴
내코드는 계산량도 많아지고 메서드 때문에 메모리도 더 차지함
*/
