package com.qatrainer.core.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer parentId;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Lob
	private String description;
	
	@Column(nullable = false)
	private boolean active = true;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name="category_has_principal"
			, joinColumns={
				@JoinColumn(name="category_id")
				}
			, inverseJoinColumns={
				@JoinColumn(name="principal_id")
				}
			)
	private List<Principal> principals = new ArrayList<Principal>();
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Principal> getPrincipals() {
		return principals;
	}

	public void setPrincipals(List<Principal> principals) {
		this.principals = principals;
	}
	
}
