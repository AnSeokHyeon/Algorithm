package algo8;

// 10844 쉬운계단수
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트

public class BOJ_10844 { // 클래스명

	public static void main(String[] args) throws IOException { // 메인함수 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		int N = Integer.parseInt(br.readLine());
		int[][] sum = new int[N+1][11];

		for (int i = 1; i <= 9; i++) {
			sum[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			sum[i][0] = sum[i - 1][1];
			for (int j = 1; j <= 9; j++) {
				sum[i][j] = (sum[i - 1][j - 1] + sum[i - 1][j + 1]) % 1000000000;
			}
		}

		int result = 0;
		for (int i = 0; i < 10; i++) {
			result += sum[N][i];
			result %= 1000000000;
		}

		bw.write(result + "");
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 엔드
