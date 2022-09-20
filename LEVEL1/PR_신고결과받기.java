package programmers;
import java.util.*;

public class PR_신고결과받기 {

	public int[] solution(String[] id_list, String[] report, int k) {
        int N = id_list.length;
        
        int[] answer = new int[N];
        
        boolean[][] select = new boolean[N][N];
        
        for(String rep : report){
            String[] str = rep.split(" ");
            int idx1 = 0;
            for(String id : id_list){
                if(str[0].equals(id)) break;
                idx1++;
            }
            int idx2 = 0;
            for(String id : id_list){
                if(str[1].equals(id)) break;
                idx2++;
            }

            select[idx1][idx2] = true;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        
        
        for(int j = 0; j < N ; j++){
            int cnt = 0;
            for(int i = 0; i < N; i++){
                if(select[i][j]) {
                    cnt++;
                    if(cnt >= k) {
                        set.add(j);
                    }
                }
            }
        }
        
        Iterator<Integer> it = set.iterator(); 

		while (it.hasNext()) { 
			int j = it.next();
            for(int i = 0; i < N; i++){
                if(select[i][j]) {
                    answer[i]++;
                }
            }
        }
		
        return answer;
    }

}