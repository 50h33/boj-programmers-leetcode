import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {
        // 신고당한사람, 신고 당한 횟수
        Map<String, Integer> mpCnt = new HashMap<>();
        // 신고당한 사람, 신고한 사람
        Map<String, Set<String>> pep = new HashMap<>();
        // 신고한 사람, 받는메일개수
        Map<String, Integer> mpMail = new HashMap<>();
        // 이름, 아이디
        Map<String, Integer> mpId = new HashMap<>();
        
        // 이름별 아이디 저장
        for (int i = 0; i < id_list.length; i++) {
            mpId.put(id_list[i], i);
        }
        
        // 신고당한 횟수 세기
        for (String report : reports) {
            String[] part = report.split(" ");
            
            // 신고당한 사람, 신고한 사람
            if (!pep.containsKey(part[1])) {
                pep.put(part[1], new HashSet<>());
            }
            if (pep.get(part[1]).contains(part[0])) continue;
            pep.get(part[1]).add(part[0]);
            
            // 신고당한사람, 신고 당한 횟수
            mpCnt.merge(part[1], 1, Integer::sum);
        }
        
        // 받는 메일 개수 세기
        for (Map.Entry<String, Integer> entry : mpCnt.entrySet()) {
            // 신고당한사람, 신고 당한 횟수
            String key = entry.getKey();
            int value = entry.getValue();
            if (value >= k) {
                for (String s : pep.get(key)) {
                    // 신고한 사람, 받는메일개수
                    mpMail.merge(s, 1, Integer::sum);   
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        // 답에 넣기
        for (Map.Entry<String, Integer> entry : mpMail.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            answer[mpId.get(key)] = value;
        }
        
        return answer;
    }
}