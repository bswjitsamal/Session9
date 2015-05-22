package com.webtek.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Excelutils {

	private static Excelutils excelUtils = new Excelutils();

	private Excelutils() {

	}

	public static Excelutils getInstance() {

		return excelUtils;
	}

	public Object[][] readData(String workbook, int sheet) throws IOException {
		Object[][] data = new Object[0][0];

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(
				new File(workbook)));
		HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheet);

		Row headerRow = hssfSheet.getRow(0);
		StringBuffer headerStringBuffer = new StringBuffer("WorkBook Header\n");
		for (Iterator<Cell> iterator = headerRow.iterator(); iterator.hasNext();) {
			Cell cell = (Cell) iterator.next();
			headerStringBuffer.append(cell + "|");
		}

		System.out.println(headerStringBuffer);

		int maxRowNum = hssfSheet.getLastRowNum();
		int maxCellNum = headerRow.getLastCellNum();

		data = new Object[maxRowNum][maxCellNum];
		StringBuffer dataStringBuffer = new StringBuffer("WorkBook Data\n");

		for (int row = 1; row <= maxRowNum; row++) {

			dataStringBuffer.append("\n");
			for (int cell = 0; cell < maxCellNum; cell++) {
				Object cellValue = hssfSheet.getRow(row).getCell(cell);

				dataStringBuffer.append(cellValue.toString() + "|");

				data[row - 1][cell] = cellValue.toString();
				System.out.println("The data are : Row :" + (row - 1)
						+ "   Col: " + cell + "   : " + cellValue.toString());

			}

		}
		return data;

	}

}
