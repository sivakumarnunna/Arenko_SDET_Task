package com.arenko.model;

import java.util.Objects;


public class Order {

	private Integer orderId;
	private Integer level;
	private String code;
	private String parent;
	private String description;
	private String thisItemIncludes;
	private String thisItemAlsoIncludes;
	private String rulings;
	private String thisItemExcludes;
	private String referenceCode;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getThisItemIncludes() {
		return thisItemIncludes;
	}

	public void setThisItemIncludes(String thisItemIncludes) {
		this.thisItemIncludes = thisItemIncludes;
	}

	public String getThisItemAlsoIncludes() {
		return thisItemAlsoIncludes;
	}

	public void setThisItemAlsoIncludes(String thisItemAlsoIncludes) {
		this.thisItemAlsoIncludes = thisItemAlsoIncludes;
	}

	public String getRulings() {
		return rulings;
	}

	public void setRulings(String rulings) {
		this.rulings = rulings;
	}

	public String getThisItemExcludes() {
		return thisItemExcludes;
	}

	public void setThisItemExcludes(String thisItemExcludes) {
		this.thisItemExcludes = thisItemExcludes;
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	public Order() {

	}

	public Order(int orderId, int level, String code, String parent, String description, String thisItemIncludes,
			String thisItemAlsoIncludes, String rulings, String thisItemExcludes, String referenceCode) {
		this.orderId = orderId;
		this.level = level;

		this.code = code;
		this.parent = parent;
		this.description = description;
		this.thisItemIncludes = thisItemIncludes;
		this.thisItemAlsoIncludes = thisItemAlsoIncludes;
		this.rulings = rulings;
		this.thisItemExcludes = thisItemExcludes;
		this.referenceCode = referenceCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Order order = (Order) o;
		return orderId == order.orderId && level == order.level && Objects.equals(code, order.code)
				&& Objects.equals(parent, order.parent) && Objects.equals(description, order.description)
				&& Objects.equals(thisItemIncludes, order.thisItemIncludes)
				&& Objects.equals(thisItemAlsoIncludes, order.thisItemAlsoIncludes)
				&& Objects.equals(rulings, order.rulings) && Objects.equals(thisItemExcludes, order.thisItemExcludes)
				&& Objects.equals(referenceCode, order.referenceCode);
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", level=" + level + ", code=" + code + ", parent=" + parent
				+ ", description=" + description + ", thisItemIncludes=" + thisItemIncludes + ", thisItemAlsoIncludes="
				+ thisItemAlsoIncludes + ", rulings=" + rulings + ", thisItemExcludes=" + thisItemExcludes
				+ ", referenceCode=" + referenceCode + "]";
	}

}
