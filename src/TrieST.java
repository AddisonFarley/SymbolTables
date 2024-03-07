public class TrieST
{
    //key type is String
    //value type is generic V
    
    private class Node
    {
        public int val;
        public Node[] next; //array of children
        
        public Node()
        {
            next = new Node[256];
        }
    }
    
    private Node root;
    
    public TrieST()
    {
        root = new Node();
    }
    
    public void put(String key, int val)
    {
        root = put(root, key, val, 0);
    }
    
    //recursive helper method
    private Node put(Node curr, String key, int val, int depth)
    {
        //create new node if none exists
        if (curr == null)
        {
            curr = new Node();
        }
        
        //base case - if key found, update val
        if (depth == key.length())
        {
            curr.val = val;
            return curr;
        }
        
        //if not found at this level, go to next level (depth + 1)
        char c = key.charAt(depth); //get index of the subtree
        curr.next[c] = put(curr.next[c], key, val, depth + 1);
        
        return curr;
    }
    
    public int get(String key)
    {
        Node curr = get(root, key, 0);
        
        if (curr == null)
        {
            
            return -1;
        }
        else
        {
            return curr.val;
        }
    }
    
    private Node get(Node curr, String key, int depth)
    {
        //base case
        if (curr == null)
        {
            return null;
        }
        
        //found
        if (depth == key.length())
        {
            return curr;
        }
        
        char c = key.charAt(depth);
        
        return get(curr.next[c], key, depth + 1);
    }
}
