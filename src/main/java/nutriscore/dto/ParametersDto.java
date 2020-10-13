package nutriscore.dto;

/**
 * Parameters DTO for random number request.
 */
public class ParametersDto {

	private String apiKey;
	private Integer n;
	private Integer min;
	private Integer max;
	
	public ParametersDto() {}
	
	public ParametersDto(String apiKey, Integer n, Integer min, Integer max) {
		this.apiKey = apiKey;
		this.n = n;
		this.min = min;
		this.max = max;
	}
	
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public Integer getN() {
		return n;
	}
	public void setN(Integer n) {
		this.n = n;
	}
	public Integer getMin() {
		return min;
	}
	public void setMin(Integer min) {
		this.min = min;
	}
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	
	
}
