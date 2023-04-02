package com.hanteoglobal.coding_test.datastructure;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Category {
  private Long idx;
  private final Long parentIdx;
  private final List<Long> childIdx;
  private final String name;
  private final String parentName;
  private final boolean isAnonymous;

  private Category(Long idx, Long parentIdx, String name, String parentName, boolean isAnonymous) {
    this.idx = idx;
    this.parentIdx = parentIdx;
    this.childIdx = new ArrayList<>();
    this.name = name;
    this.parentName = parentName;
    this.isAnonymous = isAnonymous;
  }

  public static Category createTopCategory(Long idx, String name, boolean isAnonymous) {
    return new Category(idx, null, name, null, isAnonymous);
  }

  public static Category createCategory(Long parentIdx, String name, String parentName, boolean isAnonymous) {
    return new Category(null, parentIdx, name, parentName, isAnonymous);
  }

  public void setIdx(Long Idx) {
    this.idx = Idx;
  }

  public void addChildCategoryIdx(Long childCategoryIdx) {
    this.childIdx.add(childCategoryIdx);
  }
}
