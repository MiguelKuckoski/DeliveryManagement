package apresentacao;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class DetalheRota extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetalheRota frame = new DetalheRota();
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
	public DetalheRota() {
		setFrameIcon(new ImageIcon(DetalheRota.class.getResource("/apresentacao/icones/edit.png")));
		setIcon(true);
		setClosable(true);
		setResizable(true);
		setTitle("Detalhe rota");

		
		
		
		getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		desktopPane.setBounds(0, 0, 434, 270);
		getContentPane().add(desktopPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(223, 11, 134, 20);
		desktopPane.add(textPane);
		
		JLabel lblNewLabel = new JLabel("Pacote");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 55, 16);
		desktopPane.add(lblNewLabel);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(223, 42, 134, 20);
		desktopPane.add(textPane_1);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		lblDestino.setForeground(Color.WHITE);
		lblDestino.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDestino.setBounds(10, 42, 176, 20);
		desktopPane.add(lblDestino);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(223, 73, 134, 20);
		desktopPane.add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(223, 104, 134, 20);
		desktopPane.add(textPane_3);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(223, 135, 134, 20);
		desktopPane.add(textPane_4);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(223, 166, 134, 20);
		desktopPane.add(textPane_5);
		
		JLabel lblMotorista = new JLabel("Motorista");
		lblMotorista.setForeground(Color.WHITE);
		lblMotorista.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMotorista.setBounds(10, 73, 176, 20);
		desktopPane.add(lblMotorista);
		
		JLabel lblVeculo = new JLabel("Ve\u00EDculo ");
		lblVeculo.setForeground(Color.WHITE);
		lblVeculo.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblVeculo.setBounds(10, 104, 176, 20);
		desktopPane.add(lblVeculo);
		
		JLabel lblDataDeEntrega = new JLabel("Data de Entrega");
		lblDataDeEntrega.setForeground(Color.WHITE);
		lblDataDeEntrega.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDataDeEntrega.setBounds(10, 135, 176, 20);
		desktopPane.add(lblDataDeEntrega);
		
		JLabel lblCdigoLocalizador = new JLabel("C\u00F3digo Localizador");
		lblCdigoLocalizador.setForeground(Color.WHITE);
		lblCdigoLocalizador.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCdigoLocalizador.setBounds(10, 166, 176, 20);
		desktopPane.add(lblCdigoLocalizador);
		getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		getContentPane().add(textArea, BorderLayout.NORTH);
		setBounds(100, 100, 445, 299);
		
		}
	}

