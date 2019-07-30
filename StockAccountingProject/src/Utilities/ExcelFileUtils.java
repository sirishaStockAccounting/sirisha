package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelFileUtils 

{
	private static final int row = 0;
	Workbook wb;
	public ExcelFileUtils() throws Throwable
	{
		FileInputStream fis = new FileInputStream("D:\\Sirisha\\StockAccountingProject\\TestInputs\\InputSheet.xlsx");
		
		
		wb = WorkbookFactory.create(fis);
	
}
public int rowCount(String sheetname)
{
	return wb.getSheet(sheetname).getLastRowNum();
	}
//column count
public int colCount(String sheetname,int row) 
{
	return wb.getSheet(sheetname).getRow(row).getLastCellNum();
}
//rea
public String getData(String sheetname,int row,int column)
{
	String data="";
	
		if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
		int Celldata = (int)wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
		data = String.valueOf(Celldata);
	}
	else
	{
		data= wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	
	
	}

	return data;
}
// store data
	public void setData(String sheetname,int row,int column,String Status) throws IOException

	{
      Sheet sh = wb.getSheet(sheetname);
	Row rownum = sh.getRow(row);
	Cell cell = rownum.createCell(column);
	cell.setCellValue(Status);
	if(Status.equalsIgnoreCase("PASS"))
	{
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setColor(IndexedColors.GREEN.getIndex());
		font.setBold(true);
		style.setFont(font);
		rownum.getCell(column).setCellStyle(style);
	}else
		if(Status.equalsIgnoreCase("FAIL"))
		{
			CellStyle style = wb.createCellStyle();
	Font font = wb.createFont();
	font.setColor(IndexedColors.RED.getIndex());
	font.setBold(true);
	style.setFont(font);
	rownum.getCell(column).setCellStyle(style);
	}else
	if(Status.equalsIgnoreCase("NOTEXCUTED"))
	{
		CellStyle style = wb.createCellStyle();
	Font font = wb.createFont();
	font.setColor(IndexedColors.BLUE.getIndex());
	font.setBold(true);
	style.setFont(font);
	rownum.getCell(column).setCellStyle(style);
	
}
	FileOutputStream fos = new FileOutputStream("D:\\Sirisha\\StockAccountingProject\\TestOutPut\\OutPutSheet.xlsx");
	wb.write(fos);
	fos.close();
	}


}






