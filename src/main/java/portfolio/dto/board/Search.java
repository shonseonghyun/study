package portfolio.dto.board;

public class Search {
	//검색필드 field
	private String f="";
	
	//검색어들 query
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
