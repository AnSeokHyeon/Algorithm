#include <iostream>
#include <queue>

using namespace std;

struct pos {
	int w;
	int h;
	pos(int h, int w) {
		this->w = w;
		this->h = h;
	}
};

int map[16][13];
int N, W, H;
int cnt;
int dw[] = { 1,0,-1,0 };
int dh[] = { 0,1,0,-1 };
int minBrick;
queue <pos> q;

void brick(int n, int copy[][13]) {
	if (n == N) {
		//cout << " 접속 완료 ~ " << endl;
		int cntB = 0;
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				//cout << copy[i][j] << " ";
				if (copy[i][j] != 0) cntB++;
			}
			//cout << endl;
		}
		if (minBrick > cntB)minBrick = cntB;
		return;
	}
	int test[16][13];
	for (int a = 1; a <= H; a++) {
		for (int b = 1; b <= W; b++) {
			test[a][b] = copy[a][b];
		}
	}
	for (int i = 1; i <= W; i++) {
		int temp;
		for (int j = 1; j <= H; j++) {
			if (test[j][i] == 0) continue;
			else {
				q.push(pos(j, i));
				break;
			}
		}
		while (!q.empty()) {
			pos f = q.front();
			q.pop();
			int h = f.h;
			int w = f.w;
			temp = test[h][w];

			test[h][w] = 0;
			for (int j = 1; j < temp; j++) {
				for (int k = 0; k < 4; k++) {
					int mw = w + dw[k] * j;
					int mh = h + dh[k] * j;
					if (mw > W || mh > H) continue;
					if (mw < 1 || mh < 1) continue;
					if (test[mh][mw] == 0) continue;
					q.push(pos(mh, mw));
				}
			}
		}
		for (int i = 1; i <= W; i++) {
			for (int j = H; j >0; j--) {
				if (test[j][i] == 0) {
					for (int k = j - 1; k > 0; k--) {
						if (test[k][i] == 0) continue;
						else {
							int temp = test[k][i];
							test[j][i] = temp;
							test[k][i] = 0;
							break;
						}
					}
				}
			}
		}
		//cout << n + 1 << "번쩨 ######" << endl;
		//for (int i = 1; i <= H; i++) {
		//	for (int j = 1; j <= W; j++) {
		//		cout << test[i][j];
		//	}
		//	cout << endl;
		//}
		brick(n + 1, test);
		for (int a = 1; a <= H; a++) {
			for (int b = 1; b <= W; b++) {
				test[a][b] = copy[a][b];
			}
		}
	}
}

int main(void) {
	int T;
	cin >> T;
	int Tcnt = 0;
	while(T--){
	cin >> N >> W >> H;
	minBrick = 10000;
	Tcnt++;
	for (int i = 1; i <= H; i++) {
		for (int j = 1; j <= W; j++) {
			cin >> map[i][j];
		}
	}
	//for (int i = 1; i <= H; i++) {
	//	for (int j = 1; j <= W; j++) {
	//		cout << map[i][j];
	//	}
	//	cout << endl;
	//}
	cnt = 1;
	brick(0, map);
	cout<<"#"<<Tcnt <<" " << minBrick << endl;
	}
}