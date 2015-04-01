import javax.swing.JOptionPane;


public class Dice {

	public static void main(String[] args) {
		String select;
		String c;
		double count = 0;//number game play
		double countE = 0;//number Even guess by player
		double countO = 0;//number Odd is generated by dice
		double countWin = 0;//number time win
		float perCE = 0;//percent Even
		float perCO = 0;//percent Odd
		float perWin = 0;//percent Win
		
			
		do{
			//Track number games (track#1)
			count ++;
			
			// random number of dice 1-6
			int throwDice = 1 + (int)(Math.random()*6);
			
			//Percentage Odd generate by dice (track#4)
			if (throwDice %2 !=0){ 
				countO++;
				perCO = (float)(countO/count)*100;
			}
			
			String guess = JOptionPane.showInputDialog ("Guess even or odd(E/O):");
			select = guess.toUpperCase();
			switch(select){
			case "E":
				
				countE ++;//keep track % of player guess EVEn (track#3)
				perCE = (float)(countE/count)*100;
				if ( throwDice % 2 == 0){
					countWin ++;
					String messege = String.format("dice: %d\n Win\n ", throwDice);
					JOptionPane.showMessageDialog(null, messege);
					}
				else {
					String messege1 = String.format("dice: %d\n Lose\n ", throwDice);
					JOptionPane.showMessageDialog(null, messege1);
				}
				break;
			case "O":
				
				if ( throwDice % 2 == 0){
					String messege2 = String.format("dice: %d\n lose\n ", throwDice);
					JOptionPane.showMessageDialog(null, messege2);
					}
				else {
					countWin++;
					String messege3 = String.format("dice: %d\n Win\n ", throwDice);
					JOptionPane.showMessageDialog(null, messege3);
				}
				break;
			}
			//track Percentage win (track#2)
			perWin = (float)(countWin/count)*100;
			String messege4 = String.format("Game play: %.2f\t  PerEven by player:%.2f\t  PerOdd by dice:%.2f\n PerWin:%.2f", count, perCE, perCO, perWin);
			JOptionPane.showMessageDialog(null, messege4);
			
			c = JOptionPane.showInputDialog("Play again ?: ");//play again part
		}
		while(c.equalsIgnoreCase("y"));
		JOptionPane.showMessageDialog(null, "Bye");
	}

}
