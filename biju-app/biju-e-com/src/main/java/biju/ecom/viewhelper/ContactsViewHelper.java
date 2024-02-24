package biju.ecom.viewhelper;

import java.util.Arrays;
import java.util.List;

public class ContactsViewHelper {

	private boolean isLnk;
	private String icon;
	private String text;
	private String link;

	
	public ContactsViewHelper(String icon, String text, String link, boolean isLink) {
		super();
		this.isLnk = isLink;
		this.icon = icon;
		this.text = text;
		this.link = link;
	}

	public ContactsViewHelper() {
		super();
	}

	public List<ContactsViewHelper> getList() {
		return Arrays.asList(
			new ContactsViewHelper[] {
				new ContactsViewHelper(
					"/img/what.png",
					"WhatsApp - (21)98071-6352",
					"",
					false
				),
				new ContactsViewHelper(
					"/img/insta.png",
					"Instagram - https://www.instagram.com/bijus_girls22",
					"https://www.instagram.com/bijus_girls22",
					true
				),
				new ContactsViewHelper(
					"/img/face.png",
					"Facebook - https://www.facebook.com/patriciacarvalho.dasilva.73",
					"https://www.facebook.com/patriciacarvalho.dasilva.73",
					true
				),
				new ContactsViewHelper(
					"/img/g.png",
					"E-mail - patybijugirl@gmail.com",
					"",
					false
				)
			}	
		);
	}
	
	public boolean isLink() {
		return isLnk;
	}

	public void setIsLink(boolean isLink) {
		this.isLnk = isLink;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
