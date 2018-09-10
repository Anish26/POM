package Week1Day3;

import Week1Day3.Mobile; 

public class MobilePhone {
	
public String display() {
	String display="Hi";
	return display;
}

	public static void main(String[] args) {
		
		Mobile m = new Mobile();
		//Send SMS program
		m.SendSMS(900081232, " Good Morning Happy Sunday");
		m.SendSMS(900081233, " Good Morning Happy Sunday");
		m.SendSMS(900081234, " Good Morning Happy Sunday");
		m.SendSMS(900081235, " Good Morning Happy Sunday");
		m.SendSMS(900081236, " Good Morning Happy Sunday");
		m.SendSMS(900081238, " Good Morning Happy Sunday");
		m.SendSMS(900081239, " Good Morning Happy Sunday");
		
		//Call contact 
		m.callContact(900081239);
		m.SendSMS(900081239, " The current balance = 9 INR on your prepaid mobile is going to expire today");
		
		m.SendSMS(900081238, " SMS cost 1 INR per SMS");
		m.callContact(900081238);
		m.SendSMS(900081238, " call cost 2 INR per call");
		m.callContact(900081238);
		m.SendSMS(900081238, " The current balance = 0 INR on your prepaid mobile is going to expire today");		
	}

}

