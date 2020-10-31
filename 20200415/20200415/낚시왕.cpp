#include <iostream>

using namespace std;

struct pos {
	int c;
	int x;
	int y;
	int v;
	int d;
	int n;
	int l;
	pos() {
		this->c = 0;
		this->x = 0;
		this->y = 0;
		this->v = 0;
		this->d = 0;
		this->n = 0;
		this->l = 1;
	}
	pos(int c, int x, int y, int v, int d, int n, int l) {
		this->c = c;
		this->x = x;
		this->y = y;
		this->v = v;
		this->d = d;
		this->n = n;
		this->l = l;
	}
};

int map[101][101];
int chk[101];
int dx[] = { 0,-1,1,0,0 };
int dy[] = { 0,0,0,1,-1 };
pos shark[10000];
int main(void) {

	int R, C, M, sum = 0;
	cin >> R >> C >> M;
	if (M == 0) {
		cout << M << endl;
		return 0;
	}
	for (int i = 0; i < M; i++) {
		cin >> shark[i].x;
		cin >> shark[i].y;
		cin >> shark[i].v;
		cin >> shark[i].d;
		cin >> shark[i].n;
		shark[i].c = i;
		chk[shark[i].y] = 1;
	}
	for (int i = 1; i <= C; i++) {
		int cnt = 10001, temp = 10001;
		if (chk[i] != 0) {
			for (int j = 0; j < M; j++) {
				if (shark[j].l == 0) continue;
				if (shark[j].y == i) {
					if (temp > shark[j].x) {
						temp = shark[j].x;
						cnt = shark[j].c;
					}
				}
			}
			if (cnt != 10001) {
				//	cout << cnt<< " // " << temp << endl; 
				sum += shark[cnt].n;
				shark[cnt].l = 0;
				//	cout<<" 잡았다 요놈 : " << sum << endl;
			}
		}

		for (int j = 0; j < 101; j++) {
			chk[j] = 0;
		}

		for (int j = 0; j < M; j++) {
			if (shark[j].l == 0) continue;
			//	cout << " 하이 : " << j << endl; 
			int x = shark[j].x;
			int y = shark[j].y;
			int v = shark[j].v;
			int d = shark[j].d;
			if (d > 2 ) {
				if(C > 2 ) v = v % ((2 * (C-2))+2);
			}
			else {
				if(R > 2 ) v = v % ((2 * (R-2))+2);

			}
			for (int k = 0; k < v; k++) {
				int mx = x + dx[d];
				int my = y + dy[d];

				if (mx > R || my > C || mx < 1 || my < 1) {
					if (d % 2 == 0) {
						d--;
					}
					else d++;

					mx = x + dx[d];
					my = y + dy[d];
				}

				x = mx;
				y = my;
			}
			shark[j].x = x;
			shark[j].y = y;
			shark[j].d = d;
			if (map[x][y] == 0) map[x][y] = shark[j].c + 1;
			else {
				int tempN = map[x][y] - 1;
				if (shark[tempN].n > shark[j].n) {
					shark[j].l = 0;
				}
				else {
					shark[tempN].l = 0;
					map[x][y] = shark[j].c + 1;
				}
			}


			//			for(int k = 1; k<=R;k++){
			//				for(int l = 1; l<=C;l++){
			//					cout << map[k][l] << " ";
			//				}
			//				cout << endl;
			//			}
			//			cout << endl;	
		}
		for (int j = 1; j <= R; j++) {
			for (int k = 1; k <= C; k++) {
				//cout << map[j][k] << " ";
				if (map[j][k] != 0) chk[k] = 1;
				map[j][k] = 0;
			}
			//cout << endl;
		}
		//cout << endl;
	}

	cout << sum << endl;
}