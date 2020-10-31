#include <iostream>

using namespace std;

struct pos {
	int t;
	int idx;
	int x;
	int y;
	int x2;
	int y2;
	pos() {
		this->t = -1;
		this->idx = -1;
		this->x = -1;
		this->y = -1;
		this->x2 = -1;
		this->y2 = -1;
	}
};
pos g[10001];
pos b[10001];

int green[10][4];
int blue[10][4];
void shotg(int t, int x, int y, int id) {

	g[id].idx = id;
	g[id].t = t;
	g[id].x = x;
	g[id].y = y;
	if (t == 1) {
		for (int i = 4; i < 10; i++) {
			if (green[i][y] > 0) break;
			g[id].x = i;
		}
		green[g[id].x][g[id].y] = id;
	}
	else if (t == 2) {
		g[id].x2 = x;
		g[id].y2 = y + 1;
		for (int i = 4; i < 10; i++) {
			if (green[i][y] > 0 || green[i][y + 1]) break;
			g[id].x = i;
			g[id].x2 = i;
		}
		green[g[id].x][g[id].y] = id;
		green[g[id].x2][g[id].y2] = id;

	}
	else {
		g[id].x2 = x + 1;
		g[id].y2 = y;
		for (int i = 4; i < 9; i++) {
			if (green[i + 1][y] > 0 || green[i][y]) break;
			g[id].x = i;
			g[id].x2 = i + 1;
		}
		green[g[id].x][g[id].y] = id;
		green[g[id].x2][g[id].y2] = id;
	}
}

void shotb(int t, int x, int y, int id) {


	b[id].idx = id;
	b[id].t = t;
	b[id].x = x;
	b[id].y = 3 - y;
	if (t == 1) {
		for (int i = 4; i < 10; i++) {
			if (blue[i][3 - y] > 0) break;
			b[id].x = i;
		}
		blue[b[id].x][b[id].y] = id;
	}
	else if (t == 2) {
		b[id].x2 = x + 1;
		b[id].y2 = 3 - y;
		for (int i = 4; i < 9; i++) {
			if (blue[i + 1][3 - y] > 0 || blue[i][3 - y] > 0) break;
			b[id].x = i;
			b[id].x2 = i + 1;
		}
		blue[b[id].x][b[id].y] = id;
		blue[b[id].x2][b[id].y2] = id;
	}
	else {
		b[id].x2 = x;
		b[id].y2 = 3 - y - 1;
		for (int i = 4; i < 10; i++) {
			if (blue[i][3 - y] > 0 || blue[i][2 - y] > 0) break;
			b[id].x = i;
			b[id].x2 = i;
		}
		blue[b[id].x][b[id].y] = id;
		blue[b[id].x2][b[id].y2] = id;

	}

}

void eraseg(int row) {
	for (int i = 0; i < 4; i++) {
		int index = green[row][i];
		int temp = g[index].t;
		if (temp == 1) {
			g[index].x = -1;
			g[index].y = -1;
			g[index].t = -1;
		}
		if (temp > 1) {
			if (row == g[index].x && i == g[index].y) {
				g[index].x = g[index].x2;
				g[index].y = g[index].y2;
			}
			g[index].t = 1;
			g[index].x2 = -1;
			g[index].y2 = -1;
		}
		green[row][i] = 0;
	}

}
void eraseb(int row) {
	for (int i = 0; i < 4; i++) {
		int index = blue[row][i];
		int temp = b[index].t;
		if (temp == 1) {
			b[index].x = -1;
			b[index].y = -1;
			b[index].t = -1;
		}
		if (temp > 1) {
			if (row == b[index].x && i == b[index].y) {
				b[index].x = b[index].x2;
				b[index].y = b[index].y2;
			}
			b[index].t = 1;
			b[index].x2 = -1;
			b[index].y2 = -1;
		}
		blue[row][i] = 0;
	}

}
void moveg() {
	for (int i = 8; i > 3; i--) {
		for (int j = 0; j < 4; j++) {
			if (green[i][j] == 0)continue;
			int temp = green[i][j];
			if (g[temp].x == i && g[temp].y == j) {

				if (g[temp].t == 1) {
					green[g[temp].x][g[temp].y] = 0;
					for (int k = 1; i + k < 10; k++) {
						if (green[i + k][g[temp].y] > 0) break;
						g[temp].x = i + k;
					}
					green[g[temp].x][g[temp].y] = g[temp].idx;
				}

				if (g[temp].t == 2) {
					green[g[temp].x][g[temp].y] = 0;
					green[g[temp].x2][g[temp].y2] = 0;
					for (int k = 1; i + 1 + k < 10; k++) {
						if (green[i + k][j] > 0 || green[i + k][j + 1] > 0) break;
						g[temp].x = i + k;
						g[temp].x2 = i + k;
					}
					green[g[temp].x][g[temp].y] = g[temp].idx;
					green[g[temp].x2][g[temp].y2] = g[temp].idx;

				}
				if (g[temp].t == 3) {

					green[g[temp].x][g[temp].y] = 0;
					green[g[temp].x2][g[temp].y2] = 0;
					for (int k = 1; i + k < 9; k++) {
						if (green[i + 1 + k][g[temp].y2] > 0 || green[i + k][g[temp].y] > 0) break;
						g[temp].x = i + k;
						g[temp].x2 = i + 1 + k;
					}
					green[g[temp].x][g[temp].y] = g[temp].idx;
					green[g[temp].x2][g[temp].y2] = g[temp].idx;
				}

			}
		}
	}
}


void moveb() {
	for (int i = 8; i > 3; i--) {
		for (int j = 0; j < 4; j++) {
			if (blue[i][j] == 0)continue;
			int temp = blue[i][j];
			if (b[temp].x == i && b[temp].y == j) {

				if (b[temp].t == 1) {
					blue[b[temp].x][b[temp].y] = 0;
					for (int k = 1; i + k < 10; k++) {
						if (blue[i + k][b[temp].y] > 0) break;
						b[temp].x = i + k;
					}
					blue[b[temp].x][b[temp].y] = b[temp].idx;
				}

				if (b[temp].t == 3) {
					blue[b[temp].x][b[temp].y] = 0;
					blue[b[temp].x2][b[temp].y2] = 0;
					for (int k = 1; i + k < 10; k++) {
						if (blue[i + k][j] > 0 || blue[i + k][j +1] > 0) break;
						b[temp].x = i + k;
						b[temp].x2 = i + k;
					}
					blue[b[temp].x][b[temp].y] = b[temp].idx;
					blue[b[temp].x2][b[temp].y2] = b[temp].idx;

				}
				if (b[temp].t == 2) {

					blue[b[temp].x][b[temp].y] = 0;
					blue[b[temp].x2][b[temp].y2] = 0;
					for (int k = 1; i + k + 1 < 10; k++) {
						if (blue[i + 1 + k][b[temp].y2] > 0 || blue[i + k][b[temp].y] > 0) break;
						b[temp].x = i + k;
						b[temp].x2 = i + 1 + k;
					}
					blue[b[temp].x][b[temp].y] = b[temp].idx;
					blue[b[temp].x2][b[temp].y2] = b[temp].idx;

				}

			}
		}
	}
}

void bchk(int n) {
	for (int i = 9; i > 3; i--) {
		for (int j = 0; j < 4; j++) {

			blue[i][j] = blue[i - n][j];
		}

	}
}

void gchk(int n) {
	for (int i = 9; i > 3; i--) {
		for (int j = 0; j < 4; j++) {

			green[i][j] = green[i - n][j];
		}

	}
}

int main(void) {
	int N;
	cin >> N;
	int Ncnt = 1;
	int result = 0;
	while (N--) {
		int t, x, y;
		cin >> t >> x >> y;
		shotg(t, x, y, Ncnt);
		shotb(t, y, x, Ncnt);

		Ncnt++;/*
		cout << " 쌌어" << endl;
		cout << " green" << endl;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 4; j++) {
				cout << green[i][j] << " ";
			}
			cout << endl;
		}
		cout << " blue" << endl;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 4; j++) {
				cout << blue[i][j] << " ";
			}
			cout << endl;
		}
		cout << endl;*/
		while (1) {
			bool er = false;
			for (int i = 9; i > 3; i--) {
				bool rowerase = true;
				for (int j = 0; j < 4; j++) {
					if (green[i][j] == 0) {
						rowerase = false;
						break;
					}
				}
				if (rowerase == true) {
					eraseg(i);
					result++;
					er = true;
				}
			}

			for (int i = 9; i > 3; i--) {
				bool rowerase = true;
				for (int j = 0; j < 4; j++) {
					if (blue[i][j] == 0) {
						rowerase = false;
						break;
					}
				}
				if (rowerase == true) {
					eraseb(i);
					result++;
					er = true;
				}
			}
			
			moveb();
			moveg();
			if (er == false) break;
		}/*
		cout << " 일단 다 지움 " << endl;
		cout << " green" << endl;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 4; j++) {
				cout << green[i][j] << " ";
			}
			cout << endl;
		}
		cout << " blue" << endl;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 4; j++) {
				cout << blue[i][j] << " ";
			}
			cout << endl;
		}
		cout << endl;*/

		/*
		cout << " 움직였음  " << endl;
		cout << " green" << endl;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 4; j++) {
				cout << green[i][j] << " ";
			}
			cout << endl;
		}
		cout << " blue" << endl;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 4; j++) {
				cout << blue[i][j] << " ";
			}
			cout << endl;
		}
		cout << endl;*/

		int chk = 0;
		for (int i = 4; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				if (blue[i][j] > 0) {
					chk++;
					break;
				}
			}
		}
		bchk(chk);
		chk = 0;
		for (int i = 4; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				if (green[i][j] > 0) {
					chk++;
					break;
				}
			}
		}
		gchk(chk);


		//cout << " 다 끝나고 나서 " << endl;
		//cout << " green" << endl;
		//for (int i = 0; i < 10; i++) {
		//	for (int j = 0; j < 4; j++) {
		//		cout << green[i][j] << " ";
		//	}
		//	cout << endl;
		//}
		//cout << " blue" << endl;
		//for (int i = 0; i < 10; i++) {
		//	for (int j = 0; j < 4; j++) {
		//		cout << blue[i][j] << " ";
		//	}
		//	cout << endl;
		//}
		//cout << endl;
	}
	int ans = 0;
	for (int i = 9; i > 3; i--) {
		for (int j = 0; j < 4; j++) {
			if (blue[i][j] > 0) ans++;
			if (green[i][j] > 0) ans++;

		}
	}
	cout << result << endl;
	cout << ans << endl;

}