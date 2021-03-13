package algo9;

// 17837 새로운게임 2
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17837 {

	static class Horse {
		int x;
		int y;
		int dir;
		int idx;

		public Horse(int x, int y, int dir, int idx) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.idx = idx;
		}

	}

	static int dx[] = { 0, 0, 0, -1, 1 };
	static int dy[] = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		ArrayList<Horse> horse = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int board[][] = new int[N + 1][N + 1];
		int map[][] = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < N + 1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			horse.add(new Horse(x, y, d, 1));
			map[x][y] = 1;
		}
	/*	System.out.println("시작");
		
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();*/
		int time = 1;
		int result = -1;
		boolean finish = false;
		while (time < 1001) {

			for (int z = 0; z < M; z++) {
				int x = horse.get(z).x;
				int y = horse.get(z).y;
				int d = horse.get(z).dir;
				int idx = horse.get(z).idx;
				//System.out.println(x + " "+ y + " / " + d + " |" + idx);
				int mx = x + dx[d];
				int my = y + dy[d];

				if (mx < 1 || my < 1 || mx > N || my > N || board[mx][my] == 2) {
					if (d % 2 == 0)
						d--;
					else
						d++;
					horse.get(z).dir = d;
					mx = x + dx[d];
					my = y + dy[d];
				}
				
				if (mx < 1 || my < 1 || mx > N || my > N || board[mx][my] == 2) {
					
					continue;
				}
				
				//ystem.out.println(mx + " , " + my);
				if (board[mx][my] == 0) {

					int num = map[x][y]+1 - idx;
					
					for(int i = 0; i<M; i++) {
						if(x == horse.get(i).x && y == horse.get(i).y && horse.get(i).idx >= idx) {
							horse.get(i).x = mx;
							horse.get(i).y = my;
							horse.get(i).idx = map[mx][my] +1 + (horse.get(i).idx - idx);
						}
					}
					map[mx][my] += num;
					map[x][y] -= num;
					if(map[mx][my] > 3) finish = true;
				}

				else if (board[mx][my] == 1) {
					int num = map[x][y]+1 - idx;
					for(int i = 0; i<M; i++) {
						if(x == horse.get(i).x && y == horse.get(i).y && horse.get(i).idx >= idx) {
							horse.get(i).x = mx;
							horse.get(i).y = my;
							horse.get(i).idx = num + map[mx][my] - (horse.get(i).idx - idx );
						}
					}
					map[mx][my] += num;
					map[x][y] -= num;
					if(map[mx][my] > 3) finish = true;
				}
				/*System.out.println("말 결과*******");
				for(int i = 0; i<M; i++)
				{
					System.out.println( horse.get(i).x + " , " + horse.get(i).y + " / " + horse.get(i).idx);
				}*/
				if (finish)
					break;
			}/*
			System.out.println("결과");
			
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
*/
			if (finish) {
				result = time;
				break;
			}
			time++;
			
		}

		bw.write(result + "");
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 종료 ㅃㅇ
