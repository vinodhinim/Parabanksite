
package com.maveric.core.cucumber.reporter.pojo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect
@Getter
@Setter
public class CucumberResults {

    @JsonProperty("line")
    public Integer line;
    @JsonProperty("elements")
    public List<Element> elements = new ArrayList<Element>();
    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;
    @JsonProperty("id")
    public String id;
    @JsonProperty("keyword")
    public String keyword;
    @JsonProperty("uri")
    public String uri;
    @JsonProperty("tags")
    public List<Tag> tags = new ArrayList<Tag>();
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Tag> getTags() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Element> getElements() {
		// TODO Auto-generated method stub
		return null;
	}

}
