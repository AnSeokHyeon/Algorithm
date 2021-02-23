package algo7;

// 2477 참외밭
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.StringTokenizer; // 입력을 쪼개서 받으려고 임포트

public class BOJ_2477 { // 클래스명BOJ_2477

	public static void main(String[] args) throws IOException { // 메인함수 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		int K = Integer.parseInt(br.readLine()); // 면적당 참외의 갯수
		int dir[] = new int[12]; // 참외밭 방향 배열
		int len[] = new int[12]; // 참외밭 방향에 따른 길이 배열
		int d = 0, l = 0; // 입력받기 위한 방향 d와 길이 l
		int oddLength = 0, evenLength = 0; // 입력 받으면서 최대값을 찾기 위한 변수
		for (int i = 0; i < 6; i++) { // 육각형이므로 6번으입력을 받음 
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 방향과 길이가 한번에 주어지므로 쪼개서 입력
			d = Integer.parseInt(st.nextToken()); // 방향 입력
			l = Integer.parseInt(st.nextToken()); // 길이 입력
			dir[i] = dir[i + 6] = d; // 탐색을 위해 인덱스 6번부터 똑같은 방향 배열을 만들어준다.
			len[i] = len[i + 6] = l; // 탐색을 위해 인덱스 6번부터 똑같은 길이 배열을 만들어 준다.
			if (i % 2 == 0) { // i가 짝수 일때
				evenLength = Math.max(evenLength, l); // 짝수 길이 최대값을 받고
			} else { // 홀수 일때
				oddLength = Math.max(oddLength, l); // 홀수 길이 최댓값을 받는다.
			} // if문 종료
		} // for문 종료
		
		int emptySize = 0; //비어 있는 공간을 입력 받을 변수

		for (int i = 0; i < 6; i++) { // 맨 마지막 까지만 탐색하면 되기 때문에 인데스 5번까지만 탐색
			if (dir[i] == dir[i + 2] && dir[i + 1] == dir[i + 3]) { // 방향 2개가 반복 된다면
				emptySize = len[i + 1] * len[i + 2]; // 중간 2개의 길이를 곱하면 비어있는 넓이가 나오게 된다.
				break; // 굳이 더 할필요 없으므로 브레이크
			} //if문 종료
		} // for문 종료 
		int result = (evenLength * oddLength - emptySize) * K; // 결과값은 (전체 넓이  - 비어있는 넓이 )* 면적당 참외 갯수

		bw.write(result + ""); // 결과값 출력
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 엔드
