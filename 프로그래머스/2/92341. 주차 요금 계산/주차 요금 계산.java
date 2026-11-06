import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {        
        // 차량번호, 들어온 시간
        Map<String, Integer> mpIn = new HashMap<>();
        
        // 차량번호, 누적 시간
        Map<String, Integer> mpAc = new TreeMap<>();
        
        for (String record : records) {
            String[] part = record.split(" ");
            if (part[2].equals("IN")) {
                int time = chInt(part[0]);
                mpIn.put(part[1], time);
            } else {
                int inTime = mpIn.get(part[1]);
                mpIn.remove(part[1]);
                int outTime = chInt(part[0]);
                mpAc.merge(part[1], outTime - inTime, Integer::sum);
            }
        }
        
        for(Map.Entry<String, Integer> entry : mpIn.entrySet()) {
            String num = entry.getKey();
            int time = entry.getValue();
            int endTime = chInt("23:59");
            mpAc.merge(num, endTime-time, Integer::sum);
        }
        
        int[] answer = new int[mpAc.size()];
        int idx = 0;
        
        for (Map.Entry<String, Integer> entry : mpAc.entrySet()) {
            int time = entry.getValue();
            int cost = fees[1];
            if (time > fees[0]) {
                cost += (int) Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
            }
            answer[idx++] = cost;
        }
        
        return answer;
    }
    
    private int chInt(String s) {
        String[] t = s.split(":");
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        return h*60 + m;
    }
}