package apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JMenuBar;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextPane;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
			 
			
			}
		});
		mnRota.add(mntmGerarRota);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Remover");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnRota.add(mntmNewMenuItem);
		
		JMenuItem mntmPacotesForaDo = new JMenuItem("Editar");
		mntmPacotesForaDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnRota.add(mntmPacotesForaDo);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnRota.add(mntmNewMenuItem_1);
		
		JMenuItem mntmCriar = new JMenuItem("Criar");
		mntmCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnRota.add(mntmCriar);
		
		JMenuItem mntmStatus = new JMenuItem("Status");
		mntmStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
