package com.innovationinc.servlet;

import com.innovationinc.utility.MultipartUtility;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


/**
 * Created by alok on 6/11/2016.
 */
@MultipartConfig
public class ImageUploadServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        String charset = "UTF-8";
        String requestURL = "http://localhost:8082/image/upload";

        try {
            MultipartUtility multipart = new MultipartUtility(requestURL, charset);

            multipart.addHeaderField("User-Agent", "CodeJava");




        Collection<Part> parts = request.getParts();
        /*Stream<Part> partStream = parts.stream();

        List<Part> images = (List<Part>) partStream.filter(item -> item.getName().equals("data"));
        List<Part> imageType = (List<Part>) partStream.filter(item -> item.getName().equals("imageType"));
*/
       // Part[] partsArray = (Part[]) parts.toArray();
        Iterator<Part> i = parts.iterator();
        while (i.hasNext())
        {
            Part thePart = i.next();
            if(thePart.getName().equals("imageType"))
            {
                multipart.addFormField(thePart.getName(), "USER_PHOTO");
            }else
            {
                multipart.addFilePart(thePart.getName(), thePart.getInputStream());
            }
        }

        List<String> responseList = multipart.finish();
            System.out.println("SERVER REPLIED:");
            for (String line : responseList) {
                System.out.println(line);
            }


        } catch (IOException ex) {
            System.err.println(ex);
        }




    }

    private void handleImage(Part thePart) {

    }

    private void handleText(Part thePart) {
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

    }
}
