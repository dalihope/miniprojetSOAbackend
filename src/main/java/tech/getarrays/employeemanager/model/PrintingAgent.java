package tech.getarrays.employeemanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PrintingAgent implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String imageUrl;

	public PrintingAgent() {
	}

	public PrintingAgent(String name, String email, String phone, String imageUrl, String employeeCode) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.imageUrl = imageUrl;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "PrintingAgent{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", phone='"
				+ phone + '\'' + ", imageUrl='" + imageUrl + '\'' + '}';
	}
}
