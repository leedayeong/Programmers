package basic;

import java.util.Arrays;

public class BASIC_Perm { // 5P3 
	
	static int COUNT = 0;
	static int[] src = {1,2,3,4,5};
	static int[] tgt = new int[3]; // nPr 에서 r의 크기만큼 tgt배열만든다!
	
	static boolean[] select = new boolean[src.length];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		perm(0);
		System.out.println(COUNT);
	}
	
	static void perm(int tgtIdx) {
		// 기저조건
		if(tgtIdx == tgt.length) { // tgt배열이 r크기만큼 찼다면 => 순열들 중 하나가 완성된 것 !
			//complete code 순열이 완성되었음
			// 하고싶은 동작 하면 됨!
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}
		
		//순열이니깐 모든 src의 수를 고려한다.
		for (int i = 0; i < src.length; i++) {
			if(select[i]) continue; //현재 인덱스가 이미 tgt배열에 들어가 있다면 패스!
			tgt[tgtIdx] = src[i];
			select[i] = true;//tgt 배열에 넣었으므로 true
			perm(tgtIdx+1); //다음 인덱스 찾으러 가라!
			select[i] = false; //위에 perm 끝났으므로 다시 false로 바꿔줌! 
		}
	}
}
