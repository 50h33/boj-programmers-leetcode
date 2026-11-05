import java.util.*;

class Solution {
    public String[] solution(String[] records) {
        List<String> answer = new ArrayList<>();
        
        Map<String, String> mp = new HashMap<>();
        
        // 최종 닉네임 저장
        for (String record : records) {
            String[] part = record.split(" ");
            if (part[0].equals("Enter") || part[0].equals("Change")) {
                mp.put(part[1], part[2]);
            }
        }
        
        for (String record : records) {
            String[] part = record.split(" ");
            
            String command = part[0];
            String uid = part[1];
            
            if (command.equals("Enter")) {
                answer.add(mp.get(uid) + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                answer.add(mp.get(uid) + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[0]);
    }
}