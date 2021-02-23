package algo7;

// 10163 색종이
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.StringTokenizer; // 입력을 쪼개서 받으려고 임포트

public class BOJ_10163 { // 클래스명 Boj10163

	public static void main(String[] args) throws IOException { // 메인함수 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		int board[][] = new int[101][101]; // 색종이는 가로세로 101칸이므로 101칸
		int N = Integer.parseInt(br.readLine()); // 입력 받을 색종이 갯수 
		int num = 1; // 색종이별 인덱스 설정
		int cnt[] = new int[N + 1]; // 색종이 인덱스의 갯수 배배열
 
		while (num <= N) { // 인덱스가 갯수보다 크면 false
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 색종이 좌표 정보 쪼개서 입력 받기
			int x = Integer.parseInt(st.nextToken()); //색종이 시작 x
			int y = Integer.parseInt(st.nextToken()); //색종이 시작 y

			int dx = Integer.parseInt(st.nextToken()); // 색종이 x 너비
			int dy = Integer.parseInt(st.nextToken()); // 색종이 y 너비
			for (int i = x; i < x + dx; i++) { // x부터 x+dx까지 새길
				for (int j = y; j < y + dy; j++) { // y부터 y+dy까지 색칠
					board[i][j] = num; // 인덱스로 색칠
 				} //칠하기 완료
			} // 칠하기 완료
			num++; // 인덱스 하나 늘려주기

		}

		for (int i = 0; i < 101; i++) { //x 101칸 만큼
			for (int j = 0; j < 101; j++) { // y 101만큼 탐색
				cnt[board[i][j]]++; //칠해진 인덱스에 따라 갯수 늘려주기
			} // for문 종료
		} // for문 종료
		StringBuilder sb = new StringBuilder(); //StringBuilder에 담아 정답 출력
		for (int i = 1; i <= N; i++) { // 인덱스 1번부터 N번까지의 색종이 cnt[] 접근
			sb.append(cnt[i] + "\n"); // 색종이 갯수 담기
		} // for문 종료

		bw.write(sb.toString()); // 결과값 출력
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 종료 ㅃㅇ
