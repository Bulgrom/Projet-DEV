package map;

public class Background {

	private static boolean useSprite;
	private int id;
	private String name;
	private String color;
	
	
	public Background(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}

	public String getColor(){
		return color;
	}

	public boolean getUseSprite(){
		return useSprite;
	}

	public void setId(int id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setColor(String color){
		this.color = color;
	}

}
