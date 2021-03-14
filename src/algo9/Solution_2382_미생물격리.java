package algo9;

// 
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2382_미생물격리 { // 클래스명

	static class Virus {
		int x;
		int y;
		int size;
		int dir;

		public Virus(int x, int y, int size, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.dir = dir;
		}

	}

	static int dx[] = { 0, -1, 1, 0, 0 };
	static int dy[] = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException { // 메인함수 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int board[][] = new int[N + 1][N + 1];
			ArrayList<Virus> virus = new ArrayList<>();
			while (K-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				virus.add(new Virus(x, y, s, d));
			}
			int timer = 0;
			while (timer < M) {
				// 군집 이동
				for (int i = 0; i < N; i++) {
					Arrays.fill(board[i], 0);
				}
				int size = virus.size();
				for (int z = 0; z < size; z++) {

					int x = virus.get(z).x;
					int y = virus.get(z).y;
					int d = virus.get(z).dir;
					int s = virus.get(z).size;
					int mx = x + dx[d];
					int my = y + dy[d];

					board[mx][my]++;
					virus.get(z).x = mx;
					virus.get(z).y = my;
					if (mx < 1 || my < 1 || mx > N - 2 || my > N - 2) {
						virus.get(z).size = s / 2;
						if (d % 2 == 0)
							d--;
						else
							d++;
						virus.get(z).dir = d;
					}

				}
				/*System.out.println("군집 체크 **********************");
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						System.out.print(board[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println();*/

				// 군집 겹침 체크

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (board[i][j] < 2)
							continue;
						int max = 0;
						int maxDir = 0;
						int sum = 0;
						for (int k = 0; k < virus.size(); k++) {
							if (virus.get(k).x == i && virus.get(k).y == j) {
								if (virus.get(k).size > max) {
									maxDir = virus.get(k).dir;
									max = virus.get(k).size;
								}
								sum += virus.get(k).size;
								virus.remove(k--);
								board[i][j]--;
							}
						}
						virus.add(new Virus(i, j, sum, maxDir));
					}
				}
				timer++;
			}

			int size = virus.size();
			int result = 0;
			for (int i = 0; i < size; i++) {
				result += virus.get(i).size;
			}

			sb.append("#" + (Tcnt++) + " " + result + "\n");

		}
		bw.write(sb.toString());
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 엔드
