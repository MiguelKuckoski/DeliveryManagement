package apresentacao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import controle.ControladorPrincipal;
import entidade.Rota;

public class ListarRota extends JInternalFrame {
	private JTable table;
	private ControladorPrincipal controle = ControladorPrincipal.getInstancia();
	private JButton searchButton;
	private JDesktopPane desktopMain;

	/**
	 * Create the frame.
	 * @param desktopMain 
	 */
	public ListarRota(JDesktopPane desktopMain) {
		this.desktopMain = desktopMain;
		initialize();
		
	}

	private void initialize() {

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
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Data", "Veiculo" }));
		scrollPane.setViewportView(table);

		JTextArea txtData = new JTextArea();
		txtData.setToolTipText("Data");
		txtData.setBounds(102, 28, 156, 23);
		desktop.add(txtData);

		JTextArea txtMotorista = new JTextArea();
		txtMotorista.setToolTipText("Motorista");
		txtMotorista.setBounds(362, 28, 204, 23);
		desktop.add(txtMotorista);

		searchButton = new JButton("");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Map<String, List<Rota>> mapRotas = controle.getControleRota()
						.pesquisaDataMotorista(txtMotorista.getText(), txtData.getText());
				populeTable(mapRotas);
			}
		});
		searchButton.setIcon(new ImageIcon(ListarRota.class.getResource("/apresentacao/icones/search-icon.png")));
		searchButton.setBounds(589, 26, 23, 25);
		desktop.add(searchButton);

		JButton btnRotaDetalhada = new JButton("Rota detalhada");
		btnRotaDetalhada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() > -1) {
					int row = table.getSelectedRow();
					String data = table.getModel().getValueAt(row, 0).toString();
					String placa = table.getModel().getValueAt(row, 1).toString();
					Rota rota = controle.getControleRota().rotaDalhada(data, placa);
					DetalheRota detalheRota = new DetalheRota(rota);
					try {
						setClosed(true);
					} catch (PropertyVetoException e) {
						e.printStackTrace();
					}
					desktopMain.add(detalheRota);
				}
			}
		});
		btnRotaDetalhada.setBounds(211, 448, 264, 40);
		desktop.add(btnRotaDetalhada);

		JLabel lblData = new JLabel("Data");
		lblData.setForeground(Color.WHITE);
		lblData.setBounds(65, 28, 48, 23);
		desktop.add(lblData);

		JLabel lblMotorista = new JLabel("Motorista");
		lblMotorista.setForeground(Color.WHITE);
		lblMotorista.setBounds(300, 29, 66, 23);
		desktop.add(lblMotorista);
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
				modeloTable.addRow(new Object[] { rota.getDataExecucao(), rota.getVeiculo().getPlaca() });
			}
		}
	}
}
