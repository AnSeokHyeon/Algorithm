#include <iostream>
#include <queue>
using namespace std;
struct pos {
	int x;
	int y;
	pos(int x, int y) {
		this->x = x;
		this->y = y;
	}
};
int map[101][101];
int chk[101][101];
int cnt = 0;
int result = 0;
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
int N;
void bfs(int x, int y, int h) {

	cnt++;
	queue < pos > q;
	q.push(pos(x, y));
	chk[x][y] = cnt;
	while (!q.empty()) {
		pos first = q.front();
		q.pop();

		for (int i = 0; i < 4; i++) {
			int mx = first.x + dx[i];
			int my = first.y + dy[i];

			if (mx > N - 1 || my > N - 1) continue;
			if (mx < 0 || my < 0) continue;
			if (map[mx][my] <= h) continue;
			if (chk[mx][my] != 0) continue;
			q.push(pos(mx, my));
			chk[mx][my] = cnt;
		}

	}
	

}

int main(void) {
	cin >> N;
	int tempmax = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j< N; j++) {
			cin >> map[i][j];
			if (map[i][j] > tempmax) tempmax = map[i][j];
		}
	}
	for (int a = 0; a < tempmax ; a++) {
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] <= a) continue;
				if (chk[i][j] != 0) continue;
				bfs(i, j, a);

			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				chk[i][j] = 0;
			}
		}
		if (cnt > result) result = cnt;
	}
	cout << result << endl;
}