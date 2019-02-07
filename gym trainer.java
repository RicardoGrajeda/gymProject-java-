import java.util.Scanner;
import javax.swing.JOptionPane;

class Customer{
private String firstName; 	//private variable
private String lastName;	//private vairable
private int age;		//private variable //all these variables are private because they are perosnal information
private int weight;		//private variable //which I believe should remain confidential
private String fitnessGoal;	//private variable
private int trainingAmount;	//private variable
private double price;		//private variable

public Customer(){	//default contructor
}

public Customer(String f, String l, int a, int w){  //contructor
firstName = f;
lastName = l;
age = a;
weight = w;
}

String getFirstName(){ //accessor
return firstName;
}

String getLastName(){ //accessor
return lastName;
}

void setFitnessGoal(String g){ //mutator
fitnessGoal = g;
}

int getAge(){ //accessor
return age;
}

int getWeight(){ //accessor
return weight;
}

void setTrainingAmount(int t){ //mutator
trainingAmount = t;
}


void output(){		//outputs the entire profile of object
JOptionPane.showMessageDialog(null, "NAME: " + firstName + " " + lastName + "\n" +
"AGE: " + age + "\n" + "WEIGHT: " + weight + "\n" + "FITNESS GOAL: " + fitnessGoal + "\n" + "TRAINING AMOUNT: " +
trainingAmount + " days" + "\n" + "PRICE: $" + price, "Profile" , JOptionPane.INFORMATION_MESSAGE);
}

void setPrice(int p){ //mutator
price = p;
}
}



class main{
public static void main(String args[]){

Scanner s = new Scanner (System.in); 

String firstName; //String var to hold first name
String lastName; //String var to hold last name
int age;	//int var to hold in age
int weight;	//int var to hold weight
boolean answer = false;	//boolean is allocated(will be used for a do-while loop, to restart program)

//introduction dialog boxes
JOptionPane.showMessageDialog(null, "Welcome to Brofessor Dumbbelldor gym, my name is Ricardo Grajeda and i'll be your personal trainer, together we will reach your personal goal", "Welcome!", JOptionPane.INFORMATION_MESSAGE);
JOptionPane.showMessageDialog(null, "To begin the procces I will need some information from you...", "Welcome!", JOptionPane.INFORMATION_MESSAGE);


do{ 	//do-while loop that will execute loop if user does not confirm information is correct at end of program.

firstName = JOptionPane.showInputDialog("Enter you first name: "); //getting first name input
if(firstName == null){
	System.exit(0);
}

lastName = JOptionPane.showInputDialog("Enter your las name: "); //getting last name input
if(lastName == null){
	System.exit(0);
}

age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age: ")); //getting age input
if (age < 18){ //checking if adult(if not adult then program exits)
JOptionPane.showMessageDialog(null,"Sorry, you are not old enough to request a personal trainer at your age", "Age requirement not met", JOptionPane.INFORMATION_MESSAGE);
System.exit(0);
}

weight = Integer.parseInt(JOptionPane.showInputDialog("Enter your weight(pounds): ")); //getting weight input;

Customer a = new Customer(firstName,lastName,age,weight); //object of Customer class is created

JOptionPane.showMessageDialog(null,"Now lets cover the the fitness programs we have for you","info" , JOptionPane.INFORMATION_MESSAGE); //information

JOptionPane.showMessageDialog(null, "Enter a number to select one of the following optionss.","info", JOptionPane.INFORMATION_MESSAGE); //information

int choice;
do{		//do - while loop to check if input is within range 
System.out.println("\t 1. Get lean(lower than 12% body fat)");
System.out.println("\t 2. Tone up");
System.out.println("\t 3. Gain size(muscle)");
System.out.println();
System.out.print("Enter your choice(number): ");
choice = s.nextInt();
}while (choice >3 || choice <1);

switch (choice){ //switch statement for choice of body goal customer wishes to achieve.

case 1:
System.out.println("You have chosen the Lean option");
a.setFitnessGoal("Get lean");
JOptionPane.showMessageDialog(null,"Typically will consist of cardio for 15 minutes immediately with weighted \n exercises(mostly consisting of supersets and high reps)\n and to finish off cardio for 20 minutes (cardio in those two places is essential to maximize results", "LEAN" , JOptionPane.INFORMATION_MESSAGE); 
break;

case 2:
System.out.println("You have chosen the Tone up option");
a.setFitnessGoal("Tone up");
JOptionPane.showMessageDialog(null,"Since we will be doing body weight exercises, as out main source of exercises \nthis means you are just or even more prevalent to pulling a \nmuscle since you will be doing movements that most people don’t do and or the body is not familiar with. With this being said stretching \nis IMPORTANT. A routine will consist of 10 to 15 minutes of stretching followed by body \nexercises that we will evaluate are appropriate for you when you come on your first day.","TONE",JOptionPane.INFORMATION_MESSAGE);
break;

case 3:
System.out.println("You have chosen the Gain size option");
a.setFitnessGoal("Gain size");
JOptionPane.showMessageDialog(null, "There are 3 body types in this world ectomorph, mesomorph, and endomorph(you may be in between them\n too). Each body is unique in it’s own way that is why we must approach every ones goals in a unique way. With this\nbeing said I will give you tips on what foods to eat and stay away from when trying to gain size(muscle not fat. But \nsometimes a caloric surplus is necessary so this may vary). Our routines will consist of weighted exercises as our \nprimary source to gain size with around 5 to 12 repetitions(again this may vary on your body type). Most importantly \nthis goal is hardest to achieve because eating is the most important part of this and thus I can't be filtering what you eat.", "GAIN SIZE",JOptionPane.INFORMATION_MESSAGE);
break;
}

System.out.println();
choice = Integer.parseInt(JOptionPane.showInputDialog("How many times a week are you willing to train?")); //getting int input for choice
while (choice > 7 || choice < 1){	//while loop to check if choice is valid number range
JOptionPane.showMessageDialog(null , "Invalid amount try again must be within range of 1-7","INVALID INPUT", JOptionPane.INFORMATION_MESSAGE);
choice = Integer.parseInt(JOptionPane.showInputDialog("How many times a week are you willing to train?"));
}
a.setTrainingAmount(choice); 	//calling objects method and assigning traininAmount with choice

	//displaying prices to customer
System.out.println("\t prices");
System.out.println("1.\t1 day a week for a month : 70$ a month");
System.out.println("2.\t2 days a week for a month : 120$ a month");
System.out.println("3.\t3 days a week for a month : 160$ a month");
System.out.println("4.\t4 day or more is all for 250$ a month");
System.out.print("Enter a monthly plan(1-4): ");
choice = s.nextInt();

switch (choice){	//swith statement for user to choose a fitness plan to be paid monthly
case 1:
System.out.println("You have chosen 1 day a week for 70$ a month");
a.setPrice(70);	//setting price to object's variable
a.setTrainingAmount(1); //setting amount of days that she is paying for
break; //end switch statement 

case 2:
System.out.println("You have chosen 2 days a week for 120$ a month");
a.setPrice(120);
a.setTrainingAmount(2);
break;

case 3:
System.out.println("You have chosen 3 days a week for 160$ a month");
a.setPrice(160);
a.setTrainingAmount(3);
break;

case 4:
System.out.println("You have chosen 4 days or more for 250$ a month");
a.setPrice(250);
a.setTrainingAmount(4);
break;
}

a.output(); 	//outputs the entire profile(information and prices customer has chosen)

String answer1;

answer1 = JOptionPane.showInputDialog("Is the information correct(yes/no/type 'show' to view profile again)");	//confirming information(user input)

while(answer1.equals("show")){ 	//while loop to display profile to user again if customer asks for it
a.output();
answer1 = JOptionPane.showInputDialog("Is the information correct?(yes/no/or type 'show' to view profile again)");
}


if(answer1.equals("yes")){ 		//letting user know they said yes.
JOptionPane.showMessageDialog(null, "Great, were finished!, I look forwards to our journey for self improvement!","DONE", JOptionPane.INFORMATION_MESSAGE);
answer = false;
}

else if(answer1.equals("no")){ 	//letting user know they selected no and program will restart to fix mistakes from profile
JOptionPane.showMessageDialog(null, "Start from the begginning and start over","Try again",JOptionPane.INFORMATION_MESSAGE);
answer = true;
}

}while(answer == true);	//do while loop will restart entire program when confirmation is answered with no

}
}