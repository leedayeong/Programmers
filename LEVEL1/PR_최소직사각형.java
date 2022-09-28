package programmers;
import java.util.*;

public class PR_최소직사각형 {

    public int solution(int[][] sizes) {
        int answer = 0;
        int row = 0;
        int col = 0;
        
        for(int[] size : sizes){
            if(size[0] > size[1]) {
                row = Math.max(row, size[0]);
                col = Math.max(col, size[1]);
            }
            else {
                row = Math.max(row, size[1]);
                col = Math.max(col, size[0]);
            }
        }
        // System.out.println("row : " + row);
        // System.out.println("col : " + col);
        answer = row * col;
        return answer;
    }

}
