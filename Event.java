public class Event {
    private static int eventIdCounter = 1;

    private int eventId;
    private String title;
    private String description;
    private int date; // year/month/day
    private int time; // hours/mintues

    public Event(String title, String description, int date, int time) {
        this.eventId = eventIdCounter++;
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    public String toString() {
        return title + " - " + date + " " + time;
    }

    public int getEventId() {
        return eventId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean equals(Event event) {
        return (this.title.equals(event.getTitle()) &&
                this.description.equals(event.getDescription()) &&
                this.date == event.getDate() &&
                this.time == event.getTime());

    }

}