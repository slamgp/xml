package xml.model;

public class Plane {
	private String model;
	private String origin;
	private double price;
	private Chars chars = new Chars();
	private Parameters parameters = new Parameters();

	
	public Plane(String model, String origin, double price, Chars chars, Parameters parameters) {
		this.model = model;
		this.origin = origin;
		this.price = price;
		this.chars = chars;
		this.parameters = parameters;
	}
	
	public Plane(){
		
	}
	
	public String getModel() {
		return model;
	}
	public String getOrigin() {
		return origin;
	}
	public double getPrice() {
		return price;
	}
	public Chars getChars() {
		return chars;
	}
	public Parameters getParameters() {
		return parameters;
	}
	


	public void setModel(String model) {
		this.model = model;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setCharsType(String type)
	{
		chars.setType(type);
	}
	public void setCharsSeats(int seats)
	{
		chars.setSeats(seats);
	}
	public void setCharsAmmo(Boolean ammo)
	{
		chars.setAmmo(ammo);
	}
	public void setCharsRocket(int rocket)
	{
		chars.setRocket(rocket);
	}
	public void setCharsRadar(boolean radar)
	{
		chars.setRadar(radar);
	}

	public void setParametersHeight(double height)
	{
		parameters.setHeight(height);
	}
	public void setParametersLength(double length)
	{
		parameters.setLength(length);
	}
	public void setParametersWidth(double width)
	{
		parameters.setWidth(width);
	}
	
	@Override
	public String toString() {
		StringBuilder strBuild = new StringBuilder("********************************************************************************************");
		strBuild.append("\n");
		strBuild.append("General information about the plane: ");
		strBuild.append("model: ");
		strBuild.append(model);
		strBuild.append("; origin: ");
		strBuild.append(origin);
		strBuild.append("; price: ");
		strBuild.append(price);
		strBuild.append("\n");
		strBuild.append(chars.toString());
		strBuild.append("\n");
		strBuild.append(parameters.toString());
		return strBuild.toString();
	}
	
	
	

}

 class Chars{
	private String type;
	private int seats;
	private boolean ammo;
	private int rocket;	
	private boolean radar;
	
	public Chars(String type, int seats, boolean ammo, int rocket, boolean radar) {
		this.type = type;
		this.seats = seats;
		this.ammo = ammo;
		this.rocket = rocket;
		this.radar = radar;
	}
	
	public Chars() {

	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public void setAmmo(boolean ammo) {
		this.ammo = ammo;
	}

	public void setRocket(int rocket) {
		this.rocket = rocket;
	}

	public void setRadar(boolean radar) {
		this.radar = radar;
	}

	public String getType() {
		return type;
	}

	public int getSeats() {
		return seats;
	}

	public boolean isAmmo() {
		return ammo;
	}

	public int getRocket() {
		return rocket;
	}

	public boolean isRadar() {
		return radar;
	}
	@Override
	public String toString() {
		StringBuilder strBuild = new StringBuilder("Characteristics of the aircraft: ");
		
		strBuild.append("\n");
		strBuild.append("type: ");
		strBuild.append(type);
		strBuild.append("\n");
		strBuild.append("seats: ");
		strBuild.append(seats);
		strBuild.append("\n");
		strBuild.append("is ammo: ");
		strBuild.append(ammo);
		strBuild.append("\n");
		strBuild.append("number of rocket: ");
		strBuild.append(rocket);
		strBuild.append("\n");
		strBuild.append("is radar: ");
		strBuild.append(radar);
		strBuild.append("\n");
		return strBuild.toString();
	}

}

class Parameters{
	private double length;
	private double width;
	private double height;
	
	public Parameters(double length, double width, double height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}

	
	public Parameters() {

	}
	
	public void setLength(double length) {
		this.length = length;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	@Override
	public String toString() {
		StringBuilder strBuild = new StringBuilder("Plane parameters:");
		strBuild.append("\n");
		strBuild.append("length: ");
		strBuild.append(length);
		strBuild.append("\n");
		strBuild.append("width: ");
		strBuild.append(width);
		strBuild.append("\n");
		strBuild.append("height: ");
		strBuild.append(height);
		strBuild.append("\n");
		return strBuild.toString();
	}
	
	
	
}


