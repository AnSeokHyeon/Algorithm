package algo7;
// 16236 아기상어
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {
	static int N;
	static int board[][];
	static boolean chkBoard[][];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static class Fish {
		int x;
		int y;
		int size;
		int fish;

		public Fish() {
		}

		public Fish(int x, int y, int size, int fish) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.fish = fish;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		chkBoard = new boolean[N][N];
		ArrayList<Fish> fish = new ArrayList<>();
		Fish shark = new Fish();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {

				int num = Integer.parseInt(st.nextToken());
				if (num > 0) {
					if (num == 9) {
						shark.x = i;
						shark.y = j;
						shark.size = 2;
						shark.fish = 0;

					} else {
						fish.add(new Fish(i, j, num, 0));
					}

				}

			}
		}

		int result = 0;

		while (true) {
			// 보드와 체크보드 초기화
			for (int i = 0; i < N; i++) {
				Arrays.fill(board[i], 0);
				Arrays.fill(chkBoard[i], false);
			}

			boolean chk = false;
			// 물고기 탐색
			for (int i = 0; i < fish.size(); i++) {
				int fishsize = fish.get(i).size;
				if (fishsize > shark.size) {
					board[fish.get(i).x][fish.get(i).y] = 2;
				} else if (fishsize < shark.size) {
					if (!chk)
						chk = true;
					board[fish.get(i).x][fish.get(i).y] = 1;
				}
			}
			if (!chk)
				break;

			int limit = 987654321;
			Queue<Fish> q = new LinkedList<Fish>();
			PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
				@Override
				public int compare(Point o1, Point o2) {
					// TODO Auto-generated method stub
					if (o1.x == o2.x)
						return o1.y - o2.y;
					return o1.x - o2.x;
				}
			});
			q.add(new Fish(shark.x, shark.y, 0, 0));
			chkBoard[shark.x][shark.y] = true;

			boolean chk2 = false;
			while (!q.isEmpty()) {
				Fish top = q.poll();
				int x = top.x;
				int y = top.y;
				int size = top.size;

				if (size > limit) {
					break;
				}
				if (board[x][y] == 1) {
					if(limit > size) limit = size;
					chk2 = true;
					pq.add(new Point(x, y));
				}

				for (int i = 0; i < 4; i++) {
					int mx = x + dx[i];
					int my = y + dy[i];
					int md = size + 1;
					if (mx < 0 || my < 0 || mx > N - 1 || my > N - 1)
						continue;
					if (board[mx][my] == 2)
						continue;
					if (chkBoard[mx][my])
						continue;
					chkBoard[mx][my] = true;
					q.add(new Fish(mx, my, md, 0));
				}

			} // Queue 종료

			if (!chk2)
				break;
			result += limit;

			Point top = pq.poll();
			shark.x = top.x;
			shark.y = top.y;
			for (int i = 0; i < fish.size(); i++) {
				if (fish.get(i).x == shark.x && fish.get(i).y == shark.y) {
					shark.fish++;
					if (shark.fish == shark.size) {
						shark.size++;
						shark.fish = 0;
					}
					fish.remove(i);
					break;
				}

			}

		}

		bw.write(result + "");
		br.close();
		bw.close();

	}
}