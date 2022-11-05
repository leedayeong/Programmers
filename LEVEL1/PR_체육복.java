package programmers;

import java.util.*;

public class PR_체육복 {
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        boolean [] lostCheck = new boolean[n+1];
        boolean [] reserveCheck = new boolean[n+1];

        for (int r : reserve){
            reserveCheck[r] = true;
        }

        Arrays.sort(lost);

        for (int l : lost){
            if(reserveCheck[l]) {
                reserveCheck[l] = false;   
                continue;
            }
            lostCheck[l] = true;
        }


        for (int l : lost){
            if(!lostCheck[l]) continue;
            if(l == 1){
                if(reserveCheck[l+1]) {
                    lostCheck[l] = false;
                    reserveCheck[l+1] = false;
                } 
            }else if(l == n){
                if(reserveCheck[l-1]) {
                    lostCheck[l] = false;
                    reserveCheck[l-1] = false;
                }
            }else{
                if(reserveCheck[l-1]) {
                    lostCheck[l] = false;
                    reserveCheck[l-1] = false;
                }else if(reserveCheck[l+1]){
                    lostCheck[l] = false;
                    reserveCheck[l+1] = false;
                }
            }
        }

        int num = 0;
        for (int l : lost){
            if(lostCheck[l]) num++;
        }


        return answer-num;
    }
}

