/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author Nckey Larson
 */

import Entites.Astuces;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import Utilities.datasource;
import com.itextpdf.text.Image;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class pdf {
    

    public void creation()
    { Astuces p=new Astuces();
  
   
   Connection conn =datasource.getInstance().getConnection();
   
        
        try {

    try (OutputStream file = new FileOutputStream(new File("C:\\Users\\Nckey Larson\\Documents\\test\\testpdf.pdf"))) {
            
        Document document = new Document();
        PdfWriter.getInstance(document, file);
        document.open();
        document.add(new Paragraph(new Date().toGMTString()));
        Font bold = new Font(FontFamily.COURIER, 12, Font.NORMAL, BaseColor.GREEN);
        Font b = new Font(FontFamily.COURIER, 12, Font.NORMAL, BaseColor.DARK_GRAY);
        Paragraph paragraph = new Paragraph("SHOPETAL",bold);
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        document.add(paragraph);
        paragraph = new Paragraph("Liste des  astuces ",bold);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
        paragraph = new Paragraph("\n");
        document.add(paragraph);
        paragraph = new Paragraph(" \n");
        document.add(paragraph);
        paragraph = new Paragraph(" \n");
        document.add(paragraph);
        paragraph = new Paragraph(" \n");
        document.add(paragraph);
        paragraph = new Paragraph(" \n");
        document.add(paragraph);
        paragraph = new Paragraph(" \n");
        document.add(paragraph);
        try {
        
            String sql="SELECT * FROM astuces ORDER BY Id_Astuce DESC LIMIT 1 ";
            PreparedStatement stat=conn.prepareStatement(sql);
            ResultSet rs=stat.executeQuery();
            while(rs.next()) {
                p.setId_Astuce(rs.getInt(1));
                p.setTitre_Astuce(rs.getString(2));
                p.setType_Astuce(rs.getString(3));
                p.setDesc_Astuce(rs.getString(4));
                p.setImage_Astuce("http://127.0.0.1/images/" + rs.getString(5));
                
               
            }
            Image image1 = Image.getInstance(p.getImage_Astuce());
            paragraph = new Paragraph(p.toString(),b);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            paragraph.setIndentationLeft(50);
            document.add(paragraph);
            document.add(image1);
            
            
        }
    
        catch (Exception ex)
        {System.out.println(ex);
        System.out.println("non!");}
        paragraph = new Paragraph("\n");
        document.add(paragraph);
        paragraph = new Paragraph(" \n");
        document.add(paragraph);
        paragraph = new Paragraph(" \n");
        document.add(paragraph);
        paragraph = new Paragraph(" \n");
        document.add(paragraph);
        paragraph = new Paragraph(" \n");
        document.add(paragraph);
        paragraph = new Paragraph(" \n");
        document.add(paragraph);
        paragraph = new Paragraph("\n");
        document.add(paragraph);
        paragraph = new Paragraph(" \n");
        document.add(paragraph);
        paragraph = new Paragraph(" \n");
        document.add(paragraph);
        paragraph = new Paragraph(" \n");
        document.add(paragraph);
        paragraph = new Paragraph(" \n");
        document.add(paragraph);
        paragraph = new Paragraph(" \n");
        document.add(paragraph);
        paragraph = new Paragraph("Responsable astuce",bold);
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        document.add(paragraph);
        paragraph = new Paragraph("ahmed abidi",b);
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        document.add(paragraph);
        document.close();
             
            
        }

        } catch (Exception e) {
            System.out.println("bbbbbbbbbbbbbbbbbb");


            e.printStackTrace();

        }

    }

    }




   


    



