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
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import controle.ControladorPrincipal;
import entidade.Motorista;

public class TelaMotoristaCadastro extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtPesquisar;
	private JTextField txtNome;
	private JTextField txtDataNasc;
	private JTextField txtCnh;
	private JTextField txtTipoCnh;
	private JTextField txtEndereco;
	private JTable table;

	private JButton btnMotUpdate = new JButton("");
	private JButton btnMotClear = new JButton("");
	private JButton btnMotCreate = new JButton("");
	private JButton btnPesquisar = new JButton("");
	private JButton btnMotDelete = new JButton("");

	private static ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();
	private final JLabel lblDigiteACnh = new JLabel("Digite a CNH para selecionar");

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
		desktop.setBounds(-33, 0, 759, 506);
		getContentPane().add(desktop);

		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(283, 16, 392, 28);
		desktop.add(txtPesquisar);
		txtPesquisar.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNome.setBounds(49, 212, 55, 16);
		desktop.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(215, 206, 392, 28);
		desktop.add(txtNome);
		txtNome.setColumns(10);

		txtDataNasc = new JTextField();
		txtDataNasc.setBounds(215, 247, 392, 28);
		desktop.add(txtDataNasc);
		txtDataNasc.setColumns(10);

		JLabel lblDataNasc = new JLabel("Data de Nascimento");
		lblDataNasc.setForeground(Color.WHITE);
		lblDataNasc.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDataNasc.setBounds(49, 253, 158, 16);
		desktop.add(lblDataNasc);

		txtCnh = new JTextField();
		txtCnh.setBounds(215, 287, 392, 28);
		desktop.add(txtCnh);
		txtCnh.setColumns(10);

		JLabel lblCnh = new JLabel("CNH");
		lblCnh.setForeground(Color.WHITE);
		lblCnh.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCnh.setBounds(49, 293, 55, 16);
		desktop.add(lblCnh);

		JLabel lblTipoCnh = new JLabel("Tipo CNH");
		lblTipoCnh.setForeground(Color.WHITE);
		lblTipoCnh.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblTipoCnh.setBounds(49, 332, 119, 16);
		desktop.add(lblTipoCnh);

		txtTipoCnh = new JTextField();
		txtTipoCnh.setBounds(215, 326, 392, 28);
		desktop.add(txtTipoCnh);
		txtTipoCnh.setColumns(10);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setForeground(Color.WHITE);
		lblEndereco.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEndereco.setBounds(49, 372, 88, 16);
		desktop.add(lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(215, 366, 392, 28);
		desktop.add(txtEndereco);
		txtEndereco.setColumns(10);

		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtPesquisar.getText() != null && !txtPesquisar.getText().isEmpty()) {
					if (controladorPrincipal.getControleMotorista().listarMotoristas()
							.containsKey(txtPesquisar.getText())) {
						Motorista motorista = controladorPrincipal.getControleMotorista().listarMotoristas()
								.get(txtPesquisar.getText());

						txtNome.setText(motorista.getNome());
						txtCnh.setText(motorista.getCnhNum());
						txtEndereco.setText(motorista.getEndereco());
						txtTipoCnh.setText(motorista.getCnhTipo());
						txtDataNasc.setText(motorista.getNascimento());

						txtCnh.setEditable(false);

						btnMotUpdate.setEnabled(true);
						btnMotCreate.setEnabled(false);

					} else {
						JOptionPane.showMessageDialog(null, "Motorista não encontrado");
					}
				}
				DefaultTableModel modeloTable = (DefaultTableModel) table.getModel();

				while (modeloTable.getRowCount() > 0) {
					modeloTable.removeRow(0);
				}

				Set<String> chaves = controladorPrincipal.getControleMotorista().listarMotoristas().keySet();
				for (String chave : chaves) {
					Motorista motorista = controladorPrincipal.getControleMotorista().listarMotoristas().get(chave);

					modeloTable.addRow(new Object[] { motorista.getNome(), motorista.getNascimento(),
							motorista.getCnhNum(), motorista.getCnhTipo(), motorista.getEndereco() });
				}

			}
		});
		btnPesquisar.setIcon(
				new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/search-icon.png")));
		btnPesquisar.setBounds(687, 20, 24, 24);
		desktop.add(btnPesquisar);

		btnMotCreate.setToolTipText("Adicionar");
		btnMotCreate
				.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/btnMotora.png")));
		btnMotCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (controladorPrincipal.getControleMotorista().cadastrarMotorista(txtNome.getText(),
						txtDataNasc.getText(), txtEndereco.getText(), txtCnh.getText(), txtTipoCnh.getText())) {
					JOptionPane.showMessageDialog(null, "Motorista Cadastrado com sucesso");

					txtNome.setText(null);
					txtCnh.setText(null);
					txtDataNasc.setText(null);
					txtEndereco.setText(null);
					txtTipoCnh.setText(null);
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar motorista");
				}

			}
		});
		btnMotCreate.setBounds(244, 423, 55, 52);
		desktop.add(btnMotCreate);

		btnMotUpdate.setEnabled(false);
		btnMotUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Motorista motorista = new Motorista();
				motorista.setCnhTipo(txtTipoCnh.getText());
				motorista.setEndereco(txtEndereco.getText());
				motorista.setNascimento(txtDataNasc.getText());
				motorista.setNome(txtNome.getText());

				controladorPrincipal.getControleMotorista().atualizarMotorista(txtCnh.getText(), motorista);

				txtNome.setText(null);
				txtCnh.setText(null);
				txtDataNasc.setText(null);
				txtEndereco.setText(null);
				txtTipoCnh.setText(null);

				txtCnh.setEditable(true);
			}
		});
		btnMotUpdate.setToolTipText("Editar");
		btnMotUpdate
				.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/btnEdit.png")));
		btnMotUpdate.setBounds(335, 423, 55, 52);
		desktop.add(btnMotUpdate);

		btnMotDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtCnh.getText() != null && !txtCnh.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							controladorPrincipal.getControleMotorista().removerMotorista(txtCnh.getText()));
					limparCampos();
				}

			}
		});
		btnMotDelete.setToolTipText("Deletar");
		btnMotDelete.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/delete.png")));
		btnMotDelete.setBounds(424, 423, 55, 52);
		desktop.add(btnMotDelete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setEnabled(false);
		desktop.setLayer(scrollPane, 0);
		scrollPane.setBounds(49, 71, 692, 119);
		desktop.add(scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setUpdateSelectionOnSort(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setarCampos();
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Data Nascimento", "Cnh", "Tipo Cnh", "Endere�o" }));

		btnMotClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				limparCampos();
			}
		});
		btnMotClear
				.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/btnClear.png")));
		btnMotClear.setBounds(512, 423, 55, 52);
		desktop.add(btnMotClear);
		this.lblDigiteACnh.setForeground(Color.WHITE);
		this.lblDigiteACnh.setFont(new Font("Calibri", Font.PLAIN, 18));
		this.lblDigiteACnh.setBounds(49, 19, 222, 22);

		desktop.add(this.lblDigiteACnh);

		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(109);
		table.getColumnModel().getColumn(2).setPreferredWidth(38);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);

	}

	private void limparCampos() {
		btnMotUpdate.setEnabled(true);
		btnMotCreate.setEnabled(true);
		btnMotDelete.setEnabled(true);
		btnMotUpdate.setEnabled(true);

		DefaultTableModel modeloTable = (DefaultTableModel) table.getModel();

		while (modeloTable.getRowCount() > 0) {
			modeloTable.removeRow(0);
		}

		txtNome.setText(null);
		txtCnh.setText(null);
		txtDataNasc.setText(null);
		txtEndereco.setText(null);
		txtTipoCnh.setText(null);

		txtCnh.setEditable(true);
	}

	public void setarCampos() {
		int setar = table.getSelectedRow();
		txtNome.setText(table.getModel().getValueAt(setar, 0).toString());
		txtDataNasc.setText(table.getModel().getValueAt(setar, 1).toString());
		txtCnh.setText(table.getModel().getValueAt(setar, 2).toString());
		txtTipoCnh.setText(table.getModel().getValueAt(setar, 3).toString());
		txtEndereco.setText(table.getModel().getValueAt(setar, 4).toString());

		btnMotCreate.setEnabled(false);
		btnMotUpdate.setEnabled(true);
	}
}
