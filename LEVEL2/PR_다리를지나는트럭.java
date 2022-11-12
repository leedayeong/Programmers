package programmers;

import java.util.*;

public class PR_다리를지나는트럭 {
    public static int[] parent = new int [101];
    public int solution(int n, int[][] wires) {
        int answer = 1000;
        
        for(int i = 0; i < n-1; i++){
            System.out.println("i : " + wires[i][0] + ", " + wires[i][1]);
            int cnt = 1;
            
            for(int j = 1; j <= n; j++){
                parent[j] = j;
            }
            
            for(int j = 0; j < n-1; j++){
                if(i==j) continue;
                union(wires[j][0], wires[j][1]);
            }
            for(int j = 1; j <= n; j++){
               find(j);
            }
            for(int j = 1; j <= n; j++){
                System.out.print(parent[j] + " ");
            }
            
            int before = parent[1];
            for(int j = 2; j <= n; j++){
                if(before!=parent[j]) continue;
                else cnt++;
            }

            
            int cnt2 = n - cnt;
            System.out.println();
            System.out.println( "cnt : " + cnt +", cnt2 : " + cnt2);
            System.out.println();
            answer=Math.min(answer, Math.abs(cnt-cnt2));
        }
        
        
        return answer;
    }
    
    public static int find(int x){
        if ( x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }
    
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x!=y){
            parent[x] = Math.max(x, y);
            parent[y] = Math.max(x, y);
        }
    }
}
