#include <iostream>

using namespace std;

struct pos {
	int x;
	int y;
	int n;
	int d;
	int t;
	pos() {
		this->x = 0;
		this->y = 0;
		this->n = 0;
		this->d = 0;
		this->t = 0;
	}
};

pos atom[1000];
pos map[1000];
int chk[5000][5000];
int Acnt = 0;
int dy[] = { 1,-1,0,0 };
int dx[] = { 0,0,-1,1 };
int dp[1000];

int main(void) {
	int T, Tcnt = 1;
	cin >> T;
	while (T--) {
		cin >> Acnt;
		int Icnt = 0;
		int result = 0;

		for (int i = 0; i < Acnt; i++) {
			int y, x;
			cin >> x >> y;
			atom[i].y = y * 2 +2000;
			atom[i].x = x * 2 +2000;
			cin >> atom[i].d;
			cin >> atom[i].n;
		}

		for (int i = 0; i < 4000; i++) {
			int Ccnt = 0;
			//cout << i+1 << "ÃÊ @@@@@@@@" << endl;
			//for (int i = 0; i < Acnt; i++) {

			//	cout << atom[i].x << " , " << atom[i].y << " / " << atom[i].d << " $$ " << atom[i].n << endl;
			//}

			for (int j = 0; j < Acnt; j++) {
				if (atom[j].n == 987645321) continue;
				int mx = atom[j].x + dx[atom[j].d];
				int my = atom[j].y + dy[atom[j].d];
				if (mx < 0 || my < 0 || mx > 4000 || my > 4000) {
					atom[j].x = 987645321;
					atom[j].y = 987645321;
					atom[j].n = 987645321;
					atom[j].t = 987645321;
					atom[j].d = 987645321;
					continue;;
				}

				atom[j].x = mx;
				atom[j].y = my;
				atom[j].t++;

				chk[mx][my]++;
				if (chk[mx][my] > 1) {
					//cout << " µé¾î¿È " << endl;
					for (int i = 0; i < Icnt; i++) {
						if (mx == map[i].x && my == map[i].y) {
							map[i].n++;
							break;
						}
					}
				}
				else {

					map[Icnt].x = mx;
					map[Icnt].y = my;
					map[Icnt++].n++;

				}

			}

			for (int j = 0; j < Icnt; j++) {
				if (map[j].n > 1) {
					for (int k = 0; k < Acnt; k++) {
						if (map[j].x == atom[k].x && map[j].y == atom[k].y) {
							//cout << atom[k].x << " , " << atom[k].y << " / "<< atom[k].n <<  endl;
							result = result + atom[k].n;
							atom[k].x = 987645321;
							atom[k].y = 987645321;
							atom[k].n = 987645321;
							atom[k].t = 987645321;
							atom[k].d = 987645321;
						}
					}
				}
				chk[map[j].x][map[j].y] = 0;
				map[j].n = 0;
				map[j].x = 0;
				map[j].y = 0;
			}
			if (Icnt == 0) break;
			Icnt = 0;
		}
		cout << "#" << Tcnt++ << " " << result << endl;
	}
}