//TC : O(exponential / N*2^N)
//SC : O(N)
class Solution {
    List <List<String>> result = new ArrayList();
    public List<List<String>> partition(String s) {
        if(s==null||s.length()==0) return result;
        helper(s,0,new ArrayList<>());
        return result;
    }

    private void helper(String s,int index,List<String> path)
    {
        //base
        if(index == s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i=index;i<s.length();i++)
        {
            if(isPalindrome(s,index,i))
            {
                path.add(s.substring(index,i+1));
                helper(s,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s,int l,int r)
    {
        while(r>=l)
        {
            if(s.charAt(l)!=s.charAt(r)) return false;

            r--;
            l++;
        }
        return true;
    }
}