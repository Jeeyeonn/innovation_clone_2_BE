package com.innovation.innovation_clone_be.Product.Controller;

import com.innovation.innovation_clone_be.Product.Dto.ProductDto;
import com.innovation.innovation_clone_be.Product.Entity.Product;
import com.innovation.innovation_clone_be.Product.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
//import org.apache.commons.io.FilenameUtils;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/excel")
    public String main() { // 1
        return "excel";
    }

    /*

    @PostMapping("/excel/read")
    public String readExcel(@RequestParam("file") MultipartFile file)
            throws IOException { // 2

        List<Product> dataList = new ArrayList<>();

        String extension = FilenameUtils.getExtension(file.getOriginalFilename()); // 3

        if (!extension.equals("xlsx") && !extension.equals("xls")) {
            throw new IOException("엑셀파일만 업로드 해주세요.");
        }

        Workbook workbook = null;

        if (extension.equals("xlsx")) {
            workbook = new XSSFWorkbook(file.getInputStream());
        } else if (extension.equals("xls")) {
            workbook = new HSSFWorkbook(file.getInputStream());
        }

        Sheet worksheet = workbook.getSheetAt(0);

        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) { // 4

            Row row = worksheet.getRow(i);

            Product data = new Product();

            data.setName(row.getCell(0).getStringCellValue());
            data.setContent(row.getCell(1).getStringCellValue());
            data.setPrice(Integer.parseInt(row.getCell(2).getStringCellValue()));
            data.setImg1(row.getCell(3).getStringCellValue());
            data.setImg2(row.getCell(4).getStringCellValue());
            data.setCartNum(Integer.parseInt(row.getCell(5).getStringCellValue()));

            dataList.add(data);
        }

        //model.addAttribute("datas", dataList); // 5

        return "excelList";

    }

     */

    @PostMapping("/add")
    public void postppp(@RequestBody ProductDto p){
        Product product = new Product(p);
        productRepository.save(product);
    }
}