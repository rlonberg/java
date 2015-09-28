package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game testGame;

	@Before
	public void setUp() throws Exception {
		testGame = new Game();
	}

	@After
	public void tearDown() throws Exception {
		testGame = null;
	}

	@Test
	public void testPrintBoard() {
		testGame.printBoard();
	}

	// @Test - UNABLE TO JUNIT TEST WHILE LOOP
	// public void testPlayGame() {
	// testGame.playGame();
	// }

}
