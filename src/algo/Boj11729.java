package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11729 {
	//static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	/*
	 * 
String                :  문자열 연산이 적고 멀티쓰레드 환경일 경우
StringBuffer     :  문자열 연산이 많고 멀티쓰레드 환경일 경우
StringBuilder   :  문자열 연산이 많고 단일쓰레드이거나 동기화를 고려하지 않아도 되는 경우 
	 */
	static StringBuilder S = new StringBuilder();

	public static void f(int n, int a, int b, int c) throws IOException {
		if (n == 0)
			return;
		f(n - 1, a, c, b);
		S.append(a + " " + b + "\n");
		f(n - 1, c, b, a);
	}

	public static void main(String[] args) throws IOException {

		String s = br.readLine();
		
		int num = Integer.parseInt(s);
		
		int size = (int) (Math.pow(2, num) - 1);
		
		System.out.println(size);
		
		f(num, 1, 3, 2);
		
		System.out.println(S);
	}

}
