package org.example.ra0824.model.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public enum Tools {
    CHAINSAW_STIHL ("CHNS", "Chainsaw", "Stihl"),
    LADDER_WERNER ("LADW", "Ladder", "Werner"),
    JACKHAMMER_DEWALT ("JAKD", "Jackhammer", "DeWalt"),
    JACKHAMMER_RIGID ("JACKR", "Jackhammer", "Rigid");

    private final String code;
    private final String type;
    private final String brand;

    public static Tools fromCode(String code) {
        for (Tools tool : Tools.values()) {
            if (tool.getCode().equals(code)) {
                return tool;
            }
        }

        return null;
    }

}
