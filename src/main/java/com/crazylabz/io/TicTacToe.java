package com.crazylabz.io;

public class TicTacToe {

    private String[] bord = new String[9];
    private String BORD =
                    " 0 | 1 | 2 \n" +
                    "-----------\n" +
                    " 3 | 4 | 5 \n" +
                    "-----------\n" +
                    " 6 | 7 | 8 \n";


    public void play(String symbol, int location) {
        bord[location] = symbol;
    }

    public void printBord(){
        for (int i = 0; i < bord.length; i++) {
            if(bord[i] == null || bord[i].isEmpty()){
                BORD = BORD.replace(String.valueOf(i), " ");
            } else {
                BORD = BORD.replace(String.valueOf(i), bord[i]);
            }
        }

        checkWin();
        System.out.print(BORD);
    }

    private void checkWin() {
        new ScorrerValidator(0).leapIn(1);
        new ScorrerValidator(3).leapIn(1);
        new ScorrerValidator(6).leapIn(1);

        new ScorrerValidator(0).leapIn(3);
        new ScorrerValidator(1).leapIn(3);
        new ScorrerValidator(2).leapIn(3);

        new ScorrerValidator(0).leapIn(4);
        new ScorrerValidator(2).leapIn(2);
    }

    private void replaceTo(String target, String replacement) {
        BORD = BORD.replaceFirst(target, replacement);
    }

    private class ScorrerValidator{
        int startingPosition;

        public ScorrerValidator(int startingPosition){
            this.startingPosition = startingPosition;
        }

        public void leapIn(int numOfLeaps){
            if((bord[startingPosition] != null) && (bord[startingPosition].equals(bord[startingPosition + numOfLeaps]) && bord[startingPosition].equals(bord[startingPosition +numOfLeaps+numOfLeaps]))){
                replaceTo(bord[startingPosition], "w");
                replaceTo(bord[startingPosition + numOfLeaps], "i");
                replaceTo(bord[startingPosition + numOfLeaps + numOfLeaps], "n");
            }
        }
    }
}
