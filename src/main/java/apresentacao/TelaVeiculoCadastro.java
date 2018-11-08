package apresentacao;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaVeiculoCadastro extends JInternalFrame {
	private JTextField txtPesquisar;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtPlaca;
	private JTextField txtAno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVeiculoCadastro frame = new TelaVeiculoCadastro();
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
	public TelaVeiculoCadastro() {
		setIconifiable(true);
		setTitle("Veiculo");
		setClosable(true);
		setBounds(100, 100, 744, 530);
		getContentPane().setLayout(null);
		
		JDesktopPane desktop = new JDesktopPane();
		desktop.setBounds(0, 0, 728, 500);
		getContentPane().add(desktop);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(188, 57, 356, 28);
		desktop.add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMarca.setBounds(67, 148, 55, 16);
		desktop.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModelo.setBounds(67, 204, 55, 16);
		desktop.add(lblModelo);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlaca.setBounds(67, 249, 55, 16);
		desktop.add(lblPlaca);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAno.setBounds(67, 306, 55, 16);
		desktop.add(lblAno);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(67, 360, 55, 16);
		desktop.add(lblTipo);
		
		
		
		
		txtMarca = new JTextField();
		txtMarca.setBounds(134, 143, 410, 28);
		desktop.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(134, 199, 410, 28);
		desktop.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(134, 244, 410, 28);
		desktop.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		txtAno = new JTextField();
		txtAno.setBounds(134, 301, 410, 28);
		desktop.add(txtAno);
		txtAno.setColumns(10);

		JButton btnVeiCreate = new JButton("");
		btnVeiCreate.setBackground(new Color(214, 217, 223));
		btnVeiCreate.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/Add.png")));
		btnVeiCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVeiCreate.setBounds(269, 437, 43, 41);
		desktop.add(btnVeiCreate);
		
		JButton btnVeiUpdate = new JButton("");
		btnVeiUpdate.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/edit.png")));
		btnVeiUpdate.setBounds(338, 437, 43, 41);
		desktop.add(btnVeiUpdate);		

		JButton btnMotDelete = new JButton("");
		btnMotDelete.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/delete.png")));
		btnMotDelete.setBounds(406, 437, 43, 41);
		desktop.add(btnMotDelete);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Van");
		comboBox.addItem("Caminhão");
		comboBox.addItem("Carreta");
		comboBox.setBounds(134, 356, 178, 26);
		desktop.add(comboBox);


	}
}
