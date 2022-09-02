package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertThrows;

public class BishopBlackTest {

    @Test
    public void whenCorrectPosition() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        Cell actual = bishopBlack.position();
        Cell expected = Cell.C8;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenCorrectCopy() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        Figure actual = bishopBlack.copy(Cell.D7);
        Figure expected = new BishopBlack(Cell.D7);
        assertThat(actual.position()).isEqualTo(expected.position());
    }

    @Test
    public void whenCorrectWay() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        Cell[] actual = bishopBlack.way(Cell.A6);
        Cell[] expected = {Cell.B7, Cell.A6};
        assertThat(actual).containsExactly(expected);
    }

    @Test
    public void whenIncorrectWay() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    bishopBlack.way(Cell.C7);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C8 to C7");
    }
}