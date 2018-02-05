package quotes;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		QuoteList q = InitList(); ///Initialize list and create quotes
		userChoice(q);//ask user what they want to do
		
	}
	
	public static QuoteList InitList(){ ///this is where we add or delete quotes
		
		QuoteList tempList = new QuoteList();
		
		Quote q1 = makeQuote("I know that you believe you understand what "
				+ "you think I said, but I am not sure you realize that what "
				+ "you heard is not what I meant.","Richard Nixon");
		Quote q2 = makeQuote("Nothing ever becomes real till it is experienced; even a proverb "
				+ "is no proverb to you till your life has illustrated it.","John Keats");
		Quote q3 = makeQuote("oh dang","Zi");
		Quote q4 = makeQuote("The significant problems we face cannot be solved at the same level "
				+ "of thinking we were at when we created them.","Albert Einstein");
		Quote q5 = makeQuote("Legs are the wheels of creativity","Albert Einstein");
		
		
		
		tempList.setQuote(q1);
		tempList.setQuote(q2);
		tempList.setQuote(q3);
		tempList.setQuote(q4);
		tempList.setQuote(q5);

		
		
		return tempList;
		
	}
	
	public static void userChoice(QuoteList list){
		boolean stop = true;
		while(stop){
			
			box();///box function is to make a box for operation menu
			
			System.out.print("Random , Search or Exit?(type R, S, or E): ");
			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			Quote ans = new Quote();
			switch(choice){
				case "R":
				case "r":
					ans = list.getRandomQuote(); ///get a random quote
					System.out.println(ans.getQuoteText());
					System.out.println("———"+ans.getAuthor());
					break;
				case "S":
				case "s": ///search for a quote or author
					System.out.print("Scope (type quote, author, or both): ");
					
					boolean innerSwitchStop = true;
						while(innerSwitchStop){
							choice = sc.nextLine();
							switch(choice){
								case "quote":
									boolean found = false;
									System.out.print("type in quote: ");
									choice = sc.nextLine();
									for(int i= 0; i < list.getSize(); i++){ ///loop through the list
										if(list.getQuote(i).getQuoteText().contains(choice)){ //compare
											found = true;
											System.out.println(list.getQuote(i).getQuoteText());
											System.out.println("———"+list.getQuote(i).getAuthor());
										}
									}
									if(found==false){
										System.out.println("quote not found");
									}
									innerSwitchStop = false;
									break;
								case "author":
									
									System.out.print("type in author: ");
									choice = sc.nextLine();
									found = false;
									for(int i= 0; i < list.getSize(); i++){///loop through the list
										if(list.getQuote(i).getAuthor().equals(choice)){//compare
											found = true;
											System.out.println(list.getQuote(i).getQuoteText());
											System.out.println("———"+choice);
										}
									}
									if(found==false){
										System.out.println("quote not found");
									}
									innerSwitchStop = false;
									
									break;
		
								case "both":
									System.out.print("--> ");
									choice = sc.nextLine();
									found = false;
									for(int i= 0; i < list.getSize(); i++){///loop through the list
										if(list.getQuote(i).getQuoteText().contains(choice)||list.getQuote(i).getAuthor().equals(choice)){
											found = true;
											System.out.println(list.getQuote(i).getQuoteText());
											System.out.println("———"+list.getQuote(i).getAuthor());
										}
									}
									if(found==false){
										System.out.println("quote not found");
									}
									innerSwitchStop = false;
									break;
								default:
									System.out.println("quote not found");
										break;
							}///switch close brace
						}
					break;
			////end of case "S"
					
				case "E":
				case "e":
					System.out.println("Program Terminated...");
					stop = false;
					break;
				default:
					System.out.println("Invalid Input");
					break;	
			}//switch close brace
		}//while close brace
		
	}
	
	
	public static Quote makeQuote (String text, String author){
		Quote quo = new Quote();
		quo.setQuoteText(text);
		quo.setAuthor(author);
		return quo;
	}
	
	public static void box(){
		int x = 0;
//		while(x<49){
//			System.out.print(">");
//			x++;
//			if(x == 49){
//				System.out.println();
//				System.out.print("^  ");
//				System.out.println("                                             ^");
//				System.out.print("^  ");
//				System.out.println("                                             ^");
//				System.out.print("^  ");
//				System.out.print("Type R for a random quote, S to search quote");
//				
//				System.out.println(" ^");
//				System.out.println("^  or E to exit the program                     ^");
//			}
//		}
		while(x<21){
			System.out.print(">");
			x++;
			if(x == 10){
				System.out.print("Opeartion Menu");
			}else if(x==21){
				System.out.println(">");
			}
		}
		int z = 0;
		while(z<6){
			if(z==1){
				System.out.println("^                                  ^");
				System.out.print("^    R for randome quote ");
				System.out.println("          ^");
			}
			else if(z==2){
				System.out.print("^    S for search");
				System.out.println("                  ^");
			}
			else if(z==3){
				System.out.print("^    E for exit  ");
				System.out.println("                  ^");
			}
			else if(z==4){
				System.out.print("^                                  ^");
				System.out.println();
			}
			else if(z==5){
				System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				System.out.println();
			}
			z++;
		}
	
		System.out.println();
	}

}
