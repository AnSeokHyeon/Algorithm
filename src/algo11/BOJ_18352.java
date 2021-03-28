package algo11;

// 18352 특정 거리의 도시 찾기
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18352 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M=  Integer.parseInt(st.nextToken());
		int K=  Integer.parseInt(st.nextToken());
		int S=  Integer.parseInt(st.nextToken());
		
		int min[] = new int[N+1];
		Arrays.fill(min, Integer.MAX_VALUE);
		@SuppressWarnings("unchecked")
		ArrayList<Point> arr[] = new ArrayList[N+1];
		for(int i = 0; i<N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		while(M-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int a =  Integer.parseInt(st.nextToken());
			int b =  Integer.parseInt(st.nextToken());
			arr[a].add(new Point(b, 1));
		}
		
		PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.y - o2.y;
			}
		});
		
		q.add(new Point(S, 0));
		min[S] = 0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			int now = p.x;
			int w = p.y;
			int size = arr[now].size();
			
			for(int i = 0; i<size; i++)
			{
				int next = arr[now].get(i).x;
				int nextW = arr[now].get(i).y + w;
				
				if(nextW >= min[next]) continue;
				min[next] = nextW;
				q.add(new Point(next, nextW));
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for(int i= 1; i<N+1; i++) {
			
			if(min[i] == K) {

				sb.append(i + "\n");
				cnt++;
			}
		}
		
		if(cnt == 0) sb.append("-1");
		 bw.write(sb.toString()
				 );
		br.close();
		bw.close();

	}

}
