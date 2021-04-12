package algo14;
// 16953 A -> B
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953 {
	
	static class Position{
		long x;
		int d;
		public Position(long x, int d) {
			this.x = x;
			this.d = d;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		int result = -1;
		
		Queue<Position> q = new LinkedList<Position>();
		
		q.add(new Position(A, 1));
		
		while(!q.isEmpty()) {
			
			Position p = q.poll();
			
			Long now = p.x;
			int d = p.d;
			if(now == B) {
				result = d;
				break;
			}
			
			long next = now * 2;
			if(next <= B) {
				q.add(new Position(next, d +1 ));
			}
			
			long next2 = now*10 + 1;
			
			if(next2 <= B) {
				q.add(new Position(next2, d+1));
			}
			
			
		}
		
		bw.write(result + "");
		br.close();
		bw.close();
	}
}