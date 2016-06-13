package com.innovationinc.utility;


import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * This program demonstrates a usage of the MultipartUtility class.
 * @author www.codejava.net
 *
 */
public class MultipartFileUploader {

    public static void main(String[] args) {
        String charset = "UTF-8";
        File uploadFile1 = new File("C:\\personal\\PersonalData\\pictures\\smaller_profile.jpg");
        File uploadFile2 = new File("e:/Test/PIC2.JPG");
        String requestURL = "http://localhost:8082/image/upload";

        try {
            MultipartUtility multipart = new MultipartUtility(requestURL, charset);

            multipart.addHeaderField("User-Agent", "CodeJava");
            //multipart.addHeaderField("Content-Type", "multipart/form-data");
           // multipart.addHeaderField("Authorization", "session 08b6f0df-364c-4ce5-b4d8-a1f990dac689");

            multipart.addFormField("imageType", "USER_PHOTO");
           // multipart.addFormField("keywords", "Java,upload,Spring");

            multipart.addFilePart("data", uploadFile1);
           // multipart.addFilePart("fileUpload", uploadFile2);

            List<String> response = multipart.finish();

            System.out.println("SERVER REPLIED:");

            for (String line : response) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}