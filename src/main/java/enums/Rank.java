package enums;

import lombok.Getter;

@Getter
public enum Rank {
    MASTER("Master");

    private String rank;

    Rank(String rank) {
        this.rank = rank;
    }
}