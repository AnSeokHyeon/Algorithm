package algo9;

// 11779 최소비용 구하기2
import java.awt.Point;
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11779 {

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		@SuppressWarnings("unchecked")
		ArrayList<Point> arr[] = new ArrayList[N + 1];
		int min[] = new int[N + 1];
		int idx[] = new int[N + 1];
		Arrays.fill(min, Integer.MAX_VALUE);
		for (int i = 0; i < N + 1; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			arr[x].add(new Point(y, w));
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.y - o2.y;
			}
		});

		q.add(new Point(start, 0));
		min[start] = 0;
		idx[start] = 0;
		while (!q.isEmpty()) {
			Point top = q.poll();
			int num = top.x;
			int size = arr[num].size();
			for (int i = 0; i < size; i++) {
				int nextNum = arr[num].get(i).x;
				int nextW = arr[num].get(i).y;
				if (min[num] + nextW > min[nextNum])
					continue;
				idx[nextNum] = num;
				min[nextNum] = min[num] + nextW;
				q.add(new Point(nextNum, min[nextNum]));
			}
		}

		Queue<Integer> q2 = new LinkedList<Integer>();
		ArrayList<Integer> find = new ArrayList<>();
		q2.add(end);
		find.add(end);

		while (!q2.isEmpty()) {
			Integer i = q2.poll();
			int next = idx[i];
			if (next == 0)
				break;

			q2.add(next);
			find.add(next);
		}
		
		int size = find.size();
		StringBuilder sb = new StringBuilder();
		for(int i = size-1; i>-1; i--) {
			sb.append(find.get(i) + " ");
		}
		
		bw.write(min[end] + "\n");
		bw.write(size + "\n");
		bw.write(sb.toString());
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 종료 ㅃㅇ
