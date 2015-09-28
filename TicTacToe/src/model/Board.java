package model;

import java.util.Arrays;

public class Board {
	public static enum State {
		NEW, PLAYING, WIN, DRAW;
	}

	private Mark[][] board;
	private State state;

	/**
	 * used to identify number of rows on board
	 */
	final static int NUMROWS = 3;

	/**
	 * used to identify number of columns on board
	 */
	final static int NUMCOLUMNS = 3;

	/**
	 * Constructor — create the 2D array for board, then initialize the board
	 * with nine Mark.NONE values. Initialize the state to be State.NEW
	 */
	public Board() {
		this.board = new Mark[NUMROWS][NUMCOLUMNS];
		for (int row = 0; row < NUMROWS; row++) {
			for (int col = 0; col < NUMCOLUMNS; col++) {
				this.board[row][col] = Mark.NONE;
			}
		}
		this.state = State.NEW;

	}

	/**
	 * clear the board (i.e., set all spaces to Mark.NONE)
	 */
	public void clear() {
		for (int row = 0; row < NUMROWS; row++) {
			for (int col = 0; col < NUMCOLUMNS; col++) {
				this.board[row][col] = Mark.NONE;
			}
		}
		this.state = State.NEW;
	}

	/**
	 * set the space at [row][col] to the specified Mark mark. Only allow it if
	 * the board is NEW or PLAYING, and the square desired is empty. If the play
	 * could be made, return true, otherwise, return false. This is going to be
	 * the critical method for a player to make a mark on the board.
	 * 
	 * @param row
	 * @param col
	 * @param mark
	 * @return boolean
	 */
	public boolean setMark(int row, int col, Mark mark) {
		if ((this.state == State.NEW || this.state == State.PLAYING)
				&& (this.getMark(row, col) == Mark.NONE)) {
			this.board[row][col] = mark;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * get the mark at [row][col]
	 * 
	 * @param row
	 * @param col
	 * @return Mark
	 */
	public Mark getMark(int row, int col) {
		return this.board[row][col];
	}

	/**
	 * get the current board state
	 * 
	 * @return current state, State
	 */
	public State getState() {
		return this.state;
	}

	/**
	 * Return a String to represent the object (i.e., the board, with marks, and
	 * the board state). VERY useful for debugging while you are waiting to
	 * start the GUI!
	 */
	@Override
	public String toString() {
		return "Board [board=" + Arrays.toString(board) + ", state=" + state
				+ "]";
	}

	/**
	 * Boolean method that returns true if the board state is not a WIN or DRAW
	 */
	public boolean isPlayable() {
		return !(this.state == State.WIN || this.state == State.DRAW);
	}

	/**
	 * Is the specified square on our board empty?
	 * 
	 * @param row
	 * @param col
	 * @return boolean - is it empty
	 */
	public boolean isEmpty(int row, int col) {
		return this.board[row][col] == Mark.NONE;
	}

	/**
	 * Is the state a draw
	 * 
	 * @return boolean
	 */
	public boolean isDraw() {
		for (int row = 0; row < NUMROWS; row++) {
			for (int col = 0; col < NUMCOLUMNS; col++) {
				if (this.board[row][col] == Mark.NONE) {
					return false;
				}
			}
		}
		this.state = State.DRAW;
		return true;
	}

	/**
	 * Check to see if the current board is a win for the player specified
	 * 
	 * @param player
	 * @return boolean - true if the current board is a winning board for
	 *         player, false otherwise.
	 */
	public boolean isWinFor(Player player) {
		int verticalWin = 0;
		int horizontalWin = 0;
		int diagonalWinLR = 0;
		int diagonalWinRL = 0;

		for (int row = 0; row < NUMROWS; row++) {
			horizontalWin = 0;
			verticalWin = 0;
			for (int col = 0; col < NUMCOLUMNS; col++) {
				horizontalWin += this.updateWinTracker(player, row, col);
				verticalWin += this.updateWinTracker(player, col, row);
				if (col == row && row == 1) { // center square?
					diagonalWinLR += this.updateWinTracker(player, row, col);
					diagonalWinRL += this.updateWinTracker(player, row, col);
				} else if (col == row) {
					diagonalWinLR += this.updateWinTracker(player, row, col);
				} else if (Math.abs(col - row) == 2) {
					diagonalWinRL += this.updateWinTracker(player, row, col);
				}
			}
			if (horizontalWin == NUMROWS || verticalWin == NUMROWS
					|| diagonalWinLR == NUMROWS || diagonalWinRL == NUMROWS) {
				this.state = State.WIN;
				return true; // is a horizontal/vertical/diagonal win for player
			}

		}

		return false;

	}

	/**
	 * Used to track if the current square contains specified player's mark
	 * 
	 * @param player
	 * @param row
	 * @param col
	 * @return int - 1 or 0 depending on if the search is true or false
	 */
	public int updateWinTracker(Player player, int row, int col) {
		if (player.getTheBoard().getMark(row, col) == player.getMyMark()) {
			return 1;
		} else
			;
		return 0;
	}

}
