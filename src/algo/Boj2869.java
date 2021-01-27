// 달팽이는 올라가고 싶다.
package algo;

import java.util.Scanner;

public class Boj2869 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		
			int move = A - B;
			int day = V / (A - B) - A;
			int sum = move * day;
			while (sum < V) {
				day++;
				sum += A;
				if (sum >= V) break;
				sum -= B;
			}
			System.out.println(day);

	}

}
