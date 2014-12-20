package me.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

/**
 * Entity which holds EAV relation. V-component is composite and represented
 * by separate embedable class.
 */
@Entity
@Table(name = "me_value")
public class MEParameterValue extends DomainObject implements Serializable {
	private static final long serialVersionUID = -1525364452867565243L;

	@Id
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private MEEntity entity;

	@Id
	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	private MEParameter parameter;

	@Id
	@Column(name = "order_num")
	@OrderColumn(updatable = true)
	private Integer order;

	@Embedded
	private MEValue value;

	public MEParameterValue() {
	}

	public MEParameterValue(MEParameter parameter, String text, MEEntity reference) {
		setParameter(parameter);
		setValue(new MEValue(text, reference));
	}

	public MEEntity getEntity() {
		return entity;
	}

	public void setEntity(MEEntity entity) {
		this.entity = entity;
	}

	public MEParameter getParameter() {
		return parameter;
	}

	public void setParameter(MEParameter parameter) {
		this.parameter = parameter;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public MEValue getValue() {
		return value;
	}

	public void setValue(MEValue value) {
		this.value = value;
		if (this.value != null) {
			this.value.setParameterValue(this);
		}
	}
}
