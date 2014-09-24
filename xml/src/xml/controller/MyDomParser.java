package xml.controller;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import xml.model.Plane;

import org.apache.xerces.parsers.DOMParser;


public class MyDomParser{
	private String fileToParse = null;
	private ArrayList<Plane> allPlanes = new ArrayList<Plane>();
	
	
	
	public ArrayList<Plane> getAllPlanes() {
		return allPlanes;
	}

	private String getTegValue(Element element, String nameTeg)
	{
		String result = null;
		Element elemenFromFind = (Element) element.getElementsByTagName(nameTeg).item(0);
		result = elemenFromFind.getFirstChild().getNodeValue();
		return result;
	}
	
	public MyDomParser(String fileName)
	{
		this.fileToParse = fileName;
	}
	
	public void startParsing()
	{
		if (fileToParse== null)
		{
			System.out.println("Not file name!");
			return;
		}
		System.out.println("Start parsing (DOM)!");
		
		Document doc = null;
		DOMParser  parser = new DOMParser();
		try {
			parser.parse(fileToParse);
			doc = parser.getDocument();
			Element root = doc.getDocumentElement();
			NodeList nodeList = root.getElementsByTagName("Plane");
			Element nodeElement;
			
			for(int i = 0; i<nodeList.getLength();i++)
			{
				nodeElement = (Element) nodeList.item(i);
				Node planeAttrModel = nodeElement.getAttributes().item(0);
				Node planeAttrOrigin = nodeElement.getAttributes().item(1);
				Node planeAttrPrice = nodeElement.getAttributes().item(2);
				Plane p = new Plane();
				p.setModel(planeAttrModel.getNodeValue());
				p.setOrigin(planeAttrOrigin.getNodeValue());
				p.setPrice(Double.parseDouble(planeAttrPrice.getNodeValue()));
			
				Element elementChars = (Element)nodeElement.getElementsByTagName("Chars").item(0);
				p.setCharsType(getTegValue(elementChars, "type"));
				p.setCharsAmmo(Boolean.parseBoolean(getTegValue(elementChars, "ammo")));
				p.setCharsRadar(Boolean.parseBoolean(getTegValue(elementChars, "radar")));
				p.setCharsRocket(Integer.parseInt(getTegValue(elementChars, "rocket")));
				p.setCharsSeats(Integer.parseInt(getTegValue(elementChars, "seats")));
				
				Element elementParameters = (Element)nodeElement.getElementsByTagName("Parameters").item(0);
				p.setParametersHeight(Double.parseDouble(getTegValue(elementParameters, "Height")));
				p.setParametersLength(Double.parseDouble(getTegValue(elementParameters, "Length")));
				p.setParametersWidth(Double.parseDouble(getTegValue(elementParameters, "Width")));
				
				allPlanes.add(p);
			}
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finish parsing (DOM)!");
		
	}
}
