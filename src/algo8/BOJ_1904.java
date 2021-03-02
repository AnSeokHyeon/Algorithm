// 1904 01타일
package algo8; // algo8 패키지
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트

public class BOJ_1904 {

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성
		
		int num[] = new int[1000001]; // 입력 받는 수가 최대 일백만 이므로 일백만일 배열 선언
		
		// 초기값 선언
		num[0] = 0; 
		num[1] = 1;
		num[2] = 2;
		for(int i = 3; i<1000001; i++) {
			num[i] = num[i-1] + num[i-2];
			num[i] = num[i]%15746;
		}
		int N = Integer.parseInt(br.readLine());
		
		bw.write((num[N]%15746) + "");
		br.close();
		bw.close();
	}
}
