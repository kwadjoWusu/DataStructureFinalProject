# Event Scheduler and Calendar

# Project Description
This project is a calendar application that enables users to manage events virtually. The application allows users to create, modify, delete, and view events within a virtual calendar. Additionally it allows users to view upcoming events whether by day or by month.

# Core Features
1. **Event Creation:**
Users can create events with a title, description, date, and time (with no two events having the same title because a title must be unique).

2. **Event Modification:**
Events can be edited or deleted after their creation.

3. **Daily View:**
All events for single day can be displayed using a stack to manage daily events.

4. **Monthly View:**
Events within a specified month can be quickly accessed using a hash table.

5. **Event Conflicts:**
New events scheduled for the same day and time as another event will alert the user and warn about event scheduling conflicts.

6. **Event Reminders:**
Events reminders can be managed and displayed using a priority queue.

# Instructions

The system works using an interactive menu that allows users to input a number from 0 to 8 for a specific action.
The function of each number is outlined below:

1. **Create Event:** Create a new event by specifying the title, description, date and time.
2. **Modify Event:** Change information pertaining to a specified event.
3. **Search Event:** Search for a specified event.
4. **Remove Event:** Remove a specified event.
5. **Get Daily Events:** View the events of a particular day.
6. **Get Monthly Events:** View the events of a particular month.
7. **Get Upcoming Events:** View the upcoming events.
8. **Print All Events:** View all events in the calendar.
0. **Quit:** End interaction with the system.


Based on the number the user selects from the menu above, the system will perform one of nine actions.


As a user, to create a new event, enter 1.

As a user, to modify an already existing event, enter 2.

As a user, to search for an event, enter 3.

As a user, to remove an event from the calendar, enter 4.

As a user, to view the events in a particular day, enter 5.

As a user, to view the events in a particular month, enter 6.

As a user, to view the upcoming events in the calendar, enter 7.

As a user, to view all events in the calendar, enter 8.

As a user, to end your interaction with the system, enter 0.
