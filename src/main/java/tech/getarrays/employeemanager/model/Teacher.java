package tech.getarrays.employeemanager.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import net.bytebuddy.build.ToStringPlugin;

@Entity
public class Teacher implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String name;
	private String email;
	private String subject;
	private String phone;
	private String imageUrl;
	@Column(nullable = false, updatable = false)
	private String teacherCode;
	@OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@ToStringPlugin.Exclude
	
	private List<PrintingOperation> printingOperations;

	public Teacher() {
	}

	public Teacher(String name, String email, String subject, String phone, String imageUrl, String teacherCode) {
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.phone = phone;
		this.imageUrl = imageUrl;
		this.teacherCode = teacherCode;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String jobTitle) {
		this.subject = jobTitle;
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

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String employeeCode) {
		this.teacherCode = employeeCode;
	}

	public List<PrintingOperation> getPrintingOperations() {
		return printingOperations;
	}

	public void setPrintingOperations(List<PrintingOperation> printingOperations) {
		this.printingOperations = printingOperations;
	}

	@Override
	public String toString() {
		return "Teacher{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", subject='" + subject
				+ '\'' + ", phone='" + phone + '\'' + ", imageUrl='" + imageUrl + '\'' + '}';
	}
}
