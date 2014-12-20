package me.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "me_entity")
public class MEEntity extends DomainObject {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column
	private Long id;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private String type;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "entity_id")
	private List<MEParameterValue> values = Collections.emptyList();

	public MEEntity() {
	}

	public MEEntity(String name, String description, String type) {
		this.name = name;
		this.description = description;
		this.type = type;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<MEParameterValue> getValues() {
		return Collections.unmodifiableList(values);
	}

	public void setValues(List<MEParameterValue> values) {
		if (values != null) {
			this.values = new ArrayList<MEParameterValue>(values);
			int i = 0;
			for (MEParameterValue pv : this.values) {
				pv.setEntity(this);
				pv.setOrder(i++);
			}
		} else {
			this.values = null;
		}
	}
}
