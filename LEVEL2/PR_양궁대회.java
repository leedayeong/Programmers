package programmers;

public class PR_양궁대회 {
	
	 static int[] target = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	    
	 static int[] result;
	 static int[] answer;
	    
	 static int N;
	 static int max = -1;

	 public int[] solution(int num, int[] info) {
	        
	        
	        N = num;
	        result = new int[N];
	        comb(0, 0, info);
	        return answer == null ?  ( new int[]{-1}) : answer;
	    }
	    
	    public static void comb(int cnt, int idx, int[] info) {
	        if (cnt == N){
	            // complete code
	            complete(info);
	            return;
	        }
	        
	        for( int i = idx; i < 11; i++){
	            result[cnt] = target[i];
	            comb(cnt+1, i, info);
	        }
	    }
	    
	    public static void complete(int[] info){
	        int sumA = 0;
	        int sumB = 0;
	        
	        int[] lion = new int[11];
	        for(int i = 0; i < N; i++){
	            lion[10-result[i]]++;
	        }
	        
	        for(int i = 0; i < 11; i++){
	            if(info[i] == 0 && lion[i] == 0) continue;
	            if(info[i] >= lion[i]) sumA += (10-i);
	            else sumB += (10-i);
	        }
	        
	        int diff = (sumA < sumB )? (sumB - sumA) : -1;
	        if(max < diff){
	            max = diff;
	            answer = lion;
	        }
	    }

}
