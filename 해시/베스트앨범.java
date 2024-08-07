import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int length = genres.length;
        Map<String, Integer> total = new HashMap();
        Map<String, ArrayList<int[]>> items = new HashMap();
        ArrayList<Integer> answer = new ArrayList();

        for (int i = 0; i < length; i++) {
            String category = genres[i];
            int play = plays[i];
            total.put(category, total.getOrDefault(category, 0) + play);
            if (items.containsKey(category)) {
                items.get(category).add(new int[]{i, play});
            } else {
                ArrayList<int[]> arrayList = new ArrayList();
                arrayList.add(new int[]{i, play});
                items.put(category, arrayList);
            }
        }

        List<Map.Entry<String, Integer>> sortedTotal = total.entrySet()
                .stream()
                .sorted((o1, o2) -> -(o1.getValue().compareTo(o2.getValue())))
                .collect(Collectors.toList());

        for (int i = 0; i < sortedTotal.size(); i++) {
            Map.Entry<String, Integer> category = sortedTotal.get(i);
            ArrayList<int []> item = items.get(category.getKey());
            Collections.sort(item, (o1, o2) -> {
                return -(o1[1] - o2[1]);
            });
            for(int j = 0; j < item.size(); j++){
                if(j == 2) break;
                answer.add(item.get(j)[0]);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
