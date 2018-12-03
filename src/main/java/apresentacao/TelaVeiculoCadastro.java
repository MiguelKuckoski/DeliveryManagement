package apresentacao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;

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
import entidade.Pacote;
import entidade.Veiculo;

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
	private JButton btnPesquisar = new JButton("");
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

		btnVeiUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Veiculo veiculo = new Veiculo();
				veiculo.setMarca(txtMarca.getText());
				veiculo.setModelo(txtModelo.getText());
				veiculo.setPlaca(txtPlaca.getText());
				veiculo.setAno(Integer.parseInt(txtAno.getText()));
				veiculo.setTipo(returnNumberTypeCar(cmbTipoVeiculo.getSelectedItem().toString()));

				controladorPrincipal.getControleVeiculo().atualizarVeiculo(txtPlaca.getText(), veiculo);

				txtMarca.setText(null);
				txtModelo.setText(null);
				txtPlaca.setText(null);
				txtAno.setText(null);
				cmbTipoVeiculo.setToolTipText(null);

				txtPlaca.setEditable(true);

			}
		});

		btnVeiUpdate.setToolTipText("Editar");
		btnVeiUpdate.setIcon(new ImageIcon(TelaVeiculoCadastro.class.getResource("/apresentacao/icones/btnEdit.png")));
		btnVeiUpdate.setBounds(274, 437, 55, 52);
		desktop.add(btnVeiUpdate);
		btnVeiDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtPlaca.getText() != null && !txtPlaca.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							controladorPrincipal.getControleVeiculo().removerVeiculo(txtPlaca.getText()));
					limparCampos();
				}
			}
		});

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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setarCampos();
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Marca", "Modelo", "Placa", "Ano", "Tipo", "Motorista" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(59);
		table.getColumnModel().getColumn(2).setPreferredWidth(56);
		table.getColumnModel().getColumn(3).setPreferredWidth(49);
		scrollPane.setViewportView(table);

		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtPesquisar.getText() != null && !txtPesquisar.getText().isEmpty()) {
					if (controladorPrincipal.getControleVeiculo().listarVeiculos()
							.containsKey(txtPesquisar.getText())) {
						Veiculo veiculo = controladorPrincipal.getControleVeiculo().listarVeiculos()
								.get(txtPesquisar.getText());

						txtMarca.setText(veiculo.getMarca());
						txtModelo.setText(veiculo.getModelo());
						txtPlaca.setText(veiculo.getPlaca());
						txtAno.setText(Integer.toString(veiculo.getAno()));
						cmbTipoVeiculo.setSelectedIndex(veiculo.getTipo() - 1);

						txtPlaca.setEditable(false);

						btnVeiUpdate.setEnabled(true);
						btnVeiCreate.setEnabled(false);

					} else {
						JOptionPane.showMessageDialog(null, "Veiculo não encontrado");
					}
				}
				DefaultTableModel modeloTable = (DefaultTableModel) table.getModel();

				while (modeloTable.getRowCount() > 0) {
					modeloTable.removeRow(0);
				}

				Set<String> chaves = controladorPrincipal.getControleVeiculo().listarVeiculos().keySet();
				for (String chave : chaves) {
					Veiculo veiculo = controladorPrincipal.getControleVeiculo().listarVeiculos().get(chave);

					modeloTable.addRow(new Object[] { veiculo.getMarca(), veiculo.getModelo(), veiculo.getPlaca(),
							veiculo.getAno(), returnTypeCar(chave), returnMotorista(chave) });
				}

			}
		});
		btnPesquisar
				.setIcon(new ImageIcon(TelaVeiculoCadastro.class.getResource("/apresentacao/icones/search-icon.png")));
		btnPesquisar.setBounds(576, 25, 24, 24);
		desktop.add(btnPesquisar);

	}

	private String returnMotorista(String placa) {
		String teste;
		if (controladorPrincipal.getControleVeiculo().listarVeiculos().get(placa).getMotorista() != null) {
			teste = controladorPrincipal.getControleVeiculo().listarVeiculos().get(placa).getMotorista().getNome()
					.toString();
		} else {
			teste = "Sem motorista";
		}

		return teste;
	}

	private String returnTypeCar(String placa) {
		String tipo;
		int teste = controladorPrincipal.getControleVeiculo().listarVeiculos().get(placa).getTipo();
		if (teste == 1) {
			tipo = "Van";
		} else if (teste == 2) {
			tipo = "Caminhão";
		} else {
			tipo = "Carreta";
		}

		return tipo;

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

		txtPlaca.setEditable(true);
		cmbTipoVeiculo.setSelectedIndex(1);
	}

	public void setarCampos() {
		int setar = table.getSelectedRow();
		txtMarca.setText(table.getModel().getValueAt(setar, 0).toString());
		txtModelo.setText(table.getModel().getValueAt(setar, 1).toString());
		txtPlaca.setText(table.getModel().getValueAt(setar, 2).toString());
		txtAno.setText(table.getModel().getValueAt(setar, 3).toString());
		cmbTipoVeiculo.setSelectedIndex(returnNumberTypeCar(table.getModel().getValueAt(setar, 4).toString()) - 1);

		txtPlaca.setEditable(false);

		btnVeiCreate.setEnabled(false);
		btnVeiUpdate.setEnabled(true);
	}
}
