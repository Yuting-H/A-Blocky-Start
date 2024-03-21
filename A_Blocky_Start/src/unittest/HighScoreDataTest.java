package unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mvc.HighScoreData;

class HighScoreDataTest {

	private HighScoreData highScoreData;

    @BeforeEach
    void setUp() {
        highScoreData = HighScoreData.importData();
    }

    @Test
    void testInitialization() {
    	HighScoreData highScoreData = new HighScoreData();
        for (int i = 0; i < 5; i++) {
            assertEquals("(empty)", highScoreData.getUsername(i));
            assertEquals(0, highScoreData.getHighScore(i));
        }
    }

    @Test
    void testImportData() {
       
        highScoreData = HighScoreData.importData();
        assertEquals("User1", highScoreData.getUsername(0)); 
        assertEquals(100, highScoreData.getHighScore(0));
    }

    @Test
    void testExportHighScore() {
        highScoreData.addNameScore("TestUser", 999);
        highScoreData.exportHighScore();

        HighScoreData importedData = HighScoreData.importData();
        assertEquals("TestUser", importedData.getUsername(4));
        assertEquals(999, importedData.getHighScore(4));
    }

    @Test
    void testGetUsername() {
        assertEquals("(empty)", highScoreData.getUsername(0));

    @Test
    void testGetHighScore() {
        assertEquals(0, highScoreData.getHighScore(0));
    }

    @Test
    void testAddNameScore() {
        assertTrue(highScoreData.addNameScore("NewUser", 500));
        assertEquals("NewUser", highScoreData.getUsername(0));
        assertEquals(500, highScoreData.getHighScore(0));
    }


    @Test
    void testIsIndexOutOfBound() {
        assertTrue(highScoreData.isIndexOutOfBound(5)); 
        assertFalse(highScoreData.isIndexOutOfBound(0));
    }


}
