package ru.netology.tournament;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Player> registered = new ArrayList<>();

    public void register(Player player) {
        registered.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player p1 = findByName(playerName1);
        Player p2 = findByName(playerName2);

        if (p1 == null) {
            throw new NotRegisteredException("Игрок '" + playerName1 + "' не зарегистрирован");
        }
        if (p2 == null) {
            throw new NotRegisteredException("Игрок '" + playerName2 + "' не зарегистрирован");
        }

        if (p1.getStrength() == p2.getStrength()) return 0;
        return (p1.getStrength() > p2.getStrength()) ? 1 : 2;
    }

    private Player findByName(String name) {
        for (Player p : registered) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public List<Player> getRegistered() {
        return new ArrayList<>(registered);
    }
}