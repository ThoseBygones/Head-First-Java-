package simpledotcom;

import java.util.ArrayList;

public class SimpleDotComTestDrive {
	public static void main(String[] args) {
		int numOfGuesses = 0;
		GameHelper helper = new GameHelper();
		
		SimpleDotCom theDotCom = new SimpleDotCom();
		int randomNum = (int) (Math.random() * 5);

		ArrayList<String> locations = new ArrayList<String>();
		locations.add(Integer.toString(randomNum));
		locations.add(Integer.toString(randomNum+1));
		locations.add(Integer.toString(randomNum+2));
		theDotCom.setLocationCells(locations);
		
		boolean isAlive = true;
		
		
		while(isAlive == true) {
			String guess = helper.getUserInput("enter a number");
			String result = theDotCom.checkYourself(guess);	//��bug����Ϊ��ֻҪ����һ�㣬֮�󲻶ϵش����һ����3������ܹ�"kill"
			numOfGuesses++;
			if(result.equals("kill")) {
				isAlive = false;
				System.out.println("You took " + numOfGuesses + " guesses");
			}
		}
	}
}
