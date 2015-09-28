package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class TTTBoardPanel extends JPanel {

	private JButton[][] allButtons;

	public TTTBoardPanel() {
		this.setLayout(new GridLayout(3, 3, 5, 5));
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

		this.allButtons = new JButton[3][3];
		JButton btn;
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				btn = new JButton();
				btn.setPreferredSize(new Dimension(75, 75));
				this.add(btn);
				allButtons[row][col] = btn;
			}
		}

	}

	/**
	 * @return JButton[][] - button array on tic tac toe grid
	 */
	public JButton[][] getAllButtons() {
		return this.allButtons;
	}

}
