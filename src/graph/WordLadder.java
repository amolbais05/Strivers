package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> st = new HashSet<>();

        for (String word : wordList)
        {
            st.add(word);
        }
        st.remove(beginWord);

        while (!q.isEmpty())
        {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if (word.equals(endWord))
            {
                return steps;
            }

            for (int i = 0; i < word.length(); i++)
            {
                for (char ch = 'a'; ch <= 'z'; ch++)
                {
                    char[] replaceCharArray = word.toCharArray();
                    replaceCharArray[i] = ch;
                    String replaceWord = new String(replaceCharArray);

                    if (st.contains(replaceWord))
                    {
                        st.remove(replaceWord);
                        q.add(new Pair(replaceWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}


class Pair
{
    String first;
    int second;

    public Pair(String first, int second)
    {
        this.first = first;
        this.second = second;
    }
}
