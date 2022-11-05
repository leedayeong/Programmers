package basic;

import java.util.Arrays;

public class BASIC_Comb2 { // 5C3 
	
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
		
		// srcIdx에 대한 기저조건도 필요 (배열범위 넘어가기 때문에!)
		if(srcIdx == src.length) return;
		
		tgt[tgtIdx] = src[srcIdx];
		
		comb(srcIdx + 1, tgtIdx + 1); // src 증가, tgt 증가 => 현재 srcIdx를 tgt가 받아들이고 다음으로 간다. 
		comb(srcIdx + 1, tgtIdx); //src 증가, tgt 증가X (그대로) => 현재 srcIdx를 tgt가 안받겠다. 난 그대로 있을거니깐 너는 다음것을 들고와라!
	}
}
