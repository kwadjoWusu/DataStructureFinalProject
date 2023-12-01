public class EventScheduler {
    Event[] eventplanner;
    MaxBinaryHeap reminderList;

    int size, top;
    int capacity;

    public EventScheduler(int capacity) {
        this.top = -1;
        this.size = 0;
        this.eventplanner = new Event[capacity];

        this.reminderList = new MaxBinaryHeap();
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        if (size == capacity)
            return true;
        else
            return false;
    }

    public void push(Event occassion) {
        if (this.isFull()) {
            System.out.println("Overflow");
        } else {
            top++;
            eventplanner[top] = occassion;
            size++;
        }
    }

    public Event peek() {
        if (size == 0) {
            throw new RuntimeException("stack is empty");
        } else if (size > 0) {
            return eventplanner[top];
        } else {
            return null;
        }

    }

    public void createEvent(String title, String description, int date, int time) {// more or less creation and
                                                                                   // insertion
        if (!(this.isFull())) {
            Event newEvent = new Event(title, description, date, time); // call constructor, create the event, and
                                                                        // insert in stack
            push(newEvent);
            reminderList.insert(newEvent);

        } else {
            System.out.println("Event Planner is full, complete some tasks to create");
        }

    }

    public void removeEvent() {
        if (!(this.isEmpty())) {
            System.out.println(eventplanner[top].toString() + " has been removed successfully");
            reminderList.remove(eventplanner[top]);
            top--;
            size--;
        } else {
            System.out.println("There is nothing on the schedule");
        }
    }

    public void getDailyEvent(int date) {
        for (int i = 0; i < eventplanner.length; i++) {
            if (eventplanner[i] != null && eventplanner[i].getDate() == date) {
                System.out.println(eventplanner[i].toString());
            }
        }

    }

    public void modifyEvent(Event event, String title, String description, int date, int time) {
        event.setTitle(title);
        event.setDescription(description);
        // present date should be the lower bound
        event.setDate(date);
        if (time < 1200 || time > 2359) // do present time should be the lower bound
            throw new IndexOutOfBoundsException("Input only times from now to 2359");
        event.setTime(time);
    }

    public void modifyEvent(Event event, String title, String description, int date) {
        event.setTitle(title);
        event.setDescription(description);
        // present date should be the lower bound
        event.setDate(date);
    }

    public void modifyEvent(Event event, String title, String description) {
        event.setTitle(title);
        event.setDescription(description);
    }

    public void modifyEvent(Event event, String title) {
        event.setTitle(title);
    }

    public void GetUpcomingEvent(){
        if (size == 0){
            throw new RuntimeException("Event Calandar is Empty");
        }
        else if (size > 0) {
            System.out.println(reminderList.listOfNodes());
        }
    }

    public Event[] getMonthlyEvents(int month) {
        Event[] monthlyEvents = new Event[capacity];

        for (Event event : eventplanner) {
            if (event != null && getMonth(event.getDate()) == month) {
                int day = getDay(event.getDate());
    
                int stepSize = secondaryHash(day);
    
                while (monthlyEvents[day] != null) {
                    day = (day + stepSize) % capacity;
                }

                monthlyEvents[day] = event;
            }
        }
        return monthlyEvents;
    }
    
    private int secondaryHash(int day) {
        return capacity - (day % (capacity - 1));
    }

    private int getMonth(int date) {
        return (date / 100) % 100;
    }

    private int getDay(int date) {
        return date % 100;
    }
}
