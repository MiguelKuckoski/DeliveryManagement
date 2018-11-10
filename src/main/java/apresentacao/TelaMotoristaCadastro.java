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
		desktop.setBounds(-27, 0, 759, 506);
		getContentPane().add(desktop);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(149, 16, 417, 28);
		desktop.add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(61, 202, 55, 16);
		desktop.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(205, 197, 392, 28);
		desktop.add(txtNome);
		txtNome.setColumns(10);
		
		txtDataNasc = new JTextField();
		txtDataNasc.setBounds(205, 237, 392, 28);
		desktop.add(txtDataNasc);
		txtDataNasc.setColumns(10);
		
		JLabel lblDataNasc = new JLabel("Data de Nascimento: ");
		lblDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataNasc.setBounds(61, 242, 132, 16);
		desktop.add(lblDataNasc);
		
		txtCnh = new JTextField();
		txtCnh.setBounds(205, 291, 392, 28);
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
		txtTipoCnh.setBounds(205, 341, 392, 28);
		desktop.add(txtTipoCnh);
		txtTipoCnh.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndereco.setBounds(61, 391, 73, 16);
		desktop.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(205, 386, 392, 28);
		desktop.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/search-icon.png")));
		btnPesquisar.setBounds(594, 16, 36, 28);
		desktop.add(btnPesquisar);
		
		JButton btnMotCreate = new JButton("");
		btnMotCreate.setToolTipText("Adicionar");
		btnMotCreate.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/adicionarMotorista.png")));
		btnMotCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMotCreate.setBounds(250, 426, 60, 60);
		desktop.add(btnMotCreate);
		
		JButton btnMotUpdate = new JButton("");
		btnMotUpdate.setToolTipText("Editar");
		btnMotUpdate.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/edit.png")));
		btnMotUpdate.setBounds(342, 426, 60, 60);
		desktop.add(btnMotUpdate);		

		JButton btnMotDelete = new JButton("");
		btnMotDelete.setToolTipText("Deletar");
		btnMotDelete.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/delete.png")));
		btnMotDelete.setBounds(430, 426, 60, 60);
		desktop.add(btnMotDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setEnabled(false);
		desktop.setLayer(scrollPane, 0);
		scrollPane.setBounds(99, 66, 520, 110);
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
		
		
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(109);
		table.getColumnModel().getColumn(2).setPreferredWidth(38);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);

	}
}
