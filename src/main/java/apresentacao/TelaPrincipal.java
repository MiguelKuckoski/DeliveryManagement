package apresentacao;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

import controle.ControladorPrincipal;

import javax.swing.JCheckBoxMenuItem;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JDesktopPane desktop = new JDesktopPane();
	private ControladorPrincipal controle = ControladorPrincipal.getInstancia();
	private final SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	private Calendar cal = Calendar.getInstance();


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

		JMenuItem mntmCriarDiaria = new JMenuItem("Criar rota");
		mntmCriarDiaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.getControleRota().criarRota();
			}
		});
		mnRota.add(mntmCriarDiaria);
		
		JMenuItem mntmListar_3 = new JMenuItem("Listar");
		mntmListar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarRota rota = new ListarRota();
				rota.setVisible(true);
				desktop.add(rota);
			}
		});
		mnRota.add(mntmListar_3);
		
		JMenu mnNewMenu = new JMenu("Dar baixa");
		mnRota.add(mnNewMenu);
		
		JMenuItem mntmDiaria = new JMenuItem("Data atual");
		mnNewMenu.add(mntmDiaria);
		mntmDiaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentDate = df.format(cal.getTime());
				controle.getControleRota().LerRota(currentDate);
			}
		});
		
		JMenuItem mntmDataAnterior = new JMenuItem("Data anterior");
		mnNewMenu.add(mntmDataAnterior);
		mntmDataAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.add(Calendar.DATE, -1);
				String yesterdayDate = df.format(cal.getTime());
				controle.getControleRota().LerRota(yesterdayDate);
			}
		});

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
