import java.util.*; 

class TrieNode
{
    HashMap<Character,TrieNode> map;
    boolean isEnd;
    int freq;
    TrieNode()
    {
        map = new HashMap<>();
        isEnd = false;
        freq = 0;
    }
}

public class solution 
{
    TrieNode root = new TrieNode();
    public int[] solve(String[][] A) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i<A.length; i++)
        {
            if(A[i][0].equals("insert") && search(A[i][1]) == 0)
            {
               insert(A[i][1]);
            }
            if(A[i][0].equals("search"))
            {
                ans.add(search(A[i][1]));
            }
            if(A[i][0].equals("prefixSearch"))
            {
                ans.add(prefixSearch(A[i][1]));
            }
            if(A[i][0].equals("prefixSearchCount"))
            {
                ans.add(prefixSearchCount(A[i][1]));
            }
        }
        int[] intArray = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) 
        {
            intArray[i] = ans.get(i);
        }
        return intArray;
    }

    void insert(String word)
    {
        TrieNode curr = root;
        for(int i = 0; i<word.length(); i++)
        {
            char ch = word.charAt(i);
            if(!curr.map.containsKey(ch))
            {
                curr.map.put(ch,new TrieNode());
            }
            curr = curr.map.get(ch);
            curr.freq++;
        }
        curr.isEnd = true;
    }

    int prefixSearch(String word)
    {
        TrieNode curr = root;
        for(int i = 0; i<word.length(); i++)
        {
            char ch = word.charAt(i);
            if(!curr.map.containsKey(ch))
            {
                return 0;
            }
            curr = curr.map.get(ch);
        }
        return 1;
    } 

    int search(String word)
    {
        TrieNode curr = root;
        for(int i = 0; i<word.length(); i++)
        {
            char ch = word.charAt(i);
            if(!curr.map.containsKey(ch))
            {
                return 0;
            }
            curr = curr.map.get(ch);
        }
        return curr.isEnd?1:0;   
    }

    int prefixSearchCount(String word)
    {
        TrieNode curr = root;
        for(int i = 0; i<word.length(); i++)
        {
            char ch = word.charAt(i);
            if(!curr.map.containsKey(ch))
            {
                return 0;
            }
            curr = curr.map.get(ch);
        }
        return curr.freq;   
    }
}


