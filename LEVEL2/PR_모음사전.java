package programmers;

import java.util.*;

public class PR_모음사전 {

    public static char[] src = {' ', 'A', 'E', 'I', 'O', 'U'};
    public static char[] tgt = new char[5];
    public static int N = 5;
    public static int cnt = 0;
    public static boolean chk = false;
    public static Set<String> set = new HashSet<String>();
    public int solution(String word) {
        int answer = 0;
        
        for(int i = 1; i <= N; i++){
            tgt[0] = src[i];
            perm(1, word);
        }
        
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        
        answer = list.indexOf(word);
        
        return answer+1;
    }
    public static void perm(int tgtIdx, String word){
        if(tgtIdx == N){
            //complete
            String newWord = "";
            for(int i = 0; i  < N; i++){
                if(tgt[i] == ' ') continue;
                newWord += tgt[i];
            }
            
            set.add(newWord);

            return;
        }
        
        if(chk) return;
        
        for(int i = 0; i < 6; i++){
            tgt[tgtIdx] = src[i];
            perm(tgtIdx+1, word);
        }
    }

}
