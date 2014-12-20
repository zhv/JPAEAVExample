package me.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Embeddable
public class MEValue extends DomainObject {
	@Transient
	private MEParameterValue parameterValue;

	@Column
	private String text;

	@OneToOne(optional = true)
	private MEEntity reference;

	public MEValue() {
	}

	public MEValue(String text, MEEntity reference) {
		this.text = text;
		this.reference = reference;
	}

	public MEParameterValue getParameterValue() {
		return parameterValue;
	}

	public void setParameterValue(MEParameterValue parameterValue) {
		this.parameterValue = parameterValue;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public MEEntity getReference() {
		return reference;
	}

	public void setReference(MEEntity reference) {
		this.reference = reference;
	}

}
