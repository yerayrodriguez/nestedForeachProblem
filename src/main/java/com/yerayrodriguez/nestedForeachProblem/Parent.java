package com.yerayrodriguez.nestedForeachProblem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Parent implements Serializable {
  private static final long serialVersionUID = 1L;
  private String id;
  private List<Child> children = new ArrayList<>();

  public Parent(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public List<Child> getChildren() {
    return children;
  }
}
