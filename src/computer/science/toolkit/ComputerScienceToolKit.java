/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer.science.toolkit;

import computer.science.toolkit.toolbox.FloatingPointInterpreter;
import computer.science.toolkit.toolbox.BaseConversionsInterpreter;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author MLH-Admin
 */
public class ComputerScienceToolKit {

    /**
     * @param args the command line arguments
     */
    
    public static ClassList classl;
    
    public static void main(String[] args) {
        // TODO code application logic here
        //if(true){
            
            try {
                File classlist = new File("ClassListings\\Spring2016UCMerced.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(classlist);

                doc.getDocumentElement().normalize();

                //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

                NodeList nList = doc.getElementsByTagName("meta");

                //System.out.println("----------------------------" + nList.getLength());

                for (int temp = 0; temp < nList.getLength(); temp++) {

                    Node nNode = nList.item(temp);

                    //System.out.println("\nCurrent Element :" + nNode.getNodeName());

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

                        classl = new ClassList(eElement.getElementsByTagName("school").item(0).getTextContent(), eElement.getElementsByTagName("semester").item(0).getTextContent(), Integer.parseInt(eElement.getElementsByTagName("numberofclasses").item(0).getTextContent()));

                    }
                }
                
                nList = doc.getElementsByTagName("class");
                
                String cName;
                String sName;
                String sText;
                int sNum;
                NodeList sugs;
                
                for (int temp = 0; temp < nList.getLength(); temp++) {

                    Node nNode = nList.item(temp);

                    //System.out.println("\nCurrent Element :" + nNode.getNodeName());

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
                        
                        cName = eElement.getAttribute("name");
                        //System.out.println(cName);
                        
                        sNum = Integer.parseInt(eElement.getAttribute("suggestions"));
                        
                        classl.addClass(temp, cName, sNum);
                        
                        sugs = nNode.getChildNodes();
                        //sugs = nNode.
                                
                        //System.out.println("cName " + cName + " suggestions " + sNum + " sugs number " + sugs.getLength());
                        int manualIndex = 0;
                        for(int j = 0; j < sugs.getLength(); j++){
                            Node currSug = sugs.item(j);
                            //System.out.println(currSug.getTextContent());
                            if (currSug.getNodeType() == Node.ELEMENT_NODE && currSug.getNodeName().equals("suggestion") && manualIndex < sNum) {

                                Element tElement = (Element) currSug;
                                
                                sName = tElement.getAttribute("name");
                                //System.out.println(sName);
                                sText = currSug.getTextContent();
                                //sText = tElement.getElementsByTagName("suggestion").item(0).getTextContent();
                                classl.cl[temp].add(manualIndex, sName, sText);//.getSuggestion(j) = new Suggestion(sName, sText);
                                manualIndex++;
                                //classl.addClass(temp, cName, sNum, sName, sText);
                                //System.out.println(manualIndex);
                            }
                            
                            
                        }
                         //= new ClassList(eElement.getElementsByTagName("school").item(0).getTextContent(), eElement.getElementsByTagName("semester").item(0).getTextContent(), Integer.parseInt(eElement.getElementsByTagName("numberofclasses").item(0).getTextContent()));

                    }
                }
            } catch (ParserConfigurationException ex) {
            Logger.getLogger(ComputerScienceToolKit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ComputerScienceToolKit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ComputerScienceToolKit.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(args.length == 0){
            new MainWindow().setVisible(true);
            //System.out.println(new FloatingPointInterpreter("00111110101010101010101010101010").singleLineView());
        }else if(args[0].equals("-g")){
            System.out.println("NO GUI MODE");
            new CLI().Run();
        }
    }
    
}
