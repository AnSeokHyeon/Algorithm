package algo4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1158 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i < N + 1; i++) {
			q.add(i);
		}
		int del = 0;
		while (!q.isEmpty()) {
			int a = q.poll();
			del++;
			if (del == K) {
				del = 0;
				arr.add(a);
			} else {
				q.add(a);
			}
		}
		System.out.println(arr.toString().replace("[", "<").replace("]", ">"));

	}
}
