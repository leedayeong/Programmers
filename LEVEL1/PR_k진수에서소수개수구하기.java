package programmers;
import java.util.*;

public class PR_k진수에서소수개수구하기 {

	public int solution(int n, int k) {
        int answer = 0;
        answer = make(n, k, answer);
        
        return answer;
    }
    public static int make(int n, int k, int answer){
        List<Integer> nums = new ArrayList<>();
        
        while(true){
            if(n == 0) break;
            nums.add(n%k);
            n/=k;
        }
        String s = "";
        int len = nums.size();
        for(int i = len-1; i >= 0; i--){
            s+= nums.get(i);
        }
        
        String[] numbers = s.split("0");
        
        for(String number : numbers){
            // System.out.println(number);
            if(number.equals("")) continue;
            try{
                if(isPrime(Long.parseLong(number))) answer++;
            }catch(Exception e){
                continue;
            }
            
        }
        
        return answer;
    }
    public static boolean isPrime(long n){
        // System.out.println(n);
        if(n < 2) return false; // 0 과 1은 소수가 아님
        for(int i = 2; i <= Math.sqrt(n) ; i++){
            if(n%i == 0) return false;
        }
        return true;
    }

}
