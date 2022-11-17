package study_0906;

import java.util.*;

class PR_프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Node> queue = new LinkedList<>();
        
        int len = priorities.length;
    
        for(int i = 0; i < len; i++){
            if(i == location) queue.offer(new Node(priorities[i], true));
            else queue.offer(new Node(priorities[i], false));
        }
        
        Arrays.sort(priorities);
        
        int idx = len - 1;
        
        while(true){
            
            
            if(priorities[idx] == queue.peek().priority) {
                answer++;
                if(queue.peek().chk ) break;
                // answer++;
                queue.poll();
                idx--;
            }
            else{
                queue.offer(queue.poll());
            }
            
        }
    
        return answer;
    }
    public static class Node{
        int priority;
        boolean chk;
        
        public Node(int priority, boolean chk){
            this.priority = priority;
            this.chk = chk;
        }
    }
}