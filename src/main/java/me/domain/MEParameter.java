package me.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "me_parameter")
public class MEParameter extends DomainObject {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column
	private Long id;

	@Column
	private String name;

	@Column
	private String type;

	@Column
	private Boolean multiple;

	public MEParameter() {
	}

	public MEParameter(String name, String type, Boolean multiple) {
		this.name = name;
		this.type = type;
		this.multiple = multiple;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getMultiple() {
		return multiple;
	}

	public void setMultiple(Boolean multiple) {
		this.multiple = multiple;
	}

}
