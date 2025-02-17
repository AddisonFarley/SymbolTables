//BST - Binary Search Tree
public class RedBlackBST<K extends Comparable<K>, V> implements SymbolTable<K, V>
{
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node
    {
        K key;
        V value;
        Node left;
        Node right;
        int nodesIntSubtree;
        boolean color;

        public Node(K key, V value)
        {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            nodesIntSubtree = 0;
            color = BLACK;
        }
    }


    public RedBlackBST ()
    {
        root = null;
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
        //start recursion
        root = put(root, k, val);
    }

    private Node put(Node current, K key, V val)
    {
        if (current == null)
        {
            Node theNewNode = new Node(key, val);

            theNewNode.nodesIntSubtree = 1;

            return theNewNode;
        }

        int cmp = key.compareTo(current.key);

        if (cmp < 0)
        {
            current.left = put(current.left, key, val);
        }
        else if (cmp > 0)
        {
            current.right = put(current.right, key, val);
        }
        else
        {
            current.value = val;
        }

        current.nodesIntSubtree = size(current.left) + size(current.right) + 1;

        return current;
    }

    /**
     * Returns the value paired with the given key.
     *
     * @param
     * @param keyToFind
     */
    @Override
    public V get(K keyToFind)
    {
        return get(root, keyToFind);
    }

    private V get(Node current, K keyToFind)
    {
        if (current == null)
        {
            return null;
        }

        int cmp = keyToFind.compareTo(current.key);

        if (cmp < 0)
        {
            return get(current.left, keyToFind);
        }
        else if (cmp > 0)
        {
            return get(current.right, keyToFind);
        }
        else
        {
            return current.value;
        }
    }

    /**
     * Returns the value paired with the given key.
     *
     * @param keyToFind
     */
    public V getIterative(K keyToFind)
    {
        Node current = root;

        while (current != null)
        {
            int cmp = keyToFind.compareTo(current.key);
            if (cmp < 0)
            {
                current = current.left;
            }
            else if (cmp > 0)
            {
                current = current.right;
            }
            else
            {
                return current.value;
            }
        }

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
        return size(root);
    }

    private int size(Node current)
    {
        if (current == null)
        {
            return 0;
        }
        else
        {
            return current.nodesIntSubtree;
        }
    }

    /**
     * Returns an iterator that refers to all the keys
     * in the table.
     */
    @Override
    public Iterable<K> keys()
    {
        Queue<K> q = new LinkedQueue<>();

        inorder(root, q);

        return q;
    }

    private void inorder(Node current, Queue<K> q)
    {
        if (current == null)
        {
            return;
        }

        inorder(current.left, q);
        q.enqueue(current.key);
        inorder(current.right, q);

    }

    private boolean isRed(Node current)
    {
        return false;
    }

    private Node rotateLeft(Node current)
    {
        return null;
    }

    private Node rotateRight(Node current)
    {
        return null;
    }

    private Node flipColors(Node current)
    {
        return null;
    }
}