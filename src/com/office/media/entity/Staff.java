package com.office.media.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Staff implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String staffId;
	private String position;
	private String department;
	@Temporal(TemporalType.DATE)
	private Date startEmployDate;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	private String phone;
	private String email;
	private String password;
	private String quote;
	private String name;
	private String profileimageUrl;
	@ManyToMany(mappedBy = "staffs")
	private List<StaffGroup> staffGroups;
	@OneToOne(mappedBy = "staff", cascade = CascadeType.ALL, orphanRemoval = true)
	private Birthday birthday;
	@OneToOne
	private Role role;

	public long getId() {
		return id;
	}

	public void bind(Staff staff) {
		this.staffId = staff.staffId;
		this.position = staff.position;
		this.department = staff.department;
		this.startEmployDate = staff.startEmployDate;
		this.dateOfBirth = staff.dateOfBirth;
		this.phone = staff.phone;
		this.email = staff.email;
		this.password = staff.password;
		this.name = staff.name;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getStartEmployDate() {
		return startEmployDate;
	}

	public void setStartEmployDate(Date startEmployDate) {
		this.startEmployDate = startEmployDate;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfileimageUrl() {
		return profileimageUrl;
	}

	public void setProfileimageUrl(String profileimageUrl) {
		this.profileimageUrl = profileimageUrl;
	}

	public Birthday getBirthday() {
		return birthday;
	}

	public void setBirthday(Birthday birthday) {
		this.birthday = birthday;
	}

	public List<StaffGroup> getStaffGroups() {
		return staffGroups;
	}

	public void setStaffGroups(List<StaffGroup> staffGroups) {
		this.staffGroups = staffGroups;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((profileimageUrl == null) ? 0 : profileimageUrl.hashCode());
		result = prime * result + ((quote == null) ? 0 : quote.hashCode());
		result = prime * result + ((staffId == null) ? 0 : staffId.hashCode());
		result = prime * result + ((startEmployDate == null) ? 0 : startEmployDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (profileimageUrl == null) {
			if (other.profileimageUrl != null)
				return false;
		} else if (!profileimageUrl.equals(other.profileimageUrl))
			return false;
		if (quote == null) {
			if (other.quote != null)
				return false;
		} else if (!quote.equals(other.quote))
			return false;
		if (staffId == null) {
			if (other.staffId != null)
				return false;
		} else if (!staffId.equals(other.staffId))
			return false;
		if (startEmployDate == null) {
			if (other.startEmployDate != null)
				return false;
		} else if (!startEmployDate.equals(other.startEmployDate))
			return false;
		return true;
	}

}
