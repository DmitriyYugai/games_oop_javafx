package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D2);
        Cell expected = Cell.D2;
        Cell rsl = bishopBlack.position();
        assertSame(expected, rsl);
    }

    @Test
    public void whenCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D2);
        bishopBlack = (BishopBlack) bishopBlack.copy(Cell.E1);
        Cell expected = Cell.E1;
        Cell rsl = bishopBlack.position();
        assertSame(expected, rsl);
    }

    @Test
    public void whenWay() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] rsl = bishopBlack.way(Cell.G5);
        assertThat(expected, is(rsl));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenWayWithException() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] rsl = bishopBlack.way(Cell.G3);
    }

}