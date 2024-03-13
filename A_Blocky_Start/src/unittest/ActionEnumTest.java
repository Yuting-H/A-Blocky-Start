package unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mvc.ActionEnum;

/**
 * Unit test for ActionEnum.
 * @version March 12, 2024
 * @since March 12, 2024
 * @author Chun Ho Chan (Edward)
 */
class ActionEnumTest {
	
	@Test
	void StartToEnum() {
		String action = "Start";
		assertEquals(ActionEnum.fromString(action), ActionEnum.Start);
	}
	
	@Test
	void EndToEnum() {
		String action = "End";
		assertEquals(ActionEnum.fromString(action), ActionEnum.End);
	}
	
	@Test
	void ForwardToEnum() {
		String action = "Forward";
		assertEquals(ActionEnum.fromString(action), ActionEnum.Forward);
	}
	
	@Test
	void BackToEnum() {
		String action = "Back";
		assertEquals(ActionEnum.fromString(action), ActionEnum.Back);
	}
	
	@Test
	void LeftToEnum() {
		String action = "Left";
		assertEquals(ActionEnum.fromString(action), ActionEnum.Left);
	}
	
	@Test
	void RightToEnum() {
		String action = "Right";
		assertEquals(ActionEnum.fromString(action), ActionEnum.Right);
	}
	
	@Test
	void GotoToEnum() {
		String action = "Goto";
		assertEquals(ActionEnum.fromString(action), ActionEnum.Goto);
	}
	
	@Test
	void LoopToEnum() {
		String action = "Loop";
		assertEquals(ActionEnum.fromString(action), ActionEnum.Loop);
	}
	
	@Test
	void UnknownToEnum() {
		String action = "Unknown";
		assertEquals(ActionEnum.fromString(action), ActionEnum.Unknown);
	}
	
	@Test
	void ErrorToEnum() {
		String action = "Error";
		assertEquals(ActionEnum.fromString(action), ActionEnum.Unknown);
	}
	
	@Test
	void StartToString() {
		ActionEnum action = ActionEnum.Start;
		assertEquals(action.toString(), "Start");
	}
	
	@Test
	void UnknownToString() {
		ActionEnum action = ActionEnum.Unknown;
		assertEquals(action.toString(), "Unknown");
	}

}
