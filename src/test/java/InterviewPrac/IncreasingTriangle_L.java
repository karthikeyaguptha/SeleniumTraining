package InterviewPrac;

import org.testng.annotations.Test;

public class IncreasingTriangle_L {

    @Test
    public void decreasingTriangle()
    {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
