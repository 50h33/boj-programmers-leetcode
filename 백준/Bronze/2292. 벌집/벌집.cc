#include <bits/stdc++.h>
using namespace std;
int n, cnt, x = 2;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n;
    for (int i = 1; x <= n; i++) {
        x += 6 * i;
        cnt = i;
    }
    cout << cnt + 1 << "\n";
}