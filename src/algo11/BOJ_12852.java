package algo11;

// 12852 1로 만들기2
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12852 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N+1];
		dp[0] = 0;
		dp[1] = 0;
		
		for(int i = 2; i<N+1; i++) {
			dp[i] = dp[i-1]+1;
			dp[i] = (i%2 == 0)? Math.min(dp[i], dp[i/2]+1):dp[i];
			dp[i] = (i%3 == 0)? Math.min(dp[i], dp[i/3]+1):dp[i];
		}
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(N);
		while(N > 1) {
			int num = dp[N];
			if( N % 3 == 0 && dp[N/3] +1 == num) {
				N /= 3;
				arr.add(N);
			}
			else if(N % 2 == 0 && dp[N/2] +1 == num) {
				N /= 2;
				arr.add(N);
				
			}
			else if(dp[N-1]+1 == num) {
				N--;
				arr.add(N);
			}
			cnt++;
		}
		sb.append(cnt+"\n");
		int size = arr.size();
		for(int i = 0; i<size; i++) {
			sb.append(arr.get(i) + " ");
		}
		
		
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}


}