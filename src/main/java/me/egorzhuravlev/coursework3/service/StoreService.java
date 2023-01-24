package me.egorzhuravlev.coursework3.service;

import me.egorzhuravlev.coursework3.exception.IncorrectParamException;
import me.egorzhuravlev.coursework3.model.Color;
import me.egorzhuravlev.coursework3.model.Size;
import me.egorzhuravlev.coursework3.model.Sock;
import me.egorzhuravlev.coursework3.model.SockItem;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class StoreService {
    private final Map<Sock, Integer> socks = new HashMap<>();

    public void income(SockItem sockItem) {
        if (isNonValid(sockItem)) {
            throw new IncorrectParamException();
        }
        Sock sock = sockItem.getSock();
        if (socks.containsKey(sock)) {
            socks.replace(sock, socks.get(sock) + sockItem.getQuantity());
        } else {
            socks.put(sock, sockItem.getQuantity());
        }
    }

    public void expenditure(SockItem sockItem) {
        Sock sock = sockItem.getSock();
        if (!socks.containsKey(sock) || isNonValid(sockItem)) {
            throw new IncorrectParamException();
        }
        int available = socks.get(sock);
        int result = available - sockItem.getQuantity();
        if (result < 0) {
            throw new IncorrectParamException();
        }
        socks.replace(sock, result);
    }

    public int count(String color,
                      float size,
                      int cottonMin,
                      int cottonMax) {
        Color c = Color.parse(color);
        Size s = Size.parse(size);
        if (Objects.isNull(c) || Objects.isNull(s) || cottonMin >= cottonMax || cottonMin < 0
                || cottonMax > 100) {
            throw new IncorrectParamException();
        }
        for (Map.Entry<Sock, Integer> entry: socks.entrySet()) {
            Sock sock = entry.getKey();
            int available = entry.getValue();
            if (sock.getColor() == c && sock.getSize() == s &&
                    sock.getCottonPart() >= cottonMin &&
                    sock.getCottonPart() <= cottonMax) {
                return available;
            }
        }
            return 0;
    }

    private boolean isNonValid(SockItem sockItem) {
        Sock sock = sockItem.getSock();

        return sock.getCottonPart() < 0 || sock.getCottonPart() > 100 ||
                sockItem.getQuantity() <= 0;
    }

}
