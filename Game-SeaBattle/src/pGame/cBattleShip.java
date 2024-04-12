package pGame;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    /**
     *
     * @author  DHE
     * @version $40411$
     * @since 0.0
     */


public class cBattleship implements iShip {

        private final List<Cell> positions = new ArrayList<>();

        public cBattleship(Cell... cells) {
            this.positions.addAll(Arrays.asList(cells));
        }

        @Override
            public List<Cell> position() {
                return null;
        }

        @Override
            public List<Cell> border() {
                return null;
        }
}