// 1149 RGB 거리
package algo8; // algo8 패키지
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.StringTokenizer; // 쪼개서 입력받기 위해 임포트

public class BOJ_1149 {

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성
		int N = Integer.parseInt(br.readLine()); // 색칠할 갯수 N 을 입력 받음
		int RGB[][] = new int[N][3]; // N개의 집의 RGB 각각 비용 배열
		int minMoney[][] = new int[N][3]; // 최소 비용 배열

		//RGB N개 입력 받기
		for (int i = 0; i < N; i++) { 
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				RGB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 최소비용 초기화
		minMoney[0][0] = RGB[0][0];
		minMoney[0][1] = RGB[0][1];
		minMoney[0][2] = RGB[0][2];
		
		// 같은 색깔이 아닌 것 중에서 최소비용에 현재 색칠할 색깔 비용 더하기
		for (int i = 1; i < N; i++) {
			minMoney[i][0] = Math.min(minMoney[i - 1][1], minMoney[i - 1][2]) + RGB[i][0];
			minMoney[i][1] = Math.min(minMoney[i - 1][0], minMoney[i - 1][2]) + RGB[i][1];
			minMoney[i][2] = Math.min(minMoney[i - 1][0], minMoney[i - 1][1]) + RGB[i][2];
		}

		int result = Integer.MAX_VALUE;

		for (int i = 0; i < 3; i++) {
			
			if (result > minMoney[N - 1][i])
				result = minMoney[N-1][i];
		}

		bw.write(result + "");
		br.close();
		bw.close();
	}
}
