package com.hanteoglobal.coding_test.datastructure;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.TreeMap;
import lombok.Getter;

@Getter
public class CategoryManager {

  private Long nextTreeIdx;
  private Category anonymousCategory;
  private final TreeMap<Long, Category> treeByCategory;

  public CategoryManager() {
    this.nextTreeIdx = 0L;
    this.anonymousCategory = null;
    this.treeByCategory = new TreeMap<>();
  }

  public void addCategory(Category currentCategory) {
    // 이미 익명 Category 가 있는 상태면 더 만들 필요 없기 때문에 addCategory() 종료
    if (anonymousCategory != null && currentCategory.isAnonymous()) {
      return;
    }

    nextTreeIdx++;
    currentCategory.setIdx(nextTreeIdx);
    treeByCategory.put(nextTreeIdx, currentCategory);

    // 만들어진 익명 Category 가 없고 현재 Category 가 익명 Category 라면 저장
    if (anonymousCategory == null && currentCategory.isAnonymous()) {
      anonymousCategory = currentCategory;
    }

    if (currentCategory.getParentIdx() != null) {
      for (Category categoryInTree : treeByCategory.values()) {
        if (currentCategory.getParentName().equals(categoryInTree.getName())) {
          // Tree 에 저장된 Category 중 부모를 찾아 현재 Category 와 연결
          categoryInTree.addChildCategoryIdx(currentCategory.getIdx());
        }
      }
    }
  }

  public Category searchCategoryIdx(Long categoryIdx) throws Exception {
    if (this.treeByCategory.get(categoryIdx) != null) {
      return this.treeByCategory.get(categoryIdx);
    }

    throw new Exception("찾을 수 없는 Category 입니다.");
  }

  public Category searchCategoryName(String categoryName) throws Exception {
    for (Category currentCategory : treeByCategory.values()) {
      if (currentCategory.getName().equals(categoryName)) {
        return currentCategory;
      }
    }

    throw new Exception("찾을 수 없는 Category 입니다.");
  }

  public String toJsonByCategory() {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    return gson.toJson(this.treeByCategory);
  }
}
