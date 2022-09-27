package programmers;
import java.util.*;

public class PR_주차요금계산 {

	public List<Integer> solution(int[] fees, String[] records) {
        TreeMap<String, String> ins = new TreeMap<>();
        TreeMap<String, Integer> result = new TreeMap<>();
        
        for(String record : records){
            String[] str = record.split(" ");
            if(str[2].equals("IN")){
                ins.put(str[1], str[0]);
            }else{
                
                String tmp = ins.get(str[1]);
                String[] in = tmp.split(":");
                String[] out = str[0].split(":");
                
                int hour = Integer.parseInt(out[0]) - Integer.parseInt(in[0]);
                int minite = hour * 60 + Integer.parseInt(out[1]);
                
                int time = minite - Integer.parseInt(in[1]);
                    
                ins.remove(str[1]);
                
                if(result.containsKey(str[1])) result.put(str[1], result.get(str[1]) + time);
                else result.put(str[1], time);
            }
        }
        
        ins.forEach((key,value)->{
            
            String[] in = value.split(":");
            
		    int hour = 23 - Integer.parseInt(in[0]);
            int minite = hour * 60 + 59;
            
            int time = minite - Integer.parseInt(in[1]);

            int total = 0;

            if(result.containsKey(key)) result.put(key, result.get(key) + time);
            else result.put(key, time);
	    });
        
        
        result.forEach((key, time)->{
            
         
            int total = 0;

            if(time < fees[0]) total = fees[1];
            else{
                total = fees[1];
                time-= fees[0];

                if(time % fees[2] != 0) total +=  ( ( (time/fees[2]) + 1 )  * fees[3] );
                else total += (time/fees[2]) * fees[3];
            }

            result.put(key, total);
	    });
        
        
        
        List<Integer> answer = new ArrayList<>(result.values());
        
        return answer;
    }

}
