
// 2294 동전2
package algo7;

import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.Arrays; //Arrays 클래스의 메서드를 사용하기 위해 임포트
import java.util.StringTokenizer; // 입력을 쪼개서 받으려고 임포트

public class BOJ_2294 { // 클래스명 Boj2294

	public static void main(String[] args) throws IOException { // 메인함수 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 입력 쪼개기

		int N = Integer.parseInt(st.nextToken()); // 동전가치 N개
		int K = Integer.parseInt(st.nextToken()); // 동전 가치의 합 K
		int result = -1; // 결과값
		int[] value = new int[N]; // 가치 배열
		int[] sum = new int[K + 1]; // 합 배열
		Arrays.fill(sum, 100000); // 최소값을 찾는것이므로 최대 가치가 100000이여서 이것으로 통일

		for (int i = 0; i < N; i++) { // 반복문을 통해서
			value[i] = Integer.parseInt(br.readLine()); // value 배열에 동전 값 입력
		} // 포문 종료

		sum[0] = 0; // 가치 0은 0개이므로 0으로 초기화

		for (int i = 0; i < N; i++) { // 가치의 개수 N개 만큼 for문
			int v = value[i]; // i번째의 가치
			for (int j = v; j <= K; j++) { // v부터 포문  : 가치 v미만은 v가 0개이므로
				sum[j] = Math.min(sum[j], sum[j - v] + 1); // sum[j]와 sum[j-v]의 비교를 통해 최소값찾기
			} // sum for문 종료
		} // value for문 종료

		if (sum[K] < 100000) result = sum[K];  // 100000인경우는 계산이 불가능한경우이고 미만이면 계산이 가능햇던 경우이므로 결과값에 sum[K]를 넣어준다.

		bw.write(result + ""); // 최소값 출력
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 종료 ㅃㅇ
