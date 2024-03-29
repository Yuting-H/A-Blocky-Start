package unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import mvc.SettingsData;

/**
 * Unit test for SettingsData.
 * @version 1.0
 * @since March 12, 2024
 * @author Simon Mccabe
 */
class SettingsDataTest {
	
	private SettingsData settings;
	
	@BeforeEach
    void setUp() {
        //new SettingsData();
		// Initialize or reset settings before each test
        settings = SettingsData.importData();
    }

	@Test
	void testImportData() {
		SettingsData settings = SettingsData.importData();
		assertNotNull(settings);
		
		 assertEquals(1280, settings.getScreenHeight());
		 assertEquals(720, settings.getScreenWidth());
		 assertTrue(settings.getColourblindMode());
		 assertEquals(25, settings.getVolumeLevel());
		
	}
	
	@Test
	void testExportAndReImportSettings() {
		//SettingsData settings = SettingsData.importData();
	    // Modify settings
	    settings.setScreenHeight(settings.getScreenHeight() + 100);
	    settings.setScreenWidth(settings.getScreenWidth() + 100);
	    settings.setColourblindMode(!settings.getColourblindMode());
	    settings.setVolumeLevel(settings.getVolumeLevel() + 10);
	    
	    // Export modified settings
	    settings.exportSettings();

	    // Re-import to verify changes
	    SettingsData modifiedSettings = SettingsData.importData();
	    assertNotNull(modifiedSettings);
	    assertEquals(settings.getScreenHeight(), modifiedSettings.getScreenHeight());
	    assertEquals(settings.getScreenWidth(), modifiedSettings.getScreenWidth());
	    assertEquals(settings.getColourblindMode(), modifiedSettings.getColourblindMode());
	    assertEquals(settings.getVolumeLevel(), modifiedSettings.getVolumeLevel());
	    
	    modifiedSettings.setScreenHeight(settings.getScreenHeight() - 100);
	    modifiedSettings.setScreenWidth(settings.getScreenWidth() - 100);
	    modifiedSettings.setColourblindMode(!settings.getColourblindMode());
	    modifiedSettings.setVolumeLevel(settings.getVolumeLevel() - 10);
	    
	    modifiedSettings.exportSettings();
	}
	
	@Test
	void testGetScreenHeight() {
        int expectedHeight = 1280;
        int actualHeight = settings.getScreenHeight();
        assertEquals(expectedHeight, actualHeight);
    }
	
	@Test
	void testSetScreenHeight() {
        int expectedHeight = 1400;
        settings.setScreenHeight(expectedHeight);
        int actualHeight = settings.getScreenHeight();
        assertEquals(expectedHeight, actualHeight);
    }
	
	@Test
	void testNegativeSetScreenHeight() {
        int expectedHeight = 1280;
        int tryNegativeHeight = -1400;
        settings.setScreenHeight(tryNegativeHeight);
        int actualHeight = settings.getScreenHeight();
        assertEquals(expectedHeight, actualHeight);
    }
	
	
	@Test
    void testGetScreenWidth() {
        int expectedWidth = 720;
        int actualWidth = settings.getScreenWidth();
        assertEquals(expectedWidth, actualWidth);
    }
	
    @Test
    void testSetScreenWidth() {
        int expectedWidth = 800;
        settings.setScreenWidth(expectedWidth);
        int actualWidth = settings.getScreenWidth();
        assertEquals(expectedWidth, actualWidth);
    }
    
    @Test
    void testNegativeSetScreenWidth() {
        int expectedWidth = 720;
        int tryNegativeWidth = -800;
        settings.setScreenWidth(tryNegativeWidth);
        int actualWidth = settings.getScreenWidth();
        assertEquals(expectedWidth, actualWidth);
    }

    @Test
    void testGetColourblindMode() {
        boolean expectedMode = true;
        boolean actualMode = settings.getColourblindMode();
        assertEquals(expectedMode, actualMode);
    }
    
    @Test
    void testSetColourblindMode() {
        boolean expectedMode = false;
        settings.setColourblindMode(expectedMode);
        boolean actualMode = settings.getColourblindMode();
        assertEquals(expectedMode, actualMode);
    }

    @Test
    void testGetVolumeLevel() {
        int expectedVolume = 25;
        int actualVolume = settings.getVolumeLevel();
        assertEquals(expectedVolume, actualVolume);
    }
    
    @Test
    void testSetVolumeLevel() {
        int expectedVolume = 75;
        settings.setVolumeLevel(expectedVolume);
        int actualVolume = settings.getVolumeLevel();
        assertEquals(expectedVolume, actualVolume);
    }
    
    @Test
    void testNegativeSetVolumeLevel() {
    	int expectedVolume = 25;
        int tryNegativeVolume = -85;
        settings.setVolumeLevel(tryNegativeVolume);
        int actualVolume = settings.getVolumeLevel();
        assertEquals(expectedVolume, actualVolume);
    }
	
}
