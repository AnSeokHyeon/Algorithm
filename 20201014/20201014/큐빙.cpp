#include <iostream> 

using namespace std;
char cub[12][9] = { {'0','0','0','o','o','o','0','0','0'},
					{'0','0','0','o','o','o','0','0','0'},
					{'0','0','0','o','o','o','0','0','0'},
					{'g','g','g','w','w','w','b','b','b'},
					{'g','g','g','w','w','w','b','b','b'},
					{'g','g','g','w','w','w','b','b','b'},
					{'0','0','0','r','r','r','0','0','0'},
					{'0','0','0','r','r','r','0','0','0'},
					{'0','0','0','r','r','r','0','0','0'},
					{'0','0','0','y','y','y','0','0','0'},
					{'0','0','0','y','y','y','0','0','0'},
					{'0','0','0','y','y','y','0','0','0'} };

char map[20][20];
char a[3][3];
void turn(char c) {
	char temp[3][3];/*
	cout << "  변환 전 " << endl;
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			cout << a[i][j] << " ";
		}
		cout << endl;
	}*/
	if (c == '+') {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				temp[j][2 - i] = a[i][j];
			}
		}
	}
	else {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				temp[2 - j][i] = a[i][j];
			}
		}

	}
	//cout << " 변환 후 " << endl;
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			a[i][j] = temp[i][j];
			//cout << a[i][j] << " ";
		}
		//cout << endl;
	}
}

void trans(char c, char d) {
	if (c == 'L') {
		if (d == '+') {
			for (int i = 17; i > 5; i--) {
				int j = 6;
				map[i][j] = map[i - 3][j];
			}

			for (int i = 5; i > 2; i--) {
				int j = 6;
				map[i][j] = map[i + 12][j];
			}

			for (int i = 6; i < 9; i++) {
				for (int j = 3; j < 6; j++) {
					a[i - 6][j - 3] = map[i][j];
				}
			}
			turn(d);

			for (int i = 6; i < 9; i++) {
				for (int j = 3; j < 6; j++) {
					map[i][j] = a[i - 6][j - 3];
				}
			}

		}
		if (d == '-') {

			for (int i = 0; i < 12; i++) {
				int j = 6;
				map[i][j] = map[i + 3][j];
			}
			for (int i = 12; i < 15; i++) {
				int j = 6;
				map[i][j] = map[i - 12][j];
			}

			for (int i = 6; i < 9; i++) {
				for (int j = 3; j < 6; j++) {
					a[i - 6][j - 3] = map[i][j];
				}
			}
			turn(d);

			for (int i = 6; i < 9; i++) {
				for (int j = 3; j < 6; j++) {
					map[i][j] = a[i - 6][j - 3];
				}
			}
		}
	}


	if (c == 'R') {
		if (d == '+') {

			for (int i = 0; i < 12; i++) {
				int j = 8;
				map[i][j] = map[i + 3][j];
			}
			for (int i = 12; i < 15; i++) {
				int j = 8;
				map[i][j] = map[i - 12][j];
			}

			for (int i = 6; i < 9; i++) {
				for (int j = 9; j < 12; j++) {
					a[i - 6][j - 9] = map[i][j];
				}
			}
			turn(d);

			for (int i = 6; i < 9; i++) {
				for (int j = 9; j < 12; j++) {
					map[i][j] = a[i - 6][j - 9];
				}
			}

		}
		else {

			for (int i = 17; i > 5; i--) {
				int j = 8;
				map[i][j] = map[i - 3][j];
			}
			for (int i = 5; i > 2; i--) {
				int j = 8;
				map[i][j] = map[i + 12][j];
			}

			for (int i = 6; i < 9; i++) {
				for (int j = 9; j < 12; j++) {
					a[i - 6][j - 9] = map[i][j];
				}
			}
			turn(d);

			for (int i = 6; i < 9; i++) {
				for (int j = 9; j < 12; j++) {
					map[i][j] = a[i - 6][j - 9];
				}
			}
		}
	}

	if (c == 'U') {
		if (d == '+') {
			char utp[8][8];
			for (int i = 5; i < 10; i++) {
				for (int j = 5; j < 10; j++) {
					if (i == 5 || j == 5 || i == 9 || j == 9) {

						utp[j - 5][9 - i] = map[i][j];
					}

				}
			}

			for (int i = 5; i < 10; i++) {
				for (int j = 5; j < 10; j++) {
					if (i == 5 || j == 5 || i == 9 || j == 9) {

						map[i][j] = utp[i-5][j - 5];

					}

				}
			}



			for (int i = 6; i < 9; i++) {
				for (int j = 6; j < 9; j++) {
					a[i - 6][j - 6] = map[i][j];
				}
			}
			turn(d);

			for (int i = 6; i < 9; i++) {
				for (int j = 6; j < 9; j++) {
					map[i][j] = a[i - 6][j - 6];
				}
			}
		}
		else {

			char utp[8][8];
			for (int i = 5; i < 10; i++) {
				for (int j = 5; j < 10; j++) {
					if (i == 5 || j == 5 || i == 9 || j == 9) {

						utp[9 - j][i-5] = map[i][j];
					}

				}
			}

			for (int i = 5; i < 10; i++) {
				for (int j = 5; j < 10; j++) {
					if (i == 5 || j == 5 || i == 9 || j == 9) {

						map[i][j] = utp[i - 5][j - 5];

					}

				}
			}



			for (int i = 6; i < 9; i++) {
				for (int j = 6; j < 9; j++) {
					a[i - 6][j - 6] = map[i][j];
				}
			}
			turn(d);

			for (int i = 6; i < 9; i++) {
				for (int j = 6; j < 9; j++) {
					map[i][j] = a[i - 6][j - 6];
				}
			}

		}

	}

	if (c == 'D') {
		if (d == '-') {
			char dtp[10][10];
			for (int i = 3; i < 12; i++) {
				for (int j = 3; j < 12; j++) {
					if (i == 3|| j == 3 || i == 11 || j == 11) {

						dtp[j- 3][11-i] = map[i][j];
					}

				}
			}
			for (int i = 3; i < 12; i++) {
				for (int j = 3; j < 12; j++) {
					if (i == 3 || j == 3 || i == 11 || j == 11) {

						map[i][j] = dtp[i - 3][j - 3];

					}

				}
			}



			for (int i = 12; i < 15; i++) {
				for (int j = 6; j < 9; j++) {
					a[i - 12][j - 6] = map[i][j];
				}
			}
			turn(d);

			for (int i = 12; i < 15; i++) {
				for (int j = 6; j < 9; j++) {
					map[i][j] = a[i - 12][j - 6];
				}
			}
		}
		else {

			char dtp[10][10];
			for (int i = 3; i < 12; i++) {
				for (int j = 3; j < 12; j++) {
					if (i == 3 || j == 3 || i == 11 || j == 11) {

						dtp[11 - j][i - 3] = map[i][j];
					}

				}
			}
			for (int i = 3; i < 12; i++) {
				for (int j = 3; j < 12; j++) {
					if (i == 3 || j == 3 || i == 11 || j == 11) {

						map[i][j] = dtp[i - 3][j - 3];

					}

				}
			}




			for (int i = 12; i < 15; i++) {
				for (int j = 6; j < 9; j++) {
					a[i - 12][j - 6] = map[i][j];
				}
			}
			turn(d);

			for (int i = 12; i < 15; i++) {
				for (int j = 6; j < 9; j++) {
					map[i][j] = a[i - 12][j - 6];
				}
			}

		}

	}

	if (c == 'F') {
		if (d == '+') {
			map[8][2] = map[12][6];
			map[8][1]= map[12][7];
			map[8][0] = map[12][8];
			for (int j = 14; j > 2; j--) {
				map[8][j] = map[8][j - 3];
			}
			map[12][6] = map[8][14];
			map[12][7] = map[8][13];
			map[12][8] = map[8][12];


			for (int i = 9; i < 12; i++) {
				for (int j = 6; j < 12; j++) {
					a[i - 9][j - 6] = map[i][j];
				}
			}
			turn(d);


			for (int i = 9; i < 12; i++) {
				for (int j = 6; j < 12; j++) {
					map[i][j] = a[i - 9][j - 6];
				}
			}

		}
		else {

			map[8][14] = map[12][6];
			map[8][13] = map[12][7];
			map[8][12] = map[12][8];
			for (int j = 0; j < 12; j++) {
				map[8][j] = map[8][j + 3];
			}
			map[12][6] = map[8][2];
			map[12][7] = map[8][1];
			map[12][8] = map[8][0];


			for (int i = 9; i < 12; i++) {
				for (int j = 6; j < 12; j++) {
					a[i - 9][j - 6] = map[i][j];
				}
			}
			turn(d);


			for (int i = 9; i < 12; i++) {
				for (int j = 6; j < 12; j++) {
					map[i][j] = a[i - 9][j - 6];
				}
			}

		}

	}

	if (c == 'B') {
		if (d == '-') {
			map[6][2] = map[14][6];
			map[6][1] = map[14][7];
			map[6][0] = map[14][8];
			for (int j = 14; j > 2; j--) {
				map[6][j] = map[6][j - 3];
			}
			map[14][6] = map[6][14];
			map[14][7] = map[6][13];
			map[14][8] = map[6][12];


			for (int i = 3; i < 6; i++) {
				for (int j = 6; j < 9; j++) {
					a[i - 3][j - 6] = map[i][j];
				}
			}
			turn(d);


			for (int i = 3; i < 6; i++) {
				for (int j = 6; j < 9; j++) {
					map[i][j] = a[i - 3][j - 6];
				}
			}
		}
		else {

			map[6][14] = map[14][6];
			map[6][13] = map[14][7];
			map[6][12] = map[14][8];
			for (int j = 0; j < 12; j++) {
				map[6][j] = map[6][j + 3];
			}
			map[14][6] = map[6][2];
			map[14][7] = map[6][1];
			map[14][8] = map[6][0];



			for (int i = 3; i < 6; i++) {
				for (int j = 6; j < 9; j++) {
					a[i - 3][j - 6] = map[i][j];
				}
			}
			turn(d);


			for (int i = 3; i < 6; i++) {
				for (int j = 6; j < 9; j++) {
					map[i][j] = a[i - 3][j - 6];
				}
			}

		}

	}
}
int main(void) {
	for (int i = 3; i < 15; i++) {
		for (int j = 3; j < 12; j++) {
			map[i][j] = cub[i - 3][j - 3];
		}
	}/*
	for (int i = 0; i < 20; i++) {
		for (int j = 0; j < 20; j++) {
			cout << map[i][j] << " ";
		}
		cout << endl;
	}*/
	int N;
	cin >> N;
	while (N--) {
		int num;
		cin >> num;

		for (int i = 3; i < 15; i++) {
			for (int j = 3; j < 12; j++) {
				map[i][j] = cub[i - 3][j - 3];
			}
		}
		while (num--) {

			char c1, c2;
			cin >> c1 >> c2;
			//cout << c1 << c2 << endl;
			trans(c1, c2);

			//cout << " 체크 " << endl;
			//for (int i = 3; i < 15; i++) {
			//	for (int j = 3; j < 12; j++) {
			//		cout << map[i][j] << " ";
			//	}
			//	cout << endl;
			//}
		}
		//cout << " 정답 " << endl;
		for (int i = 6; i < 9; i++) {
			for (int j = 6; j < 9; j++) {
				cout << map[i][j];
			}
			cout << endl;
		}
	}
}