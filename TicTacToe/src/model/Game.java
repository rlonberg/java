package model;

import java.util.Scanner;

public class Game {

	/**
	 * The board that will be used for this game
	 */
	private Board theBoard;

	/**
	 * An array of two players, initialized to an X player, and an O player,
	 * both using the same instance of theBoard.
	 */
	private Player players[];

	/**
	 * An integer representing which player's turn it is.
	 */
	private int currentPlayer;

	/**
	 * @param theBoard
	 * @param players
	 * @param currentPlayer
	 */
	public Game() {
		this.theBoard = new Board();
		this.players = new Player[2];
		this.players[0] = new Player(this.theBoard, Mark.X);
		this.players[1] = new Player(this.theBoard, Mark.O);
		this.currentPlayer = 0;
	}

	/**
	 * @return the players
	 */
	public Player[] getPlayers() {
		return players;
	}

	/**
	 * @return the currentPlayer
	 */
	public int getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * @return String - representing the mark of the current player
	 */
	public String getCurrentPlayerMark() {
		return this.players[this.currentPlayer].getMyMark().getRepresentation();
	}

	/**
	 * This is a test method that is designed to test out the game
	 * functionality. In a loop, it does the following: 1) print the board 2)
	 * print the current player 3) ask for a position on the board to play 4)
	 * make the move. If it was invalid, then go back to the previous step. 5)
	 * Is the board still playable? Then change the player, and go back to the
	 * top. Otherwise, print who won, or whether the game was a draw. A static
	 * main method later in the class instantiates a Game instance, then calls
	 * this playGame method
	 */

	public void playGame() {
		Scanner in;
		int userRowChoice;
		int userColChoice;
		while (true) {
			printBoard();
			System.out.println("Current player is " + this.currentPlayer);
			System.out.println();
			System.out
					.print("What space would the current player like to move to? Enter a row then a space then a column (\"1 2\" for example) : ");
			in = new Scanner(System.in);
			userRowChoice = in.nextInt();
			userColChoice = in.nextInt();

			if (!this.theBoard.setMark(userRowChoice, userColChoice,
					this.players[this.currentPlayer].getMyMark())) {
				System.out
						.println("Illegal move, reprinting the board, try again.");
			} else {
				if (this.theBoard.isWinFor(this.players[this.currentPlayer])) {
					this.printBoard();
					System.out
							.println("Player " + this.currentPlayer + " won!");
					break;
				} else if (this.theBoard.isDraw()) {
					this.printBoard();
					System.out.println("Draw!");
					break;
				} else {
					this.currentPlayer = Math.abs(1 - this.currentPlayer);
					System.out.println("New turn..");
					System.out
							.println("______________________________________");
				}
			}

		}
		in.close();

	}

	/**
	 * @param currentPlayer
	 *            the currentPlayer to set
	 */
	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	/**
	 * Prints the game board
	 */
	public void printBoard() {
		System.out.println("BOARD");
		for (int row = 0; row < this.theBoard.NUMROWS; row++) {
			for (int col = 0; col < this.theBoard.NUMCOLUMNS; col++) {
				System.out.print(this.theBoard.getMark(row, col)
						.getRepresentation());
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * @return the theBoard
	 */
	public Board getTheBoard() {
		return theBoard;
	}

	public static void main(String[] args) {
		Game newGame = new Game();
		newGame.playGame();
	}
}
