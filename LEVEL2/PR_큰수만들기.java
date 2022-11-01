package programmers;

public class PR_큰수만들기 {
	 public String solution(String number, int k) {
	        String answer = "";


	        int startIdx = 0;
	        int len = number.length();
	        int selectNum = len-k;
	        int select = len-k;

	        while(true){
	            if(k <= 0 || select == 0) break;

	            int max = number.charAt(startIdx) - '0';
	            int maxIdx = startIdx;

	            for(int i = startIdx + 1; i < len-(select-1) ; i++){

	                if(max == 9) break;
	                else if(max < number.charAt(i) - '0'){
	                    
	                    max = number.charAt(i) - '0';
	                    maxIdx = i;
	                  
	                }
	            } 

	            answer += number.charAt(maxIdx);
	            k-= (maxIdx - startIdx);

	            startIdx = maxIdx + 1;

	            select--;

	        }

	        if(answer.length() < selectNum){
	            for(int i = len - (selectNum - answer.length()); i < len ; i++){
	                answer += number.charAt(i);
	            }
	        }

	        return answer;
	    }
}