package algo8;

// 2156 포도주 시식
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트

public class BOJ_2156 { // 클래스명

	public static void main(String[] args) throws IOException { // 메인함수 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		int N = Integer.parseInt(br.readLine());
		int wine[] = new int[N+1];
		int max[] = new int[N+1];
		
		for(int i = 1; i<=N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		max[0] = 0;
		max[1] = wine[1];
		if(N > 1) 
			max[2] = max[1] + wine[2];
		for(int i =3; i<=N; i++) {
			max[i] = Math.max(Math.max(max[i-1],wine[i] + wine[i-1] + max[i-3]),wine[i] + max[i-2]);
		}
		

		bw.write(max[N] + "");
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 엔드
