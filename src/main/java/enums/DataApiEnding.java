package enums;

import lombok.Getter;

@Getter
public enum DataApiEnding {
    UPDATE_PERSON("UpdateUser/");

    private String apiEnding;

    DataApiEnding(String apiEnding) {
        this.apiEnding = "Data/" + apiEnding;
    }
}