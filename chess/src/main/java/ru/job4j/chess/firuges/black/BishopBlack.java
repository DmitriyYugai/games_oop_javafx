package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) throws  ImpossibleMoveException {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = dest.getX() - position.getX();
        if (size < 0) {
            size = -size;
        }
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() - position.getX() > 0 ? +1 : -1;
        int deltaY = dest.getY() - position.getY() > 0 ? +1 : -1;
        for (int index = 0; index < size; index++) {
            int x = position.getX() + deltaX * (index + 1);
            int y = position.getY() + deltaY * (index + 1);
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int subX = source.getX() - dest.getX();
        int subY = source.getY() - dest.getY();
        if(subX < 0) {
            subX = -subX;
        }
        if(subY < 0) {
            subY = -subY;
        }
        return subX == subY;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
