import java.time.LocalDate;

public class UsingLocalDate{
	public static void main(String[] args){
		LocalDate todaysDate = LocalDate.now();
		LocalDate myBirthdate = LocalDate.of(2000, 5, 25);
		LocalDate resumptionDate = LocalDate.parse("2026-10-15");
		
		boolean isleapYear = resumptionDate.isLeapyear();
		boolean isEqual = resumption.equals(mybirthdayDate);
		
		System.out.printf("Today's date is %s%n",todaysDate);
		System.out.print("my birth date is %s%n",myBirthDate);
		System.out.print("The resuption date is %s%n",resumptionDate);
		System.out.printf("The resumption year is %s%n",resumptionDate.getyear());
		System.out.printf("The resumption month is %s%n",resumptionDate.getMonth());
		System.out.printf("The resumption day is %s%n",resumptionDate.getDayOfMonth());
		System.out.printf("The meeting date is %s%n",resumptionDate.plusDays(10));
		System.out.printf("The party date will be  %s%n",resumptionDate.plusMonths(15));
		System.out.printf("resuption date  a leap year?  %s%n",isLeapYear);
		System.out.printf(" is %s the same as %s? %b%n",resumptionDate,myBirthdate,isEqual);
	}
}
