package com.springprimefaces.controller;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@ManagedBean
@RequestScoped
public class PdfGeneratorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private StreamedContent media;

    public PdfGeneratorBean() throws IOException {
        String filePath = "/midia/uml.pdf";
        Path path = null;
        try {
            path = Paths.get(getClass().getResource(filePath).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        byte[] pdfContents = Files.readAllBytes(path);
        InputStream stream = new ByteArrayInputStream(pdfContents);
        media = DefaultStreamedContent.builder()
                .name("uml.pdf")
                .contentType("application/pdf")
                .stream(() -> stream)
                .build();
    }

    public StreamedContent getMedia(){
        return media;
    }


}
