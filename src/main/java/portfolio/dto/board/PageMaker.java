package portfolio.dto.board;

public class PageMaker {
	private int count;
	private int page;
	private int start;
	private int end;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public PageMaker(int count,int page){
		this.count=count;
		this.page=page;
		calcPage();
	}
	
	private void calcPage() {
		start=page%5==0?page/5:page/5+1;
		end=count%5==0?count/5:count/5+1;
	}
	
}
