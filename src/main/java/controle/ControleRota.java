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
import entidade.Veiculo;
import util.FileConstants;

public class ControleRota {
	static final String PATH = "C:/rotas/";
	final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	final SimpleDateFormat fileDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

	private ControladorPrincipal controlePrincipal;

	public ControleRota(ControladorPrincipal controladorPrincipal) {
		controlePrincipal = controladorPrincipal;
	}

	public void criarRota(Map<String, Veiculo> listaVeiculo, Map<String, Pacote> listaPacote) {
		String data = dateFormat.format(new Date());

		TreeSet<Map.Entry<String, Pacote>> packageSet = new TreeSet<>(new Comparator<Map.Entry<String, Pacote>>() {
			@Override
			public int compare(Map.Entry<String, Pacote> o1, Map.Entry<String, Pacote> o2) {
				int valueComparison = o1.getValue().getDataInsercao().compareTo(o2.getValue().getDataInsercao());
				return valueComparison == 0 ? o1.getKey().compareTo(o2.getKey()) : valueComparison;
			}
		});
		packageSet.addAll(listaPacote.entrySet());
		Iterator<Entry<String, Pacote>> iteratorPackage = packageSet.iterator();

		TreeSet<Map.Entry<String, Veiculo>> vehicleSet = new TreeSet<>(new Comparator<Map.Entry<String, Veiculo>>() {
			@Override
			public int compare(Map.Entry<String, Veiculo> o1, Map.Entry<String, Veiculo> o2) {
				int valueComparison = o1.getValue().getTamanho().compareTo(o2.getValue().getTamanho());
				return valueComparison == 0 ?  valueComparison : o1.getKey().compareTo(o2.getKey());
			}
		});
		vehicleSet.addAll(listaVeiculo.entrySet());
		Iterator<Entry<String, Veiculo>> iteratorVechile = vehicleSet.iterator();

		while (iteratorVechile.hasNext()) {
			Entry<String, Veiculo> veiculo = iteratorVechile.next();
			int i = 0;
			List<Pacote> distribuirPacote = new ArrayList<>();
			if (listaVeiculo.get(veiculo.getKey()).getMotorista() != null) {
				while (i < listaVeiculo.get(veiculo.getKey()).getTamanho() && iteratorPackage.hasNext()) {
					Pacote pacote = iteratorPackage.next().getValue();
					if (!pacote.isEntrega() && !pacote.isRoteirizado()) {
						distribuirPacote.add(pacote);
						listaPacote.get(pacote.getCodLocalizador()).setRoteirizado(true);
						i++;
					}
				}
				listaVeiculo.get(veiculo.getKey()).setListaDePacote(distribuirPacote);
			}
		}
		escreverRota(data, listaVeiculo);
		controlePrincipal.getControleVeiculo().getVeiculoDAO().setListaVeiculo(listaVeiculo);
		controlePrincipal.getControleVeiculo().getVeiculoDAO().persist();
		controlePrincipal.getControlePacote().getPacoteDAO().setListaPacote(listaPacote);
		controlePrincipal.getControlePacote().getPacoteDAO().persist();
	}

	public void escreverRota(String path, Map<String, Veiculo> veiculos) {
		HSSFWorkbook wb = new HSSFWorkbook();
		FileOutputStream stream = null;

		veiculos.entrySet().forEach(veiculo -> {
			if (veiculo.getValue().getListaDePacote() != null && veiculo.getValue().getListaDePacote().size() > 0)
				populeDriverSheets(veiculo.getValue(), wb);
		});

		autoSizeColumns(wb);

		try {
			File file = new File(PATH + path + "-rota.xls");
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
		File file = new File(PATH + date);
		Workbook workBook = null;
		Sheet sheet = null;

		List<Veiculo> listaVeiculos = null;
		if (file.exists()) {

			List<Pacote> listaPacote = new ArrayList<Pacote>();
			listaVeiculos = new ArrayList<Veiculo>();
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
					controlePrincipal.getControlePacote().getPacoteDAO().listar()
							.replace(pacote.getCodLocalizador(), pacote);
				}
				veiculo.setListaDePacote(listaPacote);
				listaVeiculos.add(veiculo);
				controlePrincipal.getControleVeiculo().getVeiculoDAO().getListaVeiculo().get(veiculo.getPlaca())
						.setListaDePacote(null);

				listaPacote.clear();
			}
			controlePrincipal.getControlePacote().getPacoteDAO().persist();
			controlePrincipal.getControleVeiculo().getVeiculoDAO().persist();

			try {
				workBook.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}

		listaVeiculos.forEach(veiculo -> {
			veiculo.getListaDePacote().forEach(pacote -> {
				if (pacote.isEntrega()) {
					System.out.println("Pacote entregue: " + pacote.getCodLocalizador());
				} else {
					System.out.println("Pacote não entregue: " + pacote.getCodLocalizador());
				}
			});
		});
	}

	public void autoSizeColumns(Workbook workbook) {
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

	public void relatorioDeRoteirizacaoDiaria() {
		controlePrincipal.getControleVeiculo().getVeiculoDAO().getListaVeiculo().entrySet().forEach(veiculo -> {
			if (veiculo.getValue().getListaDePacote() != null) {
				System.out.println("placa: " + veiculo.getValue().getPlaca() + " { \n");

				veiculo.getValue().getListaDePacote().forEach(pacote -> {
					System.out.println("  rastreio: " + pacote.getCodLocalizador() + "\n");
				});
				System.out.println("}\n");
			}
		});
	}

	public void foraDaRoteirizacaoDiaria() {

		controlePrincipal.getControlePacote().getPacoteDAO().listar().entrySet().forEach(pacote -> {
			if (!pacote.getValue().isRoteirizado() && !pacote.getValue().isEntrega()) {
				System.out.println("rastreio: " + pacote.getValue().getCodLocalizador() + "\n");
			}
		});

	}

	public void pesquisaDataMotorista(String motorista, String data) {
		File searchFile = null;
		File[] files = null;
		Workbook workBook = null;
		String[] fileName = null;
		if (data.isEmpty()) {
			searchFile = new File(PATH);
			files = searchFile.listFiles();

			for (File file : files) {
				if (file.exists()) {
					fileName = file.getPath().split("/");
					try {
						workBook = WorkbookFactory.create(file);
					} catch (EncryptedDocumentException e) {
						System.err.println(e);
						e.printStackTrace();
					} catch (InvalidFormatException e) {
						System.err.println(e);
					} catch (IOException e) {
						System.err.println(e);
					}
					System.out.println("--- Rota: " + fileName[fileName.length - 1] + " ---");
					openFile(workBook, motorista);
				}
			}

		} else {
			searchFile = new File(data + "-rota.xls");
			if (searchFile.exists()) {
				try {
					workBook = WorkbookFactory.create(searchFile);
				} catch (EncryptedDocumentException e) {
					System.err.println(e);
				} catch (InvalidFormatException e) {
					System.err.println(e);
				} catch (IOException e) {
					System.err.println(e);
				}
				fileName = searchFile.getPath().split("/");
				System.out.println("--- Rota: " + fileName[fileName.length - 1] + " ---");
				openFile(workBook, motorista);

			} else {
				JOptionPane.showMessageDialog(null, "Rota inexistente pra data informada.");
			}
		}

	}

	private void openFile(Workbook workBook, String motorista) {
		Sheet sheet = null;
		if (!motorista.isEmpty()) {
			sheet = workBook.getSheet(motorista);

			if (sheet != null) {
				readFile(sheet);
			} else {
				JOptionPane.showMessageDialog(null, "O motorista " + motorista + "não possui rotas na data" + "");
			}
		} else {
			for (int i = 0; i < workBook.getNumberOfSheets(); i++) {
				sheet = workBook.getSheetAt(i);
			}

		}

	}

	private void readFile(Sheet sheet) {
		Iterator<Row> rowIterator = sheet.iterator();
		Row row = null;
		Veiculo veiculo = null;
		Motorista motorista = null;

		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			if (row.getRowNum() == 0) {
				continue;
			}

			if (motorista == null && veiculo == null) {
				motorista = new Motorista();
				veiculo = new Veiculo();
				motorista.setNome(row.getCell(FileConstants.MOTORISTA_NOME).getStringCellValue());
				motorista.setCnhNum(sheet.getSheetName());
				veiculo.setPlaca(row.getCell(FileConstants.PLACA).getStringCellValue());
				System.out.println(
						"----- MOTORISTA: " + motorista.getNome() + "Veiculo: " + veiculo.getPlaca() + "-----");
			}

			Pacote pacote = new Pacote();
			try {
				pacote.setDataInsercao(
						fileDateFormat.parse(row.getCell(FileConstants.DATA_INSERCAO).getStringCellValue()));
			} catch (ParseException e) {
				System.err.println(e.getMessage());
			}

			pacote.setCodLocalizador(row.getCell(FileConstants.RASTREIO).getStringCellValue());
			pacote.setNomeRemetente(row.getCell(FileConstants.NOME_REMETENTE).getStringCellValue());
			pacote.setNomeDestino(row.getCell(FileConstants.NOME_DESTINO).getStringCellValue());
			pacote.setEndRemetente(row.getCell(FileConstants.ENDERECO_REMETENTE).getStringCellValue());
			pacote.setEndDestino(row.getCell(FileConstants.ENDERECO_DESTINO).getStringCellValue());
			pacote.setPeso(row.getCell(FileConstants.PESO).getNumericCellValue());
			pacote.setEntrega(
					row.getCell(FileConstants.STATUS_ENTREGA).getStringCellValue().equals("sim") ? true : false);

			System.out.println("Data de inserção: " + fileDateFormat.format(pacote.getDataInsercao()) + " rastreio: "
					+ pacote.getCodLocalizador() + " Endereço de entrega: " + pacote.getNomeDestino()
					+ "status de entrega: " + (pacote.isEntrega() ? "sim" : "nao") + "\n");

		}
	}
}
