package es.unex.pi.model;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class propertyUser {
	private long idp;
	private long idu;
	
	public long getIdp() {
		return idp;
	}
	
	public void setIdp(long idp) {
		this.idp = idp;
	}
	
	public long getIdu() {
		return idu;
	}
	
	public void setIdu(long idu) {
		this.idu = idu;
	}
}
