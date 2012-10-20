/**
 * 
 */
package br.com.projeto.util;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import br.com.projeto.vo.Pagination;

/**
 * @author raul.dias
 * @since 01/10/2008
 */
public class PaginationTag extends TagSupport {

	/**
	 * @see long
	 */
	private static final long serialVersionUID = 7040547059159380007L;
	
	/** HTML form name to submit*/
	private String formName;
	/** Struts action method to execute pagination*/
	private String method;
	/** Pagination class with data*/
	private Pagination pagination;
	/** Log*/
	private static final Logger LOGGER = Logger.getLogger(PaginationTag.class);
	/** Flag that indicates if the default fields must be created*/
	private boolean createFields = true;
	/** Flag used to show pagination description**/
	private boolean showDescription = false;


	/**
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	public int doStartTag() throws JspException {
		
		if (pagination == null) return -1;
		
		StringBuffer buffer = new StringBuffer();
		
		//Get the correct actual page
		int actualPage = ((pagination.getStartPage() == 0) ? 1 : pagination.getStartPage());
		
		
		//create default fields
		if (createFields) {
			buffer.append("<input type='hidden' id='startPage'" );
			buffer.append(" name='startPage'");
			buffer.append(" value='"+ actualPage +"' />");
			
			buffer.append("<input type='hidden' id='pageSize'" );
			buffer.append(" name='size'");
			buffer.append(" value='"+ pagination.getSize() +"' />");
		}
		
		//start pagination
		buffer.append("<!-- Paginação -->");
		buffer.append("<script type=\"text/javascript\">");
		buffer.append("	function doPagination(idForm, action, pagina) {");
		buffer.append("		if(action!=null && action!='' && action!='null'){");
		buffer.append("			document.getElementById(idForm).action = action;");
		buffer.append("		}");
		buffer.append("		document.getElementById('startPage').value = pagina;");
		buffer.append("		document.getElementById(idForm).submit();");
		buffer.append("	}");
	
		buffer.append("</script>");
		buffer.append("<div class='div_paginacao'>");
		
		if(pagination.getPagesTotal() > 1) {
			buffer.append("<ul class='paginacao'>");
			
			if (pagination.getTotal() >= pagination.getSize()) {
				
				//previous link
				if (pagination.getStartPage() > 1) {
					buffer.append("<li class='previous'>");
					makeListLink(buffer, pagination.getStart()-1, "anterior");
					buffer.append("</li>");
					
					if (pagination.getStart() > (pagination.getStep() / 2)+1 
							&& pagination.getPagesTotal() > pagination.getStep())
					{
						buffer.append("<li class='numero_off'>");
						makeListLink(buffer, 1, "1");
						buffer.append("</li>");
						buffer.append("<li>...</li>");
					}
				}
				
				//page numbers
				for (Iterator<Integer>  iterator = getPageList().iterator(); iterator.hasNext();) {
					Integer page = iterator.next();
					
					if (page.intValue()!=actualPage) {
						buffer.append("<li class='numero_off'>");
						makeListLink(buffer, page.intValue(), page.toString());
					} else {
						buffer.append("<li class='numero_on'>");
						buffer.append("<strong>");
						buffer.append(page);
						buffer.append("</strong>");						
					}
					
					buffer.append("</li>");
				}
				
				//interval
				if ((pagination.getPagesTotal() - pagination.getStart() > (pagination.getStep()/2))
						&& pagination.getPagesTotal() > pagination.getStep()) {
					buffer.append("<li>...</li>");
					buffer.append("<li class='numero_off'>");
					makeListLink(buffer, pagination.getPagesTotal(), pagination.getPagesTotal()+"");
					buffer.append("</li>");
				}
				
				//next link
				if (pagination.getStart() < pagination.getPagesTotal()) {
					buffer.append("<li class='next'>");
					makeListLink(buffer, pagination.getStart()+1, "próxima");
					buffer.append("</li>");
				}
				
			}
			
			buffer.append("</ul>");
			
			if(showDescription){
				buffer.append("<p  class='qtd_registros'>");
				buffer.append("Mostrando <strong>");
				buffer.append(((pagination.getStartPage()-1) * pagination.getSize())+1);
				buffer.append("</strong>");
				buffer.append(" a ");
				buffer.append("<strong>");
				if (((pagination.getStartPage()) * pagination.getSize())+1 <= pagination.getTotal()) {
					buffer.append(pagination.getStartPage() * pagination.getSize());
				} else {
					buffer.append(pagination.getTotal());
				}
				buffer.append("</strong>");
				buffer.append(" de ");
				buffer.append("<strong>");
				buffer.append(pagination.getTotal());
				buffer.append("</strong>");
				buffer.append("</p>");
			}
			
		}
		
		//end pagination
		buffer.append("</div>");
		buffer.append("<!-- Paginação -->");
		
		try {
			pageContext.getOut().write(buffer.toString());
		} catch (IOException e) {
			LOGGER.error("PaginationTag, doStartTag: Erro ao criar a paginação", e);
		}
		
		return SKIP_BODY;
	}

	/**
	 * Make a pagination link
	 * @param buffer tag buffer
	 */
	private void makeListLink(StringBuffer buffer, int pageToGo, String linkText) {
		buffer.append("<a href='#' ");
		buffer.append("onclick=\"doPagination(");
		buffer.append("'"+formName+"',");
		buffer.append("'"+method+"',");			
		buffer.append("'"+pageToGo+"'");
		buffer.append(")\">");
		buffer.append(linkText.toString());
		buffer.append("</a>");
	}

	/**
	 * @return the listaLinks
	 */
	public Collection<Integer> getPageList() {
		
		int var = pagination.getStartPage() - 1;
		int cont = 0;
		int cont2 = 0;
		
		TreeSet<Integer> listaLinks = new TreeSet<Integer>();
			
		if (pagination.getStartPage() < pagination.getStep() / 2) {
			cont = var;
		} else if (pagination.getPagesTotal() - pagination.getStartPage() < pagination.getStep() / 2) {
			cont = pagination.getStep() - (pagination.getPagesTotal() - pagination.getStartPage()) - 1;
		} else if (pagination.getStartPage() > (pagination.getStep()/2)) {
			cont = pagination.getStep() / 2;
		} else if (pagination.getStartPage() == (pagination.getStep()/2)) {
			cont = (pagination.getStep() / 2)-1;
		}
		
		// Adiciona os links das paginas anteriores a pagina atual
		while (var > 0 && cont > 0) {
			listaLinks.add(var);
			var--;
			cont--;
			cont2++;
		}
		
		// Adiciona a pagina atual
		listaLinks.add(new Integer(pagination.getStartPage()));
		
		int var2 = pagination.getStartPage() + 1 ;
		
		// Adiciona os links das paginas posteriores a pagina atual
		while (var2 <= pagination.getPagesTotal() && cont2 < pagination.getStep() - 1) {
			listaLinks.add(new Integer(var2));
			var2 ++;
			cont2++;
		}
		
		return listaLinks;
	}
	
	/**
	 * @return the formName
	 */
	public String getFormName() {
		return formName;
	}

	/**
	 * @param formName the formName to set
	 */
	public void setFormName(String formName) {
		this.formName = formName;
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return the pagination
	 */
	public Pagination getPagination() {
		return pagination;
	}

	/**
	 * @param pagination the pagination to set
	 */
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	

	/**
	 * @return the createFields
	 */
	public boolean getCreateFields() {
		return createFields;
	}

	/**
	 * @param createFields the createFields to set
	 */
	public void setCreateFields(boolean createFields) {
		this.createFields = createFields;
	}

	/**
	 * @return the showDescription
	 */
	public boolean isShowDescription() {
		return showDescription;
	}

	/**
	 * @param showDescription the showDescription to set
	 */
	public void setShowDescription(boolean showDescription) {
		this.showDescription = showDescription;
	}

	


	
}
