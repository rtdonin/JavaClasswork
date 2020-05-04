/*
Created by: Margaret Donin
Date created: 04/20/20
Date revised: 04/27/20
*/

package M2.Object.Factorizing;

public class Factorizing{
    private int userNum;
    private int[] factors;
    private String perfect;
    private String prime;
    
    public void setUserNum(int userNum){
       if (userNum <= 0){
            System.out.println("That was not a positive whole number, please try again!");
            System.exit(0);
        }
       this.userNum = userNum;
    }
    
    public int getUserNum(){
        return userNum;
    }
    
    public void setFactors(){
        factors = new int[] {1, userNum};
        int[] temp = factors;
        
        for (int i = 2; i < userNum; i++){
            if (userNum % i == 0){
                // if the element in the second spot is the userNum
                // replace the userNum with i, aka 2 and set the temp array to
                // what is now the [1,i]
                if(factors[1] == userNum){
                    factors[1] = i;
                    temp = factors;
                } else{
                    factors = new int[factors.length + 1];
                    
                    System.arraycopy(temp, 0, factors, 0, temp.length);
                    
                    factors[temp.length] = i;
                    temp = new int[factors.length];
                    System.arraycopy(factors, 0, temp, 0, factors.length);
                }
            }
        }
    }
    
    public int[] getFactors(){
        return factors;
    }
    
    public void printOutFactors(){
        for (int factor : this.factors){
            System.out.print(factor + " ");
        }
    }
    
    public void setPerfect(){
        int sum = 0;
                
        for (int i = 0; i < factors.length-1; i++){
            sum += factors[i];
        }
        
        boolean isIt = (sum == factors[factors.length - 1]);
        
        this.perfect = (isIt)? "" : "not ";
    }
    
    public String getPerfect(){
        return perfect;
    }
    
    public void setPrime(){
        this.prime = (factors.length > 2)? "not " : "";
    }
    
    public String getPrime(){
        return prime;
    }
    
    public void getStats(){
        setFactors();
        setPerfect();
        setPrime();
        
        System.out.println("\nThe factors of " + getUserNum() + " are:");
        printOutFactors();
        System.out.println(getUserNum() + " has " + getFactors().length + " factors.");
        System.out.println(getUserNum() + " is " + getPerfect() + "a perfect number.");
        System.out.println(getUserNum() + " is " + getPrime() + "a prime number.");
    }
}