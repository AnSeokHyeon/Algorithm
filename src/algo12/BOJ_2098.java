package algo12;


// 2098 외판원 순회
/*import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_ {
	
	static class Node{
		int next;
		int flag;
		int money;
		public Node(int next, int flag, int money) {
			super();
			this.next = next;
			this.flag = flag;
			this.money = money;
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int board[][] = new int[N][N];
		int min[][][] = new int[N][N][size];
		
		PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.money - o2.money;
			}
		});
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<N; j++) {
				board[i][j]  = Integer.parseInt(st.nextToken());
				for(int k = 0; k<size; k++) {
					min[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}

			q.add(new Node(0, 0, 0));
			while(!q.isEmpty()) {
				Node n = q.poll();
				
				int now= n.next;
				int flag = n.flag;
				int w = n.money;
				for(int i= 0; i<N; i++) {
					if(board[now][i] == 0) continue;
					if((flag & 1<<i) > 0) continue;
					int next = i;
					int nextw = board[now][i] + w;
					int nextFlag = flag|1<<i;
					if(nextw>=min[0][next][nextFlag]) continue;
					min[0][next][nextFlag] = nextw;
					q.add(new Node(next, nextFlag, nextw));
				}
				
			}
			
		int result = Integer.MAX_VALUE;
		for(int i= 0; i<N; i++) {
			result = Math.min(result, min[i][i][size-1]);
		}
		bw.write(result+"");
		br.close();
		bw.close();

	}

}
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class BOJ_2098{
	static int N;
	static int board[][];
	static int dp[][];
	static int start;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		dp = new int[N][1<<N];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 0) board[i][j] = 987654321;
 			}
		}
		start = 0;
		bw.write(dfs(0, 1)+"");
		
		bw.close();
		br.close();
		
	}
	private static int dfs(int idx, int flag) {
		int result = 987654321;
		if(flag == (1<<N)-1) {
			return board[idx][start];
		}
		
		if(dp[idx][flag] != 0)
		{
			return dp[idx][flag];
		}
		
		
		for(int i = 0; i<N; i++) {
			if((flag&1<<i) > 0 || board[idx][i] == 0) continue;
			
			result = Math.min(result, board[idx][i] + dfs(i, flag|1<<i));
			
		}
		
		
		return dp[idx][flag] = result;
		
	}
}