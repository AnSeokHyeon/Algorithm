#include <iostream>
#include <queue>
#include <functional>
#include <vector>
#include <cstdio>
using namespace std;
struct tree {
	int x; 
	int y;
	int age;
	int year;
	tree (int x, int y, int age, int year) {
		this->x = x;
		this->y = y;
		this->age = age;
		this->year = year;
	}
};
struct cmp {
	bool operator()(tree t, tree u) {
		if (t.year == u.year)
			return t.age > u.age;
		else
			return t.year > u.year;
	}
};	
priority_queue<tree, vector<tree>, cmp> pq;
queue<tree> summer;
queue<tree> fall;
int dx[] = { 1,-1,0,0,1,1,-1,-1 };
int dy[] = { 0,0,1,-1,1,-1,1,-1 };
int map[11][11] = {};
int treemap[11][11] = {};
int plusmap[11][11] = {};
int main(void) {
	int N, M, K;
	cin >> N >> M >> K;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			int n;
			cin >> n;
			plusmap[i][j] = n;
			map[i][j] = 5;
		}
	}
	for (int i = 0; i < M; i++) {
		int x,y,n;
		cin >> x >> y >> n;
		treemap[x][y] = n;
		pq.push(tree(x, y, n, 0));
	}
	int cnt = 0;
	for (int i = 0; i <K; i++) {
		//cout << i+1 << "�� @@@@@@@@@@@@ ���� " << endl;
		//for (int j = 1; j <= N; j++) {
		//	for (int k = 1; k <= N; k++) {
		//		cout << map[j][k] << " ";
		//	}
		//	cout << endl;
		//}

		cout << " ���� �Ǿ����ϴ�. ���ǾƵ��� �Ͼ����  " << endl;
		while (!pq.empty()) {
			tree top = pq.top();
			cout << " ť���� ���� ���� : " << top.x << ", " << top.y << " : " << top.age << " / " << top.year << endl;
			int year = top.year;
			if (year > i) {
				cout << " ���� �ɸ� : "<< i << " @@ "  << top.x << ", " << top.y << " : " << top.age << " / " << top.year << endl;
				break;
			}
			pq.pop();
			int age = top.age;
			int x = top.x;
			int y = top.y;
			if (map[x][y] < age) { 
				summer.push(tree(x, y, age, year));
				cout << " ��� ���ĸ��� ���� : " << top.x << ", " << top.y << " : " << top.age << " / " << top.year << endl;
				continue; 
			}
			map[x][y] -= age;

			cout << " ��� �ĸ��� ���� : " << top.x << ", " << top.y << " : " << top.age << " / " << top.year << endl;
			pq.push(tree(x, y, age + 1, year + 1));
			if (((age + 1) % 5) == 0) fall.push(tree(x, y, age + 1, year + 1));
		}
		cout << " ������ �Ǿ����ϴ�. ���ǾƵ��� �Ͼ����  " << endl;
		while (!summer.empty()) {
			tree first = summer.front();
			cout << " ���� ���� : " << first.x << ", " << first.y << " : " << first.age << " / " << first.year << endl;
			summer.pop();
			int x = first.x;
			int y = first.y;
			int age = first.age;
			//cout << " �׾��� " << endl;
			//cout << x << " " << y << " " << age << " " << age / 2 << endl;
 			map[x][y] += (age / 2);
		}
		cout << " ������ �Ǿ����ϴ�. ���ǾƵ��� �Ͼ����  " << endl;
		while (!fall.empty()) {
			tree first = fall.front();
			cout << " ���� ���� �ĸ��� ���� ���� : " << first.x << ", " << first.y << " : " << first.age << " / " << first.year << endl;
			fall.pop();
			int x = first.x;
			int y = first.y;
			int year = first.year;
			for (int j = 0; j < 8; j++) {
				int mx = x + dx[j];
				int my = y + dy[j];
				if (mx > N || my > N || mx < 1 || my < 1)continue;
				pq.push(tree(mx, my, 1, year));
			}
		}
		cout << " �ܿ��� �Ǿ����ϴ�. ���ǾƵ��� �Ͼ����  " << endl;
		//cout << i + 1 << "�� @@@@@@@@@@@@" << endl;
		for (int j = 1; j <= N; j++) {
			for (int k = 1; k <= N; k++) {
				//cout << map[j][k] << " ";
				map[j][k] += plusmap[j][k];
			}
			//cout << endl;
		}
		cout << " �ذ� �ٲ�����ϴ�. " << endl;
	}

	while (!pq.empty()) {
		//tree ex = pq.top();
		//cout << cnt + 1 << " : " << ex.x << " , " << ex.y << " , " << ex.age << " , " << ex.year << endl;
		pq.pop();
		cnt++;
	}

	cout<< cnt;
}