package es.unex.pi.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PropertiesCategories {

	private long idp;
	private long idct;
	
	public long getIdp() {
		return idp;
	}
	
	public void setIdp(long idr) {
		this.idp = idr;
	}
	
	public long getIdct() {
		return idct;
	}
	
	public void setIdct(long idct) {
		this.idct = idct;
	}
}
