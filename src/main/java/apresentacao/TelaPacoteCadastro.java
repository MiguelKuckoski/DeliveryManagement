package apresentacao;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaPacoteCadastro extends JInternalFrame {
	private JTextField txtPesquisar;
	private JTextField txtNomeRem;
	private JTextField txtNomeDes;
	private JTextField txtCodigoLoc;
	private JTextField txtEndRem;
	private JTextField txtEndDes;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPacoteCadastro frame = new TelaPacoteCadastro();
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
	public TelaPacoteCadastro() {
		setTitle("Pacote");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 744, 530);
		getContentPane().setLayout(null);
		
		JDesktopPane desktop = new JDesktopPane();
		desktop.setBounds(0, 0, 728, 500);
		getContentPane().add(desktop);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(188, 18, 440, 28);
		desktop.add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		JLabel lblNomeRemetente = new JLabel("Nome remetente");
		lblNomeRemetente.setForeground(Color.WHITE);
		lblNomeRemetente.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNomeRemetente.setBounds(32, 214, 137, 16);
		desktop.add(lblNomeRemetente);
		
		JLabel lblNomeDestinatario = new JLabel("Nome destinatário");
		lblNomeDestinatario.setForeground(Color.WHITE);
		lblNomeDestinatario.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNomeDestinatario.setBounds(32, 254, 146, 16);
		desktop.add(lblNomeDestinatario);
		
		JLabel lblCodigoLocalizador = new JLabel("Código localizador");
		lblCodigoLocalizador.setForeground(Color.WHITE);
		lblCodigoLocalizador.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCodigoLocalizador.setBounds(32, 328, 146, 28);
		desktop.add(lblCodigoLocalizador);
		
		JLabel lblEnderecoRemetente = new JLabel("Endereço remetente");
		lblEnderecoRemetente.setForeground(Color.WHITE);
		lblEnderecoRemetente.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEnderecoRemetente.setBounds(32, 294, 175, 16);
		desktop.add(lblEnderecoRemetente);
		
		JLabel lblEnderecoDestino = new JLabel("Endereço destino");
		lblEnderecoDestino.setForeground(Color.WHITE);
		lblEnderecoDestino.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEnderecoDestino.setBounds(32, 374, 146, 16);
		desktop.add(lblEnderecoDestino);
		
		txtNomeRem = new JTextField();
		txtNomeRem.setBounds(188, 208, 440, 28);
		desktop.add(txtNomeRem);
		txtNomeRem.setColumns(10);
		
		txtNomeDes = new JTextField();
		txtNomeDes.setBounds(188, 248, 442, 28);
		desktop.add(txtNomeDes);
		txtNomeDes.setColumns(10);
		
		txtCodigoLoc = new JTextField();
		txtCodigoLoc.setBounds(188, 288, 442, 28);
		desktop.add(txtCodigoLoc);
		txtCodigoLoc.setColumns(10);
		
		txtEndRem = new JTextField();
		txtEndRem.setBounds(188, 328, 442, 28);
		desktop.add(txtEndRem);
		txtEndRem.setColumns(10);
		
		txtEndDes = new JTextField();
		txtEndDes.setBounds(188, 368, 442, 28);
		desktop.add(txtEndDes);
		txtEndDes.setColumns(10);
		
		JButton btnPacCreate = new JButton("");
		btnPacCreate.setToolTipText("Adicionar");
		btnPacCreate.setBackground(Color.LIGHT_GRAY);
		btnPacCreate.setIcon(new ImageIcon(TelaPacoteCadastro.class.getResource("/apresentacao/icones/btnPack.png")));
		btnPacCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPacCreate.setBounds(217, 428, 55, 52);
		desktop.add(btnPacCreate);
		
		JButton btnPacUpdate = new JButton("");
		btnPacUpdate.setToolTipText("Editar");
		btnPacUpdate.setIcon(new ImageIcon(TelaPacoteCadastro.class.getResource("/apresentacao/icones/btnEdit.png")));
		btnPacUpdate.setBounds(307, 428, 55, 52);
		desktop.add(btnPacUpdate);		

		JButton btnPacDelete = new JButton("");
		btnPacDelete.setToolTipText("Deletar");
		btnPacDelete.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/delete.png")));
		btnPacDelete.setBounds(397, 428, 55, 52);
		desktop.add(btnPacDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setEnabled(false);
		desktop.setLayer(scrollPane, 0);
		scrollPane.setBounds(46, 71, 637, 119);
		desktop.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome remetente", "Nome destinat\u00E1rio", "C\u00F3digo", "Endere\u00E7o remetente", "Endere\u00E7o destino"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(103);
		table.getColumnModel().getColumn(1).setPreferredWidth(115);
		table.getColumnModel().getColumn(2).setPreferredWidth(53);
		table.getColumnModel().getColumn(3).setPreferredWidth(123);
		table.getColumnModel().getColumn(4).setPreferredWidth(108);
		scrollPane.setViewportView(table);
		
		JButton btnPacClear = new JButton("");
		btnPacClear.setIcon(new ImageIcon(TelaPacoteCadastro.class.getResource("/apresentacao/icones/btnClear.png")));
		btnPacClear.setBounds(487, 428, 55, 52);
		desktop.add(btnPacClear);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(TelaPacoteCadastro.class.getResource("/apresentacao/icones/search-icon.png")));
		btnNewButton.setBounds(644, 22, 24, 24);
		desktop.add(btnNewButton);

	}
}
