import javax.swing.*;
import java.awt.BorderLayout;

class dice 
{
	public static void main(String[] args) 
	{
		int chips = 1000;
		int again = 0;//0 to stop, 1 to keep going
		int rolls = 0;//For keeping track of rolls for 7/11
		int pDnp = 0; //pass or do not pass
		int point = 1;
		int roll = 0;
		JFrame application = new JFrame();
		while(chips > 0 || again != 1){

			ImageIcon die1_1 = new ImageIcon("die_01.gif");
			ImageIcon die2_1 = new ImageIcon("die_02.gif");
			ImageIcon die3_1 = new ImageIcon("die_03.gif");
			ImageIcon die4_1 = new ImageIcon("die_04.gif");
			ImageIcon die5_1 = new ImageIcon("die_05.gif");
			ImageIcon die6_1 = new ImageIcon("die_06.gif");
			ImageIcon die1_2 = new ImageIcon("die_01_2.gif");
			ImageIcon die2_2 = new ImageIcon("die_02_2.gif");
			ImageIcon die3_2 = new ImageIcon("die_03_2.gif");
			ImageIcon die4_2 = new ImageIcon("die_04_2.gif");
			ImageIcon die5_2 = new ImageIcon("die_05_2.gif");
			ImageIcon die6_2 = new ImageIcon("die_06_2.gif");

			JLabel die1_1i = new JLabel(die1_1);
			JLabel die2_1i = new JLabel(die2_1);
			JLabel die3_1i = new JLabel(die3_1);
			JLabel die4_1i = new JLabel(die4_1);
			JLabel die5_1i = new JLabel(die5_1);
			JLabel die6_1i = new JLabel(die6_1);
			JLabel die1_2i = new JLabel(die1_2);
			JLabel die2_2i = new JLabel(die2_2);
			JLabel die3_2i = new JLabel(die3_2);
			JLabel die4_2i = new JLabel(die4_2);
			JLabel die5_2i = new JLabel(die5_2);
			JLabel die6_2i = new JLabel(die6_2);

			
			int bet = Integer.parseInt(JOptionPane.showInputDialog("Enter your bet"));
			while (bet > chips)
			{
				bet = Integer.parseInt(JOptionPane.showInputDialog("Enter your bet"));
			}
			chips -= bet;
			pDnp = Integer.parseInt(JOptionPane.showInputDialog("Enter 0 for pass line or 1 for Do Not Pass line"));
			if (pDnp != 1 || pDnp != 0)
			{
					pDnp = Integer.parseInt(JOptionPane.showInputDialog("Enter 0 for pass line or 1 for Do Not Pass line"));
			}
			

			int die1Roll = (int)(Math.random()*6) + 1;
			int die2Roll = (int)(Math.random()*6) + 1;
			roll = die1Roll + die2Roll;
			System.out.println(die1Roll);
			System.out.println(die2Roll);
			rolls++;
			System.out.println("roll: "+rolls);

			if (die1Roll + die2Roll == 7 || die1Roll + die2Roll == 11 && pDnp == 0)
			{
				chips += bet;
			}
			else if (die1Roll + die2Roll == 2 || die1Roll + die2Roll == 12 || die1Roll + die2Roll == 3 && pDnp == 1)
			{
				chips += bet;
			}
			else
			{
				point = die1Roll + die2Roll;
			}
			//Pass betting point will be rolled first, do not pass betting 7 rolled first
			while (roll != point || roll != 7)
			{
				int die3Roll = (int)(Math.random()*6) + 1;
				int die4Roll = (int)(Math.random()*6) + 1;
				roll = die4Roll + die3Roll;
				if (roll == point && pDnp == 1)
				{
					chips += bet;
				}
				if (roll == 7 && pDnp == 0)
				{
					chips += bet;
				}
			}


			switch(die1Roll)
			{
				case 1: 
					application.add(die1_1i, BorderLayout.WEST);
					break;
				case 2: 
					application.add(die2_1i, BorderLayout.WEST);
					break;
				case 3: 
					application.add(die3_1i, BorderLayout.WEST);
					break;
				case 4: 
					application.add(die4_1i, BorderLayout.WEST);
					break;
				case 5: 
					application.add(die5_1i, BorderLayout.WEST);
					break;
				case 6: 
					application.add(die6_1i, BorderLayout.WEST);
					break;
				default:
					System.out.println("Something broke");
					break;
					
			}

			switch(die2Roll)
			{
				case 1: 
					application.add(die1_2i, BorderLayout.EAST);
					break;
				case 2: 
					application.add(die2_2i, BorderLayout.EAST);
					break;
				case 3: 
					application.add(die3_2i, BorderLayout.EAST);
					break;
				case 4: 
					application.add(die4_2i, BorderLayout.EAST);
					break;
				case 5: 
					application.add(die5_2i, BorderLayout.EAST);
					break;
				case 6: 
					application.add(die6_2i, BorderLayout.EAST);
					break;
				default:
					System.out.println("Something broke");
					break;
					
			}
			
			
			
		}//while loop
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		application.setSize( 700, 700 );
		application.setVisible( true );
	}
}
