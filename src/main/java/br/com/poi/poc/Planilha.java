package br.com.poi.poc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 *
 * @author signorette
 */

public class Planilha {

	private final HSSFWorkbook wb;
	private final HSSFSheet sheet;

	public Planilha(final String nome) {
		wb = new HSSFWorkbook();
		sheet = wb.createSheet(nome);


	}


	public void adicionarCorCelula(final Integer linha, final Integer coluna, final byte[] cor) {
		HSSFRow row = sheet.getRow(linha);
		if (row == null) {
			row = sheet.createRow(linha);
		}

		final HSSFCell cell = row.createCell(coluna);
		final HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setFillForegroundColor(setColor(wb, cor[0], cor[1], cor[2]).getIndex());
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cell.setCellStyle(cellStyle);



	}


	public HSSFColor setColor(final HSSFWorkbook workbook, final byte r, final byte g, final byte b) {
		final HSSFPalette palette = workbook.getCustomPalette();
		HSSFColor hssfColor = null;
		try {
			hssfColor = palette.findColor(r, g, b);
			if (hssfColor == null) {
				palette.setColorAtIndex(HSSFColor.LAVENDER.index, r, g, b);
				hssfColor = palette.getColor(HSSFColor.LAVENDER.index);
			}
		} catch (final Exception e) {
			System.out.println(e.getMessage());
		}

		return hssfColor;
	}

	public File getArquivo() {
		final File arquivo = new File("/home/signorette/arquivo.xls");
		FileOutputStream outPut;
		try {
			outPut = new FileOutputStream(arquivo);
			wb.write(outPut);
		} catch (final IOException e) {
			e.printStackTrace();
		}

		return arquivo;
	}

}
