package com.hanteoglobal.coding_test.datastructure;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CategoryTest {

  @Test
  void 최상위_카테고리_생성() {
    // given
    Long idx = 1L;
    String name = "1L 카테고리";
    boolean isAnonymous = false;

    // when
    Category createTopCategory = Category.createTopCategory(idx, name, isAnonymous);

    // then
    assertThat(createTopCategory).isNotNull();
    assertThat(createTopCategory.getName()).isEqualTo(name);
  }

  @Test
  void 일반_카테고리_생성() {
    // given
    Long parentIdx = 1L;
    String name = "1L 카테고리의 하위 카테고리";
    String parentName = "1L 카테고리";
    boolean isAnonymous = false;

    // when
    Category createCategory = Category.createCategory(parentIdx, name, parentName, isAnonymous);

    // then
    assertThat(createCategory).isNotNull();
    assertThat(createCategory.getName()).isEqualTo(name);
  }


  @Test
  void 카테고리_식별자_set() {
    // given
    Long idx = 2L;
    Long parentIdx = 1L;
    String name = "1L 카테고리의 하위 카테고리";
    String parentName = "1L 카테고리";
    boolean isAnonymous = false;

    // when
    Category createCategory = Category.createCategory(parentIdx, name, parentName, isAnonymous);
    createCategory.setIdx(idx);

    // then
    assertThat(createCategory.getIdx()).isEqualTo(2L);
  }
}
