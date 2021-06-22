#include<iostream>
#include<vector>

using namespace std;

int main() {

	int m, n;	//m即投入放入钱数，n即投入的项目数
	int k, x;
	int xk, Tp = 0;	//xk代表给第k个项目投入的钱数  0<=tmp<=j;temp代表一次循环中的钱数
	cout << "投入放入钱数、投入的项目数：";
	cin >> m >> n;
	vector<vector<int>> f(n, vector<int>(m + 1));	//f[i][x], 0<i<=n,0<=x<=m,第i个项目投入x万元钱时的收益
	vector<vector<int>> F(n, vector<int>(m + 1));	//F[i][x]，将x万元钱投入到前i个项目的最大的收益
	
	for (k = 0; k < n; ++k) {
		f[k][0] = 0;	//每个项目投入0元时，收益为0元
	}
	for (k = 0; k < n; ++k) {
		for (x = 1; x < m + 1; ++x) {
			cin >> f[k][x];
		}
	}
	
	for (x = 0; x < m + 1; ++x) {
		F[0][x] = f[0][x];	//第一个项目上投入0-m万元钱的最大收益等于f[0][0-m]
	}
	for (k = 1; k < n; ++k) {				
		for (x = 0; x < m + 1; ++x) {		
			for (xk = 0; xk <= x; ++xk) {
				Tp = F[k - 1][x - xk] + f[k][xk];
				if (Tp > F[k][x])
					F[k][x] = Tp;
			}
		}
	}
	cout << "最大收益：" << F[n - 1][m] << endl;
}