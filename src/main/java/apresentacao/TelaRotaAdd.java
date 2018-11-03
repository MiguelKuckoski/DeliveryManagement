package apresentacao;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class TelaRotaAdd extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRotaAdd frame = new TelaRotaAdd();
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
	public TelaRotaAdd() {
		initialize();
	}

	private void initialize() {
		setTitle("ROTA - ADICIONAR");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 744, 530);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Ve\u00EDculo ");
		lblNewLabel.setBounds(10, 11, 64, 23);
		getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("Ve\u00EDculo ");
		label.setBounds(10, 34, 64, 23);
		getContentPane().add(label);
	}

	public void setUndecorated(boolean b) {
		// TODO Auto-generated method stub

	}
}
