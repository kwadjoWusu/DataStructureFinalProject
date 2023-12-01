import java.util.Scanner;

public class Calendar {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        EventScheduler eventScheduler= new EventScheduler(10);
        int choice;


        System.out.println("******************************______ Event Scheduler ______******************************");
        System.out.println(" ");
        System.out.println("Enter 1,2,3,4,5,6,7,8,0 to: \n 1. Create Event \n 2. Modify Event " +
                "\n 3. Search Event \n 4. Remove Event \n 5.Get Daily Events \n 6. Get Monthly Events "+
                "\n 7. Get Monthly Events \n 8. Print All Events \n 0. Quit");
        System.out.print("Feedback: ");
        choice= input.nextInt();
        input.nextLine();


        while(choice !=0){
            if (choice ==1){ //Create new Event
                System.out.print("Event Title: ");
                String title=input.nextLine();
                System.out.print("Event Description: ");
                String description=input.nextLine();
                System.out.print("Event Date(yyyymmdd): ");
                int date=input.nextInt();
                System.out.print("Event Time(24hr Clock): ");
                int time=input.nextInt();

                eventScheduler.createEvent(title,description,date,time);

            }

            if (choice == 2) { // modify event:
                System.out.print("Title of event to modify: ");
                String oldTitle= input.nextLine();
                Event oldEvent= eventScheduler.findEventWithTitle(oldTitle);
                if(oldEvent != null){
                    System.out.print("Event New Title: ");
                    String newTitle=input.nextLine();
                    System.out.print("Event New Description: ");
                    String newDescription=input.nextLine();
                    System.out.print("Event New Date(yyyymmdd): ");
                    int newDate=input.nextInt();
                    System.out.print("Event New Time(24hr Clock): ");
                    int newTime=input.nextInt();

                    eventScheduler.modifyEvent(oldEvent,newTitle,newDescription,newDate,newTime);
                    System.out.println("Event Successfully Modified!");
                }
                else{
                    System.out.println(oldTitle + " has not been scheduled. Cannot modify an event that has" +
                            " not been scheduled \n Enter 1 to create a new event");
                }

            }
            if (choice==3){
                System.out.print("What Event are you looking for?: ");
                String title= input.nextLine();
                Event searcher= eventScheduler.findEventWithTitle(title);
                if(searcher != null){
                    System.out.println(searcher.getTitle()+" : "+searcher.getDescription());
                }
                else{
                    System.out.println("Has not been scheduled");
                }
            }
            if (choice==4){
                System.out.print("What Event do you want to remove?: ");
                String toRemove= input.nextLine();
                Event eventRemove=eventScheduler.findEventWithTitle(toRemove);
                if(eventRemove != null){
                    eventScheduler.removeEvent(eventRemove);
                }
                else{
                    System.out.println("Event Has not been Scheduled");
                }
            }
            if (choice==5){
                System.out.print("Enter Date(yyyymmdd)");
                int today=input.nextInt();
                eventScheduler.getDailyEvent(today);
            }
            if(choice==6){
                System.out.print("Enter Month(1 for January......12 for December)");
                int thisMonth = input.nextInt();
                Event[] monthEvent= eventScheduler.getMonthlyEvents(thisMonth);
                System.out.println("Month's Events: ");

                for (int i=0; i<monthEvent.length; i++){
                    Event monthlyEvent = monthEvent[i];
                    if(monthlyEvent!=null){
                        System.out.println(monthlyEvent.toString());
                    }
                }
            }

            if(choice==7){
                eventScheduler.GetUpcomingEvent();
            }

            if(choice==8){
                eventScheduler.printAllEvents();
            }
            else{
                System.out.println("Input a number between 0-8");
            }



            System.out.println("Enter 1,2,3,4,5,6,7,8,0 to: \n 1. Create Event \n 2. Modify Event " +
                    "\n 3. Search Event \n 4. Remove Event \n 5.Get Daily Events \n 6. Get Monthly Events "+
                    "\n 7. Get Upcoming Event \n 8. Print All Events \n 0. Quit");
            System.out.print("Feedback: ");
            choice= input.nextInt();
            input.nextLine();
        }

        System.out.println("Thank you Byeeeeee!");





    }

}
