// dfs와 bfs
package algo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Boj1260{
	static int[][] map;
	static boolean[] chk;
	
	static void DFS(int n) {
		
		chk[n] = true;
		System.out.print(n + " ");
		for(int i = 1; i<map.length;i++) {
			
			if(chk[i] == false && map[n][i]  == 1)
				DFS(i);
		}
		
	}
	
	static void BFS(int n) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(n);
		chk[n] = true;
		
		while(!q.isEmpty()) {
			
			int a = q.poll();
			System.out.print(a + " ");
			for(int i = 1; i<map.length ;i++) {
				
				if(chk[i] == false && map[a
				                          ][i]  == 1) {
					q.add(i);
					chk[i] = true;
	
				}				
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int V = Integer.parseInt(s[2]);
		map = new int[N+1][N+1];
		
		for(int i = 0; i<M;i++) {
			String[] s2 = br.readLine().split(" ");

			int x = Integer.parseInt(s2[0]);
			int y = Integer.parseInt(s2[1]);
			map[x][y] = map[y][x] = 1;
			
		}
		
		chk = new boolean[N+1];
		
		DFS(V);
		System.out.println();
		
		chk = new boolean[N+1];
		BFS(V);
		
		br.close();
		bw.close();
		
	}
}