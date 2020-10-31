#include <iostream>
#include <queue>
#include <functional>
#include <cstdio>
#include <vector>

using namespace std;

struct pos {
	int x;
	int y;
	int l;
	pos() {
		this->x = 0;
		this->y = 0;
		this->l = 0;
	}
	pos(int x, int y, int l) {
		this->x = x;
		this->y = y;
		this->l = l;
	}
};
pos per[401];
pos taxi;

struct cmp {
	bool operator()(pos a, pos b) {
		if (a.x == b.x)
			return a.y > b.y;
		return a.x > b.y;
	}
};

int map[21][21];
int chk[21][21];
int N, M, L;
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };

int main(void) {
	cin >> N >> M >> L;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> map[i][j];
			if (map[i][j] == 1)map[i][j] = -1;
		}
	}
	int tpx, tpy;
	cin >> tpx >> tpy;
	taxi.x = tpx;
	taxi.y = tpy;
	taxi.l = L;
	for (int i = 1; i <= M; i++) {
		int tpx1, tpy1, tpx2, tpy2;
		cin >> tpx1 >> tpy1 >> tpx2 >> tpy2;

		map[tpx1][tpy1] = i;
		per[i].x = tpx2;
		per[i].y = tpy2;
		
	}

	//for (int i = 1; i <= N; i++) {
	//	for (int j = 1; j <= N; j++) {
	//		cout << map[i][j] << " ";
	//	}
	//	cout << endl;
	//}
	int size = M;
	int result = 0;
	while (size--) {
		bool finish = false;
		int c = 0;
		int limits = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				chk[i][j] = 0;
			}
		}

		priority_queue<pos, vector<pos>, cmp> pq;
		queue<pos> q;
		queue<pos> q2;
		if (map[taxi.x][taxi.y] == 0) {
			q.push(pos(taxi.x, taxi.y, taxi.l));
			chk[taxi.x][taxi.y] = 1;
		}
		else {
			c = map[taxi.x][taxi.y];
			map[taxi.x][taxi.y] = 0;
			map[per[c].x][per[c].y] = c;
 			q2.push(pos(taxi.x, taxi.y, taxi.l));
			chk[taxi.x][taxi.y] = 2;
		}
		while (!q.empty()) {
			pos f = q.front();
			q.pop();
			int x = f.x;
			int y = f.y;
			int l = f.l;
			//cout << x<< " , "  << y<< " . " << l << endl;
			if (map[x][y] > 0) {
				limits = l;
				pq.push(pos(x, y, l));
			}
			if (l < limits) break;
			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				if (mx < 1 || my < 1 || mx > N || my > N) continue;
				if (map[mx][my] < 0) continue;
				if (chk[mx][my] == 1) continue;
				chk[mx][my] = 1;
				q.push(pos(mx, my, l-1));
			}
		}

		//cout << " Å¾½Â°´ Ã£À¸·¯ °£´Ù " << endl;
		//for (int i = 1; i <= N; i++) {
		//	for (int j = 1; j <= N; j++) {
		//		cout << chk[i][j] << " ";
		//	}
		//	cout << endl;
		//}
		if (!pq.empty() == false || limits < 0) {
			result = -1;
			break;
		}

		pos f = pq.top();
		c = map[f.x][f.y];
		map[per[c].x][per[c].y] = c;
		map[f.x][f.y] = 0;
		taxi.x = f.x;
		taxi.y = f.y;
		taxi.l = f.l;
		q2.push(pos(f.x, f.y, f.l));

		while (!q2.empty()) {
			pos f = q2.front();
			q2.pop();
			int x = f.x;
			int y = f.y;
			int l = f.l;
			//cout << x << " , " << y << " . " << l << endl;
			if (map[x][y] == c) {
				map[x][y] = 0;
				taxi.x = x;
				taxi.y = y;
				taxi.l = l + (taxi.l - l) * 2;
				result = taxi.l;
				finish = true;
				break;
			}
			if (l < 1) break;
			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				if (mx < 1 || my < 1 || mx > N || my > N) continue;
				if (map[mx][my] < 0) continue;
				if (chk[mx][my] == 2) continue;
				chk[mx][my] = 2;
				q2.push(pos(mx, my, l-1));
			}

		}


		//cout << " ³»·È´Ù. " << endl;
		//for (int i = 1; i <= N; i++) {
		//	for (int j = 1; j <= N; j++) {
		//		cout << chk[i][j] << " ";
		//	}
		//	cout << endl;
		//}
		if (finish == false) {
			result = -1;
			break;
		}
	}
	cout << result << endl;
}