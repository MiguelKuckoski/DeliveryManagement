package apresentacao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class TelaRotaCriar extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRotaCriar frame = new TelaRotaCriar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaRotaCriar() {
		setClosable(true);
		setBounds(100, 100, 744, 530);


	}

}
