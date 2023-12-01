# Event Scheduler and Calendar

# Project Description
This project is a calendar application that enables users to manage events virtually. The application allows users to create, modify, delete, and view events within a virtual calendar. Additionally it allows users to view upcoming events whether by day or by month.

# Core Features
1. Event Creation:
Users can create events with a title, description, date, and time (with no two events having the same title because a title must be unique).

2. Event Modification:
Events can be edited or deleted after their creation.

3. Daily View:
All events for single day can be displayed using a stack to manage daily events.

4. Monthly View:
Events within a specified month can be quickly accessed using a hash table.

5. Event Conflicts:
New events scheduled for the same day and time as another event will alert the user and warn about event scheduling conflicts.

6. Event Reminders:
Events reminders can be managed and displayed using a priority queue.

# Instructions

The system works using an interactive menu that allows users to input a number from 0 to 8 for a specific action.
The function of each number is outlined below:

1. Create Event
2. Modify Event
3. Search Event
4. Remove Event
5. Get Daily Events
6. Get Monthly Events
7. Get Upcoming Events
8. Print All Events
0. Quit

Based on the number the user selects from the menu above the system will perform one of eight actions.

If the user enters 1 they can create a new event by specifying the title, description, date and time. 
If the user enters 2 they can change information pertaining to a specified event. 
If the user enters 3 they can search for a specified event.
If the user enters 4 they can remove a specified event.
If the user enters 5 they can view the events of a particular day.
If the user enters 6 they can view the events of a particular month.
If the user enters 7 they can view the upcoming events.
If the user enters 8 they can view all events in the calendar.
If the user enters 0 they can end their interaction with the system.
