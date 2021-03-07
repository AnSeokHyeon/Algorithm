package algo8;

// 1504 특정한 최단 경로 
// 2가지 방법으로 풀어봄 밑에 주석 참고
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

public class BOJ_1504 {
	static class Node {
		int y;
		int w;
		int flag;

		public Node(int y, int w, int flag) {
			super();
			this.y = y;
			this.w = w;
			this.flag = flag;
		}

	}

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Point> arr[] = new ArrayList[N + 1];
		int min[][] = new int[N + 1][3];

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
			arr[y].add(new Point(x, w));
		}
		int v[] = new int[3];
		v[0] = 1;
		StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");

		v[1] = Integer.parseInt(st3.nextToken());
		v[2] = Integer.parseInt(st3.nextToken());
		PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.y - o2.y;
			}
		});
		
		for(int i = 0; i<3; i++) {
			min[v[i]][i] = 0;
			q.add(new Point(v[i], 0));

			while (!q.isEmpty()) {
				Point p = q.poll();

				int num = p.x;
				int size = arr[num].size();
				int nowW = p.y;
				for (int k = 0; k < size; k++) {
					int nextNum = arr[num].get(k).x;
					int nextW = arr[num].get(k).y;

					if (nowW + nextW >= min[nextNum][i])
						continue;
					min[nextNum][i] = nowW + nextW;
					q.add(new Point(nextNum, min[nextNum][i]));

				}

			}
		}
		
		long result1 = (long)min[v[1]][0] +(long)min[v[2]][1] + (long)min[N][2];
		long result2 = (long)min[v[2]][0] + (long)min[v[1]][2] + (long)min[N][1];
		long result = Math.min(result1, result2);
		if (result >= Integer.MAX_VALUE)
			bw.write("-1\n");
		else {

			bw.write(result + "");

		}
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 종료 ㅃㅇ
/*
public class Main {
	static class Node {
		int y;
		int w;
		int flag;

		public Node(int y, int w, int flag) {
			super();
			this.y = y;
			this.w = w;
			this.flag = flag;
		}

	}

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Point> arr[] = new ArrayList[N + 1];
		int min[][] = new int[N + 1][4];

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
			arr[y].add(new Point(x, w));
		}
		StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");

		int v1 = Integer.parseInt(st3.nextToken());
		int v2 = Integer.parseInt(st3.nextToken());
		PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.y - o2.y;
			}
		});
		int startFlag = 0;
		if(v1 == 1) startFlag = 1;
		if(v2 == 1) startFlag = 2;
		q.add(new Node(1, 0, startFlag));
		min[1][startFlag] = 0;
		while (!q.isEmpty()) {
			Node p = q.poll();

			int num = p.y;
			int size = arr[num].size();
			int nowW = p.w;
			int flag = p.flag;
			for (int k = 0; k < size; k++) {
				int nextNum = arr[num].get(k).x;
				int nextW = arr[num].get(k).y;
				int nextf = flag;
				if (nextNum == v1)
					nextf = flag | 1 << 0;
				if (nextNum == v2)
					nextf = flag | 1 << 1;

				if (nowW + nextW >= min[nextNum][nextf])
					continue;
				min[nextNum][nextf] = nowW + nextW;
				q.add(new Node(nextNum, min[nextNum][nextf], nextf));

			}

		}
		for(int i = 0; i<4; i++) {
			for(int j = 1; j<N+1;j++) {
				System.out.print(min[j][i] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		if (min[N][3] == Integer.MAX_VALUE)
			bw.write("-1\n");
		else {

			bw.write(min[N][3] + "");

		}
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 종료 ㅃㅇ
*/