// 2331 반복수열
package algo6; // 패키지 algo6
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.LinkedList; // 연결리스트중 하나인 큐를 사용하기 위해 임포트
import java.util.Queue; // 큐 임포트
import java.util.StringTokenizer; // 쪼개서 입력받으려고 임포트

public class Boj2331 { // 백준 2331번을 풀고 있어서 Boj2331
	static int chk[]; // 수열 체크
	static int N, P; // 시작 숫자 N과 P제곱

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 수열을 시작할 숫자와 몇 제곱을 할지 입력을 받아야 하므로 쪼개서 받자.
		chk = new int[240000]; // 9^5 *4가 최대이므로 240000 할당
		N = Integer.parseInt(st.nextToken()); // 첫번째 토큰
		P = Integer.parseInt(st.nextToken()); // 두번째 토큰

			// 입력이 끝났습니다. 시작 숫자를 큐에 넣고 너비우선탐색을 실시해보도록 하겠습니다.
		Queue<Integer> q = new LinkedList<Integer>(); // 너비 우선탐색을위해 큐를 선언해줍니다.
		q.add(N); // x 를 넣어줍시다.
		chk[N] = 1; // 더이상 x는 확인하지 않아도 됩니다.
		int result = 1; // 수열을 시작하는 N을 집어 넣으므로 일단 1개 시작
		String S = ""; // 문자열 S 선언
		while (!q.isEmpty()) // 큐가 비어있지 않는 동안 진행됨

			
		{ // 오프닝 여는 중괄호
			Integer top = q.poll(); // 큐 헤드 값을 꺼내서 top에 저장하고 삭제
			if (chk[top] > 2) { // top이 3번 나오면 2바퀴 돌아쓰니간 반복이라고 생각하고 종료
				break; // 큐를 끝내버린다.
			} // if문 종료
			
			S = Integer.toString(top); // top을 자릿수별로 계산하기 위해 문자열로 변환
			int size = S.length(); // S의 길이를 한번만 참조하기 위해 SIZE변수에 저장
			int next = 0; // 다음 큐에 집어 넣을 변수 
			
			for(int i = 0; i<size; i++) { //문자열 SIZE만큼 FOR문
				
				next += (int)Math.pow(S.charAt(i) - '0', P); // 각 숫자별 P제곱을 해서 더함
			} // 포문 종료
			
			chk[next]++; // 다음 숫자를 체크해준다.
			if(chk[next] == 1) result++; //다음숫자가 한번 나왔으면 결과값에 더하고
			if(chk[next] == 2) result--; //두번 등장하면 중복이므로 뺀다. 
			
			q.add(next); // 다음 숫자를 큐에 넣는다.

		} // 클로징 닫는 중괄호

		bw.write(result + ""); // 결과값 출력
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료
}// 프로그램 종료 ㅃㅇ
