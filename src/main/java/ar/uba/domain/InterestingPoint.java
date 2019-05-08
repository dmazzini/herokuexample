package ar.uba.domain;

import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

@Table(name = "interestingpoint")
@Entity
public class InterestingPoint {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="title")
	private String title;

	@Column(name="description")
	private String description;
	
	@Column(name="hidden")
	private boolean hidden;
	
	@Lob
	private byte[] image;

	@JoinColumn
	@ManyToOne
	private Category category;
	
	InterestingPoint() {}
	
	public InterestingPoint(Category category, String title, String description) {
		this.category = category;
		this.title = title;
		this.description = description;
		this.hidden = false;
	}

	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean isHidden() {
		return hidden;
	}
	
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(InterestingPoint.class)
				.add("title", title)
				.add("description", description)
				.add("id", id)
				.add("category", category)
				.add("image", getImage().length())
				.toString();
	}

	public String getImage() {
		if (image == null) {
			image = new byte[0];
		}
		return Base64.getEncoder().encodeToString(image);
	}
	
	public void setImage(byte[] image) {
		this.image = image;
	}
}
