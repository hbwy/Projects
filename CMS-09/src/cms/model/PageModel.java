package cms.model;
//分页对象，用于包装分页参数
public class PageModel {
	private int pageNo; // 当前页号
	private int pageSize; // 页面大小
	private int totalPages; // 总页数
	private int rowCount; // 总记录数
	private int startIndex; // 起始页

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
		//根据记录数换算出总页数
		this.totalPages = ((rowCount%pageSize) != 0)?((rowCount/pageSize) + 1):(rowCount/pageSize);
		if (this.pageNo > this.totalPages) { //控制显示的页号大小不超过总页数
			this.pageNo = this.totalPages;
		}
	}

	public int getStartIndex() {
		return (pageNo - 1) * pageSize; //根据页号换算出分页时的起始值
	}

}
