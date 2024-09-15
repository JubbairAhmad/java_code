import java.util.*;
import java.util.regex.Pattern;

class Customer{
    String CustomerId;
	String CustomerName;
    String Email;
    String Password;
    String Address;
    String ContactNo; 
    String NomineeName;
    String Relationship;

    public Customer(String CustomerId, String CustomerName, String Email, String Password, String Address, String ContactNo, String NomineeName, String Relationship){
        this.CustomerId = CustomerId;
        this.CustomerName = CustomerName;
        this.Email = Email;
        this.Password = Password;
        this.Address = Address;
        this.ContactNo = ContactNo;
        this.NomineeName = NomineeName;
        this.Relationship = Relationship;
    }
    public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getContactNo() {
		return ContactNo;
	}

	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}

	public String getNomineeName() {
		return NomineeName;
	}

	public void setNomineeName(String nomineeName) {
		NomineeName = nomineeName;
	}

	public String getRelationship() {
		return Relationship;
	}

	public void setRelationship(String relationship) {
		Relationship = relationship;
	}

}
public class Admin{
	public static ArrayList<Customer> customerList = new ArrayList<>();
	public static Scanner  sc = new Scanner(System.in);
    public static void main(String[] args){
    	
       
        int choice;
//        ArrayList<Customer> customer = new ArrayList<Customer>();
//        CustomerRegistration(sc);
        
do {
displayMenu();
choice = sc.nextInt();
sc.nextLine(); 
switch (choice) {
case 1:
System.out.println("\nYou have selected the Policy Listing Feature.");
listPolicies();
break;
case 2:
System.out.println("\nYou have selected the Customer Registration Feature.");
CustomerRegistration();
break;
case 3:
System.out.println("\nYou have selected the Search Customer by Email Feature.");
searchCustomerByEmail();
break;
case 4:
System.out.println("\nYou have selected the Search Customer by CustomerId Feature.");
SearchByCustomerId();
break;
case 5:
System.out.println("\nYou have selected the View Customers by Email Domain Feature.");
SearchByDomain();
break;
case 6:
System.out.println("\nGood Bye Administrator!!. Terminating the Program");
break;
default:
System.out.println("\nYou have selected an inappropriate option. Kindly select an appropriate option.");
}
} while (choice != 6);

sc.close();
}
public static boolean isvalid(String email){
        String regex ="^[a-z0-9._]+@[tcs gmail yahoo]+.[a-z]{2,7}$";
        Pattern p = Pattern.compile(regex);
        return p.matcher(email).matches() && customerList.stream().noneMatch(c->c.getEmail().equals(email));
    }
 public static void displayMenu() {
    	System.out.println("\n\t\t\t    Administrator Menu ");
        System.out.println("\t\t\t --------------------------");
    	System.out.println("1. Policy Listing");
    	System.out.println("2. Customer Registration");
    	System.out.println("3. Search Customer by Email");
    	System.out.println("4. Search Customer by CustomerId");
    	System.out.println("5. View Customers by Email Domain");
    	System.out.println("6. Exit");
    	System.out.print("Select an option: ");
    	}

public static void CustomerRegistration(){
        System.out.println("\n\t\t\t Customer Registration Page");
        System.out.println("\t\t\t --------------------------");
        String CustomerName;
        System.out.println("Enter Customer Name");
        while(true){
            CustomerName = sc.nextLine();
            if(CustomerName.length() <=50)
            	break;
            else
                System.err.println("Enter valid Customer Name between 50 Characters: ");
          }
        String Email=""; boolean b=true;
        System.out.println("Enter Email: ");
        while(b) {
            Email = sc.nextLine();
            b = !(isvalid(Email));
            if(b==true) {
                System.err.println("Enter Valid Email: ");
            }        
        }
        
        String Password;
        System.out.println("Enter password  ");
        while(true){
            Password = sc.nextLine();
            if((Password.length() >=6 && Password.length() <=12))
            	break;
            else
                System.err.println("Enter valid password between 6 - 12 character: ");
          }
        System.out.println("Enter Address: ");
        String Address;
        while(true)
        {
        Address=sc.nextLine();
        if(Address.length()<=100)
        break;
        else
            System.err.println("Enter Valid Address: ");

        }
        System.out.println("Enter Contact No: ");
        String ContactNo="";
        boolean flag=true;
        while(flag)
        {int c=0;
        ContactNo=sc.nextLine();
        for(int i=0;i<10;i++)
        {
        if(Character.isDigit(ContactNo.charAt(i)) && ContactNo.length()==10)
        {
            c++;
            continue;
        }
        else
        break;
        }
        if(c==10)
            flag=false; 
        else
        	System.err.println("Enter a valid Contact No");
    }
        System.out.println("Enter NominieName: ");
        String NomineeName = sc.nextLine();
        System.out.println("Enter Relationship with Nominee: ");
        String Relationship = sc.nextLine();

        String CustomerId = String.valueOf((int)(Math.random()*10000000));
        System.out.println("Customer Registration Successful");
        System.out.println("Customer Id: "+ CustomerId);


        Customer customer= new Customer(CustomerId, CustomerName, Email, Password, Address, ContactNo, NomineeName, Relationship);
        customerList.add(customer);
        
		}
public static void searchCustomerByEmail() {
	System.out.print("Enter Email: ");
	String email = sc.nextLine();
	boolean found = false;
	for (Customer customer : customerList) {
	if (customer.Email.equals(email)) {
		 System.out.println("User Id : "+customer.CustomerId);
         System.out.println("User Name: "+ customer.CustomerName);
         System.out.println("User Email : "+ customer.Email);
         System.out.println("User Address:"+ customer.Address);
	found = true;
	break;
	}
	}
	if (!found) {
	System.err.println("No Such Customer Exist with the Given Email.");
	}
}

public static void listPolicies() {
System.out.println("\n\t\t\t Policy Page");
System.out.println("\t\t\t ----------------");
System.out.println("1. GeneralInsurance");
System.out.println("2. HealthInsurance");
System.out.println("3. MotorInsurance");
System.out.println("Enter your choice:");
int s = sc.nextInt();
sc.nextLine();
switch(s)
{
    case 1:
        GeneralInsurance();
        break;
    case 2:
        HealthInsurance();
        break;
    case 3:
        MotorInsurance();
        break;
    default:
        System.out.println("Please enter only 1 to 3 choices");
        break;
}

}

public static void GeneralInsurance()
{
System.out.println("1. BimaGold");
System.out.println("2. Janand");
System.out.println("3. Vridhdhi");
System.out.println("4. ChildCareer");
System.out.println("5. Floater");
System.out.println("6. Conventional");
System.out.println("Enter your choice:");
int ss = sc.nextInt();
sc.nextLine();
switch(ss)
{
    case 1:
        BimaGold();
        break;
    case 2:
        Janand();
        break;
    case 3:
        Vridhdhi();
        break;
    case 4:
        ChildCareer();
        break;
    case 5:
        Floater();
        break;
    case 6:
        conventional();
        break;
    default:
        System.out.println("Please enter only 1 to 6 choices");
        break;
}
}

public static void HealthInsurance()
{
System.out.println("1. BimaGold");
System.out.println("2. Janand");
System.out.println("3. Vridhdhi");
System.out.println("4. ChildCareer");
System.out.println("5. Floater");
System.out.println("6. Conventional");
System.out.println("Enter your choice:");
int ss = sc.nextInt();
sc.nextLine();
switch(ss)
{
    case 1:
        BimaGold();
        break;
    case 2:
        Janand();
        break;
    case 3:
        Vridhdhi();
        break;
    case 4:
        ChildCareer();
        break;
    case 5:
        Floater();
        break;
    case 6:
        conventional();
        break;
    default:
        System.err.println("Please enter only 1 to 6 choices");
        break;
}
}

public static void MotorInsurance()
{
System.out.println("1. BimaGold");
System.out.println("2. Janand");
System.out.println("3. Vridhdhi");
System.out.println("4. ChildCareer");
System.out.println("5. Floater");
System.out.println("6. Conventional");
System.out.println("Enter your choice:");
int ss = sc.nextInt();
sc.nextLine();
switch(ss)
{
    case 1:
        BimaGold();
        break;
    case 2:
        Janand();
        break;
    case 3:
        Vridhdhi();
        break;
    case 4:
        ChildCareer();
        break;
    case 5:
        Floater();
        break;
    case 6:
        conventional();
        break;
    default:
    	System.err.println("Please enter only 1 to 6 choices");
        break;
}



}
public static void BimaGold()
{
System.out.println("Policy Title: BimaGold");
System.out.println("Sum Assured: Rs.1000000/-");
System.out.println("Premium : Rs.1100/-");
System.out.println("Term : Rs.1900000/- for 20 years");
}

public static void Janand()
{
System.out.println("Policy Title: Janand");
System.out.println("Sum Assured: Rs.900000/-");
System.out.println("Premium : Rs.1150/-");
System.out.println("Term : Rs.1600000/- for 20 years");  
}

public static void Vridhdhi()
{
System.out.println("Policy Title: Vridhdhi");
System.out.println("Sum Assured: Rs.500000/-");
System.out.println("Premium : Rs.10000/-");
System.out.println("Term : Rs.900000/- for 17 years");
}

public static void ChildCareer()
{
System.out.println("Policy Title: ChildCareer");
System.out.println("Sum Assured: Rs.1000000/-");
System.out.println("Premium : Rs.11000/-");
System.out.println("Term : Rs.1900000/- for 20 years");
}

public static void Floater()
{
System.out.println("Policy Title: Floater");
System.out.println("Sum Assured: Rs.1000000/-");
System.out.println("Premium : Rs.11000/-");
System.out.println("Term : Rs.1900000/- for 20 years");
}

public static void conventional()
{
System.out.println("Policy Title: BimaGold");
System.out.println("Sum Assured: Rs.1000000/-");
System.out.println("Premium : Rs.11000/-");
System.out.println("Term : Rs.1900000/- for 20 years");
}
public static void SearchByCustomerId()
{
    System.out.println("Enter the searching Customer Id:");
    int f=0;
    String sid=sc.nextLine();
    for(Customer cusid:customerList ) {
        if(cusid.getCustomerId().equalsIgnoreCase(sid)) {
        	 System.out.println("Customer ID: "+cusid.getCustomerId());
             System.out.println("Customer Name: "+cusid.getCustomerName());
             System.out.println("Email: "+cusid.getEmail());
             f=1;
        }
        
    }
 
       if(f==0)
        //System.out.println("No Student found with mentioned details");
       System.err.println("No Student found with mentioned details");
}

public static void SearchByDomain()
{
    System.out.println("\t\t\t Searching By Domain Name");
    System.out.println("\t\t\t --------------------------");
    System.out.println("Enter the Domain to be viewed:");
    String s=sc.nextLine();
    ArrayList<Customer> output= new ArrayList<>();
    output=CustomerEmailDomainSearch(s);
    if(output.size()==0)
    	System.err.println("No such customer is registered with "+s);
    else
    {
    for(Customer bruh: output)
    {
        System.out.println("User ID" + bruh.getCustomerId());
        System.out.println("User Name" + bruh.getCustomerName());
        System.out.println("User ID" + bruh.getEmail());
    }
    }
}
public static ArrayList CustomerEmailDomainSearch(String s)
{    
    ArrayList<Customer> arr=new ArrayList<>();
    for(Customer var: customerList)
        {
        int index=(var.getEmail()).indexOf('@');
        String str=(var.getEmail()).substring(index+1);
        if(s.equalsIgnoreCase(str))
        {
            arr.add(var);
        }
        }
    return arr;
}

}
