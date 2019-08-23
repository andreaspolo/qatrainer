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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false, unique = true)
	private String password;
	
	@Column(nullable = false)
	private boolean active = true;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name="user_has_principal"
			, joinColumns={
				@JoinColumn(name="user_id")
				}
			, inverseJoinColumns={
				@JoinColumn(name="principal_id")
				}
			)
	private List<Principal> principals = new ArrayList<Principal>();
	
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private List<Training> training = new ArrayList<Training>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Result> results = new ArrayList<Result>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<Training> getTraining() {
		return training;
	}

	public void setTraining(List<Training> training) {
		this.training = training;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
}
