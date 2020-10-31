#include <iostream>
#include <queue>
#include <vector>
#include <cstdio>
using namespace std;
struct pos {
	int x;
	int y;
	int t;
	pos(int x, int y, int t) {
		this->x = x;
		this->y = y;
		this->t = t;
	}
	pos() {
		this->x = 0;
		this->y = 0;
		this->t = 0;
	}
};

struct cmp {
	bool operator()(pos a, pos b) {
		return a.t > b.t;
	}
};

pos virus[11];
int map[51][51];
int chk[51][51] = { -1 };
int cnt = 1;
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
bool viruschk[11] = { false };
int result = 987654321;
int N, M;
void print() {
	//priority_queue < pos, vector<pos>, cmp> pq;
	queue<pos> q;
	for (int i = 1; i <= cnt; i++) {
		if (viruschk[i] == true) {
			q.push(pos(virus[i].x, virus[i].y, 0));
			chk[virus[i].x][virus[i].y] = 0;
		}
	}
	while (!q.empty()) {
		pos f = q.front();
		q.pop();
		int x = f.x;
		int y = f.y;
		int t = f.t;
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			if (mx <1 || my <1 || mx > N || my > N)continue;
			if (map[mx][my] == 1) continue;
			if (chk[mx][my] > -1) continue;
			if (map[mx][my] == 2) {
				chk[mx][my] = 0;
				q.push(pos(mx, my, t+1));
			}
			else {
				chk[mx][my] = t+1;
				q.push(pos(mx, my, t+1));
			}
		}
	}
	bool temp = true;
	int tempmax = 0;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {/*
			if (map[i][j] == 1 && chk[i][j] == -1) cout << "- ";
			else if (map[i][j] == 0 && chk[i][j] == -1) cout << "@ ";
			else if (map[i][j] == 2 && chk[i][j] == -1) cout << "* ";
			else cout << chk[i][j] << " ";*/

 			if (map[i][j] == 0 && chk[i][j] == -1) temp = false;
			if (chk[i][j] > tempmax) tempmax = chk[i][j] ;
			chk[i][j] = -1;
		}
		//cout << endl;
	}
	//cout << tempmax << endl;
	if (temp == true) {
		if (result > tempmax) result = tempmax;
	}
}
void dfs(int n, int m) {
	if (n == 0) {
		print();
		return;
	}
	for (int i = m; i < cnt; i++) {
		if (viruschk[i] == true) continue;
		viruschk[i] = true;
		dfs(n - 1, i+1);
		viruschk[i] = false;
	}
}

int main(void) {
	cin >> N >> M;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {

			cin >> map[i][j];
			chk[i][j] = -1;
			if (map[i][j] == 2) {
				virus[cnt].x = i;
				virus[cnt].y = j;
				cnt++;
			}

		}
	}
	dfs(M, 1);
	if (result == 987654321) result = -1;
	cout << result;
}