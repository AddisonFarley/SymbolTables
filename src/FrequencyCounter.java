import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Refer to p. 372 of the Algorithms book
 */
public class FrequencyCounter
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File("text-files/leipzig1M.txt"));

        SymbolTable<String, Integer> table = new SeparateChainingHashST<>(500000);

        while (in.hasNext())
        {
            String word = in.next();

            //check if word is in table
            if (!table.contains(word))
            {
                table.put(word, 1);
            }
            else
            {
                //word is in table - update value
                int count = table.get(word);

                //increment count
                count++;

                table.put(word, count);
            }
        }

        //print table
        for (String word : table.keys())
        {
            System.out.println(word + " : " + table.get(word));
        }
    }

    public static void alternate() throws FileNotFoundException
    {
        Scanner in = new Scanner(new File("leipzig1M.txt"));

        Map<String, Integer> table = new HashMap<>();

        while (in.hasNext())
        {
            String word = in.next();

            //check if word in table
            if (!table.containsKey(word))
            {
                table.put(word, 1);
            }
            else
            {
                //word is in table - update value
                int count = table.get(word);

                //increment count
                count++;

                table.put(word, count);
            }
        }

        //print table
        for (String word : table.keySet())
        {
            System.out.println(word + " : " + table.get(word));
        }
    }
}
