package unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mvc.ActionTypeEnum;

/**
 * Unit test for ActionEnum.
 * @version 1.0
 * @since March 12, 2024
 * @author Chun Ho Chan (Edward)
 */
class ActionTypeEnumTest {
	
	@Test
	void StartToEnum() {
		String action = "Start";
		assertEquals(ActionTypeEnum.fromString(action), ActionTypeEnum.Start);
	}
	
	@Test
	void EndToEnum() {
		String action = "End";
		assertEquals(ActionTypeEnum.fromString(action), ActionTypeEnum.End);
	}
	
	@Test
	void ForwardToEnum() {
		String action = "Forward";
		assertEquals(ActionTypeEnum.fromString(action), ActionTypeEnum.Forward);
	}
	
	@Test
	void BackToEnum() {
		String action = "Back";
		assertEquals(ActionTypeEnum.fromString(action), ActionTypeEnum.Back);
	}
	
	@Test
	void LeftToEnum() {
		String action = "Left";
		assertEquals(ActionTypeEnum.fromString(action), ActionTypeEnum.Left);
	}
	
	@Test
	void RightToEnum() {
		String action = "Right";
		assertEquals(ActionTypeEnum.fromString(action), ActionTypeEnum.Right);
	}
	
	@Test
	void GotoToEnum() {
		String action = "Goto";
		assertEquals(ActionTypeEnum.fromString(action), ActionTypeEnum.Goto);
	}
	
	@Test
	void LoopToEnum() {
		String action = "Loop";
		assertEquals(ActionTypeEnum.fromString(action), ActionTypeEnum.Loop);
	}
	
	@Test
	void UnknownToEnum() {
		String action = "Unknown";
		assertEquals(ActionTypeEnum.fromString(action), ActionTypeEnum.Unknown);
	}
	
	@Test
	void ErrorToEnum() {
		String action = "Error";
		assertEquals(ActionTypeEnum.fromString(action), ActionTypeEnum.Unknown);
	}
	
	@Test
	void StartToString() {
		ActionTypeEnum action = ActionTypeEnum.Start;
		assertEquals(action.toString(), "Start");
	}
	
	@Test
	void UnknownToString() {
		ActionTypeEnum action = ActionTypeEnum.Unknown;
		assertEquals(action.toString(), "Unknown");
	}

}
