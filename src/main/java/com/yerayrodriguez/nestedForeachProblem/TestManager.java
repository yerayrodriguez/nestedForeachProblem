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
    // Parent 1 with 2 children
    Parent parent1 = new Parent("P1");
    parent1.getChildren().add(new Child("C0"));
    parent1.getChildren().add(new Child("C1"));
    root.add(parent1);
  }

  public String submit() {
    Parent P0 = root.get(0);
    Parent P1 = root.get(1);
    if (!P0.getChildren().isEmpty()) {
      return null;
    }
    // Get first child of P1
    Child removedChild = P1.getChildren().remove(0);
    System.out.println("Removed child from P1: " + removedChild.getId()); // OK
    System.out.println("Is removed child id equals 'C0': " + removedChild.getId().equals("C0")); // OK
    // Add this child to P0
    P0.getChildren().add(removedChild);
    Child firstP0Child = P0.getChildren().get(0);
    System.out.println("Frist P0 Child: " + firstP0Child.getId()); // OK
    System.out.println("Is first P0 child id equals 'C0': " + firstP0Child.getId().equals("C0")); // OK
    return null;
  }

}
