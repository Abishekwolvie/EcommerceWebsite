package dbcode;

public class Addtocart {
	
	private String useremail;
	private int crtpid;
	private String crtmodelname;
	private String crtgraphicscard;
	private String crtProcessor;
	private String crtram;
	private long crtprice;
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public int getCrtpid() {
		return crtpid;
	}
	public void setCrtpid(int crtpid) {
		this.crtpid = crtpid;
	}
	public String getCrtmodelname() {
		return crtmodelname;
	}
	public void setCrtmodelname(String crtmodelname) {
		this.crtmodelname = crtmodelname;
	}
	public String getCrtgraphicscard() {
		return crtgraphicscard;
	}
	public void setCrtgraphicscard(String crtgraphicscard) {
		this.crtgraphicscard = crtgraphicscard;
	}
	public String getCrtProcessor() {
		return crtProcessor;
	}
	public void setCrtProcessor(String crtProcessor) {
		this.crtProcessor = crtProcessor;
	}
	public String getCrtram() {
		return crtram;
	}
	public void setCrtram(String crtram) {
		this.crtram = crtram;
	}
	public long getCrtprice() {
		return crtprice;
	}
	public void setCrtprice(long crtprice) {
		this.crtprice = crtprice;
	}
	public Addtocart(String useremail, int crtpid, String crtmodelname, String crtgraphicscard, String crtProcessor,
			String crtram, long crtprice) {
		super();
		this.useremail = useremail;
		this.crtpid = crtpid;
		this.crtmodelname = crtmodelname;
		this.crtgraphicscard = crtgraphicscard;
		this.crtProcessor = crtProcessor;
		this.crtram = crtram;
		this.crtprice = crtprice;
	}
	
	

}
