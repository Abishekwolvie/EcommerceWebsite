package dbcode;

public class ProductList {
	
	private String modelname;
	private String graphicscard;
	private String Processor;
	private String ram;
	private long price;
	private int pid;
	public ProductList(String modelname, String graphicscard, String processor, String ram, long price,int pid) {
		super();
		this.modelname = modelname;
		this.graphicscard = graphicscard;
		this.Processor = processor;
		this.ram = ram;
		this.price = price;
		this.pid=pid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
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
