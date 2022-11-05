package basic;

import java.util.Arrays;

public class BASIC_Subset { // 5C3 
	
	static int COUNT = 0;
	static int[] src = {1,2,3,4,5};
	
	static boolean[] select = new boolean[src.length]; //********** 제일 중요!!
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subset(0);
		System.out.println(COUNT);
	}
	
	static void subset(int srcIdx) {
		// 기저조건
		if(srcIdx == src.length) { // tgt배열이 없으므로 src배열을 전부 다 확인했으면 탈출!
			//complete code
			printSubset();
			COUNT++;
			return;
		}
		
		// 현재 srcIdx를 선택하고 간다.
		select[srcIdx] = true;
		subset(srcIdx + 1);
		
		// 현재 srcIdx를 선택안하고 간다.
		select[srcIdx] = false;
		subset(srcIdx + 1);
	}
	
	static void printSubset() {
		// 부분 집합에 포함된? 포함되지 않은? 확인 => select배열
		System.out.print("{");
		for (int i = 0; i < select.length; i++) {
			if(select[i]) System.out.print(src[i] + " ");
		}
		System.out.println("}");
	}
}
