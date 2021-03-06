package algo8;

// 1753 최단경로
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

public class BOJ_1753 { // 클래스명

	public static void main(String[] args) throws IOException { // 메인함수 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		@SuppressWarnings("unchecked")
		ArrayList<Point> arr[] = new ArrayList[v + 1];
		int min[] = new int[v + 1];
		boolean chk[] = new boolean[v + 1];
		Arrays.fill(min, Integer.MAX_VALUE);
		for (int i = 0; i <= v; i++) {
			arr[i] = new ArrayList<>();
		}

		while (e-- > 0) {
			StringTokenizer input = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(input.nextToken());
			int y = Integer.parseInt(input.nextToken());
			int w = Integer.parseInt(input.nextToken());
			arr[x].add(new Point(y, w));
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
		min[start] = 0;
		chk[start] = true;
		q.add(new Point(start, 0));

		while (!q.isEmpty()) {
			Point top = q.poll();
			int num = top.x;
			int w = top.y;
			int size = arr[num].size();
			for (int i = 0; i < size; i++) {
				int nextN = arr[num].get(i).x;
				int nextW = arr[num].get(i).y + w;
				if (nextW >= min[nextN])
					continue;
				min[nextN] = nextW;
				q.add(new Point(nextN, min[nextN]));
			}

		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < v + 1; i++) {
			if (min[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(min[i] + "\n");
			}
		}

		bw.write(sb.toString());
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 엔드
