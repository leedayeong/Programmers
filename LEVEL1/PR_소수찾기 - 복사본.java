package programmers;
import java.util.*;

public class PR_소수찾기 {

    public static int[] src;
    public static boolean[] select;
    public static int N=0;
    public static Set<Integer> set;
    public int solution(String numbers) {
        
        int len = numbers.length();
        N = len;
        src = new int[N];
        select = new boolean[N];
        
        set = new HashSet<>();
        
        for(int i = 0; i < len; i++){
            src[i] = numbers.charAt(i) - '0';
            // System.out.print(src[i] + " ");
        }
        
        
        subset(0);
        
        return set.size();
    }
    public static void subset(int srcIdx){
        if(srcIdx == N){
            // complete code
            // System.out.println("=========");
            complete();
            return;
        }
        
        select[srcIdx] = true;
        subset(srcIdx+1);
        
        select[srcIdx] = false;
        subset(srcIdx+1);
    }
    public static void complete(){
        List<Integer> groupA = new ArrayList<>();
        for(int i = 0; i < N ; i ++){
            if(select[i]) groupA.add(src[i]);
        }
        
        int M = groupA.size();
        boolean[] visit = new boolean[M];
        int[] tgt = new int[M];
        // System.out.println(M);
        // System.out.println("=========");
        // for(Integer a : groupA){
        //     System.out.print(a + " ");
        // }
        perm(M, 0, visit, tgt, groupA);
    }
    public static void perm(int M, int idx, boolean[] visit, int[] tgt, List<Integer> groupA){
        if(idx == M){
            int sum = 0;
            for(int i = 0; i < M ; i++){
                sum += (Math.pow(10, (M-i-1)) * tgt[i]);
                if(isPrime(sum)) set.add(sum);
            }
            // System.out.println(sum);
            return;
        }
        
        for(int i = 0; i < M ; i++){
            if(visit[i]) continue;
            visit[i] = true;
            tgt[idx] = groupA.get(i);
            perm(M, idx+1, visit, tgt, groupA);
            visit[i] = false;
        }
    }
    public static boolean isPrime(int n){
        if(n < 2) return false;
        int len = (int) Math.sqrt(n);
        for(int i = 2; i <= len; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}
