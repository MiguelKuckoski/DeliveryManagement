package apresentacao;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPacoteCadastro extends JInternalFrame {
	private JTextField txtPesquisar;
	private JTextField txtNomeRem;
	private JTextField txtNomeDes;
	private JTextField txtCodigoLoc;
	private JTextField txtEndRem;
	private JTextField txtEndDes;

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
		txtPesquisar.setBounds(150, 74, 440, 28);
		desktop.add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		JLabel lblNomeRemetente = new JLabel("Nome remetente: ");
		lblNomeRemetente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeRemetente.setBounds(32, 163, 122, 16);
		desktop.add(lblNomeRemetente);
		
		JLabel lblNomeDestinatario = new JLabel("Nome destinatário:");
		lblNomeDestinatario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDestinatario.setBounds(32, 208, 115, 16);
		desktop.add(lblNomeDestinatario);
		
		JLabel lblCodigoLocalizador = new JLabel("Código localizador: ");
		lblCodigoLocalizador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoLocalizador.setBounds(32, 247, 122, 28);
		desktop.add(lblCodigoLocalizador);
		
		JLabel lblEnderecoRemetente = new JLabel("Endereço remetente:");
		lblEnderecoRemetente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnderecoRemetente.setBounds(32, 303, 137, 16);
		desktop.add(lblEnderecoRemetente);
		
		JLabel lblEnderecoDestino = new JLabel("Endereço destino: ");
		lblEnderecoDestino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnderecoDestino.setBounds(32, 349, 122, 16);
		desktop.add(lblEnderecoDestino);
		
		txtNomeRem = new JTextField();
		txtNomeRem.setBounds(150, 158, 440, 28);
		desktop.add(txtNomeRem);
		txtNomeRem.setColumns(10);
		
		txtNomeDes = new JTextField();
		txtNomeDes.setBounds(150, 203, 440, 28);
		desktop.add(txtNomeDes);
		txtNomeDes.setColumns(10);
		
		txtCodigoLoc = new JTextField();
		txtCodigoLoc.setBounds(150, 248, 440, 28);
		desktop.add(txtCodigoLoc);
		txtCodigoLoc.setColumns(10);
		
		txtEndRem = new JTextField();
		txtEndRem.setBounds(170, 296, 420, 28);
		desktop.add(txtEndRem);
		txtEndRem.setColumns(10);
		
		txtEndDes = new JTextField();
		txtEndDes.setBounds(150, 344, 440, 28);
		desktop.add(txtEndDes);
		txtEndDes.setColumns(10);
		
		JButton btnPacCreate = new JButton("");
		btnPacCreate.setToolTipText("Adicionar");
		btnPacCreate.setBackground(Color.LIGHT_GRAY);
		btnPacCreate.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/Add-pacote.png")));
		btnPacCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPacCreate.setBounds(267, 395, 60, 60);
		desktop.add(btnPacCreate);
		
		JButton btnPacUpdate = new JButton("");
		btnPacUpdate.setToolTipText("Editar");
		btnPacUpdate.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/edit.png")));
		btnPacUpdate.setBounds(334, 395, 60, 60);
		desktop.add(btnPacUpdate);		

		JButton btnPacDelete = new JButton("");
		btnPacDelete.setToolTipText("Deletar");
		btnPacDelete.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/delete.png")));
		btnPacDelete.setBounds(406, 395, 60, 60);
		desktop.add(btnPacDelete);

	}
}
