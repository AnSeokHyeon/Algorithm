package algo8;

// 17143 낚시왕
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17143 {
	static int R, C, M;
	static ArrayList<Shark> shark;
	static int board[][];
	static int dx[] = { 0, -1, 1, 0, 0 };
	static int dy[] = { 0, 0, 0, 1, -1 };

	static class Shark {
		int x;
		int y;
		int velocity;
		int direction;
		int size;

		public Shark(int x, int y, int velocity, int direction, int size) {
			this.x = x;
			this.y = y;
			this.velocity = velocity;
			this.direction = direction;
			this.size = size;
		}

	}

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[R + 1][C + 1];

		shark = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			shark.add(new Shark(x, y, s, d, z));
			board[x][y]++;
		}
		int time = 0;
		int result = 0;
		while (true) {
			time++;
			if (time > C)
				break;
			for (int i = 1; i < R + 1; i++) {
				if (board[i][time] == 0)
					continue;
				for (int j = 0; j < shark.size(); j++) {
					if (shark.get(j).x == i && shark.get(j).y == time) {
						result += shark.get(j).size;
						shark.remove(j);
						break;
					}
				}
				break;
			}

			for (int i = 0; i < R + 1; i++) {
				Arrays.fill(board[i], 0);
			}

			for (int i = 0; i < shark.size(); i++) {
				int x = shark.get(i).x;
				int y = shark.get(i).y;
				int s = shark.get(i).velocity;
				
				int d = shark.get(i).direction;

				int distance = 0;
				if (d == 1 || d == 2) {
					distance = 2 * (R - 1);
					s = s % distance;
					int mx = x + s * dx[d];
					while (mx < 1 || mx > R) {
						int gap = 0;
						if (mx < 1) {
							gap = 1 - mx;
							d = 2;
							mx = 1 + gap;
						}
						if (mx > R) {
							gap = mx - R;
							d = 1;
							mx = R - gap;
						}

					}
					shark.get(i).x = mx;
					shark.get(i).direction = d;

				} else {
					distance = 2 * (C - 1);
					s = s % distance;
					int my = y + s * dy[d];
					while (my < 1 || my > C) {
						int gap = 0;
						if (my < 1) {
							gap = 1 - my;
							d = 3;
							my = 1 + gap;
						}
						if (my > C) {
							gap = my - C;
							d = 4;
							my = C - gap;
						}

					}
					shark.get(i).y = my;
					shark.get(i).direction = d;
				}
				board[shark.get(i).x][shark.get(i).y]++;
			}
			
			for (int i = 1; i < R + 1; i++) {
				for (int j = 1; j < C + 1; j++) {
					if (board[i][j] < 2)
						continue;
					int max = 0;
					for (int k = 0; k < shark.size(); k++) {
						if (i == shark.get(k).x && j == shark.get(k).y)
							max = Math.max(shark.get(k).size, max);
					}
					for (int k = 0; k < shark.size(); k++) {
						if (i == shark.get(k).x && j == shark.get(k).y && shark.get(k).size < max) {
							shark.remove(k);
							k--;
						}
					}
				}

			}

		}
		bw.write(result + "");
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 종료 ㅃㅇ
