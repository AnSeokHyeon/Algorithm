package algo8;

// 
import java.awt.Point;
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2383_점심식사시간 { // 클래스명
	static int N, result, size;
	static ArrayList<Point> human;
	static ArrayList<Stair> stair;
	static int map[][];
	static int chk[];

	static class Stair {
		int x;
		int y;
		int l;

		public Stair(int x, int y, int l) {
			super();
			this.x = x;
			this.y = y;
			this.l = l;
		}
	}

	static class Human {
		int arrivalTime;
		int startTime;
		int endTime;

		public Human(int arrivalTime, int startTime, int endTime) {
			super();
			this.arrivalTime = arrivalTime;
			this.startTime = startTime;
			this.endTime = endTime;
		}

	}

	public static void main(String[] args) throws IOException { // 메인함수 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();
		human = new ArrayList<>();
		stair = new ArrayList<>();
		while (T-- > 0) {
			result = Integer.MAX_VALUE;
			human.clear();
			stair.clear();
			N = Integer.parseInt(br.readLine());
			map = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						human.add(new Point(i, j));
					}
					if (map[i][j] > 1) {
						stair.add(new Stair(i, j, map[i][j]));
					}
				}
			}
			size = human.size();
			chk = new int[size];

			pick(0);

			sb.append("#" + (Tcnt++) + " " + result + "\n");

		}
		bw.write(sb.toString());
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

	static void pick(int n) {
		if (n == size) {
			down();
			return;
		}

		for (int i = 0; i < 2; i++) {
			chk[n] = i;
			pick(n + 1);
		}
	}

	static void down() {
		@SuppressWarnings("unchecked")
		PriorityQueue<Human> pq[] = new PriorityQueue[2];
		for (int i = 0; i < 2; i++) {
			pq[i] = new PriorityQueue<>(new Comparator<Human>() {

				@Override
				public int compare(Human o1, Human o2) {
					// TODO Auto-generated method stub
					return o1.arrivalTime - o2.arrivalTime;
				}
			});
		}

		for (int i = 0; i < size; i++) {
			int time = Math.abs(human.get(i).x - stair.get(chk[i]).x) + Math.abs(human.get(i).y - stair.get(chk[i]).y);
			pq[chk[i]].add(new Human(time + 1, 0, 0));
		}

		int timer = 0;
		@SuppressWarnings("unchecked")
		Queue<Human> q[] = new LinkedList[2];
		for (int i = 0; i < 2; i++) {
			q[i] = new LinkedList<>();
		}
		while (true) {

			for (int i = 0; i < 2; i++) {

				while (!q[i].isEmpty()) {
					Human top = q[i].peek();
					int eT = top.endTime;
					if (eT > timer)
						break;
					q[i].remove();
				}

				while (!pq[i].isEmpty()) {
					Human top = pq[i].peek();
					int aT = top.arrivalTime; // 도착시간
					if (aT > timer)
						break;

					if (q[i].size() < 3) {
						q[i].add(new Human(aT, timer, timer + stair.get(i).l));
						pq[i].remove();
					} else {
						break;
					}
				}
			}

			boolean chk = true;
			for (int i = 0; i < 2; i++) {
				if (pq[i].size() > 0 || q[i].size() > 0) {
					chk = false;
					break;
				}
			}
			if (chk)
				break;
			timer++;

		}

		result = Math.min(result, timer);
	}

}// 프로그램 엔드
