// gaslighting gatekeeping girlbosses -- Lauren Lee, Kevin Xiao, Kevin Li
// APCS
// L09 -- Some Folks Call It a Charades
// 2022-04-26
// time spent: 5 hrs

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * GUI Frame class for the Celebrity Game
 * @author cody.henrichsen
 * @version 2.1 17/09/2018
 */
public class CelebrityFrame extends JFrame
{
	//Data members for the JFrame subclass instance

	/**
	 * The instance of the panel used for playing the game.
	 */
	private CelebrityPanel gamePanel;

	/**
	 * Blank panel used for the CardLayout switching screens feature.
	 */
	private JPanel panelCards;

	/**
	 * The instance variable used to add a celebrity to the game.
	 */
	private StartPanel startPanel;

	/**
	 * A reference to the CelebrityGame instance to allow for minimized coupling in the object structure.
	 */
	private CelebrityGame controller;


	/**
	 * Builds an instance of the CelebFrame with a reference to the CelebrityGame instance.
	 * @param controller A reference to a CelebrityGame to share with the CelebPanel instance.
	 */
	public CelebrityFrame(CelebrityGame controllerRef)
	{
		//The first line of any subclass should ALWAYS be a correct call to the super constructor.
		super();
		controller = controllerRef;
		panelCards = new JPanel();
		gamePanel = new CelebrityPanel(controller);
		startPanel = new StartPanel(controller);
		setupFrame();


	}

	/**
	 * Configures the JFrame window subclass to add the panel and set size based information.
	 */
	private void setupFrame()
	{
		panelCards.setLayout(new CardLayout());
		//panelCards.add(gamePanel);
		panelCards.add(startPanel);
		this.setSize(500, 500);
		this.setTitle("Celebrity Game");
		panelCards.add(startPanel);
		this.add(panelCards);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
		replaceScreen("START");
	}

	/**
	 * Swaps the screen between the existing panels based on the String parameter.
	 * @param screen The name of the screen to open.
	 */
	public void replaceScreen(String screen)
	{
		if(screen.equals("START")){
			setContentPane(startPanel);
		} else if(screen.equals("GAME")){
			gamePanel.addClue(controller.sendClue());
			setContentPane(gamePanel);
		}
	}

}
