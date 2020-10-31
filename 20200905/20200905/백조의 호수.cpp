#include <iostream>
#include <queue>
#include <vector>
using namespace std;

struct pos {
	int x;
	int y;
	pos(int x, int y) {
		this->x = x;
		this->y = y;
	}
	pos() {
		this->x = 0;
		this->y = 0;
	}
};
pos chicken[2];

string map[1500];
bool chk[1500][1500] = { false };
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };



int main(void) {

	queue <pos> q;
	queue <pos> water;
	int R, C;
	cin >> R >> C;
	int chickencnt = 0;
	for (int i = 0; i < R; i++) {
		cin >> map[i];

		for (int j = 0; j < C; j++) {
			if (map[i][j] == '.') {
				water.push(pos(i, j));
			}
			if (map[i][j] == 'L') {
				chicken[chickencnt].x = i;
				chicken[chickencnt].y = j;
				water.push(pos(i, j));
				chickencnt++;
			}
		}
	}
	bool result = false;
	int day = 0;
	q.push(pos(chicken[0].x, chicken[0].y));
	chk[chicken[0].x][chicken[0].y] = true;
	while (1) {
		queue <pos> q2;
		while (!q.empty()) {
			pos f = q.front();
			int x = f.x;
			int y = f.y;
			if (x == chicken[1].x && y == chicken[1].y) {
				result = true;
				break;
			}
			q.pop();
			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];

				if (mx > R - 1 || my > C - 1 || mx < 0 || my < 0) continue;
				if (chk[mx][my] == true) continue;

				chk[mx][my] = true;

				if (map[mx][my] == 'X') {

					q2.push(pos(mx, my));
					continue;
				}
				q.push(pos(mx, my));
			}

		}
		q = q2;

		if (result == true)break;

		int size = water.size();

		while (size--) {
			pos f = water.front();
			water.pop();
			int x = f.x;
			int y = f.y;

			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];

				if (mx > R - 1 || my > C - 1 || mx < 0 || my < 0) continue;

				if (map[mx][my] == '.') continue;

				map[mx][my] = '.';
				water.push(pos(mx, my));
			}

		}

		day++;
	}
	cout << day << endl;
}