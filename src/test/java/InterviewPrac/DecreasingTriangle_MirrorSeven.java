package InterviewPrac;

import org.testng.annotations.Test;

public class DecreasingTriangle_MirrorSeven {


    @Test
    public void decreasingTriangle()
    {
        int n=5;
        for (int i = 0; i <=n; i++) {
            for (int j = i; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
