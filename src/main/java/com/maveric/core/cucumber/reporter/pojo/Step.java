
package com.maveric.core.cucumber.reporter.pojo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@JsonAutoDetect
@Getter
@Setter
public class Step {

    @JsonProperty("output")
    public List<String> output = new ArrayList<String>();
    @JsonProperty("result")
    public Result result;
    @JsonProperty("line")
    public Integer line;
    @JsonProperty("name")
    public String name;
    @JsonProperty("match")
    public Match match;
    @JsonProperty("keyword")
    public String keyword;
    @JsonProperty("embeddings")
    public List<Embedding> embeddings = new ArrayList<Embedding>();
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getResult() {
		// TODO Auto-generated method stub
		return null;
	}
	public Collection<Tag> getOutput() {
		// TODO Auto-generated method stub
		return null;
	}

}
