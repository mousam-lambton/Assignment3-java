package com.pagecounter;

import com.pagecounter.service.PageCounter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PageCounterTest {
    // Test the increment And GetPageCount methods
    @Test
    void incrementAndGetPageCount() {
        PageCounter counter = new PageCounter();
        assertEquals(0, counter.getPageCount());
        counter.increment();
        assertEquals(1, counter.getPageCount());
        counter.increment();
        assertEquals(2, counter.getPageCount());
    }
}