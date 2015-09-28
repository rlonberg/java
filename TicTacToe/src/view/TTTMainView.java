package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class TTTMainView extends JFrame {

	/**
	 * instance of TTTBoardPanel to add to BorderLayout.Center
	 */
	private TTTBoardPanel viewBoardPanel;

	/**
	 * instance of TTTStatsPanel to add to BorderLayout.Center
	 */
	private TTTStatsPanel viewStatsPanel;

	public TTTMainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tic Tac Toe");
		setLocationRelativeTo(null);
		getRootPane().setBorder(new EmptyBorder(5, 5, 5, 5));
		this.viewBoardPanel = new TTTBoardPanel();
		this.add(viewBoardPanel, BorderLayout.CENTER);
		this.viewStatsPanel = new TTTStatsPanel();
		this.add(viewStatsPanel, BorderLayout.WEST);
		this.pack();
	}

	/**
	 * @return the viewBoardPanel
	 */
	public TTTBoardPanel getViewBoardPanel() {
		return viewBoardPanel;
	}

	/**
	 * @return the viewStatsPanel
	 */
	public TTTStatsPanel getViewStatsPanel() {
		return viewStatsPanel;
	}

	/**
	 * clear the JButtons on the board
	 */
	public void clearBoard() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				this.viewBoardPanel.getAllButtons()[row][col].setText("");
				// btn = new JButton();
				// btn.setPreferredSize(new Dimension(75, 75));
				// this.add(btn);
				// allButtons[row][col] = btn;
			}
		}
	}

}