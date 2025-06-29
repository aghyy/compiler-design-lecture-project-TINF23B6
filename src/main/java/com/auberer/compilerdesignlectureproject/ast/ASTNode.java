package com.auberer.compilerdesignlectureproject.ast;

import com.auberer.compilerdesignlectureproject.interpreter.Value;
import com.auberer.compilerdesignlectureproject.reader.CodeLoc;
import com.auberer.compilerdesignlectureproject.sema.SuperType;
import com.auberer.compilerdesignlectureproject.sema.Type;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public abstract class ASTNode implements IVisitable {

  public void addChild(ASTNode child) {
    assert child != null;
    children.add(child);
    child.setParent(this);
  }

  public <T> ArrayList<T> getChildren(Class<T> targetClass) {
    return children.stream()
        .filter(targetClass::isInstance)
        .map(targetClass::cast)
        .collect(Collectors.toCollection(ArrayList::new));
  }

  public <T> T getChild(Class<T> targetClass, int idx) {
    List<T> children = getChildren(targetClass);
    if (idx < 0 || idx >= children.size())
      return null;
    return children.get(idx);
  }

  public Type setEvaluatedSymbolType(Type type) {
    this.type = type;
    return type;
  }

  @ToString.Exclude
  ASTNode parent;
  ArrayList<ASTNode> children = new ArrayList<>();
  CodeLoc codeLoc;
  Type type = new Type(SuperType.TYPE_INVALID);
  Value value = new Value(this);

}
