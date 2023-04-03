package com.hanteoglobal.coding_test.datastructure;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CategoryManagerTest {

  private CategoryManager categoryManager;

  @BeforeEach
  void initCategory() {
    categoryManager = new CategoryManager();
    Category topCategory = createTopCategory();
    Category category = createCategory();

    categoryManager.addCategory(topCategory);
    categoryManager.addCategory(category);
  }

  @Test
  void 카테고리_추가() {
    // given
    Category topCategory = Category.createTopCategory(3L, "3L 카테고리", false);

    Category category = Category.createCategory(topCategory.getIdx(), "3L 의 하위 카테고리",
        topCategory.getName(), false);

    Category anonymousCategoryA = Category.createCategory(topCategory.getIdx(), "3L 의 하위 익명 카테고리",
        topCategory.getName(), true);

    Category anonymousCategoryB = Category.createCategory(topCategory.getIdx(), "중복 익명 카테고리",
        topCategory.getName(), true);

    // when
    categoryManager.addCategory(topCategory);
    categoryManager.addCategory(category);
    categoryManager.addCategory(anonymousCategoryA);

    // 익명 카테고리 중복 저장
    categoryManager.addCategory(anonymousCategoryB);

    // then
    assertThat(categoryManager.getTreeByCategory().get(topCategory.getIdx())).isEqualTo(
        topCategory);
    assertThat(categoryManager.getTreeByCategory().get(category.getIdx())).isEqualTo(category);
    assertThat(categoryManager.getTreeByCategory().get(anonymousCategoryA.getIdx())).isEqualTo(
        anonymousCategoryA);

    // 익명 카테고리 중복 저장 시 이미 저장된 익명 카테고리 반환
    assertThat(categoryManager.getAnonymousCategory()).isEqualTo(anonymousCategoryA);
  }

  @Test
  void 카테고리_식별자_검색() {
    // given
    Category searchCategory = null;

    // when
    try {
      searchCategory = categoryManager.searchCategoryIdx(1L);

    } catch (Exception e) {
      e.printStackTrace();
    }

    // then
    assert searchCategory != null;
    assertThat(searchCategory.getIdx()).isEqualTo(1L);
  }

  @Test
  void 카테고리_이름_검색() {
    // given
    Category searchCategory = null;

    // when
    try {
      searchCategory = categoryManager.searchCategoryName("1L 카테고리");

    } catch (Exception e) {
      e.printStackTrace();
    }

    // then
    assert searchCategory != null;
    assertThat(searchCategory.getName()).isEqualTo("1L 카테고리");
  }

  private Category createTopCategory() {
    return Category.createTopCategory(1L, "1L 카테고리", false);
  }

  private Category createCategory() {
    return Category.createCategory(1L, "1L 카테고리의 하위 카테고리", "1L 카테고리", false);
  }

}
