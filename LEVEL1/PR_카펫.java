package programmers;

public class PR_카펫 {

public int[] solution(int brown, int yellow) {
        
        int num = brown/2;

        int row = 0;
        int col = 0;
        for(int i = 3; i < num; i++){
            int j = num-i;
            if((i-2)*j == yellow) {
                if(i >= j+2) {
                    row = i;
                    col = j+2;
                }else{
                    row = j+2;
                    col = i;
                }
                break;
            }
        }

        int[] answer = new int[]{row, col};
        return  answer;
    }
}
