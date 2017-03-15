public class Solution {
    public int hIndex(int[] citations) {
        
        int N = citations.length;
        int[] hash = new int[N + 1];
        for (int i = 0; i < N; i++) {
            if (citations[i] >= N) {
                hash[N]++;
            } else {
                hash[citations[i]]++;
            }
        }
        
        int count = 0;
        for (int i = N; i >= 0; i--) {
            count += hash[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}
