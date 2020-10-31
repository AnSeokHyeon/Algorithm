
#include <iostream>
#include <vector>

using namespace std;

struct pos {
	int x;
	int y;
	pos() {
		this->x = 0;
		this->y = 0;
	}
}; 
pos fish[17];
struct mv {
	int id;
	int d;
	mv(int id, int d) {
		this->id = id;
		this->d = d;
	}
};
int map[4][4];
int d[17] = {};
int dx[] = {0, -1, -1, 0, 1, 1, 1, 0, -1};
int dy[] = {0, 0, -1, -1, -1, 0, 1, 1, 1};
int eating = 0;

void shark(int a[][4], int b[17],int  x,int y, int d, int result ) {
	if (a[x][y] == 0) {
		if (result > eating) eating = result;
 		return;
	}

	fish[a[x][y]].x = -1;
	fish[a[x][y]].y = -1;
	d = b[a[x][y]];
	result += a[x][y];
	b[a[x][y]] = 0;
	a[x][y] = 0;

	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			if (a[i][j] == 0) continue;
			int num = a[i][j];
			fish[num].x = i;
			fish[num].y = j;
		}
	}/*
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			if (x == i && y == j) cout << "# ";
			else cout << a[i][j] << " ";
		}
		cout << endl;
	}*/
	for (int i = 1; i <= 16; i++) {
		if (b[i] == 0) continue;
		int n = 0;
		while (1) {
			int mx = fish[i].x + dx[b[i]];
			int my = fish[i].y + dy[b[i]];

			if ((mx == x && my == y) || mx < 0 || my < 0 || mx > 3 || my > 3) {
				b[i]++;
				if (b[i] == 9) b[i] = 1;
			}
			else if (a[mx][my] > 0) {
				int temp = a[mx][my];
				a[fish[i].x][fish[i].y] = temp;
				fish[temp].x = fish[i].x;
				fish[temp].y = fish[i].y;
				a[mx][my] = i;
				fish[i].x = mx;
				fish[i].y = my;
				break;
			}
			else {
				a[mx][my] = i;
				a[fish[i].x][fish[i].y] = 0;
				fish[i].x = mx;
				fish[i].y = my;
				break;
			}
			if (n == 8) break;
		}/*
		cout << " 이동 현황 " << endl;
		for (int k = 0; k < 4; k++) {
			for (int j = 0; j < 4; j++) {
				cout << a[k][j] << " ";
			}
			cout << endl;
		}*/
	}/*
	cout << " 이동 최종 현황  @##@#@ " << endl;
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			cout << a[i][j] << " ";
		}
		cout << endl;
	}*/
	for (int i = 0; i < 3; i++) {
		int mx = x + dx[d] * (i+1);
		int my = y + dy[d] * (i + 1);
		if (mx < 0 || my < 0 || mx > 3 || my > 3) {
			if (result > eating) eating = result;
			continue;
		}
		int c[4][4];
		int e[17];
		for (int k = 0; k < 4; k++) {
			for (int j = 0; j < 4; j++) {
				c[k][j] = a[k][j];
			}
		}
		for (int j = 1; j <= 16; j++) {
			e[j] = b[j];
		}
		shark(c, e, mx, my, d, result);

	}


}


int main(void) {

	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			int fishindex, direction;
			cin >> fishindex >> direction;
			map[i][j] = fishindex;
			d[fishindex] = direction;
		}
	}
	int result = 0;/*
	cout << " 상어 시작  @@@@@@@@@@@@@@@@" << endl;
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			cout << map[i][j] << " ";
		}
		cout << endl;
	}*/
	shark(map, d, 0 ,0, 0, result);
	cout << eating << endl;

}