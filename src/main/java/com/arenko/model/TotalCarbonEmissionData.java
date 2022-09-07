package com.arenko.model;


import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class TotalCarbonEmissionData {

@SerializedName("data")
@Expose
private List<CarbonEmissionData> data = null;

public List<CarbonEmissionData> getData() {
return data;
}

public void setData(List<CarbonEmissionData> data) {
this.data = data;
}

@Override
public String toString() {
	return "Data [data=" + data + "]";
}

@Override
public boolean equals(Object o) {
	if (this == o)
		return true;
	if (o == null || getClass() != o.getClass())
		return false;
	TotalCarbonEmissionData listced = (TotalCarbonEmissionData) o;
	return  Objects.equals(this.getData(),listced.getData()) ;
}

}