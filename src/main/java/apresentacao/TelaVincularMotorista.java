package apresentacao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controle.ControladorPrincipal;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TelaVincularMotorista extends JInternalFrame {
	private static ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();
	private JTextField textPlaca;
	private JTextField textCnh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVincularMotorista frame = new TelaVincularMotorista();
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
	public TelaVincularMotorista() {
		setClosable(true);
		setTitle("Vincular Motorista");
		setIconifiable(true);
		setBounds(100, 100, 744, 530);
		getContentPane().setLayout(null);
		
		JDesktopPane desktop = new JDesktopPane();
		desktop.setBounds(0, 0, 728, 500);
		getContentPane().add(desktop);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setForeground(Color.WHITE);
		lblPlaca.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPlaca.setBounds(93, 151, 55, 16);
		desktop.add(lblPlaca);
		
		JLabel lblCnh = new JLabel("CNH");
		lblCnh.setForeground(Color.WHITE);
		lblCnh.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCnh.setBounds(93, 212, 55, 16);
		desktop.add(lblCnh);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(169, 146, 432, 28);
		desktop.add(textPlaca);
		textPlaca.setColumns(10);
		
		textCnh = new JTextField();
		textCnh.setBounds(169, 207, 432, 28);
		desktop.add(textCnh);
		textCnh.setColumns(10);
		
		JButton btnVincular = new JButton("");
		btnVincular.setIcon(new ImageIcon(TelaVincularMotorista.class.getResource("/apresentacao/icones/adicionar.png")));
		btnVincular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(getTextPlaca()!= null && getTextCnh()!= null) {
					String placaVeiculo = getTextPlaca().getText();
					String cnhMotorista = getTextCnh().getText();
					JOptionPane.showMessageDialog(null,
							controladorPrincipal.getControleVeiculo().vincularMotorista(placaVeiculo, cnhMotorista));
				}			
			}
		});
		btnVincular.setToolTipText("Vincular");
		btnVincular.setBounds(286, 387, 64, 58);
		desktop.add(btnVincular);
		
		JButton btnDesvincular = new JButton("");
		btnDesvincular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String placaVeiculo = getTextPlaca().getText();
				String resultado = controladorPrincipal.getControleVeiculo().desvincularMotorista(placaVeiculo);
				JOptionPane.showMessageDialog(null, resultado);
			}
		});
		btnDesvincular.setIcon(new ImageIcon(TelaVincularMotorista.class.getResource("/apresentacao/icones/delete.png")));
		btnDesvincular.setToolTipText("Desvincular");
		btnDesvincular.setBounds(381, 387, 64, 58);
		desktop.add(btnDesvincular);

	}

	public JTextField getTextPlaca() {
		return textPlaca;
	}

	public void setTextPlaca(JTextField textPlaca) {
		this.textPlaca = textPlaca;
	}

	public JTextField getTextCnh() {
		return textCnh;
	}

	public void setTextCnh(JTextField textCnh) {
		this.textCnh = textCnh;
	}
}
