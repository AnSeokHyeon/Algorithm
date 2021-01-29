// 통계학
package algo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Boj2108 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N]; // 1 ~ 500000 숫자 저장 
		int[] pick = new int[8001]; // 절대값 최대 4000이므로 -4000~ 0~ 4000 8001개 배열 선언

		int sum = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE; // max - min을 통한 구간을 구하기 위한 변수
		int cntmax = 0; // 최빈값들이 중복일 경우 cntmax와 같은 숫자를 같는 pick에 접근하기 위해
		
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
			
			pick[num[i]+4000]++; // 크기별 카운팅
			sum+=num[i]; 
			
			if(pick[num[i]+4000] > cntmax) cntmax = pick[num[i]+4000]; //카운팅 될수록 cntmax 증가
			if(num[i] > max) max = num[i];
			if(min > num[i]) min = num[i];
		}
		
		Arrays.sort(num); // 오름차순 정렬을 통한 중앙값 찾기를 위해 실시
		ArrayList<Integer> m = new ArrayList<Integer>(); // 카운팅된 배열을 돌아 최빈값을 값는 숫자들을 넣고 나중에 2번째로 작은 숫자를 꺼내기 위해
		
		for(int i = 0; i<8001; i++) {
			if(cntmax == pick[i]) {
				m.add(i-4000); // 최빈값을 갖는 작은수부터 카운트
			}
		}
		
		int gap = max - min;
		int avg = (int) Math.round((double)sum / N);
		
		System.out.println(avg); // 평균 출력
		System.out.println(num[N/2]); // 중앙값

		if(m.size() == 1) {
			System.out.println(m.get(0));
		}
		else {
			System.out.println(m.get(1));
		}
		
		System.out.println(gap); // 범위 출력
		bw.close();
		br.close();
		
		
	}

}
