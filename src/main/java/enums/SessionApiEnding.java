package enums;

import lombok.Getter;

@Getter
public enum SessionApiEnding {
    LOGIN("Logon/");

    private String apiEnding;

    SessionApiEnding(String apiEnding) {
        this.apiEnding = "Session/" + apiEnding;
    }
}
