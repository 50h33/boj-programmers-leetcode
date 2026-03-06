#include <bits/stdc++.h>
using namespace std;
int n, k, a[50004], l, odd, ans;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n >> k;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    
    for (int r = 0; r < n; r++) {
        if (a[r] % 2 == 1) odd++;

        while (odd > k) {
            if (a[l] % 2 == 1) odd--;
            l++;
        }

        ans = max(ans, r - l - odd + 1);
    }

    cout << ans << "\n";
}