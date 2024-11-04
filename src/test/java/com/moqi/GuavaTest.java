package com.moqi;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.google.common.collect.ImmutableList;

class GuavaTest {

    @Test
    void testImmutableList() {
        List<String> list = ImmutableList.of("A", "B", "C");
        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        System.out.print("test ImmutableList finish");
    }
}