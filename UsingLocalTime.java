import java.time.LocalTime;

public class UsingLocalTime {
	public static void main(String[] args){
		LocalTime time = LocalTime.now();
		LocalTime meetingTime = LocalTime.of(11, 40, 20);
		LocalTime classTime = LocalTIme.parse("02:00:00");
		
		boolean isbefore = meetingTime.isbefore(classTime);
		boolean isAfter = meetingTime.isAfter(classTime);
		
		System.out.printf("The time is %s%n",time);
		System.out.printf("The meeting time is %s%n", meetingTime); 
		System.out.printf("our class time will be %s on monday%n",classTime);
        System.out.printf("is %s before %n? %b%n",meetingTime,classTime,isbefore);
        System.out.printf("is %s before	%n	
	}
}