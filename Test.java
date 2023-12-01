public class Test {
    public static void main(String[] args) {
        // Create an EventScheduler with a capacity of 10
        EventScheduler eventScheduler = new EventScheduler(10);

        // Test Event Creation
        eventScheduler.createEvent("Meeting", "Discuss project", 20231130, 1400);

        //Test creating two events with the same title
         eventScheduler.createEvent("Meeting", "Assignment", 20231012, 1600);

        eventScheduler.createEvent("Birthday", "Celebrate John's birthday", 20231201, 1800);
        eventScheduler.createEvent("Conference", "Tech conference", 20231215, 1000);

        // Print all events in the EventScheduler
        eventScheduler.printAllEvents();

        // Test Event Modification for the event at the peek
        Event event = eventScheduler.peek();
        eventScheduler.modifyEvent(event, "Conference2", "Tech Conference", 20231130, 1600);
        eventScheduler.printAllEvents();
        
        // Test Event Modification for the three events created
        Event meetingEvent = eventScheduler.findEventWithTitle("Meeting");
        Event birthdayEvent = eventScheduler.findEventWithTitle("Birthday");
        Event conferenceEvent = eventScheduler.findEventWithTitle("Conference");

        // Modify each event
        eventScheduler.modifyEvent(meetingEvent, "Updated Meeting", "Discuss updated project", 20231130, 1600);
        eventScheduler.modifyEvent(birthdayEvent, "Updated Birthday", "Celebrate updated John's birthday", 20231201, 1830);
        eventScheduler.modifyEvent(conferenceEvent, "Updated Conference", "Tech Conference Updated", 20231215, 1100);

        // Print all events in the EventScheduler
        eventScheduler.printAllEvents();


        // Test Daily View
        eventScheduler.getDailyEvent(20231201);

        //Test Monthly View
       Event[] monthlyEvents = eventScheduler.getMonthlyEvents(12);
        System.out.println("Monthly Events for December:");
        for (Event monthlyEvent : monthlyEvents) {
            if (monthlyEvent != null) {
                System.out.println(monthlyEvent.toString());
            }
        }

         //Test Event Reminders
         System.out.println("These are the upcoming events: ");
        eventScheduler.GetUpcomingEvent();

        // Print the remaining events in the scheduler
        System.out.println("Remaining Events:");
         eventScheduler.printAllEvents();
        
        System.out.println("View event before removing: ");
       while (!eventScheduler.isEmpty()) {
            System.out.println(eventScheduler.peek().toString());
            eventScheduler.removeEvent(eventScheduler.peek());
        }

    //Testing resizing 
    EventScheduler scheduler = new EventScheduler(3);

        // Add some events
        scheduler.createEvent("Meeting", "Team meeting", 77, 1400);
        scheduler.createEvent("Lunch", "Lunch with colleagues", 35646, 1200);
        scheduler.createEvent("Presentation", "Client presentation", 2463, 1000);
        scheduler.createEvent("Work", "Client presentation", 5776, 1000);

    //Testing conflicting events
     EventScheduler scheduler2 = new EventScheduler(3);
        // Add some events
        scheduler2.createEvent("Meeting", "Team meeting", 77, 1400);
        scheduler2.createEvent("Lunch", "Lunch with colleagues", 35646, 1200);
        scheduler2.createEvent("Presentation", "Client presentation", 2463, 1000);
        // Attempt to schedule an event at the same time on the same day (conflict)
        scheduler2.createEvent("Work", "Client presentation", 77, 1400);
    }
}
