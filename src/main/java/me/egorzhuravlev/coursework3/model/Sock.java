package me.egorzhuravlev.coursework3.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@NoArgsConstructor
@Data
public class Sock {
    private  Size size;
    private  Color color;
    private  int cottonPart;

    public Sock(Size size, Color color, int cottonPart) {
        this.size = size;
        this.color = color;
        this.cottonPart = cottonPart;
    }
}
