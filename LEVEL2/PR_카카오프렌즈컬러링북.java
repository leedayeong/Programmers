package programmers;
import java.util.*;

public class PR_카카오프렌즈컬러링북 {

	 static boolean [][] visit;
	    
	    static int[] dy = new int[] {-1, 1, 0, 0};
	    static int[] dx = new int[] {0, 0, -1, 1};
	    
	    public int[] solution(int m, int n, int[][] picture) {
	        int numberOfArea = 0;
	        int maxSizeOfOneArea = 0;
	        
	        visit = new boolean[m][n];
	        
	        for(int i = 0 ; i < m ; i++){
	            for(int j = 0; j < n ; j++){
	                if(picture[i][j] != 0 && !visit[i][j]){
	                        numberOfArea++;
	                        maxSizeOfOneArea = Math.max(dfs(picture[i][j],i, j, 0, m, n, picture), maxSizeOfOneArea);
	                }
	            }
	        }
	       
	        int[] answer = new int[2];
	        answer[0] = numberOfArea;
	        answer[1] = maxSizeOfOneArea;
	        
	        return answer;
	    }
	    static int dfs(int color, int y, int x, int sum, int m, int n, int[][] picture){
	        
	        for(int d = 0; d < 4 ; d++){
	            int ny = dy[d] + y;
	            int nx = dx[d] + x;
	            
	            if(ny < 0 || nx < 0 || ny >= m || nx >= n || visit[ny][nx]) continue;
	            if(color != picture[ny][nx]) continue;
	            visit[ny][nx] = true;
	            sum++;
	            sum = dfs(color, ny, nx, sum, m, n, picture);
	        }
	        return sum;
	    }

}
