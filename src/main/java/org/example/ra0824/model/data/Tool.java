package org.example.ra0824.model.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public enum Tool {
    CHAINSAW_STIHL ("CHNS", "Chainsaw", "Stihl"),
    LADDER_WERNER ("LADW", "Ladder", "Werner"),
    JACKHAMMER_DEWALT ("JAKD", "Jackhammer", "DeWalt"),
    JACKHAMMER_RIGID ("JAKR", "Jackhammer", "Rigid");

    private final String code;
    private final String type;
    private final String brand;

    public static Tool fromCode(String code) {
        for (Tool tool : Tool.values()) {
            if (tool.getCode().equalsIgnoreCase(code)) {
                return tool;
            }
        }

        return null;
    }

}
