package gui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class QuantityBean {
	private String quantityRequested;
	private int quantityAvailable;
	public QuantityBean(String qr, int qa) {
		quantityRequested=qr;
		quantityAvailable=qa;
	}
	public int getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(int quantityAvail) {
		this.quantityAvailable = quantityAvail;
	}
	public String getQuantityRequested() {
		return quantityRequested;
	}
	public void setQuantityRequested(String quantityRequested) {
		this.quantityRequested = quantityRequested;
	}
	///////////property change listener code
    private PropertyChangeSupport pcs = 
    	new PropertyChangeSupport(this);
    public void addPropertyChangeListener(PropertyChangeListener pcl){
	 	pcs.addPropertyChangeListener(pcl);
	}
	public void removePropertyChangeListener(PropertyChangeListener pcl){	
    	pcs.removePropertyChangeListener(pcl);
    }

}
