package com.yerayrodriguez.nestedForeachProblem;

import java.io.Serializable;

public class Child implements Serializable {
  private static final long serialVersionUID = 1L;
  private String id;

  public Child(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
