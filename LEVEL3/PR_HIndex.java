package programmers;

import java.util.*;

public class PR_HIndex {
	public int solution(int[] citations) {

        Arrays.sort(citations);
        
        int answer = 0;
        int len = citations.length;
        
        while(true){
            
            boolean chk = false;
            int idx = 0;
            for(int i = 0; i < len; i++){
                if(citations[i] >= answer) {
                    chk = true;
                    idx = i;
                    break;
                }
            }
            
            if(chk && len-idx >= answer) answer++;
            else break;
        }
        
        return answer-1;
	}
}
