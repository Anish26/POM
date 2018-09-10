package Week1Day3;

public class Mobile1 {


	
	public void SendSMS(long a, String SMS)
	{
		System.out.println(SMS + Long.toString(a));
	}
	
	public static void main(String[] args) {
		
Mobile1 m = new Mobile1();

m.SendSMS(979042484, "Good Morning  ");

	}

}
