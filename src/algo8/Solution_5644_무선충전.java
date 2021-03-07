package algo8;

// 
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 { // 클래스명

	static int dx[] = { 0, -1, 0, 1, 0 };
	static int dy[] = { 0, 0, 1, 0, -1 };

	static class Charge {
		int x;
		int y;
		int c;
		int p;

		public Charge(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}

	}

	public static void main(String[] args) throws IOException { // 메인함수 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			ArrayList<Charge> charger = new ArrayList<>();
			int dirA[] = new int[M+1];
			int dirB[] = new int[M+1];
			dirA[0] = dirB[0] = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <=M; i++) {
				dirA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= M; i++) {
				dirB[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				charger.add(new Charge(x, y, c, p));
			}
			int time = 0;
			int result = 0;
			int ax = 1;
			int ay = 1;
			int bx = 10;
			int by = 10;
			while (time <= M) {
				ax += dx[dirA[time]];
				ay += dy[dirA[time]];
				bx += dx[dirB[time]];
				by += dy[dirB[time]];
				boolean chargeA[] = new boolean[A]; 
				boolean chargeB[] = new boolean[A];

				// 충전 가능 체크
				for (int i = 0; i < A; i++) {
					int x = charger.get(i).x;
					int y = charger.get(i).y;
					int c = charger.get(i).c;
					int distanceA = Math.abs(x - ax) + Math.abs(y - ay);
					int distanceB = Math.abs(x - bx) + Math.abs(y - by);
					if (distanceA <= c)
						chargeA[i] = true;
					if (distanceB <= c)
						chargeB[i] = true;
				}
				

				// 충전 최대값 찾기
				int tempA = 0;
				int tempB = 0;
				int charge = 0;
				for (int i = 0; i < A; i++) {
					for (int j = 0; j < A; j++) {
						int temp = 0;
						if(i == j && chargeA[i] && chargeB[j] ) {
							temp = charger.get(i).p;
						}
						else {
							if(chargeA[i]) {
								tempA = charger.get(i).p;
							}
							else {
								tempA=0;
							}
							if(chargeB[j]) {
								tempB = charger.get(j).p;
							}
							else {
								tempB=0;
							}

							temp = tempA + tempB;
						}
						charge = Math.max(charge, temp);
					}
				}
				result += charge;
				

				time++;
			}

			sb.append("#" + (Tcnt++) + " " + result + "\n");

		}
		bw.write(sb.toString());
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 엔드
