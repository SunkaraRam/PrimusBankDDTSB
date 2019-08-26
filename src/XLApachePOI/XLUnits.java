package XLApachePOI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUnits {
	
	public static FileInputStream fi;
	
	public static Workbook wb;
	
	public static Sheet ws;

	public static Row row;
	
	public static Cell cell;
	
	public static CellStyle style;
	
	public static FileOutputStream fo;
	
	
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		
		fi = new FileInputStream(xlfile);
		
		wb = new XSSFWorkbook(fi);
		
		ws = wb.getSheet(xlsheet);
		
		int rownum = ws.getLastRowNum();
		
		return rownum;		
		
	}
	
	public static int getColCount(String xlfile,String xlsheet, int rownum) throws IOException {
		
		fi = new FileInputStream(xlfile);
		
		wb = new XSSFWorkbook(fi);
		
		ws = wb.getSheet(xlsheet);
		
		row = ws.getRow(rownum);
		
		int cellcount = row.getLastCellNum();
		
		wb.close();
		
		fi.close();
		
		return cellcount;
	}
	
	public static String getCellData(String xlfile, String xlsheet, int rownum,int cellnum) throws IOException, Throwable{
	
		FileInputStream fi = new FileInputStream(xlfile);
		
		Workbook wb = WorkbookFactory.create(fi);
		
		Sheet ws = wb.getSheet(xlsheet);
		String data;
		
		if (wb.getSheet(xlsheet).getRow(rownum).getCell(cellnum).getCellType()==cell.CELL_TYPE_NUMERIC) {
			
			int vl = (int)wb.getSheet(xlsheet).getRow(rownum).getCell(cellnum).getNumericCellValue();
		
			data = String.valueOf(vl);
			
			
		} else {

			data = wb.getSheet(xlsheet).getRow(rownum).getCell(cellnum).getStringCellValue();
			
		}
		
		
		
		return data;
		
		}
	
	public static void setCellData(String xlfile,String xlsheet, int rownum,int colnum,String data) throws IOException {
		
		fi = new FileInputStream(xlfile);
		
		wb = new XSSFWorkbook(fi);
		
		ws = wb.getSheet(xlsheet);
		
		row = ws.getRow(rownum);
		
		cell = row.createCell(colnum);
		
		cell.setCellValue(data);
		
		fo = new FileOutputStream(xlfile);

		wb.write(fo);
		
		wb.close();
		
		fi.close();
		
		fo.close();
		
		
	}
	
	public static void fillGreenColor(String xlfile,String xlsheet, int rownum,int colnum) throws IOException {
		
		fi = new FileInputStream(xlfile);
		
		wb = new XSSFWorkbook(fi);
		
		ws = wb.getSheet(xlsheet);
		
		row = ws.getRow(rownum);
		
		cell = row.createCell(colnum);
		
		style=wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		
		fo=new FileOutputStream(xlfile);
		
		wb.write(fo);
		
		wb.close();
		
		fi.close();
	}
	
	public static void fillRedColor(String xlfile, String xlsheet, int rownum,int colnum) throws IOException 
		{
			fi = new FileInputStream(xlfile);
			
			wb = new XSSFWorkbook(fi);
			
			ws = wb.getSheet(xlsheet); 
			
			row = ws.getRow(rownum);
			
			cell = row.createCell(colnum);
			
			style = wb.createCellStyle();
			
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			cell.setCellStyle(style);
			
			fo = new FileOutputStream(xlfile);
			
			wb.write(fo);
			
			wb.close();
			
			fi.close();
			
			fo.close();
		}
	
	
	
	
	
	}
	
 

