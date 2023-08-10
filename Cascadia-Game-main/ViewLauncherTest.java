///// Project
package com.cascadia.demo;

import static org.junit.jupiter.api.Assertions.*;

import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ViewLauncherTest {

    private ViewLauncher viewLauncher;

    @BeforeEach
    public void setUp() throws Exception {
        viewLauncher = new ViewLauncher();
    }

    @Test
    public void testGetNumPlayer() {
        viewLauncher.setNum_Player(new TextField("2"));
        assertEquals(2, viewLauncher.getNum_Player());
    }

    @Test // to be failed as 5 is an invalid input
    public void testGetNumPlayerInvalidInput() {
        viewLauncher.setNum_Player(new TextField("5"));
        assertNull(viewLauncher.getNum_Player());
    }

}
