package apresentacao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
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

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private final JDesktopPane desktop = new JDesktopPane();

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
		setBounds(100, 100, 921, 559);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnRota = new JMenu("Rota");
		menuBar.add(mnRota);

		JMenuItem mntmGerarRota = new JMenuItem("Adicionar");
		mntmGerarRota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRotaAdd rota = new TelaRotaAdd();
				rota.setVisible(true);
				desktop.add(rota);
			}
		});
		mnRota.add(mntmGerarRota);

		JMenuItem mntmNewMenuItem = new JMenuItem("Remover");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRotaRemove rota = new TelaRotaRemove();
				rota.setVisible(true);
				contentPane.add(rota);
			}
		});
		mnRota.add(mntmNewMenuItem);

		JMenuItem mntmPacotesForaDo = new JMenuItem("Editar");
		mntmPacotesForaDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRotaEdit rota = new TelaRotaEdit();
				rota.setVisible(true);
				contentPane.add(rota);
			}
		});
		mnRota.add(mntmPacotesForaDo);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRotaListar rota = new TelaRotaListar();
				rota.setVisible(true);
				contentPane.add(rota);
			}
		});
		mnRota.add(mntmNewMenuItem_1);

		JMenuItem mntmCriar = new JMenuItem("Criar");
		mntmCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRotaCriar rota = new TelaRotaCriar();
				rota.setVisible(true);
				contentPane.add(rota);
			}
		});
		mnRota.add(mntmCriar);

		JMenuItem mntmStatus = new JMenuItem("Status");
		mntmStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRotaStatus rota = new TelaRotaStatus();
				rota.setVisible(true);
				contentPane.add(rota);
			}
		});
		mnRota.add(mntmStatus);

		JMenu mnMotorista = new JMenu("Motorista");
		menuBar.add(mnMotorista);

		JMenuItem mntmAdicionar = new JMenuItem("Adicionar");
		mntmAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnMotorista.add(mntmAdicionar);

		JMenuItem mntmRemover = new JMenuItem("Remover");
		mntmRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnMotorista.add(mntmRemover);

		JMenuItem mntmEditar = new JMenuItem("Editar");
		mntmEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnMotorista.add(mntmEditar);

		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnMotorista.add(mntmListar);

		JMenu mnVeiculo = new JMenu("Veiculo");
		menuBar.add(mnVeiculo);

		JMenuItem mntmAdicionar_1 = new JMenuItem("Adicionar");
		mntmAdicionar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnVeiculo.add(mntmAdicionar_1);

		JMenuItem mntmRemover_1 = new JMenuItem("Remover");
		mntmRemover_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnVeiculo.add(mntmRemover_1);

		JMenuItem mntmEditar_1 = new JMenuItem("Editar");
		mntmEditar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnVeiculo.add(mntmEditar_1);

		JMenuItem mntmListar_1 = new JMenuItem("Listar");
		mntmListar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnVeiculo.add(mntmListar_1);

		JMenu mnPacote = new JMenu("Pacote");
		menuBar.add(mnPacote);

		JMenuItem mntmAdicionar_2 = new JMenuItem("Adicionar");
		mntmAdicionar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnPacote.add(mntmAdicionar_2);

		JMenuItem mntmRemover_2 = new JMenuItem("Remover");
		mntmRemover_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnPacote.add(mntmRemover_2);

		JMenuItem mntmEditar_2 = new JMenuItem("Editar");
		mntmEditar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnPacote.add(mntmEditar_2);

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
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(this.desktop, GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(this.desktop, GroupLayout.PREFERRED_SIZE, 499, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		GroupLayout gl_desktop = new GroupLayout(this.desktop);
		gl_desktop
				.setHorizontalGroup(gl_desktop.createParallelGroup(Alignment.LEADING).addGap(0, 895, Short.MAX_VALUE));
		gl_desktop.setVerticalGroup(gl_desktop.createParallelGroup(Alignment.LEADING).addGap(0, 499, Short.MAX_VALUE));
		this.desktop.setLayout(gl_desktop);
		contentPane.setLayout(gl_contentPane);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}

	private void teste(TelaRotaAdd rota) {

	}
}
