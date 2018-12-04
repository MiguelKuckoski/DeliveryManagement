package controle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import entidade.Motorista;
import entidade.Pacote;
import entidade.Rota;
import entidade.Veiculo;
import persistencia.DaoFactory;
import persistencia.idao.IPacoteDao;
import persistencia.idao.IRotaDao;
import persistencia.idao.IVeiculoDao;
import util.FileConstants;

public class ControleRota {
	private String path;
	final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	final SimpleDateFormat fileDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

	private IRotaDao rotaDao;
	private IVeiculoDao veiculoDao;
	private IPacoteDao pacoteDao;

	public ControleRota(String persistencia, String caminho) {
		this.rotaDao = DaoFactory.getRotaDao(persistencia);
		this.veiculoDao = DaoFactory.getVeiculoDAO(persistencia);
		this.pacoteDao = DaoFactory.getPacoteDAO(persistencia);
		this.path = caminho;
	}

	public void criarRota() {
		String data = dateFormat.format(new Date());

		Map<String, Veiculo> listaVeiculo = veiculoDao.listar();
		Map<String, Pacote> listaPacote = pacoteDao.listar();
		TreeSet<Map.Entry<String, Pacote>> packageSet = new TreeSet<>(new Comparator<Map.Entry<String, Pacote>>() {
			@Override
			public int compare(Map.Entry<String, Pacote> o1, Map.Entry<String, Pacote> o2) {
				int valueComparison = o1.getValue().getDataInsercao().compareTo(o2.getValue().getDataInsercao());
				return valueComparison == 0 ? o1.getKey().compareTo(o2.getKey()) : valueComparison;
			}
		});
		TreeSet<Map.Entry<String, Veiculo>> vehicleSet = new TreeSet<>(new Comparator<Map.Entry<String, Veiculo>>() {
			@Override
			public int compare(Map.Entry<String, Veiculo> o1, Map.Entry<String, Veiculo> o2) {
				int valueComparison = o1.getValue().getTamanho().compareTo(o2.getValue().getTamanho());
				return valueComparison == 0 ? valueComparison : o1.getKey().compareTo(o2.getKey());
			}
		});
		packageSet.addAll(listaPacote.entrySet());
		vehicleSet.addAll(listaVeiculo.entrySet());

		Iterator<Entry<String, Veiculo>> iteratorVechile = vehicleSet.iterator();
		Iterator<Entry<String, Pacote>> iteratorPackage = packageSet.iterator();
		List<Rota> rotas = new ArrayList<>();
		while (iteratorVechile.hasNext()) {
			Entry<String, Veiculo> veiculo = iteratorVechile.next();
			int i = 0;
			List<Pacote> distribuirPacote = new ArrayList<>();
			Rota rota = new Rota();
			if (listaVeiculo.get(veiculo.getKey()).getMotorista() != null) {
				while (i < listaVeiculo.get(veiculo.getKey()).getTamanho() && iteratorPackage.hasNext()) {
					Pacote pacote = iteratorPackage.next().getValue();
					if (!pacote.isEntrega() && !pacote.isRoteirizado()) {
						distribuirPacote.add(pacote);
						pacote.setRoteirizado(true);
						pacoteDao.atualizar(pacote, pacote.getCodLocalizador());
						i++;
					}
				}
				listaVeiculo.get(veiculo.getKey()).setListaDePacote(distribuirPacote);
				rota.setDataExecucao(data);
				rota.setVeiculo(listaVeiculo.get(veiculo.getKey()));
				rotas.add(rota);
			}
		}
		escreverRota(data, listaVeiculo);
		rotaDao.inserir(rotas);
		
		JOptionPane.showMessageDialog(null, "Rota criada com sucesso em: " + path, "Rota", JOptionPane.INFORMATION_MESSAGE);
	}

	private void escreverRota(String data, Map<String, Veiculo> veiculos) {
		HSSFWorkbook wb = new HSSFWorkbook();
		FileOutputStream stream = null;

		veiculos.entrySet().forEach(veiculo -> {
			if (veiculo.getValue().getListaDePacote() != null && veiculo.getValue().getListaDePacote().size() > 0)
				populeDriverSheets(veiculo.getValue(), wb);
		});

		autoSizeColumns(wb);

		try {
			File file = new File(path + data + "-rota.xls");
			stream = new FileOutputStream(file);
			wb.write(stream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				wb.close();
				stream.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void LerRota(String date) {
		File file = new File(path + date+ "-rota.xls");
		Workbook workBook = null;
		Sheet sheet = null;
		List<Pacote> listaPacote = new ArrayList<Pacote>();

		if (file.exists()) {
			Veiculo veiculo = new Veiculo();

			/******** Open File ********/
			try {
				workBook = WorkbookFactory.create(file);
			} catch (EncryptedDocumentException e1) {
				e1.printStackTrace();
			} catch (InvalidFormatException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			/******** Select sheet ********/

			for (int i = 0; i < workBook.getNumberOfSheets(); i++) {
				sheet = workBook.getSheetAt(i);
				veiculo = new Veiculo();
				Motorista motorista = new Motorista();

				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					if (row.getRowNum() == 0)
						continue;
					Pacote pacote = new Pacote();
					try {
						pacote.setDataInsercao(
								fileDateFormat.parse(row.getCell(FileConstants.DATA_INSERCAO).getStringCellValue()));
					} catch (ParseException e) {
						System.err.println(e.getMessage());
					}

					veiculo.setPlaca(row.getCell(FileConstants.PLACA).getStringCellValue());
					pacote.setCodLocalizador(row.getCell(FileConstants.RASTREIO).getStringCellValue());
					motorista.setNome(row.getCell(FileConstants.MOTORISTA_NOME).getStringCellValue());
					motorista.setCnhNum(sheet.getSheetName());
					pacote.setNomeRemetente(row.getCell(FileConstants.NOME_REMETENTE).getStringCellValue());
					pacote.setNomeDestino(row.getCell(FileConstants.NOME_DESTINO).getStringCellValue());
					pacote.setEndRemetente(row.getCell(FileConstants.ENDERECO_REMETENTE).getStringCellValue());
					pacote.setEndDestino(row.getCell(FileConstants.ENDERECO_DESTINO).getStringCellValue());
					pacote.setPeso(row.getCell(FileConstants.PESO).getNumericCellValue());
					pacote.setEntrega(
							row.getCell(FileConstants.STATUS_ENTREGA).getStringCellValue().equals("sim") ? true
									: false);
					pacote.setRoteirizado(false);
					listaPacote.add(pacote);
					veiculo.setMotorista(motorista);
					pacoteDao.atualizar(pacote, pacote.getCodLocalizador());
				}
				veiculo.setListaDePacote(null);
				veiculoDao.atualizar(veiculo.getPlaca(), veiculo);
			}
			
			String baixas = "codigo - Status \n";
			
			for (Pacote pacote : listaPacote) {
				baixas += pacote.getCodLocalizador() +  " - " ;
				baixas += pacote.isEntrega()? "Pacote entregue \n" : "Pacote não entregue \n";
			}
			 
			 JOptionPane.showMessageDialog(null, baixas, "BAIXAS", JOptionPane.INFORMATION_MESSAGE);
			try {
				workBook.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}else {
			JOptionPane.showMessageDialog(null, "File not found", "Rota", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void autoSizeColumns(Workbook workbook) {
		int numberOfSheets = workbook.getNumberOfSheets();
		for (int i = 0; i < numberOfSheets; i++) {
			Sheet sheet = workbook.getSheetAt(i);
			if (sheet.getPhysicalNumberOfRows() > 0) {
				Row row = sheet.getRow(0);
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					int columnIndex = cell.getColumnIndex();
					sheet.autoSizeColumn(columnIndex);
				}
			}
		}
	}

	public Map<String, List<Rota>> pesquisaDataMotorista(String motorista, String data) {
		if (motorista.trim().isEmpty()) {
			motorista = null;
		}
		if (data.trim().isEmpty()) {
			data = null;
		}

		return rotaDao.pesquisar(motorista, data);
	}

	private void populeDriverSheets(Veiculo veiculo, HSSFWorkbook wb) {
		HSSFSheet sheet = null;
		HSSFRow row = null;
		sheet = wb.createSheet(veiculo.getMotorista().getCnhNum());

		row = sheet.createRow(0);
		row.createCell(FileConstants.DATA_INSERCAO).setCellValue("Data inserção");
		row.createCell(FileConstants.PLACA).setCellValue("Placa");
		row.createCell(FileConstants.MOTORISTA_NOME).setCellValue("Motorista");
		row.createCell(FileConstants.RASTREIO).setCellValue("Rastreio");
		row.createCell(FileConstants.NOME_REMETENTE).setCellValue("Nome remetente");
		row.createCell(FileConstants.ENDERECO_REMETENTE).setCellValue("Endereço remetente");
		row.createCell(FileConstants.NOME_DESTINO).setCellValue("Nome destino");
		row.createCell(FileConstants.ENDERECO_DESTINO).setCellValue("Endereço entrega");
		row.createCell(FileConstants.PESO).setCellValue("Peso");
		row.createCell(FileConstants.STATUS_ENTREGA).setCellValue("Status entrega");

		for (Pacote pacote : veiculo.getListaDePacote()) {
			row = sheet.createRow(sheet.getLastRowNum() + 1);
			row.createCell(FileConstants.DATA_INSERCAO).setCellValue(fileDateFormat.format(pacote.getDataInsercao()));
			row.createCell(FileConstants.PLACA).setCellValue(veiculo.getPlaca());
			row.createCell(FileConstants.MOTORISTA_NOME).setCellValue(veiculo.getMotorista().getNome());
			row.createCell(FileConstants.RASTREIO).setCellValue(pacote.getCodLocalizador());
			row.createCell(FileConstants.NOME_REMETENTE).setCellValue(pacote.getNomeRemetente());
			row.createCell(FileConstants.ENDERECO_REMETENTE).setCellValue(pacote.getEndRemetente());
			row.createCell(FileConstants.NOME_DESTINO).setCellValue(pacote.getNomeDestino());
			row.createCell(FileConstants.ENDERECO_DESTINO).setCellValue(pacote.getEndDestino());
			row.createCell(FileConstants.PESO).setCellValue(pacote.getPeso());
			row.createCell(FileConstants.STATUS_ENTREGA).setCellValue("não");
		}
	}

	public Rota rotaDalhada(String data, String placa) {
		return rotaDao.rotaDetalhada(data, placa);
	}
}
