#include <iostream>

using namespace std;

struct info {
	int x;
	int y;
	int n;
	info() {
		this->x = 0;
		this->y = 0;
		this->n = 0;
	}
	info(int x, int y, int  n) {
		this->x = x;
		this->y = y;
		this->n = n;
	}

};

info person[50];
int N;
int main(void) {
	cin >> N;
	for (int i = 0; i < N; i++) {
		int a, b;
		cin >> a >> b;
		person[i].x = a;
		person[i].y = b;
		person[i].n = 1;
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (i == j) continue;
			if (person[i].x < person[j].x && person[i].y < person[j].y)	person[i].n++;
		}
	}
	for (int i = 0; i < N; i++) {
		cout << person[i].n << " ";
	}
}