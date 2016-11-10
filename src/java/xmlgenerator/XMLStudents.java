/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlgenerator;

import java.io.ByteArrayOutputStream;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import java.sql.*;

/**
 *
 * @author A01561056
 */
public class XMLStudents {
    public String getXMLContent(){
        String xmlcontent = "";
        
        try {
            Connection conn;
           
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
           
            // root element
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("wad_course");
            doc.appendChild( rootElement );
            
            Class.forName("com.mysql.jdbc.Driver");
 
            String s =
                "jdbc:mysql://cml.chi.itesm.mx/wad?user=wad&password=p5zVDmq4IGto";
            conn = DriverManager.getConnection( s );
 
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student");
            while ( rs.next() ) {
                String i = rs.getString("id");
                String first = rs.getString("firstname");
                String last = rs.getString("lastname");
                String nick = rs.getString("nickname");
                String g = rs.getString("grade");
               
                // student element
                Element student = doc.createElement("student");
                student.setAttribute("id", i);
 
                // add student to root
                rootElement.appendChild( student );
 
                // first name
                Element firstname = doc.createElement("firstname");
                firstname.appendChild( doc.createTextNode(first) );
                student.appendChild( firstname );
 
                // last name
                Element lastname = doc.createElement("lastname");
                lastname.appendChild( doc.createTextNode( last) );
                student.appendChild( lastname );
 
                // nickname
                Element nickname = doc.createElement("nickname");
                nickname.appendChild( doc.createTextNode(nick) );
                student.appendChild( nickname );
 
                // grade
                Element grade = doc.createElement("grade");
                grade.appendChild( doc.createTextNode(g));
                student.appendChild( grade );
            }
           
           
            // write the content to String
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource( doc );
            
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            StreamResult result = new StreamResult( os );
            transformer.transform(source, result);
            xmlcontent = result.getOutputStream().toString();
           
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
        return xmlcontent;
    }
    
    public String getXLMByID(String id){
        String xmlcontent = "";
        
        try {
            Connection conn;
           
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
           
            // root element
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("wad_course");
            doc.appendChild( rootElement );
            
            Class.forName("com.mysql.jdbc.Driver");
 
            String s =
                "jdbc:mysql://cml.chi.itesm.mx/wad?user=wad&password=p5zVDmq4IGto";
            conn = DriverManager.getConnection( s );
 
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student where id = '"+ id +"'");
            while ( rs.next() ) {
                String i = rs.getString("id");
                String first = rs.getString("firstname");
                String last = rs.getString("lastname");
                String nick = rs.getString("nickname");
                String g = rs.getString("grade");
               
                // student element
                Element student = doc.createElement("student");
                student.setAttribute("id", i);
 
                // add student to root
                rootElement.appendChild( student );
 
                // first name
                Element firstname = doc.createElement("firstname");
                firstname.appendChild( doc.createTextNode(first) );
                student.appendChild( firstname );
 
                // last name
                Element lastname = doc.createElement("lastname");
                lastname.appendChild( doc.createTextNode( last) );
                student.appendChild( lastname );
 
                // nickname
                Element nickname = doc.createElement("nickname");
                nickname.appendChild( doc.createTextNode(nick) );
                student.appendChild( nickname );
 
                // grade
                Element grade = doc.createElement("grade");
                grade.appendChild( doc.createTextNode(g));
                student.appendChild( grade );
            }
           
           
            // write the content to String
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource( doc );
            
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            StreamResult result = new StreamResult( os );
            transformer.transform(source, result);
            xmlcontent = result.getOutputStream().toString();
           
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
        return xmlcontent;
    }
}
