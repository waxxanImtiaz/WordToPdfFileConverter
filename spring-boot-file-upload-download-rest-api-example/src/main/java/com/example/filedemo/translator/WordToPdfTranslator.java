package com.example.filedemo.translator;

import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;
import org.apache.pdfbox.pdmodel.PDDocument;

import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.fit.pdfdom.PDFDomTree;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;



@Component
public class WordToPdfTranslator {

    @Value("${file.upload-dir}")
    private String pdfFilePath;

    private final Path root = Paths.get("uploads");
    public void wordToPdf(MultipartFile multipartFile, Path targetLocation, String fileName) {

        File inputWord = new File(pdfFilePath+"/"+fileName);
        File outputFile = new File(pdfFilePath+"/Test_out.pdf");
        try  {
            InputStream docxInputStream = new FileInputStream(inputWord);
            OutputStream outputStream = new FileOutputStream(outputFile);
            IConverter converter = LocalConverter.builder().build();
            converter.convert(docxInputStream).as(DocumentType.DOCX).to(outputStream).as(DocumentType.PDF).execute();
            outputStream.close();
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
