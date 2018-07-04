public class Movie {
    private String title;
    private String director;
    private String category;
    private int year;
    private String production;
    private String time;

    Movie(String title,
            String director,
            String category,
            int year,
            String production,
            String time){
        this.title = title;
        this.director = director;
        this.category = category;
        this.year = year;
        this.production = production;
        this.time = time;
        this.rented = false;
    }

    private boolean rented;

    public boolean checkAvailability() {
        return rented;
    }

    public void rent() {
        rented = true;
    }

    public void giveBack() {
        rented = false;
    }

    public void showMovie() {
        System.out.println("Tytuł: " + title);
        System.out.println("Reżyser: " + director);
        System.out.println("Kategoria: " + category);
        System.out.println("Produkcja: " + production);
        System.out.println("Rok: " + year);
        System.out.println("Długość filmu: " + time);
    }

    public boolean checkTitle(String title) {
        return this.title == title;
    }

}
