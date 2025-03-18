package cleancode.minesweeper.tobe.minesweeper.board.cell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CellStateTest {

    @DisplayName("셀스테이트가 주어졌을 때, 플래그 여부와 오픈 여부를 얻을 수 있다.")
    @Test
    void getStatusOfCellState(){
        // given
        CellState cellState = new CellState(false, true);

        // when
        boolean isFlagged = cellState.isFlagged();
        boolean isOpened = cellState.isOpened();

        // then
        assertThat(isFlagged).isFalse();
        assertThat(isOpened).isTrue();
    }

}
