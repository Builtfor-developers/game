//Project
package com.gameView;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class wildlife_TokensTest {

    @Test
    public void testCreateWildlife_Tokens() {
        wildlife_Tokens token = new wildlife_Tokens(wildlife_Tokens.wildlife_Type.Hawk);
        assertNotNull(token.getType());
        assertEquals(token.getType(), wildlife_Tokens.wildlife_Type.Hawk);
    }

    @Test
    public void testSetType() {
        wildlife_Tokens token = new wildlife_Tokens(wildlife_Tokens.wildlife_Type.Hawk);
        token.setType(wildlife_Tokens.wildlife_Type.Fox);
        assertNotNull(token.getType());
        assertEquals(token.getType(), wildlife_Tokens.wildlife_Type.Fox);
    }

    @Test
    public void testGetType() {
        wildlife_Tokens token = new wildlife_Tokens(wildlife_Tokens.wildlife_Type.Bear);
        assertNotNull(token.getType());
        assertEquals(token.getType(), wildlife_Tokens.wildlife_Type.Bear);
    }

    @Test
    public void testDragToken() {
        // Test dragging a token to an invalid location and checking whether it goes back to it's original position
        wildlife_Tokens hawkToken = new wildlife_Tokens(wildlife_Tokens.wildlife_Type.Hawk);
        hawkToken.setLayoutX(0);
        hawkToken.setLayoutY(0);
        wildlife_Tokens.dragToken(hawkToken);
        hawkToken.getOnMousePressed().handle(null);
        hawkToken.getOnMouseDragged().handle(new javafx.scene.input.MouseEvent(javafx.scene.input.MouseEvent.MOUSE_DRAGGED, 100, 100, 0, 0, null, 0, false, false, false, false, true, false, false, false, false, false, null));
        hawkToken.getOnMouseReleased().handle(null);
        assertEquals(hawkToken.getLayoutX(), 0);
        assertEquals(hawkToken.getLayoutY(), 0);
    }

}
