public class SequentialSearchST<Key, Value>
        implements SymbolTable<Key, Value>
{
    private int size;
    private Node head;
    
    private class Node
    {
        Key key;
        Value value;
        Node next;
    
        public Node(Key key, Value value, Node next)
        {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    
    public SequentialSearchST()
    {
        head = null;
        size = 0;
    }
    
    /**
     * Put a key-value pair into the table. If key is found in list, update the value. If no key is
     * found, create a new head node and attach to front of list.
     *
     * @param key
     * @param val
     */
    @Override
    public void put(Key key, Value val)
    {
        //if key is not in list, put it up front
        //if key in list, update value
        
        //helper node
        Node curr = head;
        
        //search for key
        while (curr != null)
        {
            if (key.equals(curr.key))
            {
                curr.value = val;
                return;
            }
            
            curr = curr.next;
        }
        
        //key not found, create new head
        head = new Node(key, val, head);
        
        //increment size
        size++;
    }
    
    /**
     * Returns the value paired with the given key.
     *
     * @param key
     */
    @Override
    public Value get(Key key)
    {
        return null;
    }
    
    /**
     * Returns the number of key-value pairs in the table.
     *
     * @return
     */
    @Override
    public int size()
    {
        return size;
    }
    
    /**
     * Returns an iterator that refers to all the keys
     * in the table.
     */
    @Override
    public Iterable<Key> keys()
    {
        return null;
    }
}
