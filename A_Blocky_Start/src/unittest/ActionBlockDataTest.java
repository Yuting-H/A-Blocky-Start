package unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import mvc.ActionBlockData;

import mvc.ActionEnum;

/**
 * Unit test for ActionBlockData.
 * @version March 12, 2024
 * @author Chun Ho Chan (Edward)
 */
class ActionBlockDataTest {

	@Test
	void ConstructorWithParams() {
		ActionEnum type = ActionEnum.Start;
		ArrayList<Integer> args = new ArrayList<Integer>();
		assertAll(ActionBlockData(type, args));
	}

}
