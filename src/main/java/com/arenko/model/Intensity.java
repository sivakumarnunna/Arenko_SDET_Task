package com.arenko.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Intensity {

@SerializedName("forecast")
@Expose
private Integer forecast;
@SerializedName("actual")
@Expose
private Integer actual;
@SerializedName("index")
@Expose
private String index;

public Integer getForecast() {
return forecast;
}

public void setForecast(Integer forecast) {
this.forecast = forecast;
}

public Integer getActual() {
return actual;
}

public void setActual(Integer actual) {
this.actual = actual;
}

public String getIndex() {
return index;
}

public void setIndex(String index) {
this.index = index;
}

@Override
public String toString() {
	return "Intensity [forecast=" + forecast + ", actual=" + actual + ", index=" + index + "]";
}

@Override
public boolean equals(Object o) {
	if (this == o)
		return true;
	if (o == null || getClass() != o.getClass())
		return false;
	Intensity intensity = (Intensity) o;
	return     Objects.equals(this.getActual(),intensity.getActual())
			&& Objects.equals(this.getForecast(),intensity.getForecast())
			&& Objects.equals(this.getIndex(),intensity.getIndex());
}

}