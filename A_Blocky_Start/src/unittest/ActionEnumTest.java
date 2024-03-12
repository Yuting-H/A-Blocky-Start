package unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mvc.ActionEnum;

/**
 * Unit test for ActionEnum.
 * @version March 12, 2024
 * @author Chun Ho Chan (Edward)
 */
class ActionEnumTest {

	@Test
	void LoopToEnum() {
		String action = "Loop";
		assertEquals(ActionEnum.fromString(action), ActionEnum.Loop);
	}

}
