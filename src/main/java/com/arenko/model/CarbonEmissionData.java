package com.arenko.model;
import java.util.Objects;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class CarbonEmissionData {

@SerializedName("from")
@Expose
private String from;
@SerializedName("to")
@Expose
private String to;
@SerializedName("intensity")
@Expose
private Intensity intensity;

public String getFrom() {
return from;
}

public void setFrom(String from) {
this.from = from;
}

public String getTo() {
return to;
}

public void setTo(String to) {
this.to = to;
}

public Intensity getIntensity() {
return intensity;
}

public void setIntensity(Intensity intensity) {
this.intensity = intensity;
}

@Override
public boolean equals(Object o) {
	if (this == o)
		return true;
	if (o == null || getClass() != o.getClass())
		return false;
	CarbonEmissionData ced = (CarbonEmissionData) o;
	return     Objects.equals(this.getFrom(),ced.getFrom())
			&& Objects.equals(this.getTo(),ced.getTo())
			&& Objects.equals(this.getIntensity(),ced.getIntensity());
}

@Override
public String toString() {
	return "CarbonEmissionData [from=" + from + ", to=" + to + ", intensity=" + intensity + "]";
}

}