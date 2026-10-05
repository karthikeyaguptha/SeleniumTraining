package InterviewPrac;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CharFreqUsingHashMap {


    @Test
    public void evenCharFreq()
    {
        String str ="sdkjhfkjsdhfjsdhkjasjdfhsjk";
        char[] letters = str.toLowerCase().trim().toCharArray();
        Map<Character,Integer> freqMap = new HashMap<>();
        for (char ch : letters)
        {
          freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
        }
        System.out.print(freqMap);

        for (Map.Entry<Character,Integer> entry : freqMap.entrySet())
        {
            if (entry.getValue() % 2 == 0)
            {
                System.out.println(entry.getKey() + ":"+entry.getValue());
            }
        }

    }


}
