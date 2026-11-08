import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        answer += go(0, s);

        return answer;
    }

    private int go(int start, String s) {
        char first = s.charAt(start);
        System.out.println("first: " + first);
        int eqCnt = 1;
        int notCnt = 0;
        int cur = 0;
        if (start == s.length()-1) {
            cur++;
        }
        for (int i = start + 1; i < s.length(); i++) {
            if (eqCnt == notCnt) {
                cur++;
                cur += go(i, s);
                return cur;
            } else if (i == s.length()-1) {
                cur++;
            }
            
            if (first == s.charAt(i)) {
                eqCnt++;
            } else {
                notCnt++;
            }
        }
        System.out.println("cur: " + cur);
        return cur;
    }
}
