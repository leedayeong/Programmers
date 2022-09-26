package programmers;
import java.util.*;

public class PR_점프와순간이동 {

	public int solution(int n) {
        int ans = 0;

        while(true){
            if(n==0) break;
            if(n%2 == 0) n/= 2;
            else {
                ans++;
                n-=1;
            }
        }

        return ans;
    }

}
