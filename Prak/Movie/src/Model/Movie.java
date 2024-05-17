package Model;

public class Movie {
  private String title;
  private double plotScore;
  private double characterScore;
  private double actingScore;

  public Movie(String title, double plotScore, double characterScore, double actingScore) {
      this.title = title;
      this.plotScore = plotScore;
      this.characterScore = characterScore;
      this.actingScore = actingScore;
  }

  public String getTitle() {
      return title;
  }

  public void setTitle(String title) {
      this.title = title;
  }

  public double getPlotScore() {
      return plotScore;
  }

  public void setPlotScore(double plotScore) {
      this.plotScore = plotScore;
  }

  public double getCharacterScore() {
      return characterScore;
  }

  public void setCharacterScore(double characterScore) {
      this.characterScore = characterScore;
  }

  public double getActingScore() {
      return actingScore;
  }

  public void setActingScore(double actingScore) {
      this.actingScore = actingScore;
  }

  public double getRating() {
      return (plotScore + characterScore + actingScore) / 3;
  }

  @Override
  public String toString() {
      return "Movie{" +
              "title='" + title + '\'' +
              ", plotScore=" + plotScore +
              ", characterScore=" + characterScore +
              ", actingScore=" + actingScore +
              ", rating=" + getRating() +
              '}';
  }
}
