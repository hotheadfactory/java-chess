package chess.domain.view;

import chess.domain.Team;
import chess.domain.board.Board;
import chess.domain.pieces.Piece;
import chess.domain.position.Positions;

public class WebOutputView {

    private static final int MAX_BOARD_NUMBER = 8;
    private static final int MIN_BOARD_NUMBER = 1;

    public static String printBoard(Board board) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = MAX_BOARD_NUMBER; i >= MIN_BOARD_NUMBER; i--) {
            printRank(board, stringBuilder, i);
        }
        return stringBuilder.toString();
    }

    private static void printRank(Board board, StringBuilder stringBuilder, int i) {
        stringBuilder.append("<div class=\"blank\"></div>\n");
        for (int j = MIN_BOARD_NUMBER; j <= MAX_BOARD_NUMBER; j++) {
            Piece piece = board.findPiece(Positions.matchWith(j, i));
            stringBuilder.append(printPiece(piece, j, i));
        }
        stringBuilder.append("<div class=\"blank\"></div>\n");
    }

    private static String printPiece(Piece piece, int x, int y) {
        String tileColor = "";

        if ((x + y) % 2 == 0) {
            tileColor = " BLACK ";
        }
        if ((x + y) % 2 != 0) {
            tileColor = " WHITE ";
        }

        if (piece.isOurPiece(Team.WHITE)) {
            return "<div class=\"" + x + "" + y + tileColor + "WHITE" + piece + "\"></div>\n";
        }
        if (piece.isOurPiece(Team.BLACK)) {
            return "<div class=\"" + x + "" + y + tileColor + "BLACK" + piece + "\"></div>\n";
        }
        return "<div class=\"" + x + "" + y + tileColor + piece + "\"></div>\n";
    }

    public static String printTurn(Team team) {
        if (team == Team.WHITE) {
            return "WHITE";
        }
        return "BLACK";
    }
}