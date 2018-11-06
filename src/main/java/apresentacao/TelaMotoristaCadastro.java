package apresentacao;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class TelaMotoristaCadastro extends JInternalFrame {
	private JTextField txtClicPesquisar;
	private JTextField txtNome;
	private JTextField txtDataNasc;
	private JTextField txtCnh;
	private JTextField txtTipoCnh;
	private JTextField txtEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaMotoristaCadastro() {
		setTitle("Motorista");
		setClosable(true);
		setBounds(100, 100, 744, 530);
		getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 753, 506);
		getContentPane().add(desktopPane);
		
		txtClicPesquisar = new JTextField();
		txtClicPesquisar.setBounds(144, 60, 417, 28);
		desktopPane.add(txtClicPesquisar);
		txtClicPesquisar.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(61, 188, 55, 16);
		desktopPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(205, 183, 356, 28);
		desktopPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtDataNasc = new JTextField();
		txtDataNasc.setBounds(205, 237, 356, 28);
		desktopPane.add(txtDataNasc);
		txtDataNasc.setColumns(10);
		
		JLabel lblDataNasc = new JLabel("Data de Nascimento: ");
		lblDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataNasc.setBounds(61, 242, 132, 16);
		desktopPane.add(lblDataNasc);
		
		txtCnh = new JTextField();
		txtCnh.setBounds(205, 291, 356, 28);
		desktopPane.add(txtCnh);
		txtCnh.setColumns(10);
		
		JLabel lblCnh = new JLabel("CNH: ");
		lblCnh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCnh.setBounds(61, 296, 55, 16);
		desktopPane.add(lblCnh);
		
		JLabel lblTipoCnh = new JLabel("Tipo CNH: ");
		lblTipoCnh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoCnh.setBounds(61, 346, 73, 16);
		desktopPane.add(lblTipoCnh);
		
		txtTipoCnh = new JTextField();
		txtTipoCnh.setBounds(205, 341, 356, 28);
		desktopPane.add(txtTipoCnh);
		txtTipoCnh.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndereco.setBounds(61, 391, 73, 16);
		desktopPane.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(205, 386, 356, 28);
		desktopPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JButton btnMotCreate = new JButton("");
		btnMotCreate.setBackground(new Color(214, 217, 223));
		btnMotCreate.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/Add.png")));
		btnMotCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMotCreate.setBounds(269, 437, 43, 41);
		desktopPane.add(btnMotCreate);
		
		JButton btnMotUpdate = new JButton("");
		btnMotUpdate.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/edit.png")));
		btnMotUpdate.setBounds(338, 437, 43, 41);
		desktopPane.add(btnMotUpdate);		

		JButton btnMotDelete = new JButton("");
		btnMotDelete.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/delete.png")));
		btnMotDelete.setBounds(406, 437, 43, 41);
		desktopPane.add(btnMotDelete);

	}
}
