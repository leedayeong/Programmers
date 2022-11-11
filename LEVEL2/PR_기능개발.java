package programmers;

import java.util.*;

public class PR_기능개발 {
	 public int[] solution(int[] progresses, int[] speeds) {
	        // int[] answer = {};
	        
	        int len = progresses.length;
	        
	        List<Integer> list = new ArrayList<>();
	        
	        int idx = 0;
	        int day = 1;
	        while(idx < len){
	            int cnt = 0;
	            
	            for(int i = idx; i < len; i++){
	                if(progresses[i] + speeds[i] * day  >= 100){
	                    cnt++;
	                }else break;
	            }
	            
	            if(cnt!= 0 )list.add(cnt);
	            idx+= cnt;
	            day++;
	        }
	        
	        len = list.size();
	        
	        int [] answer = new int[len];
	        
	        for(int i = 0; i < len;i ++){
	            answer[i] = list.get(i);
	        }
	        return answer;
	    }
}
