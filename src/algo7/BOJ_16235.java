package algo7;
// 16235 나무재테크 
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16235 {
	static int N, M, K;
	static int board[][];
	static int feed[][];
	static int dx[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int dy[] = { 1, 1, 0, -1, -1, -1, 0, 1 };

	static class Tree {
		int x;
		int y;
		int age;
		int year;

		public Tree() {
			super();
		}

		public Tree(int x, int y, int age, int year) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
			this.year = year;
		}
	}

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new int[N + 1][N + 1];
		feed = new int[N + 1][N + 1];
		Deque<Tree> tree = new LinkedList<Tree>();
		Queue<Tree> summer = new LinkedList<>();
		Queue<Tree> fall = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			Arrays.fill(board[i], 5);
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				feed[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			tree.add(new Tree(x, y, age, 0));
		}

		int start = 0;
		while (start < K) {
			int size = tree.size();
			// 봄

			while (size-- > 0) {
				Tree treeTop = tree.poll();

				int x = treeTop.x;
				int y = treeTop.y;
				int age = treeTop.age;
				int year = treeTop.year;
				// System.out.println(x + " , " + y + " // " + age + " , " + year);
				if (year > start) {
					break;
				}
				if (age > board[x][y]) {
					summer.add(new Tree(x, y, age, year));
				} else {
					board[x][y] -= age;
					age++;
					year++;
					tree.addLast(new Tree(x, y, age, year));

					if (age % 5 == 0) {
						fall.add(new Tree(x, y, age, year));
					}

				}
			}

			// 여름

			while (!summer.isEmpty()) {
				Tree summerTop = summer.poll();

				int x = summerTop.x;
				int y = summerTop.y;
				int age = summerTop.age;
				board[x][y] += age / 2;

			}

			// 가을

			while (!fall.isEmpty()) {
				Tree fallTop = fall.poll();
				int x = fallTop.x;
				int y = fallTop.y;
				int age = 1;
				int year = fallTop.year;
				for (int i = 0; i < 8; i++) {
					int mx = x + dx[i];
					int my = y + dy[i];
					if (mx < 1 || my < 1 || mx > N || my > N)
						continue;
					tree.addFirst(new Tree(mx, my, age, year));
				}

			}

			// 겨울

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {

					board[i][j] += feed[i][j];
				}
			}

			start++;

		}

		bw.write(tree.size() + "");
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 종료 ㅃㅇ
