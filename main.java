import java.util.Random;

class Solver {  
    public static void main(String args[]){
        System.out.println("Hello Java");

        TwentyFortyEight game = new TwentyFortyEight();
        game.print();
        System.out.println();
        game.right();
        game.print();
        System.out.println();
        game.left();
        game.print();
        System.out.println();
        game.right();
        game.print();
        System.out.println();
        game.up();
        game.print();
        System.out.println();
        game.down();
        game.print();
        System.out.println();
    }
}

class TwentyFortyEight {
    TwentyFortyEight() {
        positions = new int[4][];
        positions[0] = new int[4];
        positions[1] = new int[4];
        positions[2] = new int[4];
        positions[3] = new int[4];

        Random rand = new Random();
        int x1 = rand.nextInt(3);
        int y1 = rand.nextInt(3);
        int x2 = x1;
        int y2 = y1;

        while (x1 == x2 && y1 == y2) {
            x2 = rand.nextInt(3);
            y2 = rand.nextInt(3);
        }

        positions[y1][x1] = 2;
        positions[y2][x2] = 2;
    }

    public void print() {
        System.out.format("[%d, %d, %d, %d]\n[%d, %d, %d, %d]\n[%d, %d, %d, %d]\n[%d, %d, %d, %d]\n", positions[0][0], positions[0][1], positions[0][2], positions[0][3], positions[1][0], positions[1][1], positions[1][2], positions[1][3], positions[2][0], positions[2][1], positions[2][2], positions[2][3], positions[3][0], positions[3][1], positions[3][2], positions[3][3]);
    }

    public void right() {
        for (int y = 0; y < 4; y++) {
            // first, move everything right
            if (positions[y][3] == 0) {
                if (positions[y][2] != 0) {
                    positions[y][3] = positions[y][2];
                    positions[y][2] = 0;
                } else if (positions[y][1] != 0) {
                    positions[y][3] = positions[y][1];
                    positions[y][1] = 0;
                } else if (positions[y][0] != 0) {
                    positions[y][3] = positions[y][0];
                    positions[y][0] = 0;
                }
            }
            if (positions[y][2] == 0) {
                if (positions[y][1] != 0) {
                    positions[y][2] = positions[y][1];
                    positions[y][1] = 0;
                } else if (positions[y][0] != 0) {
                    positions[y][2] = positions[y][0];
                    positions[y][0] = 0;
                }
            }
            if (positions[y][1] == 0) {
                if (positions[y][0] != 0) {
                    positions[y][1] = positions[y][0];
                    positions[y][0] = 0;
                }
            }

            // then, merge right, starting with the rightmost
            if (positions[y][3] == positions[y][2]) {
                positions[y][3] = 2*positions[y][3];
                positions[y][2] = positions[y][1];
                positions[y][1] = positions[y][0];
                positions[y][0] = 0;
            }
            if (positions[y][2] == positions[y][1]) {
                positions[y][2] = 2*positions[y][2];
                positions[y][1] = positions[y][0];
                positions[y][0] = 0;
            }
            if (positions[y][1] == positions[y][0]) {
                positions[y][1] = 2*positions[y][1];
                positions[y][0] = 0;
            }
        }
    }

    public void left() {
        for (int y = 0; y < 4; y++) {
            // first, move everything left
            if (positions[y][0] == 0) {
                if (positions[y][1] != 0) {
                    positions[y][0] = positions[y][1];
                    positions[y][1] = 0;
                } else if (positions[y][2] != 0) {
                    positions[y][0] = positions[y][2];
                    positions[y][2] = 0;
                } else if (positions[y][3] != 0) {
                    positions[y][0] = positions[y][3];
                    positions[y][3] = 0;
                }
            }
            if (positions[y][1] == 0) {
                if (positions[y][2] != 0) {
                    positions[y][1] = positions[y][2];
                    positions[y][2] = 0;
                } else if (positions[y][3] != 0) {
                    positions[y][1] = positions[y][3];
                    positions[y][3] = 0;
                }
            }
            if (positions[y][2] == 0) {
                if (positions[y][3] != 0) {
                    positions[y][2] = positions[y][3];
                    positions[y][3] = 0;
                }
            }

            // then, merge left, starting with the leftmost
            if (positions[y][0] == positions[y][1]) {
                positions[y][0] = 2*positions[y][0];
                positions[y][1] = positions[y][2];
                positions[y][2] = positions[y][3];
                positions[y][3] = 0;
            }
            if (positions[y][1] == positions[y][2]) {
                positions[y][1] = 2*positions[y][1];
                positions[y][2] = positions[y][3];
                positions[y][3] = 0;
            }
            if (positions[y][2] == positions[y][3]) {
                positions[y][2] = 2*positions[y][2];
                positions[y][3] = 0;
            }
        }
    }

    public void up() {
        for (int x = 0; x < 4; x++) {
            // first, move everything up
            if (positions[0][x] == 0) {
                if (positions[1][x] != 0) {
                    positions[0][x] = positions[1][x];
                    positions[1][x] = 0;
                } else if (positions[2][x] != 0) {
                    positions[0][x] = positions[2][x];
                    positions[2][x] = 0;
                } else if (positions[3][x] != 0) {
                    positions[0][x] = positions[3][x];
                    positions[3][x] = 0;
                }
            }
            if (positions[1][x] == 0) {
                if (positions[2][x] != 0) {
                    positions[1][x] = positions[2][x];
                    positions[2][x] = 0;
                } else if (positions[3][x] != 0) {
                    positions[1][x] = positions[3][x];
                    positions[3][x] = 0;
                }
            }
            if (positions[2][x] == 0) {
                if (positions[3][x] != 0) {
                    positions[2][x] = positions[3][x];
                    positions[3][x] = 0;
                }
            }

            // then, merge up, starting with the upmost
            if (positions[0][x] == positions[1][x]) {
                positions[0][x] = 2*positions[0][x];
                positions[1][x] = positions[2][x];
                positions[2][x] = positions[3][x];
                positions[3][x] = 0;
            }
            if (positions[1][x] == positions[2][x]) {
                positions[1][x] = 2*positions[1][x];
                positions[2][x] = positions[3][x];
                positions[3][x] = 0;
            }
            if (positions[2][x] == positions[3][x]) {
                positions[2][x] = 2*positions[2][x];
                positions[3][x] = 0;
            }
        }
    }

    public void down() {
        for (int x = 0; x < 4; x++) {
            // first, move everything down
            if (positions[3][x] == 0) {
                if (positions[2][x] != 0) {
                    positions[3][x] = positions[2][x];
                    positions[2][x] = 0;
                } else if (positions[1][x] != 0) {
                    positions[3][x] = positions[1][x];
                    positions[1][x] = 0;
                } else if (positions[0][x] != 0) {
                    positions[3][x] = positions[0][x];
                    positions[0][x] = 0;
                }
            }
            if (positions[2][x] == 0) {
                if (positions[1][x] != 0) {
                    positions[2][x] = positions[1][x];
                    positions[1][x] = 0;
                } else if (positions[0][x] != 0) {
                    positions[2][x] = positions[0][x];
                    positions[0][x] = 0;
                }
            }
            if (positions[1][x] == 0) {
                if (positions[0][x] != 0) {
                    positions[1][x] = positions[0][x];
                    positions[0][x] = 0;
                }
            }

            // then, merge down, starting with the downmost
            if (positions[3][x] == positions[2][x]) {
                positions[3][x] = 2*positions[3][x];
                positions[2][x] = positions[1][x];
                positions[1][x] = positions[0][x];
                positions[0][x] = 0;
            }
            if (positions[2][x] == positions[1][x]) {
                positions[2][x] = 2*positions[2][x];
                positions[1][x] = positions[0][x];
                positions[0][x] = 0;
            }
            if (positions[1][x] == positions[0][x]) {
                positions[1][x] = 2*positions[1][x];
                positions[0][x] = 0;
            }
        }
    }

    private int positions[][];
}