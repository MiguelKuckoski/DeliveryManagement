package apresentacao;

import java.awt.Color;
import java.awt.Font;
import java.beans.PropertyVetoException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import entidade.Pacote;
import entidade.Rota;

public class DetalheRota extends JInternalFrame {
	private JTable tablePacotes;
	private JTable tableMotorista;
	private JTable tableVeiculo;
	Rota rota;

	/**
	 * Create the frame.
	 * 
	 * @param rota
	 * @throws PropertyVetoException
	 */

	public DetalheRota(Rota rota) {
		this.rota = rota;
		try {
			initialize();
			this.setVisible(true);
			populeTables();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	public void initialize() throws PropertyVetoException {
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

		tablePacotes = new JTable();
		tablePacotes.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Entrega confirmada",
				"Codigo localizador", "Peso", "Nome destinatario", "Nome remetente" }));
		scrollPane.setViewportView(tablePacotes);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 320, 709, 71);
		desktopPane.add(scrollPane_1);

		tableMotorista = new JTable();
		tableMotorista.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Tipo CNH", "CNH" }));
		scrollPane_1.setViewportView(tableMotorista);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 453, 709, 71);
		desktopPane.add(scrollPane_2);

		tableVeiculo = new JTable();
		tableVeiculo.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Modelo", "Tipo", "Placa" }));
		scrollPane_2.setViewportView(tableVeiculo);
		getContentPane().setLayout(null);
		setBounds(100, 100, 780, 573);
	}

	private void populeTables() {
		DefaultTableModel modelTablePacote = (DefaultTableModel) tablePacotes.getModel();
		DefaultTableModel modelTableMotorista = (DefaultTableModel) tableMotorista.getModel();
		DefaultTableModel modelTableVeiculo = (DefaultTableModel) tableVeiculo.getModel();

		for (Pacote pacote : rota.getVeiculo().getListaDePacote()) {
			modelTablePacote.addRow(new Object[] { pacote.isEntrega() ? "Sim" : "Não", pacote.getCodLocalizador(),
					pacote.getPeso(), pacote.getNomeDestino(), pacote.getNomeRemetente() });
		}
		modelTableVeiculo.addRow(new Object[] { rota.getVeiculo().getModelo(), rota.getVeiculo().getTipo(),
				rota.getVeiculo().getPlaca() });
		modelTableMotorista.addRow(new Object[] { rota.getVeiculo().getMotorista().getNome(),
				rota.getVeiculo().getMotorista().getCnhTipo(), rota.getVeiculo().getMotorista().getCnhNum() });

	}

}
