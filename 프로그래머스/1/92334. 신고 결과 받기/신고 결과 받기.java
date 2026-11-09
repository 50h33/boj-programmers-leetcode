import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {
        Map<String, Integer> index = new HashMap<>();
        Map<String, Set<String>> reporters = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            index.put(id_list[i], i);
        }

        for (String report : reports) {
            String[] part = report.split(" ");
            String from = part[0];
            String to = part[1];

            reporters.computeIfAbsent(to, key -> new HashSet<>())
                     .add(from);
        }

        int[] answer = new int[id_list.length];

        for (Set<String> people : reporters.values()) {
            if (people.size() >= k) {
                for (String person : people) {
                    answer[index.get(person)]++;
                }
            }
        }

        return answer;
    }
}
