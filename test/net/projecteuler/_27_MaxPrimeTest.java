package net.projecteuler;

import net.projecteuler.problems._27_MaxPrimeFormula;
import org.junit.Assert;
import org.junit.Test;

public class _27_MaxPrimeTest {

    @Test public void primesGeneratedTest() {
        Assert.assertEquals(39, _27_MaxPrimeFormula.primesGenerated(1, 41));
        Assert.assertEquals(79, _27_MaxPrimeFormula.primesGenerated(-79, 1601));
    }
}
