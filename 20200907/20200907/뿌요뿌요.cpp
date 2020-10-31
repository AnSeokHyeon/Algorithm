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

int dx[] = {1,-1,0,0};
int dy[] = {0,0,1,-1};

int chk[13][7];
char map[13][7];

int main(void) {

	for (int i = 1; i < 13; i++) {
		for (int j = 1; j < 7; j++) {
			cin >> map[i][j];
		}
	}

	int num = 0;
	queue<pos> puyo;
	while (1) {
		queue<pos> erase;
		cout << "µé¾î¿È " << endl;
		for (int i = 1; i < 13; i++) {
			for (int j = 1; j < 7; j++) {
				cout << map[i][j];
			}
			cout << endl;
		}
		cout << endl;

		int cnt = 1;
		bool puyopuyo = false;

		for (int i = 12; i > 0; i--) {
			for (int j = 1; j < 7; j++) {
				if (chk[i][j] != 0) continue;
				if (map[i][j] == '.') continue;
				int temp = 0;
				puyo.push(pos(i, j));
				chk[i][j] = cnt;
				while (!puyo.empty()) {
					temp++;
					pos f = puyo.front();
					puyo.pop();
					int x = f.x;
					int y = f.y;
					char p = map[x][y];
					
					for (int i = 0; i < 4; i++) {
						int mx = x + dx[i];
						int my = y + dy[i];

						if (mx < 1 || my < 1 || mx > 12 || my >6) continue;
						if (chk[mx][my] != 0) continue;
						if (map[mx][my] != p) continue;

						chk[mx][my] = cnt;
						puyo.push(pos(mx, my));

					}

				}
				if (temp > 3) {
					erase.push(pos(i, j));
				}
				cnt++;
			}
			if (!erase.empty() == true) {
				puyopuyo = true;
			}
		}


		while (!erase.empty()) {
			
			pos f = erase.front();
			erase.pop();
			int x = f.x;
			int y = f.y;
			int p = map[x][y];
			map[x][y] = '.';
			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				if (map[mx][my] == '.') continue;
				if (map[mx][my] == p) {
					erase.push(pos(mx, my));
				}
				
			}
		}

		for (int j = 1; j < 7; j++) {
			for (int i = 12; i > 0; i--) {
				chk[i][j] = 0;
				if (map[i][j] == '.') continue;
				for (int k = 12; k > i; k--) {
					if (map[k][j] != '.') continue;
					map[k][j] = map[i][j];
					map[i][j] = '.';
					break;
				}
			}
		}

		if (puyopuyo == false) break;
		num++;
	}

	cout << num << endl;

}