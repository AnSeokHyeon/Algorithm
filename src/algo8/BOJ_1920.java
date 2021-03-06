package algo8;

//1920 수찾기
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 { // 클래스명
	static int N;
	static int arr[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException { // 메인함수 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		while (M-- > 0) {
			binarySearch(Integer.parseInt(st.nextToken()));
		}
		bw.write(sb.toString());
		bw.close(); // 출력 종
		br.close(); // 입력 종료
	}// 메임함수 종료

	static void binarySearch(int num) {
		int left = 0;
		int right = N - 1;
		int mid = 0;
		int result = 0;
		while (left <= right) { // left > right이면 종료
			mid = (left + right) / 2; // mid 설정
			if (arr[mid] > num) { // 찾는 값이 현재 값보다 작은 경우
				right = mid - 1;
			} else if (arr[mid] < num) { // 찾는 값이 현재 값보다 큰 경우
				left = mid + 1;
			} else {
				result = 1;
				break;
			}
		}

		sb.append(result + "\n");

	}

}// 프로그램 엔드
