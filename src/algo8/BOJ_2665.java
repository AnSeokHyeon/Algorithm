package algo8;

// 2665 미로 만들기
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_2665 {
	static class Location {
		int x;
		int y;
		int w;

		public Location(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}

	}

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		int N = Integer.parseInt(br.readLine());
		int board[][] = new int[N][N];
		int min[][] = new int[N][N];
		int dx[] = { 1, -1, 0, 0 };
		int dy[] = { 0, 0, 1, -1 };
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = s.charAt(j) - '0';
			}
			Arrays.fill(min[i], Integer.MAX_VALUE);
		}

		PriorityQueue<Location> q = new PriorityQueue<>(new Comparator<Location>() {

			@Override
			public int compare(Location o1, Location o2) {
				// TODO Auto-generated method stub
				return o1.w - o2.w;
			}
		});
		q.add(new Location(0, 0, 0));
		min[0][0] = 0;
		while (!q.isEmpty()) {
			Location l = q.poll();
			int x = l.x;
			int y = l.y;
			int w = l.w;

			for (int i = 0; i < 4; i++) {

				int mx = x + dx[i];
				int my = y + dy[i];
				int mw = w;
				if (mx < 0 || my < 0 || mx > N - 1 || my > N - 1)
					continue;
				if (board[mx][my] == 0)
					mw++;
				if (mw >= min[mx][my])
					continue;

				
				min[mx][my] = mw;
				q.add(new Location(mx, my, mw));

			}
		}
		bw.write(min[N - 1][N - 1] + "");
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 종료 ㅃㅇ