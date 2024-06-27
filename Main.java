import java.util.Scanner; 
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.time.LocalDate;
import java.time.Period;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.regex.Pattern;

class BankAcc{
    public int  acc_no;
    public String name;
    public int age;
    public String gender;
    public String DOB;
    public String address;
    public String typ;
    public int balance;
    public String pan;
    public String aadhar;
    public BankAcc(int acc_no,String name,int age,String gender, String DOB,String address,String typ,int balance,String pan,String aadhar){
        this.acc_no=acc_no;
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.DOB=DOB;
        this.address=address;
        this.typ=typ;
        this.balance=balance;
        this.pan=pan;
        this.aadhar=aadhar;
    }
    
    public String getPanNumber() {
        return pan;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getaccno(){
        return this.acc_no;
    }
    
    public String getacct(){
        return this.typ;
    }
    
    public void acc_detail(){
        System.out.println("Name: "+name);
        System.out.println("Account number: "+acc_no);
        System.out.println("Age: "+ age);
        System.out.println("Gender: "+gender);
        System.out.println("DOB: "+DOB);
        System.out.println("Address: "+address);
        System.out.println("Account type: "+typ);
        System.out.println("Balance:"+ balance);
        System.out.println("Pan: "+pan);
        System.out.println("Aadhar: "+aadhar);
        System.out.println("---------------------------------------------");
    }
    
    public void updateName(String newName) {
        this.name = newName;
    }
    
    public void updateAddress(String newAddress) {
        this.address = newAddress;
    }
    
    public void updatedob(String newdob) {
        this.DOB = newdob;
    }
    
    public void updateamount(int amount){
        this.balance+=amount;
    }
    
    public int  updatewamount(int amount){
        int a=0;
        if(this.balance>=amount){
            this.balance-=amount;
            System.out.println("Amount withdrawn!");
        }else{
            a=1;
            System.out.println("Insufficient balnce!");
            return a;
        }
        return a;
    }
    
    public void check(){
        System.out.println("Your account balnce is Rs."+ this.balance);
    }
    
}
public class Main{
    
    public static void search(ArrayList<BankAcc> details){
        Iterator<BankAcc> iterator = details.iterator();
        Scanner myObj = new Scanner(System.in);
        System.out.println("Choose option to search:");
        System.out.println("a: To search using name");
        System.out.println("b: To search using account number");
        System.out.println("c: To search using account type");
        String op=myObj.next();
        switch (op) {
          case "a":
            int d=0;
            String name=myObj.next();
            while (iterator.hasNext()) {
            BankAcc detail = iterator.next();
            if (detail.getName().equals(name)) {
                d=1;
                System.out.println("Name:"+ detail.name);
                System.out.println("Account number"+ detail.acc_no);
                System.out.println("-----------------------------------");
            }
            }
            if(d==0){
                System.out.println("No user found!");
                System.out.println("--------------------------------------------------------");
            }
            break;
          case "b":
                int e=0;
                String acno=myObj.next();
                while (iterator.hasNext()) {
                BankAcc detail = iterator.next();
            if (detail.getPanNumber().equals(acno)) {
                e=1;
                System.out.println("Name:"+ detail.name);
                System.out.println("Account number"+ detail.acc_no);
                System.out.println("-----------------------------------");
            }
                }
            if(e==0){
                System.out.println("No user found!");
                System.out.println("--------------------------------------------------------");
            }
            break;
          case "c":
            int f=0;
            String acc_type=myObj.next();
            while (iterator.hasNext()) {
            BankAcc detail = iterator.next();
            if (detail.getacct().equals(acc_type)) {
                f=1;
                System.out.println("Name:"+ detail.name);
                System.out.println("Account number"+ detail.acc_no);
                System.out.println("-----------------------------------");
            }
                }
            if(f==0){
                System.out.println("No user found!");
                System.out.println("--------------------------------------------------------");
            }
            break;
        }
    }
    
    public static void fundtransfer(ArrayList<BankAcc> details, String id1, String id2,int amount){
        Iterator<BankAcc> iterator = details.iterator();
        int c=0;
        int d=0;
        while (iterator.hasNext()) {
            BankAcc detail = iterator.next();
            if (detail.getPanNumber().equals(id1)) {
                c=1;
                int a=detail.updatewamount(amount);
                if(a==1){
                    return;
                }
            }
        }
        if(c==0){
            System.out.println("incorrect account number!");
            System.out.println("--------------------------------------------------------");
            return;
        }
        
        while (iterator.hasNext()) {
            BankAcc detail = iterator.next();
            if (detail.getPanNumber().equals(id2)) {
                c=1;
                detail.updateamount(amount);
            }
        }
        if(c==0){
            System.out.println("Invalid benificiary account number!");
            System.out.println("--------------------------------------------------------");
        }else{
            System.out.println("Funds tranferred sucessfully.");
            System.out.println("--------------------------------------------------------");
        }

    }
    
    public static void checkbalance(ArrayList<BankAcc> details, String pan){
        int a=0;
        Iterator<BankAcc> iterator = details.iterator();
        while (iterator.hasNext()) {
            BankAcc detail = iterator.next();
            if (detail.getPanNumber().equals(pan)) {
                a=1;
                detail.check();
            }
        }
        if(a==0){
            System.out.println("Invalid account number!");
        }
        System.out.println("--------------------------------------------------------");
    }
    
    public static void withdraw(ArrayList<BankAcc> details, String pan,int amount){
        Iterator<BankAcc> iterator = details.iterator();
        int b=0;
        while (iterator.hasNext()) {
            BankAcc detail = iterator.next();
            if (detail.getPanNumber().equals(pan)) {
                b=1;
                int a=detail.updatewamount(amount);
                if(a==1){
                    return;
                }
            }
        }
        if(b==0){
            System.out.println("Invalid account number!");
        }
        System.out.println("--------------------------------------------------------");
    }
    
    public static void deposit(ArrayList<BankAcc> details, String pan,int amount){
        Iterator<BankAcc> iterator = details.iterator();
        int a=0;
        while (iterator.hasNext()) {
            BankAcc detail = iterator.next();
            if (detail.getPanNumber().equals(pan)) {
                a=1;
                detail.updateamount(amount);
                System.out.println(amount +" deposited successfully!");
            }
        }
        if(a==0){
            System.out.println("invalid account number!");
        }
        System.out.println("--------------------------------------------------------");
    }
    
    public static void update(ArrayList<BankAcc> details, String pan){
        int a=0;
        Scanner myObj = new Scanner(System.in);
        Iterator<BankAcc> iterator = details.iterator();
        while (iterator.hasNext()) {
            BankAcc detail = iterator.next();
            if (detail.getPanNumber().equals(pan)) {
                a=1;
                System.out.println("Select options to upadste details:");
                System.out.println("a: To update name");
                System.out.println("b: To update address");
                System.out.println("c: To update DOB");
                String opt1=myObj.next();
                switch (opt1) {
                  case "a":
                    String newName=myObj.next();
                    detail.updateName(newName);
                    System.out.println("Name updated successfully");
                    System.out.println("--------------------------------------------------------");
                    break;
                  case "b":
                    String newAddress=myObj.next();
                    detail.updateAddress(newAddress);
                    System.out.println("Address updated successfully");
                    System.out.println("--------------------------------------------------------");
                    break;
                  case "c":
                    String newDOB=myObj.next();
                    detail.updatedob(newDOB);
                    System.out.println("DOB updated successfully");
                    System.out.println("--------------------------------------------------------");
                    break;
                }
            }
        }
        if(a==0){
            System.out.println("Invalid account number!");
            System.out.println("--------------------------------------------------------");
        }
    }
    
    public static void deletebypan(ArrayList<BankAcc> details, String panNumberToDelete) {
        Iterator<BankAcc> iterator = details.iterator();
        int a=0;
        while (iterator.hasNext()) {
            BankAcc detail = iterator.next();
            if (detail.getPanNumber().equals(panNumberToDelete)) {
                iterator.remove();
                System.out.println("Account deleted successfully!");
                a=1;
            }
        }
        if(a==0){
            System.out.println("Invalid acount number!");
        }
        System.out.println("--------------------------------------------------------");
    }
    private static final String PAN_REGEX = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
    
    public static   boolean validatePan(String pan){
        Pattern pattern = Pattern.compile(PAN_REGEX);
        return pattern.matcher(pan).matches();
    }
    
    private static final String AADHAR_REGEX = "[0-9]{12}";
    
    public static boolean validateAadahr(String aad){
        Pattern pattern = Pattern.compile(AADHAR_REGEX);
        return pattern.matcher(aad).matches();
    }
        
    public static boolean validatebalance(int bal){
        if(bal<0){
            return false;
        }
        return true;
    }
        
    public static boolean validateacctype(String type){
        if(type.equals("saving") || type.equals("current") || type.equals("joint")){
            return true;
        }
        return false;
    }
        
    public static boolean validategender(String gender){
        if(gender.equals("male") || gender.equals("female")){
            return true;
        }
        return false;
    }
        
    public static boolean validateacc(ArrayList<BankAcc> details,String pan){
        Iterator<BankAcc> iterator = details.iterator();
        while (iterator.hasNext()) {
            BankAcc detail = iterator.next();
            if (detail.getPanNumber().equals(pan)) {
                return true;
            }
        }
        System.out.println("Invalid acount number!");
        return false;
    }
        
    public static int generaccno(){
        Random rand = new Random();
    	int rand_int1 = rand.nextInt(1000000000);
    	return rand_int1;
    }
    
    public static String getCaptcha(){
        int length=5;
        SecureRandom random = new SecureRandom();
        char[] chars = new char[length];
        for(int i=0; i<chars.length; i++)
        {
            int v = random.nextInt(10 + 26 + 26);
            char c;
            if (v < 10)
            {
                c = (char)('0' + v);
            }
            else if (v < 36)
            {
                c = (char)('a' - 10 + v);
            }
            else
            {
                c = (char)('A' - 36 + v);
            }
            chars[i] = c;
        }
        return new String(chars);
    }
    
    public static boolean validateCaptcha(String capt,String tycapt){
        if(capt.equals(tycapt)){
            return true;
        }
        return false;
    }
    
    public static boolean isValidYear(String date) {
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(date); 
            return true; 
        } catch (ParseException e) {
            return false;
        }
    }
    
    public static void main(String[] args) {
    	String userName="BankAccount";
    	String password="B123@nk";
    	ArrayList<BankAcc> details = new ArrayList<BankAcc>();
    	Scanner myObj = new Scanner(System.in);
        int acc_n;
        String nam;
    	int ag;
    	String gendr;
    	String dob;
    	String add;
    	String typp;
    	int bal;
    	String pann;
    	String adhar;
    	int cnt=0;
    	for(int i=0;i<3;i++){
    	    System.out.println("Enter username:");
    	    String uName=myObj.next();
    	    System.out.println("Enter password:");
    	    String pswd=myObj.next();
    	    if(userName.equals(uName) && password.equals(pswd)){
    	        System.out.println("Fill the captcha on the screen");
    	        String captcha=getCaptcha();
    	        System.out.println(captcha);
    	        String putCaptcha=myObj.next();
    	        boolean tcaptcha=true;
    	        tcaptcha=validateCaptcha(captcha,putCaptcha);
    	        while(!tcaptcha){
    	            System.out.println("Invalid captcha!");
    	            System.out.println("Fill the captcha on the screen");
    	            captcha=getCaptcha();
    	            System.out.println(captcha);
    	            putCaptcha=myObj.next();
    	            tcaptcha=validateCaptcha(captcha,putCaptcha);
    	        }
                	System.out.println("Select options to perform operation:");
                	System.out.println("1: To create account");
                	System.out.println("2: To delete account");
                	System.out.println("3: To update account");
                	System.out.println("4: To deposit amount");
                	System.out.println("5: To withdraw ammount");
                	System.out.println("6: To transfer fund");
                	System.out.println("7: To search acount");
                	System.out.println("8: To chaeck balance");
                	
                	while(true){
                	    int opt=myObj.nextInt();
                    	switch (opt) {
                            case 1:
                                System.out.println("Creating account");
                                System.out.println("Enter the details:");
                                System.out.println("Enter the name:");
                                nam=myObj.next();
                                
                            	System.out.println("Enter your gender:");
                            	gendr=myObj.next();
                            	boolean e=validategender(gendr);
                                while(!e){
                                    System.out.println("Enter correct gender");
                                    gendr=myObj.next();
                                    e=validategender(gendr);
                                }
                                
                            	System.out.println("Enter your date of birth (yyyy-mm-dd): ");
                            	dob = System.console().readLine();
                            	boolean dd= isValidYear(dob);
                            	while(!dd){
                            	    System.out.println("Invalid date");
                            	    System.out.println("Enter your date of birth (yyyy-mm-dd): ");
                            	    dob = System.console().readLine();
                            	    dd=isValidYear(dob);
                            	}
                            	LocalDate birthdate = LocalDate.parse(dob);
                            	LocalDate currentDate = LocalDate.now();
                            	Period period = Period.between(birthdate, currentDate);
                            	
                            	ag = period.getYears();
                            	
                            	System.out.println("Enter your address:");
                            	add=myObj.next();
                            	
                            	System.out.println("Enter account type:");
                            	typp=myObj.next();
                            	boolean d=validateacctype(typp);
                                while(!d){
                                    System.out.println("Enter correct type");
                                    typp=myObj.next();
                                    d=validateacctype(typp);
                                }
                                
                            	System.out.println("Enter the openning balance:");
                            	bal=myObj.nextInt();
                            	boolean c=validatebalance(bal);
                                while(!c){
                                    System.out.println("Enter correct opening balance");
                                    bal=myObj.nextInt();
                                    c=validatebalance(bal);
                                }
                                
                            	System.out.println("Enter your pan details:");
                            	pann=myObj.next();
                                boolean p=validatePan(pann);
                                while(!p){
                                    System.out.println("Enter correct pan number:");
                                    pann=myObj.next();
                                    p=validatePan(pann);
                                }
                                
                            	System.out.println("Enter your aadhar details:");
                            	adhar=myObj.next();
                                boolean a=validateAadahr(adhar);
                                while(!a){
                                    System.out.println("Enter correct aadhar number:");
                                    adhar=myObj.next();
                                    a=validateAadahr(adhar);
                                }
                                
                                acc_n=generaccno();
                                BankAcc p1=new BankAcc(acc_n,nam,ag,gendr,dob,add,typp,bal,pann,adhar);
                                details.add(p1);
                                System.out.println("Account created successfully");
                                p1.acc_detail();
                                break;
                            case 2:
                                System.out.println("Enter your pan number to delete your account:");
                                String pp=myObj.next();
                                deletebypan(details,pp);
                                break;
                            case 3:
                                System.out.println("Enter your account number to update your account details:");
                                String ppp=myObj.next();
                                update(details,ppp);
                                break;
                            case 4:
                                System.out.println("Enter your account number to deposit the amount:");
                                String pppp=myObj.next();
                                System.out.println("Enter the ammount to be deposited:");
                                int amount=myObj.nextInt();
                                deposit(details,pppp,amount);
                                break;
                            case 5:
                                System.out.println("Enter your account number to withdraw the amount:");
                                String ab=myObj.next();
                                System.out.println("Enter the ammount to be withdrawn:");
                                amount=myObj.nextInt();
                                withdraw(details,ab,amount);
                                break;
                            case 6:
                                System.out.println("Enter details for fund transfer:");
                                System.out.println("Enter your account number:");
                                String id1=myObj.next();
                                boolean a1=validateacc(details,id1);
                                System.out.println("Enter benificiary account number:");
                                String id2=myObj.next();
                                boolean a2=validateacc(details,id2);
                                System.out.println("Enter the amount to be transferred:");
                                int amt=myObj.nextInt();
                                if(a1==true && a2== true){
                                    fundtransfer(details, id1,id2,amt);
                                }
                                break;
                            case 7:
                                System.out.println("Enter the details to search:");
                                search(details);
                                break;
                            case 8:
                                System.out.println("Enter your account number:");
                                String id=myObj.next();
                                checkbalance(details,id);
                                break;
                        }
                    }
                
    	    }else{
    	        cnt++;
    	        if(cnt==3){
    	            System.out.println("You have exhausted the limit.");
    	        }
    	    }
    	    
    	}
	
	}
}
