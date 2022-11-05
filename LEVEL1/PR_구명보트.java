package programmers;

import java.util.*;

public class PR_구명보트 {
	public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int len = people.length;
        
        int answer = 0;
        int idx = 0;
        for(int i = len-1; i >= 0; i--){
            if(idx > i) break;
            else if(idx == i){
                answer ++;
                break;
            }else{
                if(people[i] + people[idx] > limit){
                    answer ++;
                    continue;
                }else{
                    answer ++;
                    idx ++;
                }
            }
            
        }
        
        return answer;
    }
}
