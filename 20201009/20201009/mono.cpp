#include <iostream>
using namespace std;

struct pos {
	int t;
	int x1;
	int x2;
	int y1;
	int y2;

	int bt;
	int bx1;
	int bx2;
	int by1;
	int by2;

	int gt;
	int gx1;
	int gx2;
	int gy1;
	int gy2;
	pos() {
		this->t = 0;
		this->bt = 0;
		this->gt = 0;
		this->x1 = -1;
		this->x2 = -1;
		this->y1 = -1;
		this->y2 = -1;
		this->bx1 = -1;
		this->bx2 = -1;
		this->by1 = -1;
		this->by2 = -1;
		this->gx1 = -1;
		this->gx2 = -1;
		this->gy1 = -1;
		this->gy2 = -1;
	}
};

pos bk[10000];

int map[10][10];

void moving(int n, int cnt) {
	if (n == 0) {


		for (int i = 1; i < 11; i++) {
			if (bk[cnt].t == 1) {
				if (map[bk[cnt].x1 + i][bk[cnt].y1] > 0 || (bk[cnt].x1 + i) > 9) {

					bk[cnt].gx1 = bk[cnt].x1 + i - 1;
					bk[cnt].gy1 = bk[cnt].y1;
					break;
				}
			}
			else if (bk[cnt].t == 2) {
				if (map[bk[cnt].x1 + i][bk[cnt].y1] > 0 || map[bk[cnt].x2 + i][bk[cnt].y2] > 0 || (bk[cnt].x1 + i) > 9) {
					bk[cnt].gx1 = bk[cnt].x1 + i - 1;
					bk[cnt].gx2 = bk[cnt].x2 + i - 1;
					bk[cnt].gy1 = bk[cnt].y1;
					bk[cnt].gy2 = bk[cnt].y2;
					break;
				}
			}
			else if (bk[cnt].t == 3) {
				if (map[bk[cnt].x2 + i][bk[cnt].y2] > 0 || (bk[cnt].x2 + i) > 9) {

					bk[cnt].gx1 = bk[cnt].x1 + i - 1;
					bk[cnt].gx2 = bk[cnt].x2 + i - 1;
					bk[cnt].gy1 = bk[cnt].y1;
					bk[cnt].gy2 = bk[cnt].y2;
					break;
				}
			}
		}
		for (int i = 1; i < 11; i++) {
			if (bk[cnt].t == 1) {
				if (map[bk[cnt].x1][bk[cnt].y1 + i] > 0 || (bk[cnt].y1 + i) > 9)break;
				bk[cnt].by1 = bk[cnt].y1 + i;
				bk[cnt].bx1 = bk[cnt].x1;
			}
			else if (bk[cnt].t == 2) {
				if (map[bk[cnt].x2][bk[cnt].y2 + i] > 0 || (bk[cnt].y2 + i) > 9) break;
				bk[cnt].by1 = bk[cnt].y1 + i;
				bk[cnt].by2 = bk[cnt].y2 + i;
				bk[cnt].bx1 = bk[cnt].x1;
				bk[cnt].bx2 = bk[cnt].x2;
			}
			else if (bk[cnt].t == 3) {
				if (map[bk[cnt].x1][bk[cnt].y2 + i] > 0 || map[bk[cnt].x2][bk[cnt].y2 + i] > 0 || (bk[cnt].y2 + i) > 9)
					break;
				bk[cnt].by1 = bk[cnt].y1 + i;
				bk[cnt].by2 = bk[cnt].y2 + i;
				bk[cnt].bx1 = bk[cnt].x1;
				bk[cnt].bx2 = bk[cnt].x2;
			}
		}

		map[bk[cnt].gx1][bk[cnt].gy1] = cnt;
		map[bk[cnt].bx1][bk[cnt].by1] = cnt;
		if (bk[cnt].t > 1) {
			map[bk[cnt].gx2][bk[cnt].gy2] = cnt;
			map[bk[cnt].bx2][bk[cnt].by2] = cnt;
		}

	}
	if (n == 1) {

		map[bk[cnt].gx1][bk[cnt].gy1] = 0;
		if (bk[cnt].gt > 1) {
			map[bk[cnt].gx2][bk[cnt].gy2] = 0;
		}
		for (int i = 1; i < 10; i++) {
			if (bk[cnt].gt == 1) {
				if (map[bk[cnt].gx1 + i][bk[cnt].gy1] > 0 || (bk[cnt].gx1 + i) > 9) {

					bk[cnt].gx1 = bk[cnt].gx1 + i-1;
					bk[cnt].gy1 = bk[cnt].gy1;
					break;
				}
			}
			else if (bk[cnt].gt == 2) {
				if (map[bk[cnt].gx1 + i][bk[cnt].gy1] > 0 || map[bk[cnt].gx2 + i][bk[cnt].gy2] > 0 || (bk[cnt].gx1 + i) > 9) {
					bk[cnt].gx1 = bk[cnt].gx1 + i-1;
					bk[cnt].gx2 = bk[cnt].gx2 + i-1;
					break;
				}
			}
			else if (bk[cnt].gt == 3) {
				if (map[bk[cnt].gx2 + i][bk[cnt].gy2] > 0 || (bk[cnt].gx2 + i) > 9) {

					bk[cnt].gx1 = bk[cnt].gx1 + i-1;
					bk[cnt].gx2 = bk[cnt].gx2 + i-1;
					break;
				}
			}
		}
		map[bk[cnt].gx1][bk[cnt].gy1] = cnt;
		if (bk[cnt].gt > 1) {
			map[bk[cnt].gx2][bk[cnt].gy2] = cnt;
		}

	}
	if (n == 2) {

		map[bk[cnt].bx1][bk[cnt].by1] = 0;
		if (bk[cnt].bt > 1) {
			map[bk[cnt].bx2][bk[cnt].by2] = 0;
		}

		for (int i = 1; i < 10; i++) {
			if (bk[cnt].bt == 1) {
				if (map[bk[cnt].bx1][bk[cnt].by1 + i] > 0 || (bk[cnt].by1 + i) > 9) {
					bk[cnt].by1 = bk[cnt].by1 + i - 1;
					break;
				}
			}
			else if (bk[cnt].bt == 2) {
				if (map[bk[cnt].bx2][bk[cnt].by2 + i] > 0 || (bk[cnt].by2 + i) > 9) {
					bk[cnt].by1 = bk[cnt].by1 + i - 1;
					bk[cnt].by2 = bk[cnt].by2 + i - 1;
					break;
				}
			}
			else if (bk[cnt].bt == 3) {
				if (map[bk[cnt].bx1][bk[cnt].by2 + i] > 0 || map[bk[cnt].bx2][bk[cnt].by2 + i] > 0 || (bk[cnt].by2 + i) > 9) {

					bk[cnt].by1 = bk[cnt].by1 + i - 1;
					bk[cnt].by2 = bk[cnt].by2 + i - 1;
					break;
				}
			}
		}

		map[bk[cnt].bx1][bk[cnt].by1] = cnt;
		if (bk[cnt].bt > 1) {
			map[bk[cnt].bx2][bk[cnt].by2] = cnt;
		}

	}
}

void erase(char c, int l) {
	if (c == 'g') {
		int i = l;
		for (int j = 0; j < 4; j++) {
			int n = map[i][j];
			if (bk[n].gt == 1) {
				bk[n].gt = 0;
				bk[n].gx1 = -1;
				bk[n].gy1 = -1;
			}
			else {
				if (bk[n].gx1 == i && bk[n].gy1 == j) {
					bk[n].gx1 = bk[n].gx2;
					bk[n].gy1 = bk[n].gy2;
				}
				bk[n].gt = 1;
				bk[n].gx2 = -1;
				bk[n].gy2 = -1;
			}
			map[i][j] = 0;
		}
	}
	else {
		int j = l;
		for (int i = 0; i < 4; i++) {
			int n = map[i][j];
			if (bk[n].bt == 1) {
				bk[n].bt = 0;
				bk[n].bx1 = -1;
				bk[n].by1 = -1;
			}
			else {
				if (bk[n].bx1 == i && bk[n].by1 == j) {
					bk[n].bx1 = bk[n].bx2;
					bk[n].by1 = bk[n].by2;
				}
				bk[n].bt = 1;
				bk[n].bx2 = -1;
				bk[n].by2 = -1;
			}
			map[i][j] = 0;
		}

	}

}


int main(void) {
	int N;
	cin >> N;
	int cnt = 1;
	int result = 0;
	while (N--) {
		int T, x, y;
		cin >> T >> x >> y;
		bk[cnt].t = T;
		bk[cnt].gt = T;
		bk[cnt].bt = T;

		bk[cnt].x1 = x;
		bk[cnt].y1 = y;
		if (T == 2) {
			bk[cnt].x2 = x;
			bk[cnt].y2 = y+1;
		}
		if (T == 3) {
			bk[cnt].x2 = x +1;
			bk[cnt].y2 = y;
		}
		moving(0, cnt);

		cout << " 배치 후 상황 " << endl;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == bk[cnt].x1 && j == bk[cnt].y1 || i == bk[cnt].x2 && j == bk[cnt].y2) printf("%3d", cnt);
				else printf("%3d", map[i][j]);
			}
			cout << endl;
		}


		int findg = 0;
		int findb = 0;
		while (1) {

			while (1) {
				bool del = false;
				for (int i = 9; i > 3; i--) {
					bool ndel = false;
					if (findg > 0) {
						erase('g', i);
						findg--;
						continue;
					}

					for (int j = 0; j < 4; j++) {
						if (map[i][j] == 0) {
							ndel = true;
							break;
						}
					}
					if (ndel == true) continue;
					erase('g', i);

					result++;
					del = true;
				}

				//cout << "그린존 삭제 후 상황 " << endl;
				//for (int i = 0; i < 10; i++) {
				//	for (int j = 0; j < 10; j++) {
				//		if (i == bk[cnt].x1 && j == bk[cnt].y1 || i == bk[cnt].x2 && j == bk[cnt].y2) cout << cnt << " ";
				//		else cout << map[i][j] << " ";
				//	}
				//	cout << endl;
				//}

				for (int i = 9; i > 3; i--) {
					for (int j = 0; j < 4; j++) {
						if (map[i][j] == 0) continue;
						int temp = map[i][j];
						if (bk[temp].gt > 1 && bk[temp].gx2 == i && bk[temp].gy2 == j) continue;
						moving(1, temp);
					}
				}

				//cout << "그린존 이동 후  상황 " << endl;
				//for (int i = 0; i < 10; i++) {
				//	for (int j = 0; j < 10; j++) {
				//		if (i == bk[cnt].x1 && j == bk[cnt].y1 || i == bk[cnt].x2 && j == bk[cnt].y2) cout << cnt << " ";
				//		else cout << map[i][j] << " ";
				//	}
				//	cout << endl;
				//}

				for (int j = 9; j > 3; j--) {
					bool ndel = false;
					if (findb > 0) {
						erase('b', j);
						findb--;
						break;
					}
					for (int i = 0; i < 4; i++) {
						if (map[i][j] == 0 && findb == 0) {
							ndel = true;
							break;
						}
					}
					if (ndel == true) continue;
					erase('b', j);
					result++;
					del = true;
				}

				//cout << "블루존 삭제 후 상황 " << endl;
				//for (int i = 0; i < 10; i++) {
				//	for (int j = 0; j < 10; j++) {
				//		if (i == bk[cnt].x1 && j == bk[cnt].y1 || i == bk[cnt].x2 && j == bk[cnt].y2) cout << cnt << " ";
				//		else cout << map[i][j] << " ";
				//	}
				//	cout << endl;
				//}


				for (int j = 9; j > 3; j--) {
					for (int i = 0; i < 4; i++) {
						if (map[i][j] == 0) continue;
						int temp = map[i][j];
						if (bk[temp].gt > 1 && bk[temp].gx2 == i && bk[temp].gy2 == j) continue;
						moving(2, temp);
					}
				}

				//cout << "블루존 이동 후 상황 " << endl;
				//for (int i = 0; i < 10; i++) {
				//	for (int j = 0; j < 10; j++) {
				//		if (i == bk[cnt].x1 && j == bk[cnt].y1 || i == bk[cnt].x2 && j == bk[cnt].y2) cout << cnt << " ";
				//		else cout << map[i][j] << " ";
				//	}
				//	cout << endl;
				//}

				if (del == false)break;
			}

			bool special = false;
			for (int j = 5; j > 3; j--) {
				bool nsp = false;
				for (int i = 0; i < 4; i++) {
					if (map[i][j] > 0) {
						findb++;
						special = true;
						break;
					}
				}
				if (nsp == false) break;
			}

			for (int i = 5; i > 3; i--) {
				bool nsp = false;
				for (int j = 0; j < 4; j++) {
					if (map[i][j] > 0) {
						findg++;
						special = true;
						break;
					}
				}
				if (nsp == false) break;
			}
			if (special == false) break;

			//cout << "현상황 " << endl;
			//for (int i = 0; i < 10; i++) {
			//	for (int j = 0; j < 10; j++) {
			//		if (i == bk[cnt].x1 && j == bk[cnt].y1 || i == bk[cnt].x2 && j == bk[cnt].y2) cout << cnt << " ";
			//		else cout << map[i][j] << " ";
			//	}
			//	cout << endl;
			//}

		}

		cout << "종료 된 상황 " << endl;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == bk[cnt].x1 && j == bk[cnt].y1 || i == bk[cnt].x2 && j == bk[cnt].y2) printf("%3d", cnt);
				else printf("%3d", map[i][j]);
			}
			cout << endl;
		}

		cnt++;
	}
	int ans = 0;
	for (int j = 9; j > 5; j--) {
		for (int i = 0; i < 4; i++) {
			if (map[i][j] > 0) {
				ans++;
			}
		}
	}

	for (int i = 9; i > 5; i--) {
		for (int j = 0; j < 4; j++) {
			if (map[i][j] > 0) {
				ans++;
			}
		}
	}
	cout << result << endl;
	cout << ans << endl;
}