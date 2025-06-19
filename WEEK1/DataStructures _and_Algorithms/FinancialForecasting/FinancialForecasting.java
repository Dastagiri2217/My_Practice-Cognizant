import java.util.*;
public class FinancialForecasting{
    public static double calulateFutureValue(int presentAmount,double rate,int years){
        if(years == 0){
            return presentAmount;
        }
        return calulateFutureValue(presentAmount,rate,years-1)*(rate+1);//1 represent percentage of our original value
        //this recursion will go on until years  == 0  with a constant intrest rate + 1
        //amount * rate +1 
        
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Present Amount : ");
        int presentAmount = sc.nextInt();
        System.out.println("Enter the Growth Rate : ");
        double rate  = sc.nextDouble();
        System.out.println("Enter the Years You want to Forecast : ");
        int years = sc.nextInt();
        double futureValue = calulateFutureValue(presentAmount,rate,years);
        System.out.printf("The Future value of : %d After %d years with constant Growth rate: %.2f is :%.2f",presentAmount,years,rate,futureValue);
    }
}