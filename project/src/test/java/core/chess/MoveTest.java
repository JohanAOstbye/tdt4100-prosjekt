package core.chess;

import core.chess.Board;
import core.chess.Move;
import core.chess.pieces.Pawn;
import core.chess.pieces.Queen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MoveTest {
  Board board = new Board();

  @BeforeEach
  void setUp() {
    board = new Board();
  }

  @Test
  void testCapture() {
    //caputre
    Move validCapture = new Move("Qxb7");
    assertTrue(validCapture.isCapture());
    Move illegalCapture1 = new Move("Qa6");
    Move illegalCapture2 = new Move("Qb6");

    assertFalse(illegalCapture1.isCapture());
    assertFalse(illegalCapture2.isCapture());
  }

  @Test
  void testValidCapture() {
    Board board = new Board();
    Queen queen = new Queen(board.getSquare("c6"), true);

    Pawn blackPawnB7 = new Pawn(board.getSquare("b7"), false);
    Pawn whitePawnA6 = new Pawn(board.getSquare("a6"), true);

    //caputre
    Move validCapture = new Move("Qxb7");
    assertTrue(validCapture.validCapture(board));
    Move illegalCapture1 = new Move("Qa6");
    Move illegalCapture2 = new Move("Qb6");

    assertFalse(illegalCapture1.validCapture(board));
    assertFalse(illegalCapture2.validCapture(board));
  }

  @Test
  void testTargetCordinates() {
    //caputre
    Move move1 = new Move("Qxb7");
    Move move2 = new Move("Qa6");

    assertEquals(move1.getTargetCordinates(), "b7");
    assertEquals(move2.getTargetCordinates(), "a6");
    assertNotEquals(move2.getTargetCordinates(), "b7");
  }

  @Test
  void testColumn() {
    //caputre
    Move move1 = new Move("Qxb7");
    Move move2 = new Move("Qa6");

    assertEquals(move1.getColumn(), "b");
    assertEquals(move2.getColumn(), "a");
    assertNotEquals(move2.getColumn(), "b");
  }

  @Test
  void testPiece() {
    //caputre
    Move move1 = new Move("Qxb7");
    Move move2 = new Move("Qa6");

    assertEquals(move1.getPiece(), 'Q');
    assertEquals(move2.getPiece(), 'Q');
    assertNotEquals(move2.getPiece(), 'R');
  }

  @Test
  void testToString() {
    //caputre
    Move move1 = new Move("Qxb7");
    Move move2 = new Move("Qa6");

    assertEquals(move1.toString(), "Qxb7");
    assertEquals(move2.toString(), "Qa6");
    assertNotEquals(move2.toString(), "Rxh7");
  }
}
