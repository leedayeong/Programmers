package programmers;
import java.util.*;

public class PR_최소값만들기 {
	public int solution(int []A, int []B)
    {
        int length = A.length;
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < length; i++){
            answer += ( A[i] * B[length-1-i] );
        }

        return answer;
    }
}

