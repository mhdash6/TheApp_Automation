package utils.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginTestData(
        @JsonProperty("userName") String userName,
        @JsonProperty("password") String password,
        @JsonProperty("shouldLogin") boolean shouldLogin,
        @JsonProperty("story") String story,
        @JsonProperty("description") String description
) {

}
