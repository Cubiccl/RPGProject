package main.graphics.states;

public abstract class MSButton {

  private String text;

  public MSButton(String text) {
    this.text = text;
  }

  public String getText() {
    return this.text;
  }

  public abstract void onClick();

}
