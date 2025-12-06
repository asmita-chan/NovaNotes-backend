package dev.novanotes.backend.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "login_id")
	private String loginId;
	
	@Column(name = "user_pwd")
	private String userPwd;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "last_changed_pwd")
	private Timestamp lastChangedPwd;
	
	@UpdateTimestamp
	@Column(name = "last_login_updated_on")
	private Timestamp lastLoginUpdatedOn;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "active_flag")
	private Boolean activeFlag;
	
	@CreationTimestamp
	@Column(name = "created_on")
	private Timestamp createdOn;
	
	@Column(name = "created_by")
	private Long createdBy;
	
	@UpdateTimestamp
	@Column(name = "updated_on")
	private Timestamp updatedOn;
	
	@Column(name = "updated_by")
	private Long updatedBy;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getLastChangedPwd() {
		return lastChangedPwd;
	}

	public void setLastChangedPwd(Timestamp lastChangedPwd) {
		this.lastChangedPwd = lastChangedPwd;
	}

	public Timestamp getLastLoginUpdatedOn() {
		return lastLoginUpdatedOn;
	}

	public void setLastLoginUpdatedOn(Timestamp lastLoginUpdatedOn) {
		this.lastLoginUpdatedOn = lastLoginUpdatedOn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
}
