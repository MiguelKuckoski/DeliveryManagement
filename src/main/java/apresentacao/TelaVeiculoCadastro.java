package apresentacao;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaVeiculoCadastro extends JInternalFrame {
	private JTextField txtPesquisar;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtPlaca;
	private JTextField txtAno;
	private JTable table;

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
		txtPesquisar.setBounds(154, 25, 410, 28);
		desktop.add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setForeground(Color.WHITE);
		lblMarca.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMarca.setBounds(80, 218, 55, 16);
		desktop.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(Color.WHITE);
		lblModelo.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblModelo.setBounds(80, 263, 93, 16);
		desktop.add(lblModelo);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setForeground(Color.WHITE);
		lblPlaca.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPlaca.setBounds(80, 308, 55, 16);
		desktop.add(lblPlaca);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setForeground(Color.WHITE);
		lblAno.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAno.setBounds(80, 353, 55, 16);
		desktop.add(lblAno);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblTipo.setBounds(80, 397, 55, 16);
		desktop.add(lblTipo);
		
		
		
		
		txtMarca = new JTextField();
		txtMarca.setBounds(154, 212, 410, 28);
		desktop.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(154, 257, 410, 28);
		desktop.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(154, 302, 410, 28);
		desktop.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		txtAno = new JTextField();
		txtAno.setBounds(154, 347, 410, 28);
		desktop.add(txtAno);
		txtAno.setColumns(10);

		JButton btnVeiCreate = new JButton("");
		btnVeiCreate.setToolTipText("Adicionar");
		btnVeiCreate.setBackground(new Color(214, 217, 223));
		btnVeiCreate.setIcon(new ImageIcon(TelaVeiculoCadastro.class.getResource("/apresentacao/icones/btnVehicle.png")));
		btnVeiCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVeiCreate.setBounds(176, 437, 55, 52);
		desktop.add(btnVeiCreate);
		
		JButton btnVeiUpdate = new JButton("");
		btnVeiUpdate.setToolTipText("Editar");
		btnVeiUpdate.setIcon(new ImageIcon(TelaVeiculoCadastro.class.getResource("/apresentacao/icones/btnEdit.png")));
		btnVeiUpdate.setBounds(274, 437, 55, 52);
		desktop.add(btnVeiUpdate);		

		JButton btnMotDelete = new JButton("");
		btnMotDelete.setToolTipText("Deletar");
		btnMotDelete.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/delete.png")));
		btnMotDelete.setBounds(373, 437, 55, 52);
		desktop.add(btnMotDelete);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Van");
		comboBox.addItem("Caminhão");
		comboBox.addItem("Carreta");
		comboBox.setBounds(154, 392, 178, 26);
		desktop.add(comboBox);
		
		JButton btnClear = new JButton("");
		btnClear.setIcon(new ImageIcon(TelaVeiculoCadastro.class.getResource("/apresentacao/icones/btnClear.png")));
		btnClear.setBounds(473, 437, 55, 52);
		desktop.add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setEnabled(false);
		desktop.setLayer(scrollPane, 0);
		scrollPane.setBounds(49, 71, 635, 119);
		desktop.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Marca", "Modelo", "Placa", "Ano", "Tipo"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(59);
		table.getColumnModel().getColumn(2).setPreferredWidth(56);
		table.getColumnModel().getColumn(3).setPreferredWidth(49);
		scrollPane.setViewportView(table);
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(TelaVeiculoCadastro.class.getResource("/apresentacao/icones/search-icon.png")));
		btnPesquisar.setBounds(576, 25, 24, 24);
		desktop.add(btnPesquisar);


	}
}
