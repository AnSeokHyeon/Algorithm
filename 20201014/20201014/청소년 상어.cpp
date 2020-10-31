#include <iostream>

using namespace std;
struct pos {
	int x;
	int y;
	int d;
	pos() {
		this->x = 0;
		this->y = 0;
		this->d = 0;
	}
};
int dx[] = {0,-1,-1,0,1,1,1,0,-1 };
int dy[] = {0,0,-1,-1,-1,0,1,1,1};
pos fish[17];
pos shark;
int map[5][5];
int result = 0;
void moving(pos n[17], int x, int y, int d, int sum, int m[5][5]) {
	if (m[x][y] == 0) {

		if (result < sum) result = sum;
		return;
	}
		int temp = m[x][y];
		m[x][y] = 0;
		d = n[temp].d;
		sum += temp;
		n[temp].x = 0;
		n[temp].y = 0;
		n[temp].d = 0;


	for (int i = 1; i < 17; i++) {
		if (n[i].d == 0)continue;
		int nx = n[i].x;
		int ny = n[i].y;
		int nd = n[i].d;
		while (1) {
			int mx = nx + dx[nd];
			int my = ny + dy[nd];

			if (mx > 4 || my > 4 || mx < 1 || my < 1) {
				nd++;
				if (nd > 8) nd = 1;
				continue;
			}
			if (mx == x && my == y) {
				nd++;
				if (nd > 8) nd = 1;
				continue;

			}
			if (m[mx][my] > 0) {
				int temp = m[mx][my];
				n[temp].x = nx;
				n[temp].y = ny;
				m[nx][ny] = temp;
			}
			else {
				m[nx][ny] = 0;
			}
			m[mx][my] = i;
			n[i].x = mx;
			n[i].y = my;
			n[i].d = nd;
			break;

		}

	}

	for (int i = 1; i < 4; i++) {
		int mx = x + dx[d] * i;
		int my = y + dy[d] * i;

		if (mx < 1 || my < 1 || mx > 4 || my > 4) {

			if (result < sum) result = sum;
			continue;
		}
		int c[5][5];
		pos f[17];
		for (int k = 1; k <= 4; k++) {
			for (int j = 1; j <= 4; j++) {
				c[k][j] = m[k][j];
			}
		}
		for (int j = 1; j <= 16; j++) {
			f[j].x = n[j].x;
			f[j].y = n[j].y;
			f[j].d = n[j].d;
		}
		moving(f,mx, my, d, sum, c);



	}
	
	


}
int main(void) {
	for (int i = 1; i <= 4; i++) {
		for (int j = 1; j <= 4; j++) {
			int num, dir;
			cin >> num >> dir;
			fish[num].d = dir;
			fish[num].x = i;
			fish[num].y = j;
			map[i][j] = num;
		}
	}
	shark.x = 1;
	shark.y = 1;
	moving(fish, 1,1,0, 0, map);
	cout << result << endl;
}