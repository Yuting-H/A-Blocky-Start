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
		assertNotNull(settings, "Settings should not be null after importing them.");
		
		 assertEquals(1280, settings.getScreenHeight(), "Incorrect screen height.");
		 assertEquals(720, settings.getScreenWidth(), "Incorrect screen width.");
		 assertTrue(settings.getColourblindMode(), "Colourblind mode should be enabled.");
		 assertEquals(25, settings.getVolumeLevel(), "Incorrect volume level.");
		
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
	    assertNotNull(modifiedSettings, "Settings should not be null after re-import.");
	    assertEquals(settings.getScreenHeight(), modifiedSettings.getScreenHeight(), "Screen height did not update correctly.");
	    assertEquals(settings.getScreenWidth(), modifiedSettings.getScreenWidth(), "Screen width did not update correctly.");
	    assertEquals(settings.getColourblindMode(), modifiedSettings.getColourblindMode(), "Colourblind mode did not update correctly.");
	    assertEquals(settings.getVolumeLevel(), modifiedSettings.getVolumeLevel(), "Volume level did not update correctly.");
	    
	    modifiedSettings.setScreenHeight(settings.getScreenHeight() - 100);
	    modifiedSettings.setScreenWidth(settings.getScreenWidth() - 100);
	    modifiedSettings.setColourblindMode(!settings.getColourblindMode());
	    modifiedSettings.setVolumeLevel(settings.getVolumeLevel() - 10);
	    
	    modifiedSettings.exportSettings();
	}
	
	@Test
	void testSetGetScreenHeight() {
        int expectedHeight = 1280;
        settings.setScreenHeight(expectedHeight);
        int actualHeight = settings.getScreenHeight();
        assertEquals(expectedHeight, actualHeight, "The screen height should be set and retrieved correctly.");
    }

    @Test
    void testSetGetScreenWidth() {
        int expectedWidth = 720;
        settings.setScreenWidth(expectedWidth);
        int actualWidth = settings.getScreenWidth();
        assertEquals(expectedWidth, actualWidth, "The screen width should be set and retrieved correctly.");
    }

    @Test
    void testSetGetColourblindMode() {
        boolean expectedMode = true;
        settings.setColourblindMode(expectedMode);
        boolean actualMode = settings.getColourblindMode();
        assertEquals(expectedMode, actualMode, "The colourblind mode should be set and retrieved correctly.");
    }

    @Test
    void testSetGetVolumeLevel() {
        int expectedVolume = 25;
        settings.setVolumeLevel(expectedVolume);
        int actualVolume = settings.getVolumeLevel();
        assertEquals(expectedVolume, actualVolume, "The volume level should be set and retrieved correctly.");
    }
	
}
