public class SeparateChainingHashST<K,V> implements SymbolTable<K,V>
{
    //private fields
    //array of linked lists
    private SequentialSearchST<K, V>[] table;
    private int tableSize; //size of the entire array
    private int size; //number of keys in table
    
    public SeparateChainingHashST(int tableSize)
    {
        this.tableSize = tableSize;
        this.size = 0;
    
        //creates an array where each element is initialized to null
        table = new SequentialSearchST[tableSize];
    
        //loop through array and replace null with an empty linked list
        for (int i = 0; i < tableSize; i++)
        {
            table[i] = new SequentialSearchST<>();
        }
    }
    
    public SeparateChainingHashST()
    {
        //call other constructor
        this(997);
    }
    
    //private helper method - the hash function
    private int hash(K key)
    {
        //take a key and generate an index number
        return (key.hashCode() & 0x7fffffff) % tableSize;
    }
    
    /**
     * Put a key-value pair into the table
     *
     * @param k
     * @param val
     */
    @Override
    public void put(K k, V val)
    {
        //increment size if key is not already in table
        if (!table[hash(k)].contains(k))
        {
            size++;
        }
        table[hash(k)].put(k, val);
    }
    
    /**
     * Returns the value paired with the given key.
     *
     * @param k
     */
    @Override
    public V get(K k)
    {
        return table[hash(k)].get(k);
    }
    
    /**
     * Returns the number of key-value pairs in the table.
     *
     * @return
     */
    @Override
    public int size()
    {
        return 0;
    }
    
    /**
     * Returns an iterator that refers to all the keys
     * in the table.
     */
    @Override
    public Iterable<K> keys()
    {
        //create an empty queue as a collector/container
        Queue<K> q = new LinkedQueue<>();
        
        //loop through the table and collect keys
        for (int i = 0; i < tableSize; i++)
        {
            for (K singleKey:table[i].keys())
            {
                q.enqueue(singleKey);
            }
        }
        
        return q;
    }
}
