package utils.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EchoBoxTestData(
        @JsonProperty("firstInput") String firstInput,
        @JsonProperty("secondInput") String secondInput,
        @JsonProperty("story") String story,
        @JsonProperty("description") String description
) {
    public boolean shouldChangeText() {
        return secondInput != null && !secondInput.isBlank();
    }

    public String getExpectedFinalText() {
        if (shouldChangeText()){
           return secondInput;
        }
        return firstInput;
    }
}
