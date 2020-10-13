package nutriscore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Random number request DTO.
 */
public class RequestDto {

	private Integer id;
	@JsonProperty(value = "jsonrpc")
	private String version;
	private String method;
	@JsonProperty(value = "params")
	private ParametersDto parameters;
	
	public RequestDto() {}
	
	public RequestDto(Integer id, String version, String method, ParametersDto parameters) {
		this.id = id;
		this.version = version;
		this.method = method;
		this.parameters = parameters;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public ParametersDto getParameters() {
		return parameters;
	}
	public void setParameters(ParametersDto parameters) {
		this.parameters = parameters;
	}
	
	
}
