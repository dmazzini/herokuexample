package ar.uba.domain;

import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

@Table(name = "category")
@Entity
public class Category {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="hidden")
	private boolean hidden;

	@Lob
	private byte[] logo;
	
	Category() {}
	
	public Category(String name) {
		this.name = name;
		this.hidden = false;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isHidden() {
		return hidden;
	}
	
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(Category.class)
				.add("name", name)
				.add("logo", getLogo().length())
				.add("id", id)
				.toString();
	}

	public String getLogo() {
		if (logo == null) {
			logo = new byte[0];
		}
		return Base64.getEncoder().encodeToString(logo);
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
}
