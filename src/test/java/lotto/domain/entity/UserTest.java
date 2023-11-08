package lotto.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    @DisplayName("구매 금액이 1,000단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(longs = {1_001L, 999L})
    void createUserByInvalidAmountOfPurchasePrice(long purchasePrice) {
        assertThatThrownBy(() -> new User(getLottos(), purchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 음수이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(longs = {-1_000L, -1L})
    void createUserByNegativePurchasePrice(long purchasePrice) {
        assertThatThrownBy(() -> new User(getLottos(), purchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 양수이고 1,000원 단위이면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(longs = {0L, 1_000L})
    void createUserSuccess(long purchasePrice) {
        assertThatNoException().isThrownBy(() -> new User(getLottos(), purchasePrice));
    }

    private Lottos getLottos() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        return new Lottos(List.of(lotto));
    }


}