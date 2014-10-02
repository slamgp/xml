package xml.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import xml.model.Plane;

public class MyStaxParset {
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
    
	private String fileToParse = null;
    
    private String currentTeg = null;
    
    private ArrayList<Plane> allPlanes = null;
    
    private Plane currentPlane = null;   

	public ArrayList<Plane> getAllPlanes() {
		return allPlanes;
	}
	
	public MyStaxParset(String fileName)
	{
		this.fileToParse = fileName;
	}
	
	
	public void addAllPlanes(Plane plane) {
		if(this.allPlanes == null){
			allPlanes = new <Plane>ArrayList<Plane>();
		}
		allPlanes.add(plane);
	}
	
	public void startParsing()
	{
		XMLInputFactory inpFactory = XMLInputFactory.newInstance();
		try {
			XMLStreamReader reader =inpFactory.createXMLStreamReader(new FileInputStream(this.fileToParse));
			System.out.println("Start parsing (StAX)!");
			while (reader.hasNext()) {
				int typeElement  = reader.next();
				switch(typeElement)
				{
					case XMLStreamConstants.START_ELEMENT:
						switch(reader.getLocalName()){
						case PLANE_TEG:
							currentPlane = new Plane();
							currentPlane.setModel(reader.getAttributeValue(0));
							currentPlane.setOrigin(reader.getAttributeValue(1));
							currentPlane.setPrice(Double.valueOf(reader.getAttributeValue(2)));
							currentTeg = PLANE_TEG;
							break;
						case TYPE_TEG:
							this.currentTeg = TYPE_TEG;
							break;
						case SEASTS_TEG:
							this.currentTeg = SEASTS_TEG;
							break;
						case AMMO_TEG:
							this.currentTeg = AMMO_TEG;
							break;
						case ROCKET_TEG:
							this.currentTeg = ROCKET_TEG;
							break;
						case RADAR_TEG:
							this.currentTeg = RADAR_TEG;
							break;
						case LENGTH_TEG:
							this.currentTeg = LENGTH_TEG;
							break;
						case WIDTH_TEG:
							this.currentTeg = WIDTH_TEG;
							break;
						case HEIGHT_TEG:
							this.currentTeg = HEIGHT_TEG;
							break;
						default:
								this.currentTeg = null;	
						}
						break;
					case  XMLStreamConstants.CHARACTERS:
						String dataTeg = reader.getText().trim();
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
						break;
					case XMLStreamConstants.END_ELEMENT:
						if(reader.getLocalName().equals(PLANE_TEG))
						{
							addAllPlanes(currentPlane);
							currentPlane = null;
						}
						currentTeg = null;
						break;

				}
			}
			System.out.println("Finish parsing (StAX)!!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
