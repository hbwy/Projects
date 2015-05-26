package cms.model;
//��ҳ�������ڰ�װ��ҳ����
public class PageModel {
	private int pageNo; // ��ǰҳ��
	private int pageSize; // ҳ���С
	private int totalPages; // ��ҳ��
	private int rowCount; // �ܼ�¼��
	private int startIndex; // ��ʼҳ

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
		//���ݼ�¼���������ҳ��
		this.totalPages = ((rowCount%pageSize) != 0)?((rowCount/pageSize) + 1):(rowCount/pageSize);
		if (this.pageNo > this.totalPages) { //������ʾ��ҳ�Ŵ�С��������ҳ��
			this.pageNo = this.totalPages;
		}
	}

	public int getStartIndex() {
		return (pageNo - 1) * pageSize; //����ҳ�Ż������ҳʱ����ʼֵ
	}

}
