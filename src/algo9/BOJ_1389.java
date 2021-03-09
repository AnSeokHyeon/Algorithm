package algo9;

// 1389 케빈 베이컨의 6단계 ㅓㅂ칙
import java.awt.Point;
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1389 {
	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int dis[][] = new int[N + 1][N + 1];
		@SuppressWarnings("unchecked")
		ArrayList<Integer> arr[] = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		boolean chk[] = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x].add(y);
			arr[y].add(x);
		}

		Queue<Point> q = new LinkedList<>();

		for (int i = 1; i < N + 1; i++) {
			Arrays.fill(chk, false);
			q.add(new Point(i, 0));
			chk[i] = true;
			while (!q.isEmpty()) {
				Point p = q.poll();
				int num = p.x;
				int d = p.y;
				int size = arr[num].size();
				for (int j = 0; j < size; j++) {
					int nextNum = arr[num].get(j);
					int nextD = d + 1;
					if (chk[nextNum])
						continue;
					chk[nextNum] = true;
					dis[i][nextNum] = nextD;
					q.add(new Point(nextNum, nextD));

				}

			}
		}
		int result = 0;
		int minimum = Integer.MAX_VALUE;
		for(int i = 1; i<N+1; i++) {
			int sum = 0;
			for(int j = 1; j<N+1; j++) {
				sum += dis[i][j];
			}
			if(minimum > sum) {
				minimum = sum;
				result = i;
			}
		}
		bw.write(result + "");
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 종료 ㅃㅇ
