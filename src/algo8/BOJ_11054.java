package algo8;

//11054 가장 긴 바이토닉 부분 수열
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11054 { // 클래스명

	public static void main(String[] args) throws IOException { // 메인함수 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max[] = new int[N];
		int min[] = new int[N];
		int result = 0;

		Arrays.fill(max, 1);
		Arrays.fill(min, 1);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					max[i] = Math.max(max[i], max[j] + 1);
				}
			}
		}
		for (int i = N - 1; i > -1; i--) {
			for (int j = N - 1; j > i; j--) {
				if (arr[i] > arr[j]) {
					min[i] = Math.max(min[i], min[j] + 1);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			result = Math.max(result, max[i] + min[i] - 1);
		}
		bw.write(result + "");
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 엔드
