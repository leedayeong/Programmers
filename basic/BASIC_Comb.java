package basic;

import java.util.Arrays;

public class BASIC_Comb { // 5C3 
	
	static int COUNT = 0;
	static int[] src = {1,2,3,4,5};
	static int[] tgt = new int[3]; // nPr 에서 r의 크기만큼 tgt배열만든다!
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		comb(0, 0);
		System.out.println(COUNT);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		// 기저조건
		if(tgtIdx == tgt.length) { // tgt배열이 r크기만큼 찼다면 => 조합들 중 하나가 완성된 것 !
			//complete code 조합이 완성되었음
			// 하고싶은 동작 하면 됨!
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}
		
		//조합이므로 이전에 src에서 사용한 것은 고려하지 않는다 => i가 0 부터시작하지않고 srcIdx부터 시작!
		for (int i = srcIdx; i < src.length; i++) {
			tgt[tgtIdx] = src[i];
			comb( i+1, tgtIdx+1); // srcIdx + 1:이전에 src사용한것은 고려하지 않기 때문에, tgtIdx + 1:다음 idx 조합 값 넣기 위해 ! 
		}
	}
}
