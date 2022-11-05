package programmers;

public class PR_멀쩡한사각형 {

	 public long solution(int w, int h) {
	        long answer = 0;
	        
	        while(w != 0 && h != 0){
	            if(w>h){
	                answer+= ((long)h*(long)h) -(long)h;
	                w-=h;
	            }else{
	                answer+= ((long)w*(long)w) -(long)w;
	                h-=w;
	            }
	        }
	        
	        return answer;
	    }

}
