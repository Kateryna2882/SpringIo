package com.example.springio.exeptionTests;
import com.example.springio.exeption.OrderNotFoundException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderNotFoundExceptionTest {

    @Test
    public void testConstructor() {
        OrderNotFoundException exception = new OrderNotFoundException();
        assertNotNull(exception);
    }

    @Test
    public void testInheritance() {
        OrderNotFoundException exception = new OrderNotFoundException();
        assertTrue(exception instanceof RuntimeException);
    }
}
