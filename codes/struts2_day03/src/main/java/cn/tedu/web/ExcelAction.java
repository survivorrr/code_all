package cn.tedu.web;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
@Controller
@Scope("prototype")
public class ExcelAction {
	private InputStream excel;

	public InputStream getExcel() {
		return excel;
	}

	public void setExcel(InputStream excel) {
		this.excel = excel;
	}
	
	public String execute() throws IOException{
		//在内存中创建excel文件(JDK没有这个API，所以要用第三方的API，用maven导入就行了)
		Workbook workbook = new HSSFWorkbook();
		//在工作簿创建一个工作表
		Sheet sheet = workbook.createSheet();
		//在工作表中创建一行
		Row row = sheet.createRow(0);
		//在一行中创建一个单元格
		Cell cell = row.createCell(0);
		//在单元格中添加字符串
		cell.setCellValue("hello world");
		
		//保存在byte数组
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		workbook.write(out);
		out.close();
		//返回流
		byte[] buf = out.toByteArray();
		excel = new ByteArrayInputStream(buf);
		return "success";
	}
}
