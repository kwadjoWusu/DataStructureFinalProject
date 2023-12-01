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

    private int getMonthFromEvent(Event event) {

        int year = event.getDate() / 10000;
        int month = (event.getDate() / 100) % 100;
        return month;
    }

    private int getDayFromEvent(Event event) {
        int day = event.getDate() % 100;
        return day;
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

    private void increaseSize(){
        Event[] newlist = new  Event[capacity*2];
        System.arraycopy(eventplanner, 0,newlist, 0, eventplanner.length);
        eventplanner  = newlist;
    }

    public void push(Event occassion) {
        if (this.isFull()) {
            increaseSize();
        }
        top++;
        eventplanner[top] = occassion;
        size++;
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
            Event newEvent = new Event(title, description, date, time); // call constructor, create the event, and                                             // insert in stack
            push(newEvent);
            reminderList.insert(newEvent);

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
        if (time >= 0 &&  time <= 2359) // do present time should be the lower bound
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
            if (event != null && getMonthFromEvent(event) == month) {
                int day = getDayFromEvent(event);
    
                int stepSize = calcStepSize(day);
    
                while (monthlyEvents[day] != null) {
                    day = (day + stepSize) % capacity;
                }

                monthlyEvents[day] = event;
            }
        }
        return monthlyEvents;
    }
    
    private int calcStepSize(int day) {
        return capacity - (day % (capacity - 1));
    }
}