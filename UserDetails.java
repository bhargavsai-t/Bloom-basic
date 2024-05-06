import java.util.*;
class UserDetails {
	static Scanner s = new Scanner(System.in);
	static String phone;
	static String fName;
	static int plant = 0;
	static String loginNumber;
	static HashMap<String, String> u = new HashMap<>();
	static {
		System.out.println("Welcome to Bloom.");
		System.out.println("serving earth!!");
	}
	public static void registerUser() {
		System.out.println("----------------------------------------------"+"\nEnter your name: ");
		fName = s.next();
		System.out.println("Enter Phone number: ");
		phone = s.next();
		u.put(phone, fName);
		System.out.println("User registration done");
		System.out.println("Kindly login");
		login();
	}
	public static void login() {
		System.out.println("----------------------------------------------"+"\nTotal plants planted till: " + plant);
		System.out.println("Login using mobile number:");
		System.out.println("Enter registered mobile number: ");
		loginNumber = s.next();
		if (u.containsKey(loginNumber)) {
			System.out.println("Logging you in");
			dashBoard();
		} else {
			System.out.println("Incorrect details or kindly register if you are new");
			System.out.println("Press 1 to register and 2 to abort");
			int decs = s.nextInt();
			if(decs==1) {
				registerUser();
			}else {
				System.out.println("Have a good day!!");
			}
		}
	}
	public static void dashBoard() {
		System.out.println("Bloom - Serving Earth!!"+"\nTotal plants: " + plant+"\nWelcome " + u.get(loginNumber));
		System.out.println("Choose action: " + "\n1) press 1 To plant" + "\n2)press 2 View Profile" + "\n3) press 3 to Logout");
		int action = s.nextInt();
		switch (action) {
		case 1:
			System.out.println("Do you want to plant(press 1 to plant 0 to abort): ");
			int dec = s.nextInt();
			if (dec == 1) {
				System.out.println("Please confirm here to plant(Press 1 to confirm, 0 to return to dashboard)");
				int decs = s.nextInt();
				if (decs == 1) {
					plant ++;
					System.out.println("Thank you for serving earth!!"+"\n----------------------------------------------");
					dashBoard();
				} else {
					dashBoard();
				}
			}else if(dec==0) {
				dashBoard();
			}
			break;
		case 2:
			System.out.println("Profile Deatils are: "+"\nName: "+u.get(loginNumber)+"\nYour plants: " + plant+"\n----------------------------------------------");
			dashBoard();
			break;
		case 3:
			System.out.println("Do you want to logout(press 1 to confirm, 2 to return to dashboard): ");
			int a = s.nextInt();
			if (a == 1) {
				System.out.println("Logging you out...");
				home();
			}else {
				dashBoard();
			}
			break;
		}
	}
	public static void home() {
		System.out.println("Total plants planted till: " + plant+"\nPress 1 to register and press 2 to if you're existing user: ");
		int decs = s.nextInt();
		switch(decs) {
		case 1:
			registerUser();
			break;
		case 2:
			login();
			break;
		}
	}
	@Override
	public String toString() {
		return fName;
	}
	public static void main(String[] args) {
		home();
			}
		}

