public class Solution {
    
    int k;
    int n;
    List<List<Integer>> lists;
    
    public List<List<Integer>> combinationSum3(int k, int n) {
          this.k = k;
          this.n = n;
          this.lists = new LinkedList<List<Integer>>();
          List<Integer> list = new ArrayList<Integer>();
          dfs(0, list, 0, 1);
          return lists;
    }
    
    void dfs(int count, List<Integer> list, int sum, int start) {
        if (count == k) {
            if (sum == n) {
                lists.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            dfs(count + 1, list, sum + i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
