package model;

public class Identifier
{
  String id;

  public Identifier() {
    this.generate();
  }

  private void generate() {
    this.id = java.util.UUID.randomUUID().toString();
  }

  public String getID() {
    return id;
  }

  public void setID(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return this.id.toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Identifier)) return false;

    Identifier that = (Identifier) obj;

    if (!this.id.equals(that.id)) return false;

    return true;

  }

}
