package apresentacao;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JDesktopPane desktop = new JDesktopPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		// String persistencia = "";
		// controladorPrincipal.start(persistencia);
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
	public TelaPrincipal() {
		initialize();
	}

	private void initialize() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
			}
		});
		setTitle("Entrega Rapida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(Frame.MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnRota = new JMenu("Rota");
		menuBar.add(mnRota);

		JMenuItem mntmGerarRota = new JMenuItem("Cadastro");
		mntmGerarRota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRotaCadastro rota = new TelaRotaCadastro();
				rota.setVisible(true);
				desktop.add(rota);
			}
		});
		mnRota.add(mntmGerarRota);

		JMenu mnMotorista = new JMenu("Motorista");
		menuBar.add(mnMotorista);

		JMenuItem mntmAdicionar = new JMenuItem("Cadastro");
		mntmAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMotoristaCadastro telaMotorista = new TelaMotoristaCadastro();
				telaMotorista.setVisible(true);
				desktop.add(telaMotorista);
			}
		});
		mnMotorista.add(mntmAdicionar);

		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnMotorista.add(mntmListar);

		JMenu mnVeiculo = new JMenu("Veiculo");
		menuBar.add(mnVeiculo);

		JMenuItem mntmAdicionar_1 = new JMenuItem("Cadastro");
		mntmAdicionar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVeiculoCadastro rota = new TelaVeiculoCadastro();
				rota.setVisible(true);
				desktop.add(rota);
			}
		});
		mnVeiculo.add(mntmAdicionar_1);

		JMenuItem mntmVincularDesvincular = new JMenuItem("Vincular/Desvincular");
		mntmVincularDesvincular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVincularMotorista rota = new TelaVincularMotorista();
				rota.setVisible(true);
				desktop.add(rota);
			}
		});
		mnVeiculo.add(mntmVincularDesvincular);

		JMenuItem mntmListar_1 = new JMenuItem("Listar");
		mntmListar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnVeiculo.add(mntmListar_1);

		JMenu mnPacote = new JMenu("Pacote");
		menuBar.add(mnPacote);

		JMenuItem mntmAdicionar_2 = new JMenuItem("Cadastro");
		mntmAdicionar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaPacoteCadastro rota = new TelaPacoteCadastro();
				rota.setVisible(true);
				desktop.add(rota);

			}
		});
		mnPacote.add(mntmAdicionar_2);

		JMenuItem mntmListar_2 = new JMenuItem("Listar");
		mntmListar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnPacote.add(mntmListar_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(desktop,
				GroupLayout.DEFAULT_SIZE, 1349, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(desktop, GroupLayout.PREFERRED_SIZE, 678, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		GroupLayout gl_desktop = new GroupLayout(this.desktop);
		gl_desktop
				.setHorizontalGroup(gl_desktop.createParallelGroup(Alignment.LEADING).addGap(0, 895, Short.MAX_VALUE));
		gl_desktop.setVerticalGroup(gl_desktop.createParallelGroup(Alignment.LEADING).addGap(0, 499, Short.MAX_VALUE));
		this.desktop.setLayout(gl_desktop);
		contentPane.setLayout(gl_contentPane);
	}
}
