// 1912 연속합
package algo7;
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.StringTokenizer; // 입력을 쪼개서 받으려고 임포트

public class BOJ_1912 { // 클래스명 Boj1912

	public static void main(String[] args) throws IOException{ // 메인함수 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		int N = Integer.parseInt(br.readLine()); // 몇개의 정수인지 N에 입력 받음
		int[] sum = new int[N]; // 합 배열
		int[] num = new int[N]; // 수열 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine()," "); //입력 쪼개기
		
		for(int i = 0 ; i < N; i++) { // 반복문을 통해서
			num[i] = Integer.parseInt(st.nextToken()); // num 배열에 입력값을 입력
		} // 포문 종료
		
		sum[0] = num[0]; // sum[0]는 num[0]이므로 저장
		int max = sum[0]; // sum[0]를 max로 시작
		
		
		for( int i = 1 ; i < N; i++) { // 인덱스 0의 값들은 모두 저장되어 있으므로 1부터 N-1까지 시행
			sum[i] = Math.max(sum[i-1] + num[i], num[i] ); // 현재 num과 현재num과 전의 sum을 합한 결과를 비교하여 큰것을 sum에 넣는다.
			max = Math.max(max, sum[i]); // sum 결과를 비교하여 max값을 뽑아낸다.
		} // 반보ㄱ문 종료
		bw.write(max +""); // 최댓값 출력
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 종료 ㅃㅇ
