package programmers;
import java.util.*;

public class PR_행렬테두리회전하기 {

	static int[][] map;

    public List solution(int rows, int columns, int[][] queries) {
        List<Integer> answer = new ArrayList<>();

        map = new int[rows][columns];

        int num = 1;
        for(int i = 0; i < rows ; i++){
            for(int j = 0; j < columns ; j++){
                map[i][j] = num++;
            }
        }

        for(int[] query : queries){
            answer.add(rotate(query[0]-1, query[1]-1, query[2]-1, query[3]-1));
            // print(rows, columns);
        }

        return answer;
    }

    public static int rotate(int y1, int x1, int y2, int x2){
        int min = Integer.MAX_VALUE;

        int n = map[y1][x2];
        min = Math.min(n, min);
        for(int j = x2; j > x1; j--){
            map[y1][j] = map[y1][j-1];
            min = Math.min(map[y1][j], min);
        }

        int k = map[y2][x2];
        min = Math.min(k, min);
        for(int i = y2; i > y1+1; i--){
            map[i][x2] = map[i-1][x2];
            min = Math.min(map[i][x2], min);
        }
        map[y1+1][x2] = n;

        int l = map[y2][x1];
        min = Math.min(l, min);
        for(int j = x1; j < x2 - 1; j++){
            map[y2][j] = map[y2][j+1];
            min = Math.min(map[y2][j], min);
        }
        map[y2][x2-1] = k;

        for(int i = y1; i < y2-1; i++){
            map[i][x1] = map[i+1][x1];
            min = Math.min(map[i][x1], min);
        }
        map[y2-1][x1] = l;

        return min;
    }
    public static void print(int rows, int columns){
        System.out.println("=================");
        for(int i = 0; i < rows ; i++){
            for(int j = 0; j <  columns ; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
