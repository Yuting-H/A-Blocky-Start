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
        // Assuming a method to reset or initialize the CSV file to a known state might be needed here
    }

    @Test
    void testInitialization() {
        for (int i = 0; i < 5; i++) {
            assertEquals("(empty)", highScoreData.getUsername(i));
            assertEquals(0, highScoreData.getHighScore(i));
        }
    }

    @Test
    void testImportData() {
       
        highScoreData = HighScoreData.importData();
        // Assert based on expected content of your CSV
        assertEquals("User1", highScoreData.getUsername(0)); // Example assertion
        assertEquals(100, highScoreData.getHighScore(0)); // Example assertion
    }

    @Test
    void testExportHighScore() {
        // Set some data to export
        highScoreData.addNameScore("TestUser", 999);
        highScoreData.exportHighScore();

        // You would then either manually check the CSV, or re-import and check the data programmatically
        HighScoreData importedData = HighScoreData.importData();
        assertEquals("TestUser", importedData.getUsername(4));
        assertEquals(999, importedData.getHighScore(4));
    }

    @Test
    void testGetUsername() {
        // Testing beyond initial state assumes either importing data or manually setting up state
        assertEquals("(empty)", highScoreData.getUsername(0)); // Initial state test
    }

    @Test
    void testGetHighScore() {
        assertEquals(0, highScoreData.getHighScore(0)); // Initial state test
    }

    @Test
    void testAddNameScore() {
        assertTrue(highScoreData.addNameScore("NewUser", 500));
        assertEquals("NewUser", highScoreData.getUsername(0));
        assertEquals(500, highScoreData.getHighScore(0));
    }


    @Test
    void testIsIndexOutOfBound() {
        assertTrue(highScoreData.isIndexOutOfBound(5)); // Out of bounds
        assertFalse(highScoreData.isIndexOutOfBound(0)); // Within bounds
    }


}
