package programmers;

import java.util.*;

public class PR_위장 {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] cloth : clothes){
            map.put(cloth[1], map.getOrDefault(cloth[1], 1) + 1 );
        }
        
        Collection <Integer > values = map.values();
        
        answer =  values.stream().reduce(1, (a, b) -> a*b )-1;
        
        return answer;
    }
}
