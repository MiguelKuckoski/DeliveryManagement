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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaMotoristaCadastro extends JInternalFrame {
	private JTextField txtPesquisar;
	private JTextField txtNome;
	private JTextField txtDataNasc;
	private JTextField txtCnh;
	private JTextField txtTipoCnh;
	private JTextField txtEndereco;
	private JTable table;

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
		txtPesquisar.setBounds(215, 16, 392, 28);
		desktop.add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome: ");
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
		
		JLabel lblDataNasc = new JLabel("Data de Nascimento: ");
		lblDataNasc.setForeground(Color.WHITE);
		lblDataNasc.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDataNasc.setBounds(49, 253, 158, 16);
		desktop.add(lblDataNasc);
		
		txtCnh = new JTextField();
		txtCnh.setBounds(215, 287, 392, 28);
		desktop.add(txtCnh);
		txtCnh.setColumns(10);
		
		JLabel lblCnh = new JLabel("CNH: ");
		lblCnh.setForeground(Color.WHITE);
		lblCnh.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCnh.setBounds(49, 293, 55, 16);
		desktop.add(lblCnh);
		
		JLabel lblTipoCnh = new JLabel("Tipo CNH: ");
		lblTipoCnh.setForeground(Color.WHITE);
		lblTipoCnh.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblTipoCnh.setBounds(49, 332, 119, 16);
		desktop.add(lblTipoCnh);
		
		txtTipoCnh = new JTextField();
		txtTipoCnh.setBounds(215, 326, 392, 28);
		desktop.add(txtTipoCnh);
		txtTipoCnh.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setForeground(Color.WHITE);
		lblEndereco.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEndereco.setBounds(49, 372, 88, 16);
		desktop.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(215, 366, 392, 28);
		desktop.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/search-icon.png")));
		btnPesquisar.setBounds(635, 16, 24, 24);
		desktop.add(btnPesquisar);
		
		JButton btnMotCreate = new JButton("");
		btnMotCreate.setToolTipText("Adicionar");
		btnMotCreate.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/adicionarMotorista.png")));
		btnMotCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMotCreate.setBounds(244, 423, 55, 52);
		desktop.add(btnMotCreate);
		
		JButton btnMotUpdate = new JButton("");
		btnMotUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMotUpdate.setToolTipText("Editar");
		btnMotUpdate.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/edit.png")));
		btnMotUpdate.setBounds(335, 423, 55, 52);
		desktop.add(btnMotUpdate);		

		JButton btnMotDelete = new JButton("");
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
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Data Nascimento", "Cnh", "Tipo Cnh", "Endere\u00E7o"
			}
		));
		
		JButton btnMotClear = new JButton("");
		btnMotClear.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/btnClear.png")));
		btnMotClear.setBounds(512, 423, 55, 52);
		desktop.add(btnMotClear);
		
		
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(109);
		table.getColumnModel().getColumn(2).setPreferredWidth(38);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);

	}
}
