package cleancode.minesweeper.tobe.minesweeper.board.position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CellPositionTest {

    @DisplayName("행 인덱스와 열 인덱스가 동일하면 같은 셀포지션이다.")
    @Test
    void isEqual(){
        // given
        CellPosition a = new CellPosition(1, 2);
        CellPosition b = new CellPosition(1, 2);

        // when
        boolean result = a.equals(b);

        // then
        assertThat(result).isTrue();
    }
    
    @DisplayName("인덱스끼리 값을 서로 비교할 수 있다.")
    @Test
    void compareIndexValue(){
        // given
        CellPosition cellPosition = new CellPosition(1, 2);
        
        // when
        boolean a = cellPosition.isRowIndexMoreThanOrEqual(2);
        boolean b = cellPosition.isRowIndexLessThan(2);
        boolean c = cellPosition.isColIndexMoreThanOrEqual(2);
        boolean d = cellPosition.isColIndexLessThan(2);

        // then
        assertThat(a).isFalse();
        assertThat(b).isTrue();
        assertThat(c).isTrue();
        assertThat(d).isFalse();
    }

    @DisplayName("상대 좌표를 더해 새로운 좌표를 구할 수 있다.")
    @Test
    void addRelativePosition(){
        // given
        CellPosition originPosition = new CellPosition(1, 2);
        RelativePosition relativePosition = new RelativePosition(1, 0);

        // when
        CellPosition newPosition = originPosition.calculatePositionBy(relativePosition);

        // then
        assertThat(newPosition).isEqualTo(new CellPosition(2, 2));
    }

    @DisplayName("상대 좌표를 더해 구한 새로운 좌표가 범위를 벗어나면 예외를 던진다.")
    @Test
    void addRelativePositionWithOutOfRange(){
        // given
        CellPosition originPosition = new CellPosition(1, 2);

        // when
        RelativePosition relativePosition = new RelativePosition(-2, 0);

        // then
        assertThatThrownBy(() -> originPosition.calculatePositionBy(relativePosition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("움직일 수 있는 좌표가 아닙니다.");
    }
}
