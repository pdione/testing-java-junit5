package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test Proper View name is returned for index")
    @Test
    void index() {
        assertEquals("index",controller.index());
        assertEquals("index", controller.index(), "wrong view Returned");
        assertEquals("index", controller.index(), ()-> "Another expensive message "+
                "Make me only if you have to");
    }

    @Test
    @DisplayName("Test Exception")
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.oopsHandler();
        });
    }

    @Disabled
    @Test
    void testTimeout(){
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got here");
        });
    }

    // Running in a separeted thread.
    @Disabled
    @Test
    void testTimeoutPreemptively(){
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got here 64646465465");
        });
    }

    @Disabled
    @Test
    void testAssumptionTrue(){
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionIsTrue(){
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }
}