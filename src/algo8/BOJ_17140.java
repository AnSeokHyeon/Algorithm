package algo8;

//17140 이차원 배열과 연산
import java.awt.Point;
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17140 { // 클래스명

	static int numCnt[];
	static boolean numChk[];
	static int arr[][];
	static int R, C;

	public static void main(String[] args) throws IOException { // 메인함수 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		arr = new int[101][101];
		numCnt = new int[101];
		numChk = new boolean[101];
		R = C = 3;
		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;
		int result = -1;
		while (time < 101) {
			if(arr[r][c] == k) {
				result = time;
				break;
			}
			if (R >= C) {
				cal(1);
			} else {
				cal(-1);
			}
			time++;

		}

/*		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		*/
		bw.write(result + "");
		bw.close(); // 출력 종
		br.close(); // 입력 종료
	}// 메임함수 종료

	static void cal(int n) {
		if (n == -1) {
			R = 0;
			for (int j = 1; j <= C; j++) {

				Arrays.fill(numCnt, 0);
				Arrays.fill(numChk, false);
				ArrayList<Integer> num = new ArrayList<>();
				for (int i = 1; i <= C; i++) {
					numCnt[arr[i][j]]++;
					if (!numChk[arr[i][j]] && arr[i][j] > 0) {
						numChk[arr[i][j]] = true;
						num.add(arr[i][j]);
					}
					arr[i][j] = 0;
				}

				PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {

					@Override
					public int compare(Point o1, Point o2) {
						// TODO Auto-generated method stub
						if (o1.y == o2.y) {
							return o1.x - o2.x;
						}
						return o1.y - o2.y;
					}
				});
				int size = num.size();
				for (int i = 0; i < size; i++) {
					int x = num.get(i);
					int y = numCnt[x];
					q.add(new Point(x, y));
				}

				if (size > 50)
					size = 50;
				for (int i = 1; i < size * 2 + 1; i+= 2) {
					Point first = q.poll();
					arr[i][j] = first.x;
					arr[i+1][j] = first.y;
				}
				R = Math.max(R, size * 2);
			}

		}

		else {
			C = 0;
			for (int i = 1; i <= R; i++) {
				Arrays.fill(numCnt, 0);
				Arrays.fill(numChk, false);
				ArrayList<Integer> num = new ArrayList<>();
				for (int j = 1; j <= R; j++) {
					numCnt[arr[i][j]]++;
					if (!numChk[arr[i][j]] && arr[i][j] > 0) {
						numChk[arr[i][j]] = true;
						num.add(arr[i][j]);
					}
					arr[i][j] = 0;
				}

				PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {

					@Override
					public int compare(Point o1, Point o2) {
						// TODO Auto-generated method stub
						if (o1.y == o2.y) {
							return o1.x - o2.x;
						}
						return o1.y - o2.y;
					}
				});
				int size = num.size();
				for (int j = 0; j < size; j++) {
					int x = num.get(j);
					int y = numCnt[x];
					q.add(new Point(x, y));
				}

				if (size > 50)
					size = 50;
				for (int j = 1; j < size * 2 + 1; j += 2) {
					Point first = q.poll();
					arr[i][j] = first.x;
					arr[i][j + 1] = first.y;
				}
				C = Math.max(C, size * 2);
			}

		}

	}

}// 프로그램 엔드
