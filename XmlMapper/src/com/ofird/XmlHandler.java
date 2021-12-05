package com.ofird;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlHandler {
    public HashMap getObjectsFromXml(String filePath) {
        readFileLineByLine(filePath);
        
        
        
        HashMap map=new HashMap();
       /* File xml = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xml);
            Schema schema = null;
            *//**Xml validator optional*//*
            String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
            schema = schemaFactory.newSchema(xml);
            Validator validator = schema.newValidator();
            validator.validate(new DOMSource(doc));
            *//**Extract Root element *//*
            Element root = doc.getDocumentElement();
        
            
            
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return map;
    }
    
    private void readFileLineByLine(String filePath) {
        boolean isXml=filePath.contains(".xml")?true:false;
        boolean isJson=filePath.contains(".json")?true:false;
        BufferedReader reader;
        List<String> lines=new ArrayList<>();
        try {
            reader=new BufferedReader(new FileReader(filePath));
            String line=reader.readLine();
            while(line!=null){
                System.out.println(line);
                if(!line.equals("")){
                    lines.add(line);
                }
                
                line=reader.readLine();
            }
            reader.close();
            if(isXml){
                HashMap<String,Object> map=getMapFromXml(lines);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private HashMap<String, Object> getMapFromXml(List<String> lines) {
        HashMap map=new HashMap();
        Pattern pattern=Pattern.compile("<\\S*>$");
        Pattern pattern1=Pattern.compile("</\\S*>");
        List<String> tags=new ArrayList<>();
    
        for (String line:lines) {
            Matcher m=pattern.matcher(line);
            boolean isTag=m.find();
//                System.out.println(isTag);
            boolean
            if(isTag){

//                int start=m.start();
                int start=m.start();
                start+=1;
//                int end=m.end();
                int end=m.end();
                end-=1;
                System.out.println(start);
                System.out.println(end);
                String tag= line.substring(start,end);
                System.out.println("Found matching tag : "+tag);

            }
        }
        return map;
    }
}
