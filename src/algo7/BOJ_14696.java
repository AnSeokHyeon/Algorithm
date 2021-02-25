package algo7;

// 14696 딱지놀이
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.Arrays; //Arrays.fill 메서드 사용을 위한 임포트
import java.util.StringTokenizer; // 입력을 쪼개서 받으려고 임포트

public class BOJ_14696 { // 클래스명

	public static void main(String[] args) throws IOException { // 메인함수 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		int A[] = new int[5]; // A의 세모 네모 동그라미 별 배열 
		int B[] = new int[5]; // B의 세모 네모 동그라미 별 배열
		StringBuilder sb = new StringBuilder(); // 정답 출력을 위한 스트링 빌더
		char C; // 결과값을 저장하기 위한 변수
		StringTokenizer st; // 쪼개서 입력 받기 위해 StringTokenizer 사용
		int N = Integer.parseInt(br.readLine()); // N 의 갯수를 입력 받음
		while (N-- > 0) { // N만큼 WHILE문 진행
			C = 'D'; // 결과값은 무승부로 초기화
			Arrays.fill(A, 0); // A배열 모두 0으로 초기화
			Arrays.fill(B, 0); // B배열 모두 0으로 초기화

			st = new StringTokenizer(br.readLine(), " "); //A의 딱지 현황 입력 시작
			int a = Integer.parseInt(st.nextToken()); // A의 딱지 보유 갯수 a
			for (int i = 0; i < a; i++) { // for문을 a번 만큼
				A[Integer.parseInt(st.nextToken())]++; // 입력 받은 딱지의 인덱스에 다른 갯수 상승
			} // for문 종료
			st = new StringTokenizer(br.readLine(), " "); //B의 딱지 현황 입력 시작
			int b = Integer.parseInt(st.nextToken()); // B의 딱지 보유 갯수 a
			for (int i = 0; i <b; i++) {// for문을 b번 만큼
				B[Integer.parseInt(st.nextToken())]++;// 입력 받은 딱지의 인덱스에 다른 갯수 상승
			} // for문 종료

			for (int i = 4; i > 0; i--) { // 별 동그라미 네모 세모 순으로 탐색
				if (A[i] == B[i])	continue; // 별 동그라미 네모 세모 순으로 탐색 , 같으면 컨티뉴
				if (A[i] > B[i]) // i딱지의 갯수가 A가 많으면
					C = 'A'; // A 승
				else // 아니면
					C = 'B'; // B 승
				break;
			} // for문 종료
			sb.append(C + "\n"); // 겨과값 추가

		} // while문 종료
		bw.write(sb.toString()); // 결과값 출력
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 엔드
