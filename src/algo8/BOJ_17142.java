package algo8;
//17142 연구소3
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17142 { // 클래스명
	static int map[][];
	static int pickVirus[];
	static int N, M;
	static ArrayList<Virus> virus;
	static int size;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static int result = Integer.MAX_VALUE;

	static class Virus {
		int x;
		int y;
		int d;

		public Virus(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException { // 메인함수 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		virus = new ArrayList<>();
		pickVirus = new int[11];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus.add(new Virus(i, j, 0));
				}
			}
		}
		size = virus.size();

		pick(0, 0);

		if (result == Integer.MAX_VALUE) {
			bw.write((-1) + "");
		} else {
			bw.write(result + "");
		}
		bw.close(); // 출력 종
		br.close(); // 입력 종료
	}// 메임함수 종료

	static void pick(int n, int m) {
		if (n == M) {
			spread();
			return;

		}
		for (int i = m; i < size; i++) {

			pickVirus[n] = i;
			pick(n + 1, i + 1);
		}
	}

	static void spread() {
		int copy[][] = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			System.arraycopy(map[i], 1, copy[i], 1, N);
		}
		boolean chk[][] = new boolean[N + 1][N + 1];
		Queue<Virus> q = new LinkedList<Virus>();
		for (int i = 0; i < M; i++) {
			int idx = pickVirus[i];
			int x = virus.get(idx).x;
			int y = virus.get(idx).y;

			q.add(new Virus(x, y, 0));
			copy[x][y] = -1;
			chk[x][y] = true;
		}
		while (!q.isEmpty()) {
			Virus v = q.poll();

			int x = v.x;
			int y = v.y;
			int d = v.d;
			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				int md = d + 1;
				if (mx < 1 || my < 1 || mx > N || my > N)
					continue;

				if (copy[mx][my] == 1)
					continue;
				if (chk[mx][my])
					continue;
				if (map[mx][my] == 2) {

					copy[mx][my] = 0;
				} else {
					copy[mx][my] = md;
				}
				chk[mx][my] = true;
				q.add(new Virus(mx, my, md));
			}

		}

		boolean resultChk = true;
		int max = 0;
		//System.out.println("결과 ************************* ");
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(chk[i][j]) {
					max = Math.max(copy[i][j], max);
				}
				if (!chk[i][j] && copy[i][j] == 0) {
					resultChk = false;
				}
			}
			//System.out.println();
		}
		//System.out.println();
		if (resultChk)
			result = Math.min(result, max);
		

		
	}

}// 프로그램 엔드
