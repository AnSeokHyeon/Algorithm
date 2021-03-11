package algo9;
// 1719 택배
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

public class BOJ_1719{
	
	static class Box {
		
		int x;
		int w;
		int s;
		public Box(int x, int w, int s) {
			super();
			this.x = x;
			this.w = w;
			this.s = s;
		}
		
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int min[][] = new int[N+1][N+1];

		int first[][] = new int[N+1][N+1];
		@SuppressWarnings("unchecked")
		ArrayList<Point> arr[] = new ArrayList[N+1];
		for(int i = 0; i<N+1; i++) {
			arr[i] = new ArrayList<>();
			Arrays.fill(min[i], Integer.MAX_VALUE);
		}
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[x].add(new Point(y, w));
			arr[y].add(new Point(x, w));
		}
		PriorityQueue<Box> q = new PriorityQueue<>(new Comparator<Box>() {

			@Override
			public int compare(Box o1, Box o2) {
				// TODO Auto-generated method stub
				return o1.w - o2.w;
			}
		});
		for(int i = 1; i<N+1; i++) {
			q.add(new Box(i, 0, 0));
			min[i][i] = 0;
			while(!q.isEmpty()) {
				Box b = q.poll();
				int now = b.x;
				int w = b.w;
				int s = b.s;
				int size = arr[now].size();
				for(int k = 0;k<size; k++) {
					int next = arr[now].get(k).x;
					int nextW = arr[now].get(k).y;
					int nextS = s;
					
					if(w + nextW >= min[i][next]) continue;
					
					min[i][next] = w + nextW;
					if(nextS == 0) nextS = next;
					first[i][next] = nextS;
					q.add(new Box(next, w + nextW, nextS));
					
				}
				
			}
		}
		for(int i = 1; i<N+1; i++) {
			for(int j = 1;j<N+1;j++) {
				if(i == j) System.out.print("- ");
				else {
					System.out.print(first[i][j]+ " ");
				}
			}
			System.out.println();
		}
		br.close();
		bw.close();
	}

}