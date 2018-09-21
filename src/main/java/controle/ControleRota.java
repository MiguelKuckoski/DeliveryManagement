package controle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

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

import entidade.Pacote;
import entidade.Veiculo;
import util.FileConstants;

public class ControleRota {
	static final String PATH = "C:\rotas";
	final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public void criarRota(HashSet<Veiculo> veiculos, HashSet<Pacote> pacotes) {

		LocalDateTime now = LocalDateTime.now();
		String data = dtf.format(now);

		pacotes.stream().sorted(Comparator.comparing(Pacote::getDataInsercao).reversed());
		veiculos.stream().sorted(Comparator.comparing(Veiculo::getTamanho));

		Iterator<Pacote> pacoteIterator = pacotes.iterator();

		for (Veiculo veiculo : veiculos) {
			int i = 0;
			List<Pacote> distribuirPacote = new ArrayList<Pacote>();

			if (veiculo.getMotorista() != null) {
				while (i < veiculo.getTamanho()) {
					if (pacoteIterator.hasNext()) {
						Pacote pacote = pacoteIterator.next();
						distribuirPacote.add(pacote);
						i++;
					} else {
						break;
					}
				}
				veiculo.setListaDePacote(distribuirPacote);
			}

		}
		escreverRota(data, veiculos);

	}

	public void escreverRota(String path, HashSet<Veiculo> veiculos) {
		HSSFWorkbook wb = new HSSFWorkbook();
		FileOutputStream stream = null;

		veiculos.forEach(veiculo -> {
			populeDriverSheets(veiculo, wb);
		});

		autoSizeColumns(wb);

		try {
			stream = new FileOutputStream(path + dtf + "- rota");
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

	public HashSet<Veiculo> LerRota(FileInputStream file) {
		List<Pacote> listaPacote = new ArrayList<Pacote>();
		HashSet<Veiculo> listaVeiculo = new HashSet<Veiculo>();
		Workbook workBook = null;
		Sheet sheet = null;

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

		Veiculo veiculo = new Veiculo();
		for (int i = 0; i < workBook.getNumberOfSheets() - 1; i++) {
			sheet = workBook.getSheetAt(i); // L� somente a primeira aba do documento.
			veiculo = new Veiculo();
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				if (row.getRowNum() == 0)
					continue;

				Pacote pacote = new Pacote();
				veiculo.setPlaca(row.getCell(FileConstants.PLACA).getStringCellValue());
				pacote.setDataInsercao(row.getCell(FileConstants.ID_INSERCAO).getStringCellValue());
				pacote.setCodLocalizador(row.getCell(FileConstants.RASTREIO).getStringCellValue());
				pacote.setNomeRemetente(row.getCell(FileConstants.RASTREIO).getStringCellValue());
				pacote.setNomeDestino(row.getCell(FileConstants.NOME_DESTINO).getStringCellValue());
				pacote.setEndRemetente(row.getCell(FileConstants.ENDERECO_REMETENTE).getStringCellValue());
				pacote.setEndDestino(row.getCell(FileConstants.ENDERECO_DESTINO).getStringCellValue());
				pacote.setPeso(row.getCell(FileConstants.PESO).getNumericCellValue());
				pacote.setEntrega(
						row.getCell(FileConstants.STATUS_ENTREGA).getStringCellValue().equals("sim") ? true : false);
				pacote.setRoteirizado(true);
				listaPacote.add(pacote);
			}
			veiculo.setListaDePacote(listaPacote);
			listaVeiculo.add(veiculo);
			listaPacote.clear();
		}
		return listaVeiculo;
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
		sheet = wb.createSheet(veiculo.getPlaca());

		row = sheet.createRow(0);
		row.createCell(FileConstants.ID_INSERCAO).setCellValue("Data inser��o");
		row.createCell(FileConstants.PLACA).setCellValue("Placa");
		row.createCell(FileConstants.RASTREIO).setCellValue("Rastreio");
		row.createCell(FileConstants.NOME_REMETENTE).setCellValue("Nome remetente");
		row.createCell(FileConstants.ENDERECO_REMETENTE).setCellValue("Endere�o remetente");
		row.createCell(FileConstants.NOME_DESTINO).setCellValue("Nome destino");
		row.createCell(FileConstants.ENDERECO_DESTINO).setCellValue("Endere�o entrega");
		row.createCell(FileConstants.PESO).setCellValue("Peso");
		row.createCell(FileConstants.STATUS_ENTREGA).setCellValue("Status entrega");

		for (Pacote pacote : veiculo.getListaDePacote()) {
			row = sheet.createRow(sheet.getLastRowNum() + 1);
			row.createCell(FileConstants.ID_INSERCAO).setCellValue(pacote.getDataInsercao());
			row.createCell(FileConstants.PLACA).setCellValue(veiculo.getPlaca());
			row.createCell(FileConstants.RASTREIO).setCellValue(pacote.getCodLocalizador());
			row.createCell(FileConstants.NOME_REMETENTE).setCellValue(pacote.getNomeRemetente());
			row.createCell(FileConstants.ENDERECO_REMETENTE).setCellValue(pacote.getEndRemetente());
			row.createCell(FileConstants.NOME_DESTINO).setCellValue(pacote.getNomeDestino());
			row.createCell(FileConstants.ENDERECO_DESTINO).setCellValue(pacote.getEndDestino());
			row.createCell(FileConstants.PESO).setCellValue(pacote.getPeso());
			row.createCell(FileConstants.STATUS_ENTREGA).setCellValue("n�o");
		}
	}

}
