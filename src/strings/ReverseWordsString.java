package strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ReverseWordsString
{
    public String reverseWords(String s) {

        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();

        for(int i = words.length - 1; i >= 0; i--)
        {
            if (!words[i].isEmpty())
            {
                res.append(words[i].trim()).append(" ");
            }
        }
        return res.toString().trim();
    }

    public String reverseWordsStream(String s)
    {
        return Arrays.stream(s.trim().split("\\s+"))
            .filter(word -> !word.isEmpty())
            .collect(Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                Collections.reverse(list);
                return String.join(" ", list);
                }));
    }

}
