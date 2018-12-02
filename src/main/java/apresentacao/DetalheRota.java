package apresentacao;

import java.awt.EventQueue;
import java.awt.Font;
import java.beans.PropertyVetoException;

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
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class DetalheRota extends JInternalFrame {
	private JTable table;
	private JTable table_1;
	private JTable table_2;

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
	 * @throws PropertyVetoException 
	 */
	public DetalheRota() throws PropertyVetoException {
		setFrameIcon(new ImageIcon(DetalheRota.class.getResource("/apresentacao/icones/edit.png")));
		setIcon(true);
		setClosable(true);
		setResizable(true);
		setTitle("Detalhe rota");

		
		
		
		getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		desktopPane.setBounds(0, 0, 764, 537);
		getContentPane().add(desktopPane);
		
		JLabel lblPacote = new JLabel("Pacotes\r\n");
		lblPacote.setForeground(Color.WHITE);
		lblPacote.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPacote.setBounds(10, 11, 71, 16);
		desktopPane.add(lblPacote);
		
		JLabel lblMotorista = new JLabel("Motorista");
		lblMotorista.setForeground(Color.WHITE);
		lblMotorista.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMotorista.setBounds(10, 287, 176, 20);
		desktopPane.add(lblMotorista);
		
		JLabel lblVeculo = new JLabel("Ve\u00EDculo ");
		lblVeculo.setForeground(Color.WHITE);
		lblVeculo.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblVeculo.setBounds(10, 420, 176, 20);
		desktopPane.add(lblVeculo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 709, 234);
		desktopPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Entrega confirmada", "C\u00F3digo localizador", "Peso", "Destino", "Remetente"
			}
		));
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 320, 709, 71);
		desktopPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Tipo CNH", "CNH"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 453, 709, 71);
		desktopPane.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Modelo", "Tipo", "Placa"
			}
		));
		scrollPane_2.setViewportView(table_2);
		getContentPane().setLayout(null);
		setBounds(100, 100, 780, 573);
		
		}
	}

