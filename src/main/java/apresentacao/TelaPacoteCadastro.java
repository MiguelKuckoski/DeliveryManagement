package apresentacao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;

public class TelaPacoteCadastro extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPacoteCadastro frame = new TelaPacoteCadastro();
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
	public TelaPacoteCadastro() {
		setBounds(100, 100, 744, 530);
		getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 728, 500);
		getContentPane().add(desktopPane);

	}
}
