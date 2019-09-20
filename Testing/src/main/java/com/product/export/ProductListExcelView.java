package com.product.export;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.product.model.Products;
import com.products.utils.ProductSorting;

@SuppressWarnings("deprecation")
public class ProductListExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workBook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("ContentDisposition", "attachment; filename=\"my-xls-file.xls\"");
		@SuppressWarnings("unchecked")

		// Create excel sheet
		Sheet sheet = workBook.createSheet("List Of Mobile Products");
		// Create Row
		setExcelHearder(sheet);
		List<Products> products = (List<Products>) model.get("listOfProducts");
//		Collections.sort(products,ProductSorting.sortProductName);		 
		setExcelRows(sheet, products);
	}

	private void setExcelRows(Sheet sheet, List<Products> products) {
		// create Data
		int rowCount = 1;
		for (Products product : products) {
			Row productRow = sheet.createRow(rowCount++);
			productRow.createCell(0).setCellValue(product.getProductId());
			productRow.createCell(1).setCellValue(product.getProductName());
			productRow.createCell(2).setCellValue(product.getProductModel());
			productRow.createCell(3).setCellValue(product.getProductPrize());
			productRow.createCell(4).setCellValue(product.getProductYear());
			productRow.createCell(5).setCellValue(product.getProductWarrenty());

		}
	}
	private void sortRows(List<Products>products){
		
	}

	private void setExcelHearder(Sheet sheet) {
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("ProductId");
		header.createCell(1).setCellValue("ProductName");
		header.createCell(2).setCellValue("ProductModel");
		header.createCell(3).setCellValue("ProductPrize");
		header.createCell(4).setCellValue("ProductYear");
		header.createCell(5).setCellValue("ProductWarrenty");

	}

}
