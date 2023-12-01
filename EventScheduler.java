import java.util.Arrays;
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

    //public boolean isFull() {
        //if (size == capacity)
           // return true;
        //else
            //return false;
    //}

   //public void push(Event occassion) {
        //if (this.isFull()) {
            //increaseSize();
        //}
        //top++;
        //eventplanner[top] = occassion;
        //size++;
    //}

    public void push(Event occasion) {
        if (isFull()) {
            increaseSize();
        }
        if (top < eventplanner.length - 1) {
            top++;
            eventplanner[top] = occasion;
            size++;
        }
    }


public boolean isFull() {
    return size == eventplanner.length;
}


    //private void increaseSize(){
        //Event[] newlist = new  Event[capacity*2];
        //System.arraycopy(eventplanner, 0,newlist, 0, eventplanner.length);
        //eventplanner  = newlist;
    //}

   private void increaseSize() {
        Event[] newlist = new Event[eventplanner.length * 2];
        for (int i = 0; i < size; i++) {
            newlist[i] = eventplanner[i];
        }        eventplanner = newlist;
        capacity = newlist.length; // Update the capacity to reflect the new size
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

   //public void createEvent(String title, String description, int date, int time) {// more or less creation and
            //Event newEvent = new Event(title, description, date, time); // call constructor, create the event, and                                             // insert in stack
            //push(newEvent);
            //reminderList.insert(newEvent);

    //}
  public void createEvent(String title, String description, int date, int time) {
    // Check if the title already exists
    for (int i = 0; i <= top; i++) {
        if (eventplanner[i] != null && eventplanner[i].getTitle().equals(title)) {
            System.out.println("Two events cannot have the same title.");
            return;
        }
    }

    // Check for scheduling conflicts at the same time and on the same day
    for (int i = 0; i <= top; i++) {
        if (eventplanner[i] != null && eventplanner[i].getDate() == date &&
            eventplanner[i].getTime() == time) {
            System.out.println("Scheduling conflict: Another event is already scheduled at the same time on the same day.");
            return;
        }
    }

    // Create and add the new event
    Event newEvent = new Event(title, description, date, time);
    push(newEvent);
    reminderList.insert(newEvent);
    System.out.println("Event created successfully: " + newEvent.toString());
}



   public void removeEvent(Event eventToRemove) {
    if (eventToRemove == null) {
        System.out.println("Cannot remove a null event.");
        return;
    }

    int indexToRemove = -1;
    for (int i = 0; i <= top; i++) {
        if (eventplanner[i] != null && eventplanner[i].equals(eventToRemove)) {
            indexToRemove = i;
            break;
        }
    }

    if (indexToRemove != -1) {
        Event removedEvent = eventplanner[indexToRemove];
        System.out.println(removedEvent.toString() + " has been removed successfully");
        eventplanner[indexToRemove] = null;  // Set the removed event to null
        top--;
        size--;
    } else {
        System.out.println("Event not found for removal.");
    }
}


    public void getDailyEvent(int date) {
        for (int i = 0; i < eventplanner.length; i++) {
            if (eventplanner[i] != null && eventplanner[i].getDate() == date) {
                System.out.println(eventplanner[i].toString());
            }
        }

    }

    //public void modifyEvent(Event event, String title, String description, int date, int time) {
    //event.setTitle(title);
    //event.setDescription(description);
    // present date should be the lower bound
    //event.setDate(date);
    //if (!(time >= 0 && time <= 2359)) // corrected condition
        //throw new IndexOutOfBoundsException("Input only times from now to 2359");
    //event.setTime(time);
//}
public void modifyEvent(Event eventToModify, String title, String description, int date, int time) {
    if (eventToModify == null) {
        System.out.println("Cannot modify a null event.");
        return;
    }

    for (int i = 0; i <= top; i++) {
        if (eventplanner[i] != null && eventplanner[i].equals(eventToModify)) {
            eventplanner[i].setTitle(title);
            eventplanner[i].setDescription(description);
            // present date should be the lower bound
            eventplanner[i].setDate(date);
            if (!(time >= 0 && time <= 2359)) // corrected condition
                throw new IndexOutOfBoundsException("Input only times from now to 2359");
            eventplanner[i].setTime(time);
            System.out.println("Event modified successfully: " + eventplanner[i].toString());
            return; // Break out of the loop once the event is found and modified
        }
    }
    System.out.println("Event not found for modification.");
}



    public void GetUpcomingEvent() {
    if (size == 0) {
        throw new RuntimeException("Event Calendar is Empty");
    } else if (size > 0) {
        System.out.println(Arrays.toString(reminderList.listOfNodes()));
    }
}
    public Event[] getMonthlyEvents(int month) {
    // Assuming 31 days in a month, adjust this if necessary
    int daysInMonth = 31;
    Event[] monthlyEvents = new Event[daysInMonth];

    for (Event event : eventplanner) {
        if (event != null) {
            int eventMonth = getMonth(event.getDate());
            int eventDay = getDay(event.getDate());

            if (eventMonth == month) {
                int day = eventDay;

                int stepSize = secondaryHash(day);

                while (monthlyEvents[day] != null) {
                    day = (day + stepSize) % daysInMonth;
                }

                monthlyEvents[day] = event;
            }
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

public Event findEventWithTitle(String title) {
    for (Event event : eventplanner) {
        if (event != null && event.getTitle().equals(title)) {
            return event;
             }
              }
               return null;
               }

public void printAllEvents() {
    System.out.println("All Events in the Event Scheduler:");
    for (int i = 0; i <= top; i++) {
        System.out.println(eventplanner[i].toString());
    }
}

}
