package programmers;

import java.util.*;

public class PR_완주하지못한선수 {
	public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String part : participant){
            map.put(part, map.getOrDefault(part, 0) + 1);
        }
        
        for(String part : completion){
            map.put(part, map.getOrDefault(part, 0) - 1);
            // if(map.get(part) == 0) map.remove(part);
        }
        
        String answer = "";
//         for(String part : participant){
//             if(map.getOrDefault(part, 0)!=0) answer = part;
            
//         }
        for( String strKey : map.keySet() ){
            if(map.get(strKey) == 1) answer = strKey;
        }

        
        return answer;
    }
}
