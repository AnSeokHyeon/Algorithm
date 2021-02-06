// 카드 2
package algo4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2164 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cnt=  0;
		int N = sc.nextInt();
		Queue<Integer> q= new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			q.add(i+1);
		}
		while(cnt++ < N-1) {
			q.poll();
			q.add(q.poll());
				
		}
		System.out.println(q.poll());
		sc.close();
	}

}
