package apresentacao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controle.ControladorPrincipal;

public class TelaVeiculoCadastro extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtPesquisar;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtPlaca;
	private JTextField txtAno;
	private JTable table;

	private JButton btnVeiCreate = new JButton("");
	private JButton btnVeiUpdate = new JButton("");
	private JButton btnVeiDelete = new JButton("");
	private JComboBox<String> cmbTipoVeiculo = new JComboBox<String>();
	JButton btnClear = new JButton("");

	private static ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();

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

		btnVeiCreate.setToolTipText("Adicionar");
		btnVeiCreate.setBackground(new Color(214, 217, 223));
		btnVeiCreate
				.setIcon(new ImageIcon(TelaVeiculoCadastro.class.getResource("/apresentacao/icones/btnVehicle.png")));
		btnVeiCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ano = Integer.parseInt(txtAno.getText());
				if (controladorPrincipal.getControleVeiculo().cadastrarVeiculo(txtMarca.getText(), txtModelo.getText(),
						txtPlaca.getText(), ano, returnNumberTypeCar(cmbTipoVeiculo.getSelectedItem().toString()))) {
					JOptionPane.showMessageDialog(null, "Veiculo Cadastrado com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar veículo");
				}
			}
		});
		btnVeiCreate.setBounds(176, 437, 55, 52);
		desktop.add(btnVeiCreate);

		btnVeiUpdate.setToolTipText("Editar");
		btnVeiUpdate.setIcon(new ImageIcon(TelaVeiculoCadastro.class.getResource("/apresentacao/icones/btnEdit.png")));
		btnVeiUpdate.setBounds(274, 437, 55, 52);
		desktop.add(btnVeiUpdate);

		btnVeiDelete.setToolTipText("Deletar");
		btnVeiDelete.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/delete.png")));
		btnVeiDelete.setBounds(373, 437, 55, 52);
		desktop.add(btnVeiDelete);

		cmbTipoVeiculo.addItem("Van");
		cmbTipoVeiculo.addItem("Caminhão");
		cmbTipoVeiculo.addItem("Carreta");
		cmbTipoVeiculo.setBounds(154, 392, 178, 26);
		desktop.add(cmbTipoVeiculo);

		this.btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
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
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Marca", "Modelo", "Placa", "Ano", "Tipo" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(59);
		table.getColumnModel().getColumn(2).setPreferredWidth(56);
		table.getColumnModel().getColumn(3).setPreferredWidth(49);
		scrollPane.setViewportView(table);

		JButton btnPesquisar = new JButton("");
		btnPesquisar
				.setIcon(new ImageIcon(TelaVeiculoCadastro.class.getResource("/apresentacao/icones/search-icon.png")));
		btnPesquisar.setBounds(576, 25, 24, 24);
		desktop.add(btnPesquisar);

	}

	private int returnNumberTypeCar(String tipo) {
		if (tipo.equalsIgnoreCase("van")) {
			return 1;
		} else if (tipo.equalsIgnoreCase("Caminhão")) {
			return 2;
		} else {
			return 3;
		}
	}

	private void limparCampos() {
		btnClear.setEnabled(true);
		btnVeiDelete.setEnabled(true);
		btnVeiCreate.setEnabled(true);
		btnVeiUpdate.setEnabled(true);

		DefaultTableModel modeloTable = (DefaultTableModel) table.getModel();

		while (modeloTable.getRowCount() > 0) {
			modeloTable.removeRow(0);
		}

		txtAno.setText(null);
		txtMarca.setText(null);
		txtModelo.setText(null);
		txtPesquisar.setText(null);
		txtPlaca.setText(null);

		cmbTipoVeiculo.setSelectedIndex(1);
	}
}
