package xml.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import xml.controller.MyDomParser;
import xml.controller.MySaxHendler;
import xml.model.Plane;

public class Main {
	public static void main(String[] args)
	{
		try {
			SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
			MySaxHendler mySaxHendler = new MySaxHendler();
			if(mySaxHendler != null)
			{
					saxParser.parse(".\\xml project\\planes.xml", mySaxHendler);
					ArrayList<Plane> plSax = mySaxHendler.getAllPlanes();
					for(Plane p: plSax)
					{
						System.out.println(p);
					}
			}
		} catch (ParserConfigurationException | SAXException  | IOException e) {
			e.printStackTrace();
		}
		MyDomParser mdp = new MyDomParser(".\\xml project\\planes.xml");
		mdp.startParsing();
		ArrayList<Plane> plDom = mdp.getAllPlanes();
		for(Plane p: plDom)
		{
			System.out.println(p);
		}
		
	}

}
