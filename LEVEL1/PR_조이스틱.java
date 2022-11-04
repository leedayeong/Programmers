package programmers;

import java.util.*;

public class PR_조이스틱 {
	public int solution(String name) {
		int len = name.length();      
        int answer = 0;
        
        int move = len - 1; // -----> 이렇게 쭉 이동
        
        for(int i = 0; i < len; i++){
            // 1. 알파벳 맞추기 A->J
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            // 2. 조이스틱 이동
            
            int idx = i + 1;
            while(idx < len && name.charAt(idx) == 'A') idx++;
            
            move = Math.min(move, i * 2 + len - idx); // 순방향으로 갔다가 다시 역방향
            move = Math.min(move, (len-idx) * 2 + i); //역방향으로 갔다가 다시 순방향 BBBBBBBBBBBAAAAAAAAB 
        }
        answer += move;

        return answer;
    }
}
