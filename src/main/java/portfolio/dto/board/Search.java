package portfolio.dto.board;

public class Search {
	//�˻��ʵ� field
	private String f="";
	
	//�˻���� query
	private String q="";
	
	public String getF() {
		return f;
	}
	public void setF(String f) {
		this.f = f;
	}
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	@Override
	public String toString() {
		return "Search [f=" + f + ", q=" + q + "]";
	}
	
	
}
