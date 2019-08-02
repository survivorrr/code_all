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
		//���ڴ��д���excel�ļ�(JDKû�����API������Ҫ�õ�������API����maven���������)
		Workbook workbook = new HSSFWorkbook();
		//�ڹ���������һ��������
		Sheet sheet = workbook.createSheet();
		//�ڹ������д���һ��
		Row row = sheet.createRow(0);
		//��һ���д���һ����Ԫ��
		Cell cell = row.createCell(0);
		//�ڵ�Ԫ��������ַ���
		cell.setCellValue("hello world");
		
		//������byte����
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		workbook.write(out);
		out.close();
		//������
		byte[] buf = out.toByteArray();
		excel = new ByteArrayInputStream(buf);
		return "success";
	}
}
