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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Lob
	@Column(nullable = false, unique = true)
	private String text;
	
	@Lob
	private String notes;
	
	@Column(nullable = false)
	private boolean verified = false;

	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	private List<Answer> answers = new ArrayList<Answer>();
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name="question_has_link"
			, joinColumns={
				@JoinColumn(name="question_id")
				}
			, inverseJoinColumns={
				@JoinColumn(name="link_id")
				}
			)
	private List<Link> links = new ArrayList<Link>();
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name="question_has_categotu"
			, joinColumns={
				@JoinColumn(name="question_id")
				}
			, inverseJoinColumns={
				@JoinColumn(name="categoty_id")
				}
			)
	private List<Category> categories = new ArrayList<Category>();
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
