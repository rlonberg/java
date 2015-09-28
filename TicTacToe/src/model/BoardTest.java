package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.Board.State;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	private Board testBoard;

	@Before
	public void setUp() throws Exception {
		testBoard = new Board();
	}

	@After
	public void tearDown() throws Exception {
		testBoard = null;
	}

	@Test
	public void testClear() {
		testBoard.clear();
		for (int row = 0; row < testBoard.NUMROWS; row++) {
			for (int col = 0; col < testBoard.NUMCOLUMNS; col++) {
				assertTrue(testBoard.getMark(row, col) == Mark.NONE);
			}
		}
	}

	@Test
	public void testSetAndGetMark() {
		int sampleRow = 1;
		int sampleCol = 1;
		testBoard.setMark(sampleRow, sampleCol, Mark.O);
		assertTrue(testBoard.getMark(sampleRow, sampleCol) == Mark.O);
		assertFalse(testBoard.setMark(sampleRow, sampleCol, Mark.X));
	}

	@Test
	public void testGetState() {
		assertTrue(testBoard.getState() == State.NEW);
	}

	@Test
	public void testIsPlayable() {
		assertTrue(testBoard.isPlayable());
	}

	@Test
	public void testIsEmpty() {
		int sampleRow = 1;
		int sampleCol = 1;
		assertTrue(testBoard.isEmpty(sampleRow, sampleCol));
		testBoard.setMark(sampleRow, sampleCol, Mark.X);
		assertFalse(testBoard.isEmpty(sampleRow, sampleCol));
	}

	@Test
	public void testIsDraw() {
		assertFalse(testBoard.isDraw());
	}

	@Test
	public void testUpdateWinTracker() {
		Player testPlayer = new Player(testBoard, Mark.X);
		testPlayer.move(0, 0);
		assertTrue(testBoard.updateWinTracker(testPlayer, 0, 0) == 1);
		testPlayer.move(1, 1);
		assertFalse(testBoard.updateWinTracker(testPlayer, 1, 1) == 0);
		assertTrue(testBoard.updateWinTracker(testPlayer, 2, 1) == 0);

	}

	@Test
	public void testIsWinFor() {
		Player testPlayer = new Player(testBoard, Mark.X);
		testPlayer.move(0, 0);
		testPlayer.move(1, 0);
		testPlayer.move(2, 0);
		assertTrue(testBoard.isWinFor(testPlayer)); // test horizontal type one
													// win
		testBoard.clear();
		testPlayer.move(0, 1);
		testPlayer.move(1, 1);
		testPlayer.move(2, 1);
		assertTrue(testBoard.isWinFor(testPlayer)); // test horizontal type two
													// win

		testBoard.clear();
		testPlayer.move(0, 2);
		testPlayer.move(1, 2);
		testPlayer.move(2, 2);
		assertTrue(testBoard.isWinFor(testPlayer)); // test horizontal type
													// three win
		testBoard.clear();
		testPlayer.move(0, 0);
		testPlayer.move(0, 1);
		testPlayer.move(0, 2);
		assertTrue(testBoard.isWinFor(testPlayer)); // test vertical type one
													// win

		testBoard.clear();
		testPlayer.move(1, 0);
		testPlayer.move(1, 1);
		testPlayer.move(1, 2);
		assertTrue(testBoard.isWinFor(testPlayer)); // test vertical type two
													// win

		testBoard.clear();
		testPlayer.move(2, 0);
		testPlayer.move(2, 1);
		testPlayer.move(2, 2);
		assertTrue(testBoard.isWinFor(testPlayer)); // test vertical type three
													// win

		testBoard.clear();
		testPlayer.move(0, 0);
		testPlayer.move(1, 1);
		testPlayer.move(2, 2);
		assertTrue(testBoard.isWinFor(testPlayer)); // test diagonal (left to
													// right) win
		testBoard.clear();
		testPlayer.move(0, 2);
		testPlayer.move(1, 1);
		testPlayer.move(2, 0);
		assertTrue(testBoard.isWinFor(testPlayer)); // test diagonal (right to
													// left) win
		testBoard.clear();

	}

}
