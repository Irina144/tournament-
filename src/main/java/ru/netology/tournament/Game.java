package ru.netology.tournament;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    // хранение по имени игрока → O(1) доступ
    private final Map<String, Player> registered = new HashMap<>();

    public void register(Player player) {
        registered.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) {
        Player p1 = registered.get(playerName1);
        Player p2 = registered.get(playerName2);

        if (p1 == null) {
            throw new NotRegisteredException("Игрок '" + playerName1 + "' не зарегистрирован");
        }
        if (p2 == null) {
            throw new NotRegisteredException("Игрок '" + playerName2 + "' не зарегистрирован");
        }

        if (p1.getStrength() == p2.getStrength()) return 0;
        return (p1.getStrength() > p2.getStrength()) ? 1 : 2;
    }

    // Возвращаем копию списка зарегистрированных (как раньше)
    public List<Player> getRegistered() {
        return new ArrayList<>(registered.values());
    }
}