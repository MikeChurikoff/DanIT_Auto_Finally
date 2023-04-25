package homework.parallelismus;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ParallelClass2 {
    @Test(groups = "smile")
    public void parallel6() throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(true);
    }
    @Test(groups = "smile")
    public void parallel7() throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(true);
    }
    @Test(groups = "smile")
    public void parallel8() throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(true);
    }
    @Test(groups = "smile")
    public void parallel9() throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(true);
    }
    @Test(dependsOnGroups = "smile")
    public void parallel10() throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(true);
    }
}
