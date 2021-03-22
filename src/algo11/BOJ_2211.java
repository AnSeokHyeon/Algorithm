package algo11;

// 2211 네트워크 복구
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2211 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int min[] = new int[N+1];
		Arrays.fill(min, Integer.MAX_VALUE);
		@SuppressWarnings("unchecked")
		ArrayList<Point> arr[] = new ArrayList[N+1];
		HashMap<Integer, Integer> line = new HashMap<>();
		for(int i= 0; i<N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			int a= Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			arr[a].add(new Point(b, w));
			arr[b].add(new Point(a, w));
		}
		
		PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.y - o2.y;
			}
		});
		
		min[1] = 0;
		pq.add(new Point(1, 0));
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			int now = p.x;
			int w = p.y;
			int size = arr[now].size();
			
			for(int i = 0; i<size; i++) {
				int next = arr[now].get(i).x;
				int nextW = arr[now].get(i).y;
				
				if(w + nextW >= min[next]) continue;
				
				min[next] = w + nextW;
				if(line.containsKey(next)) {
					line.replace(next, now);
				}
				else {
					line.put(next, now);
				}
				
				pq.add(new Point(next,w + nextW ));
				
			}
		}
		StringBuilder sb = new StringBuilder();
		int lineSize = line.size();
		sb.append(lineSize + "\n");
		for(int i = 1; i<N+1; i++) {
			if(line.get(i) == null) continue;
			sb.append(i + " " + line.get(i) + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}