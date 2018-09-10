package Week1Day3;
import Week1Day3.MobilePhone;
public class Mobile {
	
	
	public void SendSMS(long mobileNumber, String SMS)
	{
		System.out.println(Long.toString(mobileNumber) + SMS);
	}
	
	public void callContact(long mobileNumber) {
		System.out.println("Calling.... " + Long.toString(mobileNumber));
	}
	
	String text="welcome";
	public String show()
	{
		return "welcome123";
	}
	{
		//System.out.println(text);	
	}
    String show1() {	

 	int num=10;
	if(num==10) {
    System.out.println("Welcome to the world");
    return "Yes";
    
	}
    else
    {
    	return "No";
    }
	} 
    
   
   
    
	public static void main(String args[]) {
		Mobile mp = new Mobile();
		MobilePhone mph = new MobilePhone();
		System.out.println(mph.display());
		mp.show();
		//mp.show1();
		
		//mp.SendSMS(900081232, " Good Morning Happy Sunday");
	
		
	}

}
