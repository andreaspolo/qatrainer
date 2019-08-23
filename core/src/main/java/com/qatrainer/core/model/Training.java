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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "training")
public class Training {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Lob
	private String description;
	
	@Column(nullable = false)
	private boolean onlyVerified = false;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private User author;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name="training_has_categotu"
			, joinColumns={
				@JoinColumn(name="training_id")
				}
			, inverseJoinColumns={
				@JoinColumn(name="categoty_id")
				}
			)
	private List<Category> categories = new ArrayList<Category>();
	
	@OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isOnlyVerified() {
		return onlyVerified;
	}

	public void setOnlyVerified(boolean onlyVerified) {
		this.onlyVerified = onlyVerified;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
}
