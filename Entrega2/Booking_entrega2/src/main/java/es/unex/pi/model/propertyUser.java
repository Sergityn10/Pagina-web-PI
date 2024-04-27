package es.unex.pi.model;

public class propertyUser {
	private long idp;
	private long idu;
	
	public propertyUser(long idp, long idu) {
		this.idp = idp;
		this.idu=idu;
	}
	
	public propertyUser() {
		this.idp=0;
		this.idu=0;
	}

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
