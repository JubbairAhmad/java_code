// public class dsjffgs {
    
// }
import java.util.Scanner;

public class ComplaintSystem {
    
    // Class to store complaint details
    static class Complaint {
        String userName;
        String contactNumber;
        String roomNumber;
        String complaintType;
        int feedbackRating;

        // Constructor to initialize complaint details
        Complaint(String userName, String contactNumber, String roomNumber, String complaintType, int feedbackRating) {
            this.userName = userName;
            this.contactNumber = contactNumber;
            this.roomNumber = roomNumber;
            this.complaintType = complaintType;
            this.feedbackRating = feedbackRating;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Choose complaint/feedback option
        System.out.println("Press 1 to submit a complaint/feedback:");
        int option = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (option == 1) {
            // Collect user details
            System.out.print("Enter Username: ");
            String userName = scanner.nextLine();

            System.out.print("Enter Contact Number: ");
            String contactNumber = scanner.nextLine();

            System.out.print("Enter Room Number: ");
            String roomNumber = scanner.nextLine();

            System.out.println("Select Type of Complaint:");
            System.out.println("1. Poor housekeeping");
            System.out.println("2. Noisy guests");
            System.out.println("3. Uncomfortable beds");
            System.out.println("4. Slow service");
            System.out.println("5. Lack of amenities");
            System.out.println("6. Unfriendly staff");
            int complaintOption = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            String[] complaintTypes = {"Poor housekeeping", "Noisy guests", "Uncomfortable beds", 
                                       "Slow service", "Lack of amenities", "Unfriendly staff"};
            String complaintType = complaintTypes[complaintOption - 1];

            // Collect feedback rating
            System.out.print("Enter Feedback (Rating out of 5): ");
            int feedbackRating = scanner.nextInt();

            // Create a complaint object and store it in an array
            Complaint[] complaints = new Complaint[1];  // Array of complaints
            complaints[0] = new Complaint(userName, contactNumber, roomNumber, complaintType, feedbackRating);

            // Display acknowledgment message
            System.out.println("\nSuccessfully registered Complaint");

            // Optionally display the complaint details (for verification)
            System.out.println("\nComplaint Details:");
            System.out.println("Username: " + complaints[0].userName);
            System.out.println("Contact Number: " + complaints[0].contactNumber);
            System.out.println("Room Number: " + complaints[0].roomNumber);
            System.out.println("Type of Complaint: " + complaints[0].complaintType);
            System.out.println("Feedback Rating: " + complaints[0].feedbackRating);
        } else {
            System.out.println("Invalid Option. Exiting...");
        }

        scanner.close();
    }
}