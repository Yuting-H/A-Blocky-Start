package unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import mvc.ActionBlockData;

import mvc.ActionEnum;

/**
 * Unit test for ActionBlockData.
 * @version March 12, 2024
 * @since March 12, 2024
 * @author Chun Ho Chan (Edward)
 */
class ActionBlockDataTest {

	@Test
	void ConstructEmpty() {
		ActionEnum type = ActionEnum.Unknown;
		ArrayList<Integer> args = new ArrayList<Integer>();
		assertAll(() -> new ActionBlockData(type, args));
	}
	
	@Test
	void ConstructStart() {
		ActionEnum type = ActionEnum.Start;
		ArrayList<Integer> args = new ArrayList<Integer>();
		assertAll(() -> new ActionBlockData(type, args));
	}
	
	@Test
	void ConstructGoto() {
		ActionEnum type = ActionEnum.Goto;
		ArrayList<Integer> args = new ArrayList<Integer>();
		args.add(10); // Line to jump)
		assertAll(() -> new ActionBlockData(type, args));
	}
	
	@Test
	void ConstructLoop() {
		ActionEnum type = ActionEnum.Loop;
		ArrayList<Integer> args = new ArrayList<Integer>();
		args.add(5);  // End point
		args.add(3);  // Start point
		args.add(10); // Line to jump
		assertAll(() -> new ActionBlockData(type, args));
	}
	
	@Test
	void ImportEmpty() {
		String data = "";
		assertAll(() -> ActionBlockData.importData(data));
	}
	
	@Test
	void ImportStart() {
		String data = "Start";
		assertAll(() -> ActionBlockData.importData(data));
	}
	
	@Test
	void ImportGoto() {
		String data = "Goto_10";
		assertAll(() -> ActionBlockData.importData(data));
	}
	
	@Test
	void ImportLoop() {
		String data = "Loop_5_3_10";
		assertAll(() -> ActionBlockData.importData(data));
	}
	
	@Test
	void ImportWrongGotoWeirdArguments() {
		String data = "Goto__IO";
		assertAll(() -> ActionBlockData.importData(data));
	}
	
	@Test
	void ExportEmpty() {
		String data = "";
		ActionBlockData block = ActionBlockData.importData(data);
		assertEquals(block.exportData(), "Unknown");
	}
	
	@Test
	void ExportStart() {
		String data = "Start";
		ActionBlockData block = ActionBlockData.importData(data);
		assertEquals(block.exportData(), data);
	}
	
	@Test
	void ExportGoto() {
		String data = "Goto_10";
		ActionBlockData block = ActionBlockData.importData(data);
		assertEquals(block.exportData(), data);
	}
	
	@Test
	void ExportLoop() {
		String data = "Loop_5_3_10";
		ActionBlockData block = ActionBlockData.importData(data);
		assertEquals(block.exportData(), data);
	}
	
	@Test
	void ExportWrongGotoWeirdArguments() {
		String data = "Goto__IO";
		ActionBlockData block = ActionBlockData.importData(data);
		assertEquals(block.exportData(), "Unknown");
	}
	
	@Test
	void ExportWrongLoopTooFewArguments() {
		String data = "Loop_1_2";
		ActionBlockData block = ActionBlockData.importData(data);
		assertEquals(block.exportData(), "Unknown");
	}
	
	@Test
	void ExportWrongLoopTooManyArguments() {
		String data = "Loop_1_2_3_4";
		ActionBlockData block = ActionBlockData.importData(data);
		assertEquals(block.exportData(), "Unknown");
	}
	
	@Test
	void GetTypeLoop() {
		String data = "Loop_5_3_10";
		ActionBlockData block = ActionBlockData.importData(data);
		assertEquals(block.getType(), ActionEnum.Loop);
	}
	
	@Test
	void GetArgsEmpty() {
		String data = "";
		ActionBlockData block = ActionBlockData.importData(data);
		ArrayList<Integer> list = new ArrayList<Integer>();
		assertEquals(block.getArgs(), list);
	}
	
	@Test
	void GetArgsStart() {
		String data = "Start";
		ActionBlockData block = ActionBlockData.importData(data);
		ArrayList<Integer> list = new ArrayList<Integer>();
		assertEquals(block.getArgs(), list);
	}
	
	@Test
	void GetArgsGoto() {
		String data = "Goto_10";
		ActionBlockData block = ActionBlockData.importData(data);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		assertEquals(block.getArgs(), list);
	}
	
	@Test
	void GetArgsLoop() {
		String data = "Loop_5_3_10";
		ActionBlockData block = ActionBlockData.importData(data);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(3);
		list.add(10);
		assertEquals(block.getArgs(), list);
	}
	
	@Test
	void GetArgsGotoWrongArguments() {
		String data = "Goto__IO";
		ActionBlockData block = ActionBlockData.importData(data);
		ArrayList<Integer> list = new ArrayList<Integer>();
		assertEquals(block.getArgs(), list);
	}
	
	@Test
	void GetEndPointEmpty() {
		String data = "";
		ActionBlockData block = ActionBlockData.importData(data);
		assertEquals(block.getEndPoint(), -1);
	}
	
	@Test
	void GetEndPointLoop() {
		String data = "Loop_5_3_10";
		ActionBlockData block = ActionBlockData.importData(data);
		assertEquals(block.getEndPoint(), 5);
	}
	
	@Test
	void GetStartPointEmpty() {
		String data = "";
		ActionBlockData block = ActionBlockData.importData(data);
		assertEquals(block.getStartPoint(), -1);
	}
	
	@Test
	void GetStartPointLoop() {
		String data = "Loop_5_3_10";
		ActionBlockData block = ActionBlockData.importData(data);
		assertEquals(block.getStartPoint(), 3);
	}
	
	@Test
	void GetJumpLineEmpty() {
		String data = "";
		ActionBlockData block = ActionBlockData.importData(data);
		assertEquals(block.getJumpLine(), -1);
	}
	
	@Test
	void GetJumpLineGoto() {
		String data = "Goto_10";
		ActionBlockData block = ActionBlockData.importData(data);
		assertEquals(block.getJumpLine(), 10);
	}
	
	@Test
	void GetJumpLineLoop() {
		String data = "Loop_5_3_10";
		ActionBlockData block = ActionBlockData.importData(data);
		assertEquals(block.getJumpLine(), 10);
	}
	
	@Test
	void GetCounterEmpty() {
		String data = "";
		ActionBlockData block = ActionBlockData.importData(data);
		assertEquals(block.getCounter(), -1);
	}
	
	@Test
	void GetCounterLoop() {
		String data = "Loop_5_3_10";
		ActionBlockData block = ActionBlockData.importData(data);
		assertEquals(block.getCounter(), 5 - 3);
	}
	
	@Test
	void DecCounterEmpty() {
		String data = "";
		ActionBlockData block = ActionBlockData.importData(data);
		int oldCounter = block.getCounter();
		block.decCounter();
		assertEquals(block.getCounter(), oldCounter);
	}
	
	@Test
	void DecCounterLoop() {
		String data = "Loop_5_3_10";
		ActionBlockData block = ActionBlockData.importData(data);
		int oldCounter = block.getCounter();
		block.decCounter();
		assertEquals(block.getCounter(), oldCounter - 1);
	}
	
	@Test
	void ResetCounterEmpty() {
		String data = "";
		ActionBlockData block = ActionBlockData.importData(data);
		int oldCounter = block.getCounter();
		block.decCounter();
		block.resetCounter();
		assertEquals(block.getCounter(), oldCounter);
	}
	
	@Test
	void ResetCounterLoop() {
		String data = "Loop_5_3_10";
		ActionBlockData block = ActionBlockData.importData(data);
		int oldCounter = block.getCounter();
		block.decCounter();
		block.resetCounter();
		assertEquals(block.getCounter(), oldCounter);
	}

}
