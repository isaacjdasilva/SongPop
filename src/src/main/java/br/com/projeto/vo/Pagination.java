package br.com.projeto.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author marcio.camurati
 * 
 */
public class Pagination {
	private static final int min = 0;

	private final int defaultSize = 10;

	/*
	 * number of pages to show in view 
	 */
	private int step = 10;
	
	private int size;

	private int startPage=1;

	private int total;
	
	private int actualPage;
	
	private List<Page> pages;

	public Pagination()	{
		// void
	}
	
	public Pagination(int size)	{
		this.size = size;
	}
	
	public Pagination(int size, int step)	{
		this.size = size;
		this.step = step;
	}	
	/**
	 * @return the start
	 */
	public int getStart() {
		return this.startPage;
	}

	/**
	 * @param startPage
	 *            the start to set
	 */
	public void setStartPage(Integer startPage) {
		startPage=startPage==null?1:startPage;
		if (startPage<min) {
			this.startPage = min;
		} else {
			this.startPage = startPage;
		}
	}
	
	/**
	 * Return the index of first register in the actual page
	 * @return
	 */
	public int getFirstPosition() {
		return (getStart() * getSize())-getSize();
	}

	/**
	 * @return the startPage
	 */
	public int getStartPage() {
		return startPage;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return the min
	 */
	public static int getMin() {
		return min;
	}

	
	
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		if (size == 0)
			size = defaultSize;
		
		return size;
	}

	/**
	 * 
	 * @return
	 */
	public int getPagesTotal()	{
		if (this.total != 0)	{
			int pages = this.total/this.size;
			
			if ((this.total % this.size) != 0)	{
				pages += 1;
			}
			
			return pages;
		}
		
		return 0;
	}

	/**
	 * @return the pages
	 */
	public List<Page> getPages() {
		return pages;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getStep() {
		return step;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getActualPage() {
		return actualPage;
	}

	/**
	 * 
	 * @param page
	 */
	private void addPages(int page, int startPage)	{
		if (this.pages == null)
			this.pages = new ArrayList<Page>();
		
		this.pages.add(new Page(page+1, startPage));
	}

	/**
	 * Build the correct page range
	 */
	public void build()	{
		int pagesTotal = this.getPagesTotal();

		int pStart = 0;

		int pEnd = this.total;

		if (pagesTotal > 1) {
			pEnd = (int) pagesTotal;

			actualPage = this.reverseStartPage();

			if (actualPage >= this.step) {
				pEnd = actualPage + 1;

				if (pEnd > pagesTotal) {
					pEnd = (int) pEnd-2;
					if (pEnd < pagesTotal) {
						pEnd++;
					}
					
					if (pEnd == this.total)
						pEnd--;
				}	else if (pEnd == pagesTotal)	{
					pEnd = (int) pagesTotal-1;
				}

				pStart = pEnd - this.step;
			} else {
				if (pagesTotal < this.step){
					pEnd = (int) pagesTotal;
				}	else	{
					pEnd = this.step;
				}
			}

		} else {
			pStart = 0;
			pEnd = 0;
		}		
		
		for (; pStart < pEnd; pStart++)	{
			this.addPages(pStart, this.convertStartPage(pStart));
		}
	}

	/**
	 * Generate step 	=> size*(page-1)
	 * @param page
	 * @return
	 */
	private int convertStartPage(int page)	{
		if (page != 0)
			return this.size*(page);

		return 0;
	}
	
	/**
	 * @param step the step to set
	 */
	public void setStep(int step) {
		this.step = step;
	}

	/**
	 * Reverse step 	=> (startPage+size)/size
	 * @return
	 */
	private int reverseStartPage()	{
		return (this.startPage+this.size)/this.size;
	}
	
	/**
	 * Inner Class for return to view
	 * @author marcio.camurati
	 *
	 */
	public class Page	{
		private int page;
		
		private int startPage;

		public Page(int page, int startPage)	{
			this.page = page;
			this.startPage = startPage;
		}
		
		public int getPage() {
			return page;
		}

		public int getStartPage() {
			return startPage;
		}
	}
}
