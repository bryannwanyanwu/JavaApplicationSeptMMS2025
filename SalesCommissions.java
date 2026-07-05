public class SalesCommissions {
    public static void main(String[] args) {
        // Array to count salespeople in each salary range
        int[] salaryCounts = new int[9]; // 8 ranges + 1 for $1000+
        
        // Sample sales data (in dollars)
        double[] sales = {5000, 2500, 3200, 1800, 4500, 6000, 1500, 800, 
                         7000, 3500, 2800, 4100, 5200, 1900, 3000, 5500};
        
        for (double sale : sales) {
            int salary = (int)(200 + 0.09 * sale);
            
            if (salary < 200) {
                // Should not happen with given formula
            } else if (salary <= 299) {
                salaryCounts[0]++;
            } else if (salary <= 399) {
                salaryCounts[1]++;
            } else if (salary <= 499) {
                salaryCounts[2]++;
            } else if (salary <= 599) {
                salaryCounts[3]++;
            } else if (salary <= 699) {
                salaryCounts[4]++;
            } else if (salary <= 799) {
                salaryCounts[5]++;
            } else if (salary <= 899) {
                salaryCounts[6]++;
            } else if (salary <= 999) {
                salaryCounts[7]++;
            } else {
                salaryCounts[8]++;
            }
        }
        
        // Display results
        System.out.println("Salary Range\tNumber of Employees");
        System.out.println("$200-$299\t" + salaryCounts[0]);
        System.out.println("$300-$399\t" + salaryCounts[1]);
        System.out.println("$400-$499\t" + salaryCounts[2]);
        System.out.println("$500-$599\t" + salaryCounts[3]);
        System.out.println("$600-$699\t" + salaryCounts[4]);
        System.out.println("$700-$799\t" + salaryCounts[5]);
        System.out.println("$800-$899\t" + salaryCounts[6]);
        System.out.println("$900-$999\t" + salaryCounts[7]);
        System.out.println("$1000 and over\t" + salaryCounts[8]);
    }
}