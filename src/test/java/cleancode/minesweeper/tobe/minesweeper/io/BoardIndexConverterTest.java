package cleancode.minesweeper.tobe.minesweeper.io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import cleancode.minesweeper.tobe.minesweeper.exception.GameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardIndexConverterTest {

    @DisplayName("사용자가 입력한 좌표에서 인덱스를 계산한다.")
    @Test
    void getSelectedIndex(){
        // given
        BoardIndexConverter boardIndexConverter = new BoardIndexConverter();
        String userInput = "b5";

        // when
        int selectedRowIndex = boardIndexConverter.getSelectedRowIndex(userInput);
        int selectedColIndex = boardIndexConverter.getSelectedColIndex(userInput);

        // then
        assertThat(selectedRowIndex).isEqualTo(4);
        assertThat(selectedColIndex).isEqualTo(1);
    }

    @DisplayName("사용자가 입력한 좌표의 행이 범위를 벗어난 경우 예외를 던진다.")
    @Test
    void getSelectedIndexWithOutOfRange(){
        // given
        BoardIndexConverter boardIndexConverter = new BoardIndexConverter();

        // when
        String userInput = "b-2";

        // then
        assertThatThrownBy(() -> boardIndexConverter.getSelectedRowIndex(userInput))
                .isInstanceOf(GameException.class)
                .hasMessage("잘못된 입력입니다.");
    }
}
