package study_0906;

import java.util.*;

class PR_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        int len = genres.length;
        
        List<Integer> ans = new ArrayList<>();
        
        List<Node> list = new ArrayList<>();
        
        for(int i = 0; i < len; i++){
            list.add(new Node(i, genres[i], plays[i], 0));
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        
        for(int i = 0; i < len; i++){
            Node node = list.get(i);
            node.sum = map.get(node.genre);
            
            list.set(i, node);
        }
        
        Collections.sort(list, (o1, o2) -> o2.sum == o1.sum ? (o2.play == o1.play ? o1.num - o2.num : o2.play - o1.play) : o2.sum - o1.sum);
 
        String before = list.get(0).genre;
        ans.add(list.get(0).num);
        int cnt = 1;
        
        for(int i = 1; i < len; i++){
            
            Node node = list.get(i);
            
            if(before.equals(node.genre)) cnt++;
            else cnt = 1;
            
            if(cnt > 2) continue;
            
            ans.add(node.num);
            before = node.genre;
            
            list.set(i, node);
        }
        
        int size = ans.size();
        
        int[] answer = new int[size];
        for(int i = 0; i < size; i++){
            answer[i] = ans.get(i);
        }
        
        
        
        // int[] answer = {};
        return answer;
    }
    
    public static class Node{
        int num;
        String genre;
        int play;
        int sum;
        
        public Node(int num, String genre, int play, int sum){
            this.num = num;
            this.genre = genre;
            this.play = play;
            this.sum = sum;
        }
    }    
}