package algo13;

//5567 결혼식
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5567 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean chk[] = new boolean[N+1];
		@SuppressWarnings("unchecked")
		ArrayList<Integer> arr[] = new ArrayList[N+1];
		for(int i= 0; i<N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		while(M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		Queue<Point> q = new LinkedList<>();
		
		q.add(new Point(1, 0));
		chk[1] = true;
		
		int result = 0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			int now = p.x;
			int step = p.y;
			int size = arr[now].size();
			for(int i = 0; i<size; i++) {
				int next = arr[now].get(i);
				int nextstep = step + 1;
				if(chk[next]) continue;
				if(nextstep >2) continue;
				result++;
				chk[next] = true;
				q.add(new Point(next, nextstep));
			}
		}
		bw.write(result + "");
		br.close();
		bw.close();
	}


}