package biju.ecom.viewhelper;

public class PecaViewHelper {

	private String dataBsTarget;
	private Integer idProduto;
	private String divClass;
	private String text;
	private String title;
	private byte[] photo;
	private String id;

	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDataBsTarget() {
		return dataBsTarget;
	}

	public void setDataBsTarget(String dataBsTarget) {
		this.dataBsTarget = dataBsTarget;
	}

	public String getDivClass() {
		return divClass;
	}

	public void setDivClass(String divClass) {
		this.divClass = divClass;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

}
