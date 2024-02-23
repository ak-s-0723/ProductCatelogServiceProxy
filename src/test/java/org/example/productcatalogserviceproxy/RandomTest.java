package org.example.productcatalogserviceproxy;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomTest {

    @Test
    public void testRandomNumber() {
        Random random = new Random();
        int n = random.nextInt(10);
        assert(n<5);
    }
}
