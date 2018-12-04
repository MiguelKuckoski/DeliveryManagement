package apresentacao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.ControladorPrincipal;
import entidade.Pacote;
import entidade.Rota;

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
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ListarRota extends JInternalFrame {
	private JTable table;
	private ControladorPrincipal controle = ControladorPrincipal.getInstancia();
	private JButton searchButton;
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
		scrollPane.setBounds(65, 81, 600, 338);
		desktop.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Data", "Ve\u00EDculo" }));
		scrollPane.setViewportView(table);

		JTextArea txtData = new JTextArea();
		txtData.setToolTipText("Data");
		txtData.setBounds(65, 28, 274, 23);
		desktop.add(txtData);
		
		JTextArea txtMotorista = new JTextArea();
		txtMotorista.setToolTipText("Motorista");
		txtMotorista.setBounds(368, 28, 264, 23);
		desktop.add(txtMotorista);
		
		searchButton = new JButton("");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Map<String, List<Rota>> mapRotas = controle.getControleRota().pesquisaDataMotorista(txtMotorista.getText(), txtData.getText());
				populeTable(mapRotas);
			}
		});
		searchButton.setIcon(new ImageIcon(ListarRota.class.getResource("/apresentacao/icones/search-icon.png")));
		searchButton.setBounds(642, 26, 23, 25);
		desktop.add(searchButton);
		Map<String, List<Rota>> mapRotas = controle.getControleRota().pesquisaDataMotorista("", "");
		populeTable(mapRotas);

	}

	private void populeTable(Map<String, List<Rota>> mapRotas) {
		DefaultTableModel modeloTable = (DefaultTableModel) table.getModel();

		while (modeloTable.getRowCount() > 0) {
			modeloTable.removeRow(0);
		}
		Set<String> chaves = mapRotas.keySet();
		
		for (String chave : chaves) {
			List<Rota> rotas = mapRotas.get(chave);
			
			for (Rota rota : rotas) {
				modeloTable.addRow(new Object[] { rota.getDataExecucao(), rota.getVeiculo().getPlaca()});
			}
		}
	}
}
