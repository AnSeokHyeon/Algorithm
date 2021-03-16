package algo10;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_Contact {

   public static void main(String[] args) throws Exception {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      int Tcnt = 1;
      StringBuilder sb = new StringBuilder();
      while(Tcnt <= 10) {
    	  @SuppressWarnings("unchecked")
		ArrayList<Integer> arr[] = new ArrayList[101];
    	  for(int i = 1; i<101; i++) {
    		  arr[i] = new ArrayList<>();
    	  }
          int num[] = new int[101];
          Arrays.fill(num, Integer.MAX_VALUE);
          
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          int N = Integer.parseInt(st.nextToken()) / 2;
          int start = Integer.parseInt(st.nextToken());
          
          StringTokenizer input = new StringTokenizer(br.readLine(), " ");
          while(N-- > 0) {
        	  int x = Integer.parseInt(input.nextToken());
        	  int y = Integer.parseInt(input.nextToken());
        	  arr[x].add(y);
          }
          
          Queue<Point> q = new LinkedList<>();
          q.add(new Point(start, 0));
          int maxStep = 0;
          num[start] = 0;
          while(!q.isEmpty()) {
        	  Point p = q.poll();
        	  
        	  int now = p.x;
        	  int step = p.y;
        	  int size = arr[now].size();
        	  maxStep = Math.max(step, maxStep);
        	  for(int i = 0; i<size; i++) {
        		  int next = arr[now].get(i);
        		  int nextStep = step+1;
        		  if(num[next] != Integer.MAX_VALUE) continue;
        		  num[next] = nextStep;
        		  q.add(new Point(next, nextStep));
        	  }
          }
          
          int result = 0;
          for(int i = 100; i>0; i--) {
        	  if(maxStep == num[i]) {
        		  result = i;
        		  break;
        	  }
          }
          
          
    	  
    	  sb.append("#"+(Tcnt++) + " "+ result + "\n");
      }
      
      
      
      bw.write(sb.toString());

      bw.close();
      br.close();
   }

}