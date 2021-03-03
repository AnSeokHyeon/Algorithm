package algo8;

// 1932 정수 삼각형
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.StringTokenizer; // 입력을 쪼개서 받으려고 임포트

public class BOJ_1932 { // 클래스명

	public static void main(String[] args) throws IOException { // 메인함수 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성
		
		int N = Integer.parseInt(br.readLine());
		int board[][] = new int[N][N];
		int sum[][] = new int[N][N];
		
		for(int i = 0; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<=i; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sum[0][0] = board[0][0];

		for(int i = 1; i<N ; i++) {
			
			for(int j = 0; j<=i; j++) {
				if(j == 0) {
					sum[i][j] = sum[i-1][j] + board[i][j];
				}
				else if(j == i) {
					sum[i][j] = sum[i-1][j-1] + board[i][j];
				}
				else {
					sum[i][j] = Math.max(sum[i-1][j], sum[i-1][j-1]) + board[i][j];

				}
			}
		}
		int result =0;
		for(int i = 0; i<N; i++) {
			if(sum[N-1][i] > result)
				result = sum[N-1][i];
		}
		
		bw.write(result + "");
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

	
}// 프로그램 엔드
