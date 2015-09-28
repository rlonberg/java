package model;

public class Player {

	/**
	 * a reference to the actual board that the player is playing on
	 */
	private Board theBoard;
	/**
	 * the mark that the player always plays with (will always be either Mark.X
	 * or Mark.O)
	 */
	private Mark myMark;

	/**
	 * Takes two parameters to initialize the instance variables defined above
	 * 
	 * @param theBoard
	 * @param myMark
	 */
	public Player(Board theBoard, Mark myMark) {
		this.theBoard = theBoard;
		this.myMark = myMark;
	}

	/**
	 * called when a player makes a move at a specified row, col position on
	 * theBoard
	 * 
	 * @param row
	 * @param col
	 * @return boolean
	 */
	public boolean move(int row, int col) {
		return this.theBoard.setMark(row, col, this.myMark);
	}

	/**
	 * @return the theBoard
	 */
	public Board getTheBoard() {
		return theBoard;
	}

	/**
	 * @return the myMark
	 */
	public Mark getMyMark() {
		return myMark;
	}

	@Override
	public String toString() {
		return "Player " + myMark;
	}

}
