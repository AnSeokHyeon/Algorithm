// 나이 순 정렬
package algo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Boj10814 {
	
	static class Person{
		int n; // 가입 번호
		int age; // 나이
		String name; // 이름
	}
	
	static class MyComparator implements Comparator<Person>{
		public int compare(Person p1, Person p2) {
			if(p1.age > p2.age) {
				return 1;
			}
			else if (p1.age == p2.age) {
				if(p1.n > p2.n){
					return 1;
				}
			}
			return -1;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Person> people = new ArrayList<Person>();
		
		
		for(int i = 0; i < N;i++) {
			Person p = new Person();
			p.n = i+1;
			String[] s = br.readLine().split(" ");
			p.age = Integer.parseInt(s[0]);
			p.name = s[1];
			people.add(p);
		}
		
		MyComparator myComparator = new MyComparator();
		Collections.sort(people, myComparator);
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N;i++) {
			sb.append(people.get(i).age).append(" ").append(people.get(i).name).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}

}
