package algo9;
// 14938 서강그라운드
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14938 {

	static int item[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		@SuppressWarnings("unchecked")
		ArrayList<Point> arr[] = new ArrayList[n + 1];

		item = new int[n + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < n + 1; i++) {
			item[i] = Integer.parseInt(st.nextToken());
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			arr[x].add(new Point(y, w));
			arr[y].add(new Point(x, w));
		}
		int result = 0;
		PriorityQueue<Point> q = new PriorityQueue<Point>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.y - o2.y;
			}
		});
		int quest[] = new int[n+1];
		for(int i = 1; i<n+1; i++) {
			System.arraycopy(item, 0, quest, 0, n+1);;
			int temp = quest[i];
			quest[i] = 0;
			q.add(new Point(i, 0));
			while(!q.isEmpty()) {
				Point p = q.poll();
				
				int nowNum = p.x;
				int nowW = p.y;
				int size = arr[nowNum].size();
				for(int k = 0; k<size; k++) {
					int nextNum = arr[nowNum].get(k).x;
					int nextW = arr[nowNum].get(k).y;
					
					if(nowW + nextW > m ) continue;
					
					temp += quest[nextNum];
					quest[nextNum] = 0;
					q.add(new Point(nextNum, nowW + nextW));
					
					
				}
			}	
			result = Math.max(result, temp);
		}
		
		bw.write(result + "");
		br.close();
		bw.close();
	}

}