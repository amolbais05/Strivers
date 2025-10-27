package strings;

public class NumberOfBeams
{
    private int numberOfBeams(String[] bank)
    {
        int result = 0;
        int prevDeviceCount = 0;
        for (String row : bank)
        {
            int currDeviceCount = 0;
            for (char c : row.toCharArray())
            {
                if (c == '1')
                {
                    currDeviceCount++;
                }
            }
            result += prevDeviceCount * currDeviceCount;
            prevDeviceCount = (currDeviceCount == 0) ? prevDeviceCount : currDeviceCount;
        }
        return result;
    }
    // TC : O(n)
    // SC : O(1)
}
