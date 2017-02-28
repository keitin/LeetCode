public class Solution {

    int[][] adj;
    int[] indegrees;
    boolean[] isConfirm;
    
    public String alienOrder(String[] words) {
        
        this.adj = new int[26][26];
        this.indegrees = new int[26];
        this.isConfirm = new boolean[26];
        Arrays.fill(indegrees, -1);
        
        int N = words.length;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                indegrees[words[i].charAt(j) - 'a'] = 0;
            }
        }
        
        for (int i = 1; i < N; i++) {
            String prevStr = words[i - 1];
            String currStr = words[i];
            
            int preId = 0;
            int curId = 0;
            
            while (preId < prevStr.length() && curId < currStr.length()) {
                if (prevStr.charAt(preId) == currStr.charAt(curId)) {
                    preId++;
                    curId++;
                    continue;
                }
                if (adj[prevStr.charAt(curId) - 'a'][currStr.charAt(preId) - 'a'] > 0) {
                    break;
                }
                adj[prevStr.charAt(curId) - 'a'][currStr.charAt(preId) - 'a'] = 1;
                indegrees[currStr.charAt(preId) - 'a']++;
                break;
            }
        }
        
        StringBuffer sb = new StringBuffer();
        for (char c : topologicalSort()) {
            sb.append(c);
        }
        
        if (invalid()) {
            return "";
        }
        
        return sb.toString();
    }
    
    boolean invalid() {
        for (int i = 0; i < 26; i++) {
            if (indegrees[i] > 0) {
                return true;
            }
        }
        return false;
    }
    
    LinkedList<Character> topologicalSort() {
        LinkedList<Character> res = new LinkedList<Character>();
        for (int i = 0; i < 26; i++) {
            if (indegrees[i] == 0 && !isConfirm[i]) {
                LinkedList<Character> list = bfs((char)(i + 'a'));
                for (char c : list) {
                    res.add(c);
                }
            }
        }
        return res;
    }
    
    LinkedList<Character> bfs(char c) {
        LinkedList<Character> list = new LinkedList<Character>();
        Queue<Character> q = new LinkedList<Character>();
        isConfirm[c - 'a'] = true;
        q.add(c);
        
        while (!q.isEmpty()) {
            
            char currChar = q.poll();
            list.add(currChar);
            
            for (char nextChar : getLinkedChas(currChar)) {
                
                indegrees[nextChar - 'a']--;
                if (!isConfirm[nextChar - 'a'] && indegrees[nextChar - 'a'] == 0) {
                    isConfirm[nextChar - 'a'] = true;
                    q.add(nextChar);
                }
                
            }
        }
        return list;
    }
    
    LinkedList<Character> getLinkedChas(char c) {
        LinkedList<Character> list = new LinkedList<Character>();
        for (int i = 0; i < 26; i++) {
            if (adj[c-'a'][i] > 0) {
                list.add((char)(i + 'a'));
            }
        }
        return list;
    }

}
