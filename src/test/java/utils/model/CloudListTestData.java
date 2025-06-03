package utils.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CloudListTestData(
        @JsonProperty("firstCloudName") String firstCloudName,
        @JsonProperty("firstCloudLearnMore") String firstCloudLearnMore,
        @JsonProperty("secondCloudName") String secondCloudName,
        @JsonProperty("secondCloudDirection") String secondCloudDirection,
        @JsonProperty("secondCloudLearnMore") String secondCloudLearnMore,
        @JsonProperty("story") String story,
        @JsonProperty("description") String description
) {
    public boolean hasSecondCloud() {
        return secondCloudName != null && !secondCloudName.isBlank();
    }
}
