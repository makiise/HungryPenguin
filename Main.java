package fop.w4fish;

public class Penguin extends MiniJava {

    public static void printWorld(int[][] world, int pinguRow, int pinguColumn) {
       
        for(int i = 0;i < world.length;i++) {
            for(int j = 0;j < world[i].length;j++) {
                if(i == pinguRow && j == pinguColumn) {
                    if (world[i][j] == 0) {
                        System.out.print("L(P)"+ '\t');
                    }
                    else if (world[i][j] == 1) {
                        System.out.print("I(P)"+ '\t');
                    }
                    else if(world[i][j] == 2) {
                        System.out.print("W(P)"+'\t');
                    }
                    else if(world[i][j] == 3) {
                        System.out.print("S(P)" + '\t');

                    }
                    else if(world[i][j] == 4) {
                        System.out.print("F(P)" + '\t');
                    }
                }
                else {
                    if (j == world[i].length - 1) {
                        if (world[i][j] == 0) {
                            System.out.print("L");
                        } else if (world[i][j] == 1) {
                            System.out.print("I");
                        } else if (world[i][j] == 2) {
                            System.out.print("W");
                        } else if (world[i][j] == 3) {
                            System.out.print("S");
                        } else if (world[i][j] == 4) {
                            System.out.print("F");
                        }
                    } else {
                        if (world[i][j] == 0) {
                            System.out.print("L" + '\t');
                        } else if (world[i][j] == 1) {
                            System.out.print("I" + '\t');
                        } else if (world[i][j] == 2) {
                            System.out.print("W" + '\t');
                        } else if (world[i][j] == 3) {
                            System.out.print("S" + '\t');
                        } else if (world[i][j] == 4) {
                            System.out.print("F" + '\t');
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    public static boolean isFishReachable(int[][] world, int pinguRow, int pinguColumn) {
        //TODO
        if (world[pinguRow][pinguColumn] == 0) {
            if (Check(world, pinguRow, pinguColumn + 1)) {
                return isFishReachable(world,pinguRow,pinguColumn+1);
            } else if (Check(world, pinguRow, pinguColumn - 1)) {
                return isFishReachable(world,pinguRow,pinguColumn-1);
            } else if (Check(world, pinguRow + 1, pinguColumn)) {
                return isFishReachable(world,pinguRow+1,pinguColumn);
            } else if (Check(world, pinguRow - 1, pinguColumn)) {
                return isFishReachable(world, pinguRow - 1, pinguColumn);
            }
            else {
                return false;
            }
        } else if (world[pinguRow][pinguColumn] == 1) {
            if (Check(world, pinguRow + 1, pinguColumn + 1)) {
                return isFishReachable(world,pinguRow+1,pinguColumn+1);
            } else if (Check(world, pinguRow - 1, pinguColumn - 1)) {
                return isFishReachable(world,pinguRow-1,pinguColumn-1);
            } else if (Check(world, pinguRow + 1, pinguColumn - 1)) {
                return isFishReachable(world,pinguRow+1,pinguColumn-1);
            } else if (Check(world, pinguRow - 1, pinguColumn + 1)) {
                return isFishReachable(world,pinguRow-1,pinguColumn+1);
            }
            else {
                return false;
            }
        } else if (world[pinguRow][pinguColumn] == 2) {
            if (Check(world, pinguRow + 3, pinguColumn + 3)) {
                return isFishReachable(world,pinguRow+3,pinguColumn+3);
            } else if (Check(world, pinguRow - 3, pinguColumn - 3)) {
                return isFishReachable(world,pinguRow-3,pinguColumn-3);
            } else if (Check(world, pinguRow + 3, pinguColumn - 3)) {
                return isFishReachable(world,pinguRow+3,pinguColumn-3);
            } else if (Check(world, pinguRow - 3, pinguColumn + 3)) {
                return isFishReachable(world,pinguRow-3,pinguColumn+3);
            }
            else {
                return false;
            }
        }
    
            return false;
    }

    public static boolean Check(int[][] world,int a,int b) {
        if(a < 0 || b<0 || a > world.length-1 || b > world[a].length-1 ) {
            return false;
        }
        if(world[a][b] == 3) {
            return false;
        }
            return true;
    }

    /**
     * returns the example world 1.
     * Do not modify this method.
     * @return An example world
     */
    public static int[][] generateExampleWorldOne(){
        return new int[][] {{2,3,3,3,3,3}, {3,0,3,3,4,3}, {3,3,3,3,3,1}, {3,3,3,0,1,3}, {3,3,3,3,3,3}};
    }

    /**
     * returns the example world 1.
     * Do not modify this method.
     * @return An example world
     */
    public static int[][] generateExampleWorldTwo(){
        return new int[][] {{0,0,0,2}, {0,0,0,1}, {0,1,3,4}, {3,4,3,3}};
    }

    /** 
     *  You may use the main method for testing your program.
     */
    public static void main(String[] args){
        int pinguRow =  0;
        int pinguColumn = 0;
        int[][] world = generateExampleWorldOne();
        printWorld(world, pinguRow, pinguColumn);
        write(""+isFishReachable(world, pinguRow, pinguColumn));
    }
}
