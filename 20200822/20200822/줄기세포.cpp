#include <iostream>
#include <queue>
#include <cstdio>
#include <functional>

using namespace std;

struct cell {
	int x; 	int y;
	int n;
	int st;
	int at;
	int nt;
	int et;
	cell(int x, int y, int n, int st, int at, int et, int nt) {
		this->x = x;
		this->y = y;
		this->n = n;
		this->st = st;
		this->at = at;
		this->et = et;
		this->nt = nt;
	}
};

struct cmp {
	bool operator()(cell a, cell b) {
		if (a.nt == b.nt) {
			if (a.at == b.at) return a.n < b.n;
			else return a.at > b.at;
		}
		else return a.nt > b.nt;
	}
};

int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
int map[800][800];

int main(void) {
	int T, Tcnt = 1;
	cin >> T;
	while (T--) {
		int N, M, K;
		int ans = 0;
		cin >> N >> M >> K;
		priority_queue< cell, vector<cell>, cmp > pq;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int tempx = 400 - N / 2 + i;
				int tempy = 400 - M / 2 + j;
				cin >> map[tempx][tempy];
				if (map[tempx][tempy] > 0) {
					pq.push(cell(tempx, tempy, map[tempx][tempy], 0, map[tempx][tempy], map[tempx][tempy] * 2, 0));
				}
			}
		}
		int timer = 1;
		while (!pq.empty()) {
			cell f = pq.top();
			if (f.nt == K) break;
			pq.pop();
			if (f.et > f.nt) pq.push(cell(f.x, f.y, f.n, f.st, f.at, f.et, f.nt + 1));
			if (f.at == f.nt) {
				for (int i = 0; i < 4; i++) {
					int mx = f.x + dx[i];
					int my = f.y + dy[i];
					if (map[mx][my] != 0) continue;
					pq.push(cell(mx, my, f.n, f.at + 1, f.at + 1 + f.n, f.at + 1 + f.n * 2, f.nt + 1));
					map[mx][my] = f.n;
				}
			}
		}
		while (!pq.empty()) {
			cell f = pq.top();

			if (f.et > K) ans++;

			pq.pop();
		}

		cout << "#" << Tcnt++ << " " << ans << endl;
		for (int i = 0; i < 800; i++) {
			for (int j = 0; j < 800; j++) {
				map[i][j] = 0;
			}
		}
	}
}