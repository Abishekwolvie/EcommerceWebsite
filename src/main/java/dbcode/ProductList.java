package dbcode;

public class ProductList {
	
	private String modelname;
	private String graphicscard;
	private String Processor;
	private String ram;
	private long price;
	public ProductList(String modelname, String graphicscard, String processor, String ram, long price) {
		super();
		this.modelname = modelname;
		this.graphicscard = graphicscard;
		this.Processor = processor;
		this.ram = ram;
		this.price = price;
	}
	public String getModelname() {
		return modelname;
	}
	public String getGraphicscard() {
		return graphicscard;
	}
	public String getProcessor() {
		return Processor;
	}
	public String getRam() {
		return ram;
	}
	public long getPrice() {
		return price;
	}

}
