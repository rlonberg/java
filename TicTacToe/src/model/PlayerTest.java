package model;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	private Player testPlayer;
	private Board testBoard;

	@Before
	public void setUp() throws Exception {
		testBoard = new Board();
		testPlayer = new Player(testBoard, Mark.X);
	}

	@After
	public void tearDown() throws Exception {
		testPlayer = null;
		testBoard.clear();
	}

	@Test
	public void testMove() {
		int sampleRow = 1;
		int sampleCol = 1;
		testPlayer.move(sampleRow, sampleCol);
		assertTrue(testBoard.getMark(sampleRow, sampleCol) == Mark.X);

	}

}
