package bean;

public class Page {
	Integer pageRow;
	Integer thePage;
	Integer pageRowCount;
	Integer pageCount;
	public Integer getPageRow() {
		return pageRow;
	}
	public void setPageRow(Integer pageRow) {
		this.pageRow = pageRow;
	}
	public Integer getThePage() {
		return thePage;
	}
	public void setThePage(Integer thePage) {
		this.thePage = thePage;
	}
	public Integer getPageRowCount() {
		return pageRowCount;
	}
	public void setPageRowCount(Integer pageRowCount) {
		this.pageRowCount = pageRowCount;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Page(Integer pageRow, Integer thePage, Integer pageRowCount, Integer pageCount) {
		super();
		this.pageRow = pageRow;
		this.thePage = thePage;
		this.pageRowCount = pageRowCount;
		this.pageCount = pageCount;
	}
	public Page() {
		super();
	}
	
}
