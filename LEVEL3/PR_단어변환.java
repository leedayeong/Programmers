package programmers;

import java.util.*;

public class PR_단어변환 {

	 static boolean[] visit;
	    static int N;
	    
	    public int solution(String begin, String target, String[] words) {
	        int answer = 0;
	        
	        N = words.length;
	        visit = new boolean[N];
	        
	        return bfs(begin, target, words);
	    }
	    public int bfs(String begin, String target, String[] words){
	        Queue<Node> queue = new LinkedList<>();
	        
	        queue.add(new Node(begin, 0));
	        int length = begin.length();
	        
	        while(!queue.isEmpty()){
	            Node node = queue.poll();
	            if(node.str.equals(target)) return node.depth;
	            
	            for(int i = 0; i < N; i++){
	                if(visit[i]) continue;
	                
	                int cnt = 0;
	                for(int j =0; j < length; j++){
	                    char ch1 = node.str.charAt(j);
	                    char ch2 = words[i].charAt(j);
	                    if(ch1!= ch2) cnt++;
	                    if(cnt > 1) break;
	                }
	                if(cnt == 1) {
	                    queue.offer(new Node(words[i], node.depth + 1));
	                    visit[i] = true;
	                }
	            }
	            
	        }
	        
	        return 0;
	    }
	    public static class Node{
	        String str;
	        int depth;
	        
	        public Node(String str, int depth){
	            this.str = str;
	            this.depth = depth;
	        }
	    }
}
