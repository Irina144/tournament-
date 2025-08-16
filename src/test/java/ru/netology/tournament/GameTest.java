package ru.netology.tournament;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;

    Player anna = new Player(1, "Anna", 10);
    Player boris = new Player(2, "Boris", 7);
    Player chris = new Player(3, "Chris", 10);

    @BeforeEach
    void setup() {
        game = new Game();
        game.register(anna);
        game.register(boris);
        game.register(chris);
    }

    @Test
    void shouldReturn1WhenFirstPlayerStronger() {
        int result = game.round("Anna", "Boris");
        assertEquals(1, result);
    }

    @Test
    void shouldReturn2WhenSecondPlayerStronger() {
        int result = game.round("Boris", "Anna");
        assertEquals(2, result);
    }

    @Test
    void shouldReturn0WhenTie() {
        int result = game.round("Anna", "Chris");
        assertEquals(0, result);
    }

    @Test
    void shouldThrowWhenFirstNotRegistered() {
        NotRegisteredException ex = assertThrows(
                NotRegisteredException.class,
                () -> game.round("Dasha", "Anna")
        );
        assertTrue(ex.getMessage().contains("Dasha"));
    }

    @Test
    void shouldThrowWhenSecondNotRegistered() {
        NotRegisteredException ex = assertThrows(
                NotRegisteredException.class,
                () -> game.round("Anna", "Egor")
        );
        assertTrue(ex.getMessage().contains("Egor"));
    }

    @Test
    void shouldThrowWhenBothNotRegistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("X", "Y"));
    }
}