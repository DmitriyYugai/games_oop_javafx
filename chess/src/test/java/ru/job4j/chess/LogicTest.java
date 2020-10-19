package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.junit.Assert.assertSame;

public class LogicTest {

    @Test
    public void whenMoveForwardThenOK()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test
    public void whenMoveBackwardThenOK()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F4));
        logic.move(Cell.F4, Cell.C1);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenMoveThenFigureNotFound()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F4));
        logic.move(Cell.F2, Cell.C1);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenMoveThenOccupiedCell()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F4));
        logic.add(new BishopBlack(Cell.E3));
        logic.move(Cell.F4, Cell.C1);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveThenImpossibleMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F4));
        logic.move(Cell.F4, Cell.E6);
    }

}