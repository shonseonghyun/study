package study;

public class ArticelVo {
	private int articleNo;
	private String writer;
	private String title;
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "ArticelVo [articleNo=" + articleNo + ", writer=" + writer + ", title=" + title + "]";
	}
	
	
}
