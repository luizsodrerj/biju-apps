package biju.data.dto;

import java.io.Serializable;

public class StatusProdutoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String status;

	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
