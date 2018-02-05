
import java.util.Scanner;

public class main {

	static int recentSearchCount = 0;
	static String[] a = new String[5];
	
	public static void main(String[] args) {
		
		QuoteList q = InitList(); ///Initialize list and create quotes
		recentSearch("");//changed
		userChoice(q);//ask user what they want to do
		
	}
	
	public static QuoteList InitList(){ ///this is where we add or delete quotes
        QuoteSaxParser parser= new QuoteSaxParser ("quotes.xml");
        return parser.getQuoteList();
		
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
											//recentSearch(choice);//changed
										}
									}
									if(found==false){
										System.out.println("quote not found");
										System.out.println();
										//recentSearch(choice);//changed
									}
									innerSwitchStop = false;
                                    recentSearch(choice);
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
											//changed
										}
									}
									if(found==false){
										System.out.println("quote not found");
										recentSearch(choice);//changed
									}
									innerSwitchStop = false;
									recentSearch(choice);
									break;
		
								case "both":
									System.out.print("--> ");
									choice = sc.nextLine();
									recentSearch(choice);
									found = false;
									for(int i= 0; i < list.getSize(); i++){///loop through the list
										if(list.getQuote(i).getQuoteText().contains(choice)||list.getQuote(i).getAuthor().equals(choice)){
											found = true;
											System.out.println(list.getQuote(i).getQuoteText());
											System.out.println("———"+list.getQuote(i).getAuthor());
											//recentSearch(choice);//changed
										}
									}
									if(found==false){
										System.out.println("quote not found");
										//recentSearch(choice);//changed
									}
									innerSwitchStop = false;
                                    recentSearch(choice);
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

	public static void recentSearch(String search){//changed
		
		System.out.println(">>>>>>>>>>>>>>>>>>recent search<<<<<<<<<<<<<<<<<<");
		System.out.println();
		
		if(recentSearchCount==0){
			for(int i = 0; i < 5; i++){
				a[i] = "";
			}
			System.out.println("");
		}else{
			if(recentSearchCount<5){
				a[recentSearchCount-1] = search;
				for(int i = 0; i < recentSearchCount; i++){
						System.out.println(i+1 + ". "+ a[i]);
				}
			}else{
				for(int i = 0; i < 4; i++){
					a[i] = a[i+1];
				}
				a[4] = search;
				for(int i = 0; i < 5; i++){
					System.out.println(i+1 + ". "+ a[i]);
				}
			}

		}
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println();
		recentSearchCount++;
		
		
	}
}
