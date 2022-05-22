package project.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "users")
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "username", unique=true)
	@NotEmpty(message = "username can not be null")
	private String username;
	@Column(name = "email")
	@NotEmpty(message = "email can not be null")
	private String email;
	@Column(name = "password")
	@NotEmpty(message = "Password can not be null")
	private String password;
	@Column(name = "gender")
	@NotNull(message = "Gender can not be null")
	private boolean gender;
	@Column(name = "dateOfBirth")
	@NotNull(message = "Birthday can not be null")
	private Date dateOfBirth;
	@Column(name = "avatar")
	private String avatar;
	@Column(name = "phone")
	@NotNull(message = "Phone can not be null")
	private String phone;
	@Column(name = "address")
	@NotEmpty(message = "Address can not be null")
	private String address;
	@Column(name = "enabled")
	private boolean enabled;
	@OneToMany(mappedBy = "id")
    private List<User_Course> listUserCourse;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<User_Course> getListUserCourse() {
		return listUserCourse;
	}
	public void setListUserCourse(List<User_Course> listUserCourse) {
		this.listUserCourse = listUserCourse;
	}
	public User(int id, @NotEmpty(message = "username can not be null") String username,
			@NotEmpty(message = "email can not be null") String email,
			@NotEmpty(message = "Password can not be null") String password,
			@NotNull(message = "Gender can not be null") boolean gender,
			@NotNull(message = "Birthday can not be null") Date dateOfBirth, String avatar,
			@NotNull(message = "Phone can not be null") String phone,
			@NotEmpty(message = "Address can not be null") String address, boolean enabled,
			List<User_Course> listUserCourse) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.avatar = avatar;
		this.phone = phone;
		this.address = address;
		this.enabled = enabled;
		this.listUserCourse = listUserCourse;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
