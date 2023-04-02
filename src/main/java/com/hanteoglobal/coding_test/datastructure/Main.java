package com.hanteoglobal.coding_test.datastructure;

public class Main {
  public static void main(String[] args) {
    Category mail = Category.createTopCategory(1L, "남자 카테고리", false);
    Category anonymousA = Category.createCategory(mail.getIdx(), "익명 카테고리A", mail.getName(), true);
    Category anonymousB = Category.createCategory(mail.getIdx(), "익명 카테고리B", mail.getName(), true);
    Category bts = Category.createCategory(mail.getIdx(), "BTS", mail.getName(), false);
    Category exo = Category.createCategory(mail.getIdx(), "EXO", mail.getName(), false);

    Category femail = Category.createTopCategory(2L, "여자 카테고리", false);
    Category blackpink = Category.createCategory(femail.getIdx(), "Black Pink", femail.getName(), false);
    Category anonymousC = Category.createCategory(femail.getIdx(), "익명 카테고리C", femail.getName(), true);

    CategoryManager categoryManager = new CategoryManager();
    categoryManager.addCategory(mail);
    categoryManager.addCategory(anonymousA);
    categoryManager.addCategory(anonymousB);
    categoryManager.addCategory(bts);
    categoryManager.addCategory(exo);

    categoryManager.addCategory(femail);
    categoryManager.addCategory(anonymousC);
    categoryManager.addCategory(blackpink);

    System.out.println(categoryManager.toJsonByCategory());
  }
}
