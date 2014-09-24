package xml.controller;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import xml.model.Plane;

public class MySaxHendler extends DefaultHandler{
    private final  String PLANE_TEG = "Plane";
    private final  String TYPE_TEG = "type";
    private final  String SEASTS_TEG = "seats";
    private final  String AMMO_TEG = "ammo";
    private final  String ROCKET_TEG = "rocket";
    private final  String RADAR_TEG = "radar";
    private final  String LENGTH_TEG = "Length";
    private final  String WIDTH_TEG = "Width";
    private final  String HEIGHT_TEG = "Height";
    
    private final  String MODEL_ATR = "model";
    private final  String ORIGIN_ATR = "origin";
    private final  String PRICE_ATR = "price";
    
    private String currentTeg = null;
    
    private ArrayList<Plane> allPlanes = null;
    
    private Plane currentPlane = null;   

	public ArrayList<Plane> getAllPlanes() {
		return allPlanes;
	}

	public void addAllPlanes(Plane plane) {
		if(this.allPlanes == null){
			allPlanes = new <Plane>ArrayList<Plane>();
		}
		allPlanes.add(plane);
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String dataTeg = new String(ch,start,length).trim();
		if(currentTeg != null)
		{
			if(currentTeg.equals(TYPE_TEG))
			{
				currentPlane.setCharsType(dataTeg);
			}
			else if(currentTeg.equals(SEASTS_TEG))
			{
				currentPlane.setCharsSeats(Integer.valueOf(dataTeg));
			}
			else if(currentTeg.equals(AMMO_TEG))
			{
				currentPlane.setCharsAmmo(Boolean.valueOf(dataTeg));
			}
			else if(currentTeg.equals(ROCKET_TEG))
			{
				currentPlane.setCharsRocket(Integer.valueOf(dataTeg));
			}
			else if(currentTeg.equals(RADAR_TEG))
			{
				currentPlane.setCharsRadar(Boolean.valueOf(dataTeg));
			}
			else if(currentTeg.equals(LENGTH_TEG))
			{
				currentPlane.setParametersLength(Double.valueOf(dataTeg));
			}
			else if(currentTeg.equals(WIDTH_TEG))
			{
				currentPlane.setParametersWidth(Double.valueOf(dataTeg));
			}
			else if(currentTeg.equals(HEIGHT_TEG))
			{
				currentPlane.setParametersHeight(Double.valueOf(dataTeg));
			}else{
				currentTeg = null;
			}
		}

	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Finish parsing (SAX)!");
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
			if(qName.equals(PLANE_TEG))
			{
				addAllPlanes(currentPlane);
				currentPlane = null;
			}
			currentTeg = null;

	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start parsing (SAX)!");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		//System.out.println(currentTeg + " - 1");
		//System.out.println(qName+ " - 2");
			if(qName.equals(PLANE_TEG)){
				this.currentTeg = PLANE_TEG;
				if (currentPlane == null){
					currentPlane = new Plane();	
				}
				currentPlane.setModel(attributes.getValue(MODEL_ATR));
				currentPlane.setOrigin(attributes.getValue(ORIGIN_ATR));
				currentPlane.setPrice(Double.valueOf(attributes.getValue(PRICE_ATR)));
			}
			else if(qName.equals(TYPE_TEG)){
				this.currentTeg = TYPE_TEG;
			}
			else if(qName.equals(SEASTS_TEG)){
				this.currentTeg = SEASTS_TEG;
			}
			else if(qName.equals(AMMO_TEG)){
				this.currentTeg = AMMO_TEG;
			}
			else if(qName.equals(ROCKET_TEG)){
				this.currentTeg = ROCKET_TEG;
			}
			else if(qName.equals(RADAR_TEG)){
				this.currentTeg = RADAR_TEG;
			}
			else if(qName.equals(LENGTH_TEG)){
				this.currentTeg = LENGTH_TEG;
			}
			else if(qName.equals(WIDTH_TEG)){
				this.currentTeg = WIDTH_TEG;
			}
			else if(qName.equals(HEIGHT_TEG)){
				this.currentTeg = HEIGHT_TEG;
			}
			else
			{
				this.currentTeg = null;	
			}
			//System.out.println(currentTeg+ " - 3");
			

	}
	

}
