package controle;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
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
	static final String PATH = "";
	final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public void criarRota() {
		   LocalDateTime now = LocalDateTime.now();  
		   String data = dtf.format(now);
		
		exportarRota(data);
	}
	
	public void exportarRota(String data) {

		File file = new File(path);
		Workbook wb = null;
		FileOutputStream stream = null;
		FileInputStream inputFile = null;
		Sheet sheet = null;

		if (file.exists()) {
			try {
				inputFile = new FileInputStream(file);
				wb = WorkbookFactory.create(inputFile);
			} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
				e.printStackTrace();
			}

			sheet = wb.getSheetAt(0);

		} else {
			wb = new HSSFWorkbook();
			sheet = (HSSFSheet) wb.createSheet("Plan");
			createHeader((HSSFSheet) sheet);
		}
		
		
		populeMainSheet(list, (HSSFSheet) sheet);
		populeDriverSheets(list, (HSSFWorkbook) wb);
		autoSizeColumns(wb);
		
		try {
			if(inputFile != null) {
				inputFile.close();				
			}
			stream = new FileOutputStream(path);
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

	public HashSet<Veiculo> importarRota(FileInputStream file) {
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
		sheet = workBook.getSheetAt(0); // Lê somente a primeira aba do documento.

		/******** Read file ********/
		Iterator<Row> rowIterator = sheet.iterator();
		
		Veiculo veiculo = new Veiculo();
		
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			if (row.getRowNum() == 0)
				continue;
			
			Pacote pacote = new Pacote();
			String placa = row.getCell(FileConstants.PLACA).getStringCellValue();
			pacote.setIdInsercao((int) row.getCell(FileConstants.ID_INSERCAO).getNumericCellValue());
			pacote.setCodLocalizador(row.getCell(FileConstants.RASTREIO).getStringCellValue());
			pacote.setNomeRemetente(row.getCell(FileConstants.RASTREIO).getStringCellValue());
			pacote.setNomeDestino(row.getCell(FileConstants.NOME_DESTINO).getStringCellValue());
			pacote.setEndRemetente(row.getCell(FileConstants.ENDERECO_REMETENTE).getStringCellValue());
			pacote.setEndDestino(row.getCell(FileConstants.ENDERECO_DESTINO).getStringCellValue());
			pacote.setPeso(row.getCell(FileConstants.PESO).getNumericCellValue());
			pacote.setEntrega(row.getCell(FileConstants.STATUS_ENTREGA).getStringCellValue().equals("sim") ? true : false);
			pacote.setRoteirizado(true);
			
			if(veiculo.getPlaca() == null){
				veiculo.setPlaca(placa);
				
			}else if(veiculo.getPlaca() != placa) {
				
				veiculo.setListaDePacote((Pacote[]) listaPacote.toArray());
				listaVeiculo.add(veiculo);
				veiculo = new Veiculo();
				veiculo.setPlaca(placa);
				listaPacote.clear();
			}
			
			listaPacote.add(pacote);
		}
		
		return listaVeiculo;
	}

	private void createHeader(HSSFSheet plan1) {
		HSSFRow row = plan1.createRow(0);
		row.createCell(FileConstants.ID_INSERCAO).setCellValue("Id inserção");
		row.createCell(FileConstants.PLACA).setCellValue("Placa");
		row.createCell(FileConstants.RASTREIO).setCellValue("Rastreio");
		row.createCell(FileConstants.NOME_REMETENTE).setCellValue("Nome remetente");
		row.createCell(FileConstants.ENDERECO_REMETENTE).setCellValue("Endereço remetente");
		row.createCell(FileConstants.NOME_DESTINO).setCellValue("Nome destino");
		row.createCell(FileConstants.ENDERECO_DESTINO).setCellValue("Endereço entrega");
		row.createCell(FileConstants.PESO).setCellValue("Peso");
		row.createCell(FileConstants.STATUS_ENTREGA).setCellValue("Status entrega");
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

	private void populeDriverSheets(List<RouteImport> list, HSSFWorkbook wb) {
		HSSFSheet sheet = null;
		HSSFRow row = null;
		for (int i = 0; i < list.size(); i++) {
			sheet = wb.getSheet(list.get(i).getDriver());
			if (sheet == null) {
				sheet = wb.createSheet((list.get(i).getDriver()));
				createHeader(sheet);
			}
			row = sheet.createRow(i);
		}
	}
	
	private void populeDriverSheets(List<RouteImport> list, HSSFWorkbook wb) {
		HSSFSheet sheet = null;
		HSSFRow row = null;
		for (int i = 0; i < list.size(); i++) {
			sheet = wb.getSheet(list.get(i).getDriver());
			if (sheet == null) {
				sheet = wb.createSheet((list.get(i).getDriver()));
				createHeader(sheet);
			}
			row = sheet.createRow(sheet.getLastRowNum() + 1);
			row.createCell(APConstantsImportWaybill.DRIVER).setCellValue(list.get(i).getDriver());
		}
	}
	
	
}
