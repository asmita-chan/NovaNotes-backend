package dev.novanotes.backend.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserRoleKey implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long userId;
	private Long roleId;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}
