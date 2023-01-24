package me.egorzhuravlev.coursework3.model;

import org.springframework.lang.Nullable;

import java.awt.*;

public enum Color {
    BLUE,
    WHITE,
    BLACK,
    RED,
    GREEN;

    @Nullable
    public static Color parse(String color){
        for (Color c : values()) {
            if (c.name().equals(color)){
                return c;
            }
        }
        return null;
    }
}
