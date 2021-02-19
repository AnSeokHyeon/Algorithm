package algo6;

import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.StringTokenizer;

public class Solution_SWEA_3234_준환이의양팔저울_안석현 {
	static int total;
	static int weight[];
	static int N, result;
	static int fact[];
	static int pow[];

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성
		pow = new int[20];
		fact = new int[20];

		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();
		factorial();
		power();
		while (T-- > 0) {

			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			result = 0;
			total = 0;

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
				total += weight[i];
			}
			
			
			cal(0, 0, 0, 0, total);
			sb.append("#" + (Tcnt++) + " " + result + "\n");
		}

		bw.write(sb.toString());
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

	static void cal(int depth, int flag, int rsum, int lsum, int total) {

		if (depth == N) {
			result++;
			return;
		}
		if (lsum >= total + rsum) {
			result += fact[N-depth]*pow[N-depth];
			return;
		}


		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			int now = weight[i];
			cal(depth + 1, flag | 1 << i, rsum, lsum + weight[i], total - now);
			if(rsum + weight[i] > lsum) continue;
			cal(depth + 1, flag | 1 << i, rsum + weight[i],lsum, total -now);

		}

	}
	
	static void factorial() {
		fact[0] = 1; fact[1] = 1;
		for(int i = 2; i<10; i++) {
			fact[i] = i*fact[i-1];
		} 
		
	}
	
	static void power() {
		pow[0] = 1; pow[1] = 2;
		for(int i = 2; i<10; i++) {
			pow[i] = 2*pow[i-1];
		} 
		
	}

}// 프로그램 종료 ㅃㅇ
