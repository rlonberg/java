package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import model.Mark;
import model.Player;

public class TTTStatsPanel extends JPanel {

	/**
	 * string representing next player
	 */
	private String nextPlayerUp;

	/**
	 * number wins for X player
	 */
	private Integer xWins;

	/**
	 * number of wins for O player
	 */
	private Integer oWins;

	/**
	 * number of draws that have occurred in game
	 */
	private Integer numDraws;

	/**
	 * button representing xWins
	 */
	private JLabel xWinsScore;

	/**
	 * button representing oWins
	 */
	private JLabel oWinsScore;

	/**
	 * button representing numDraws
	 */
	private JLabel drawsScore;

	/**
	 * button representing next player
	 */
	private JLabel nextPlayer;

	public TTTStatsPanel() {
		xWins = 0;
		oWins = 0;
		numDraws = 0;
		nextPlayerUp = "X";
		this.setLayout(new GridLayout(0, 1, 5, 5));
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

		JLabel next = new JLabel("NEXT");
		next.setHorizontalAlignment(SwingConstants.CENTER);
		next.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
		this.nextPlayer = new JLabel(nextPlayerUp);
		nextPlayer.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel xWinsTitle = new JLabel("X Wins");
		xWinsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		this.xWinsScore = new JLabel(xWins.toString());
		xWinsScore.setHorizontalAlignment(SwingConstants.CENTER);
		xWinsScore.setBorder(new LineBorder(Color.BLACK));

		JLabel oWinsTitle = new JLabel("O Wins");
		oWinsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		this.oWinsScore = new JLabel(oWins.toString());
		oWinsScore.setHorizontalAlignment(SwingConstants.CENTER);
		oWinsScore.setBorder(new LineBorder(Color.BLACK));

		JLabel drawsTitle = new JLabel("Draws");
		drawsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		this.drawsScore = new JLabel(numDraws.toString());
		drawsScore.setHorizontalAlignment(SwingConstants.CENTER);
		drawsScore.setBorder(new LineBorder(Color.BLACK));

		this.add(next);
		this.add(nextPlayer);
		this.add(new JSeparator());
		this.add(xWinsTitle);
		this.add(xWinsScore);
		this.add(new JSeparator());
		this.add(oWinsTitle);
		this.add(oWinsScore);
		this.add(new JSeparator());
		this.add(drawsTitle);
		this.add(drawsScore);

	}

	/**
	 * update the stats panel on the left with a win for the designated player
	 * 
	 * @param player
	 */
	public void updateStatsPanelWin(Player player) {
		if (player.getMyMark() == Mark.O) {
			this.oWins++;
			this.oWinsScore.setText(oWins.toString());
		} else if (player.getMyMark() == Mark.X) {
			this.xWins++;
			this.xWinsScore.setText(xWins.toString());
		}
	}

	/**
	 * update the stats panel on the left with a draw for the game just played
	 */
	public void updateStatsPanelDraw() {
		this.numDraws++;
		this.drawsScore.setText(numDraws.toString());
	}

	/**
	 * update the stats panel on the left with a draw
	 */
	public void updateStatsPanelNextPlayer() {
		if (this.nextPlayerUp == "X") {
			this.nextPlayerUp = "O";
			this.nextPlayer.setText(this.nextPlayerUp);
		} else {
			this.nextPlayerUp = "X";
			this.nextPlayer.setText(this.nextPlayerUp);
		}
	}

}
