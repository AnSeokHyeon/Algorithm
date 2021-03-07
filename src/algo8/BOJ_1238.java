package algo8;

// 1238 파티  
import java.awt.Point;
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238 {

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		@SuppressWarnings("unchecked")
		ArrayList<Point> arr[] = new ArrayList[N + 1];
		int min[][] = new int[N + 1][N + 1];

		for (int i = 0; i < N + 1; i++) {
			arr[i] = new ArrayList<>();
			Arrays.fill(min[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st2.nextToken());
			int y = Integer.parseInt(st2.nextToken());
			int w = Integer.parseInt(st2.nextToken());
			arr[x].add(new Point(y, w));
		}

		PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.y - o2.y;
			}
		});

		for (int i = 1; i < N + 1; i++) {
			q.add(new Point(i, 0));
			min[i][i] = 0;

			while (!q.isEmpty()) {
				Point p = q.poll();

				int num = p.x;
				int size = arr[num].size();
				int nowW = p.y;

				for (int k = 0; k < size; k++) {
					int nextNum = arr[num].get(k).x;
					int nextW = arr[num].get(k).y;

					if (nowW + nextW >= min[i][nextNum])
						continue;
					min[i][nextNum] = nowW + nextW;
					q.add(new Point(nextNum, min[i][nextNum]));

				}

			}
		}
		
		int result = 0;
		for(int i = 1; i<N+1; i++) {
			int temp = min[i][X] + min[X][i];
			result = Math.max(result, temp);
		}
		bw.write(result + "");
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 종료 ㅃㅇ
