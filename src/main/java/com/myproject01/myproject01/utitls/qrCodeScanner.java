package com.myproject01.myproject01.utitls;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.myproject01.myproject01.dto.ProductDTO;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class qrCodeScanner {


    public static void generateQRCode(ProductDTO productDTO) throws Exception {
        String qrCodePath = "C:\\Users\\PC\\Downloads\\myproject01\\QRCode\\";
        String qrCodeName = qrCodePath+productDTO.getProducttitle()+productDTO.getProductId()+"-QRCODE.png";
        var qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                "ID: "+productDTO.getProductId() +"\n"+
                        "Product Title: "+productDTO.getProducttitle()+ "\n"+
                        "Product Price: "+productDTO.getProductPrice()+"\n"+
                        "Product Discription "+productDTO.getProductDescription()+ "\n" +
                        "Stock: "+productDTO.isInStock(), BarcodeFormat.QR_CODE, 400, 400);
        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }
}
