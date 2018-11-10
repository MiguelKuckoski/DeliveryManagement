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
	private JTextField txtPesquisar;
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
		setIconifiable(true);
		setResizable(true);
		setTitle("Motorista");
		setClosable(true);
		setBounds(100, 100, 744, 530);
		getContentPane().setLayout(null);
		
		JDesktopPane desktop = new JDesktopPane();
		desktop.setBounds(0, 6, 753, 506);
		getContentPane().add(desktop);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(144, 60, 417, 28);
		desktop.add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(61, 188, 55, 16);
		desktop.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(205, 183, 356, 28);
		desktop.add(txtNome);
		txtNome.setColumns(10);
		
		txtDataNasc = new JTextField();
		txtDataNasc.setBounds(205, 237, 356, 28);
		desktop.add(txtDataNasc);
		txtDataNasc.setColumns(10);
		
		JLabel lblDataNasc = new JLabel("Data de Nascimento: ");
		lblDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataNasc.setBounds(61, 242, 132, 16);
		desktop.add(lblDataNasc);
		
		txtCnh = new JTextField();
		txtCnh.setBounds(205, 291, 356, 28);
		desktop.add(txtCnh);
		txtCnh.setColumns(10);
		
		JLabel lblCnh = new JLabel("CNH: ");
		lblCnh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCnh.setBounds(61, 296, 55, 16);
		desktop.add(lblCnh);
		
		JLabel lblTipoCnh = new JLabel("Tipo CNH: ");
		lblTipoCnh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoCnh.setBounds(61, 346, 73, 16);
		desktop.add(lblTipoCnh);
		
		txtTipoCnh = new JTextField();
		txtTipoCnh.setBounds(205, 341, 356, 28);
		desktop.add(txtTipoCnh);
		txtTipoCnh.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndereco.setBounds(61, 391, 73, 16);
		desktop.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(205, 386, 356, 28);
		desktop.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JButton btnMotCreate = new JButton("");
		btnMotCreate.setToolTipText("Adicionar");
		btnMotCreate.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/adicionarMotorista.png")));
		btnMotCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMotCreate.setBounds(246, 431, 70, 55);
		desktop.add(btnMotCreate);
		
		JButton btnMotUpdate = new JButton("");
		btnMotUpdate.setToolTipText("Editar");
		btnMotUpdate.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/edit.png")));
		btnMotUpdate.setBounds(334, 418, 60, 60);
		desktop.add(btnMotUpdate);		

		JButton btnMotDelete = new JButton("");
		btnMotDelete.setToolTipText("Deletar");
		btnMotDelete.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/delete.png")));
		btnMotDelete.setBounds(406, 418, 60, 60);
		desktop.add(btnMotDelete);

	}
}
