package org.example.store;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CookingTest {

    @DisplayName("메뉴에 해당하는 음식을 만든다.")
    @Test
    void makeCookTest() {
        Cooking cooking = new Cooking(); // 요리사 객체 생성
        MenuItem menuItem = new MenuItem("돈까스", 5000); // 요리사에게 전달할 메뉴 항목 생성
        Cook cook = cooking.makeCook(menuItem); // 요리사에게 만들어야할 요리 메뉴 항목 전달

        assertThat(cook).isEqualTo(new Cook("돈까스", 5000)); // 해당 요리의 사실여부 확인
        // 객체끼리 비교를 하게 될 경우에는 해당 객체 내부에 eqauls() & Hashcode()를 선언해줘야 한다.
    }
}
