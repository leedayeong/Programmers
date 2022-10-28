package programmers;

public class PR_피로도 {

	 public static int[] src;
	    public static boolean[] select;
	    public static int[] tgt;
	    public static int N;
	    public static int max;
	    
	    public int solution(int k, int[][] dungeons) {
	        // int answer = -1;
	        
	        int len = dungeons.length;
	        N = len;
	        src = new int [N];
	        select = new boolean[N];
	        tgt = new int[N];
	        
	        max = 0;
	        
	        for(int i = 0; i < N ; i ++){
	            src[i] = i;
	        }
	        
	        perm(0, k, dungeons);
	        
	        return max;
	    }
	    public static void perm(int tgtIdx, int k, int[][] dungeons){
	        if(tgtIdx == N){
	            //complete
	            complete(k, dungeons);
	            return;
	        }
	        
	        for(int i = 0; i < N ; i ++){
	            if(select[i]) continue;
	            select[i] = true;
	            tgt[tgtIdx] = src[i];
	            perm(tgtIdx + 1, k, dungeons);
	            select[i] = false;
	        }
	    }
	    
	    public static void complete(int k, int[][] dungeons){
	        int cnt = 0;
	        int sum = k;
	        for(int i = 0; i < N ; i ++){

	            int need = dungeons[tgt[i]][0];
	            int minus  = dungeons[tgt[i]][1];

	            if(sum < need) break;
	            
	            cnt++;
	            sum-=minus;
	        }
	        max = Math.max(max, cnt);
	    }

}
