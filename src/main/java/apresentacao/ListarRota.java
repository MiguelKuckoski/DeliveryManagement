package apresentacao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ListarRota extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarRota frame = new ListarRota();
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
	public ListarRota() {
		setClosable(true);
		setBounds(100, 100, 744, 530);
		getContentPane().setLayout(null);
		
		
		JDesktopPane desktop = new JDesktopPane();
		desktop.setBounds(0, 0, 746, 499);
		getContentPane().add(desktop);
		desktop.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 81, 600, 373);
		desktop.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Data", "Ve\u00EDculo"
			}
		));
		scrollPane.setViewportView(table);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(65, 28, 402, 23);
		desktop.add(textArea);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(ListarRota.class.getResource("/apresentacao/icones/search-icon.png")));
		btnNewButton.setBounds(477, 28, 28, 25);
		desktop.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Data", "Ve\u00EDculo", "Rota"}));
		comboBox.setBounds(509, 30, 72, 21);
		desktop.add(comboBox);

		
	}
}
