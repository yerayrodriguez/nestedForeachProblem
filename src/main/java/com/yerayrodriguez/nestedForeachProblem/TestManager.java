package com.yerayrodriguez.nestedForeachProblem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TestManager implements Serializable {
  private static final long serialVersionUID = 1L;

  private List<Parent> root = new ArrayList<>();

  public List<Parent> getRoot() {
    return root;
  }

  @PostConstruct
  public void init() {
    // Parent 0 with no children
    Parent parent0 = new Parent("P0");
    root.add(parent0);
    // Parent 1 with n2 children
    Parent parent1 = new Parent("P1");
    parent1.getChildren().add(new Child("C0"));
    parent1.getChildren().add(new Child("C1"));
    parent1.getChildren().add(new Child("C2"));
    root.add(parent1);
  }

  public void extractFirst() {
 // If P1 has no children, return
    if (root.get(1).getChildren().isEmpty()) {
      return;
    }
    // Get first child of P1
    Child removedChild = root.get(1).getChildren().remove(0);
    // Add this child to P0
    root.get(0).getChildren().add(removedChild);
  }

}
