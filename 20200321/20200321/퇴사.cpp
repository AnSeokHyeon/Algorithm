#include <iostream>

using namespace std;

struct inf {
	int d;
	int t;
	int p;
	inf() {
		this->d = 0;
		this->t = 0;
		this->p = 0;
	}
};

inf day[15];

int N;
void money(int d) {
	if (d ==N+1) { 
		cout << "Επ»η" << endl;
		return; 
	} 
	for (int i = d + 1; i < N + 1; i++) {
		
	}

}

int main(void) {
	cin >> N;
	for (int i = 0; i < N; i++) {
		day[i].d = i+1;
		cin >> day[i].t;
		cin >> day[i].p;
	}
	for (int i = 1; i <= N; i++) {
		money(i);
	}
}