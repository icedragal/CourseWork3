package me.egorzhuravlev.coursework3.model;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.lang.Nullable;

public enum Size {
    SIZE_36(36),
    SIZE_36_5(36.5f),
    SIZE_37(37),
    SIZE_37_5(37.5f),
    SIZE_38(38),
    SIZE_38_5(38.5f);
    private final float size;
    Size(float size) {
        this.size = size;
    }

    @JsonValue
    public float getSize() {
        return size;
    }

    @Nullable
    public static Size parse(float size){
        for (Size s : values()) {
            if (Float.compare(s.size, size) == 0){
                return s;
            }
        }
        return null;
    }
}
