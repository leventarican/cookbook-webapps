package com.github.leventarican;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Testing: unit, integration, ...
 */
public class AppTest {
	
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    
    @Test
    public void testMockito() {
        // mock creation
        List<String> mockedList = Mockito.mock(List.class);

        // using mock object - it does not throw any "unexpected interaction" exception
        mockedList.add("one");
        mockedList.clear();

        // selective, explicit, highly readable verification
        Mockito.verify(mockedList).add("one");
        Mockito.verify(mockedList).clear();
    }
}
