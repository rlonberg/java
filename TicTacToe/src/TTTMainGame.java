import java.awt.EventQueue;

import model.Game;
import view.TTTMainView;
import controller.TTTController;

public class TTTMainGame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TTTMainView frame = new TTTMainView();
					TTTController control = new TTTController(new Game(), frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
