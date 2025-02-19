package com.codegym;

public class TennisGame {
    private static final int LOVE = 0;
    private static final int FIFTEEN = 1;
    private static final int THIRTY = 2;
    private static final int FORTY = 3;
    private static final int ABOVE_FORTY = 4;

    public static String getScore(int player1Score, int player2Score) {
        if (player1Score == player2Score) {
            return getEqualScore(player1Score);
        }
        if (player1Score >= ABOVE_FORTY || player2Score >= ABOVE_FORTY) {
            return getAdvantageOrWin(player1Score, player2Score);
        }
        return getStandardScore(player1Score, player2Score);
    }

    private static String getEqualScore(int score) {
        switch (score) {
            case LOVE:
                return "Love-All";
            case FIFTEEN:
                return "Fifteen-All";
            case THIRTY:
                return "Thirty-All";
            case FORTY:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    private static String getAdvantageOrWin(int player1Score, int player2Score) {
        int scoreDifference = player1Score - player2Score;
        if (scoreDifference == 1) {
            return "Advantage player1";
        } else if (scoreDifference == -1) {
            return "Advantage player2";
        } else if (scoreDifference >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private static String getStandardScore(int player1Score, int player2Score) {
        return getPlayerScore(player1Score) + "-"
                + getPlayerScore(player2Score);
    }

    private static String getPlayerScore(int score) {
        String scoreDescription = "";
        switch (score) {
            case LOVE:
                scoreDescription = "Love";
                break;
            case FIFTEEN:
                scoreDescription = "Fifteen";
                break;
            case THIRTY:
                scoreDescription = "Thirty";
                break;
            case FORTY:
                scoreDescription = "Forty";
        }
        return scoreDescription;
    }
}
