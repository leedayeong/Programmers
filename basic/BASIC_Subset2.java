package basic;

import java.util.ArrayList;

// 0~9 까지의 숫자를 2개의 그룹으로 나눈뒤, 두 그룹 모두의 원소 수가 3보다 크거나 같은 경우만 출력 (두 그룹 모두 출력)
public class BASIC_Subset2 { // 5C3 
	
	static int COUNT = 0;
	static int[] src = {0,1,2,3,4,5,6,7,8,9};
	
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
			complete();
			return;
		}
		
		// 현재 srcIdx를 선택하고 간다.
		select[srcIdx] = true;
		subset(srcIdx + 1);
		
		// 현재 srcIdx를 선택안하고 간다.
		select[srcIdx] = false;
		subset(srcIdx + 1);
	}
	
	static void complete() {
		
		ArrayList<Integer> groupA = new ArrayList<>();
		ArrayList<Integer> groupB = new ArrayList<>();
		
		// 부분 집합에 포함된? 포함되지 않은? 확인 => select배열을 이용 
		for (int i = 0; i < select.length; i++) {
			
			if(select[i]) groupA.add(src[i]);
			else groupB.add(src[i]);
		}
		
		if(groupA.size()>=3 && groupB.size()>=3) {
			COUNT++;
			System.out.println("-----------------------");
			for (int n : groupA) {
				System.out.print(n + " ");
			}
			System.out.println();
			for (int n : groupB) {
				System.out.print(n + " ");
			}
			System.out.println();
			System.out.println();
		}
		
	}
}
