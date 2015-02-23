import java.util.ArrayList;
import java.io.InputStreamReader;

public class War {
	private Deck playDeck;
	private Deck player1;
	private Deck player2;
	private Card p1TopCard;
	private Card p2TopCard;
	private ArrayList<Card> playHand;
	private int handsPlayed = 0;
	private int ties = 0;
	private boolean hasWinner = false;
	private int warCount;
	public static final int DEFAULT_WAR_SIZE = 3;

	public War(Deck player1Deck, Deck player2Deck) {
		playDeck = playDeck = new Deck(1, 23);
		player1 = player1Deck;
		p1TopCard = player1.getTopCard();
		player2 = player2Deck;
		p2TopCard = player2.getTopCard();
		warCount = DEFAULT_WAR_SIZE;
		playHand = new  ArrayList<Card>();
	}

	public War(long randomSeed, int numberOfDecks, int numberOfJokerPairs, int warSize) {
		playDeck = new Deck(numberOfDecks, numberOfJokerPairs, randomSeed);
		player1 = new Deck();
		player2 = new Deck();
		playHand = new ArrayList<Card>();
		warCount = warSize;
		playDeck.shuffleCards();
		Deck.dealCards(playDeck, player1, player2);
		p1TopCard = player1.getTopCard();
		p2TopCard  = player1.getTopCard();
	}

	public War (long randomSeed, int numberOfDecks, int numberOfJokerPairs) {
		this(randomSeed, numberOfDecks, numberOfJokerPairs, DEFAULT_WAR_SIZE);
	}

	public War (long randomSeed, int numberOfDecks) {
		this(randomSeed, numberOfDecks, numberOfDecks, DEFAULT_WAR_SIZE);
	}

	public War (long randomSeed) {
		this(randomSeed, 1, 1, DEFAULT_WAR_SIZE);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Deck: "  +  playDeck + "\n\n");
		sb.append("Player 1: ");
		if (p1TopCard != null) {
			sb.append(p1TopCard + ", " + player1 );
		}
		sb.append("\n\n");
		sb.append("Player 2: ");
		if (p2TopCard != null){
			sb.append(p2TopCard + ", " +  player2);
		}
		sb.append("\n\n");
		return sb.toString();
	}

	public boolean gameOver() {
		return hasWinner;
	}

	public void printStats() {
		System.out.println("Hands played: " + handsPlayed);
		System.out.println("Ties: " + ties);
	}

	public int playHand() {
		int result = Deck.playDeal(p1TopCard, p2TopCard);
		handsPlayed = (result != 0 ? ++handsPlayed : handsPlayed);
		playHand.add(p1TopCard);
		playHand.add(p2TopCard);
		if (result > 0 && !hasWinner){
			System.out.println(p1TopCard + " beats " +  p2TopCard);
			player1.addCards(playHand);
			playHand.clear();
			if (hasWinner()) {
				return result;
			}
		} else if (result < 0 && !hasWinner){
			System.out.println(p1TopCard + " loses to " + p2TopCard);
			player2.addCards(playHand);
			playHand.clear();
			if (hasWinner()) {
				return result;
			}
		} else if (result == 0){

			System.out.println(p1TopCard + " ties " + p2TopCard);
			ties++;
			for (int i = 0; i < warCount; i++) {
				if (player1.getSize() == 0 && player2.getSize() != 0) {
					handsPlayed++;
					System.out.println("Player 1 is out of cards.  Player 2 wins!");
					hasWinner = true;
					winPlayer2();
					result = -1;
					return result;
				} else if (player2.getSize() == 0 && player1.getSize() != 0) {
					handsPlayed++;
					System.out.println(player1.getSize());
					System.out.println("Player 2 is out of cards.  Player 1 wins!");
					hasWinner = true;
					winPlayer1();
					result = 1;
					return result;
				} else if (player1.getSize() == 0 && player2.getSize() == 0) {
					handsPlayed++;
					System.out.println("Wow, unbelievable! The game tied!");
					hasWinner = true;
					result = -1;
					p1TopCard = null;
					p2TopCard = null;
					return result;
				} else {
					p1TopCard = player1.getTopCard();
					p2TopCard = player2.getTopCard();
					if ( i <  warCount - 1 ) {
						playHand.add(p1TopCard);
						playHand.add(p2TopCard);
					}
				}
			}
			return playHand();
		}

		// ready for a new hand
		p1TopCard = player1.getTopCard();
		p2TopCard  = player2.getTopCard();
		return result;
	}

	public void winPlayer1() {
		player1.addCards(playHand);
		playHand.clear();
		p1TopCard = null;
		p2TopCard = null;
		hasWinner = true;
	}

	public void winPlayer2() {
		player2.addCards(playHand);
		p1TopCard = null;
		p2TopCard = null;
		playHand.clear();
		hasWinner = true;
	}

	public boolean hasWinner() {
		if (player2.getSize() == 0){
			System.out.println("Player 2 is out of cards.  Player 1 wins!");
			winPlayer1();
			return true;
		}
		if (player1.getSize() == 0) {
			System.out.println("Player 1 is out of cards.  Player 2 wins!");
			winPlayer2();
			return true;
		}
		return false;
	}

	public void myWarSize() {
		int p1Size = (p1TopCard == null ? player1.getSize() :  player1.getSize() + 1);
		int p2Size = (p2TopCard == null ? player2.getSize() :  player2.getSize() + 1);
		System.out.println("Player 1: " + p1Size);
		System.out.println("Player 2: " + p2Size);
		printStats();
	}

	public static void WarTest() {
		ArrayList<Card> p1Cards = new ArrayList<Card>();
		ArrayList<Card> p2Cards = new ArrayList<Card>();

		p1Cards.add(new Card(Face.EIGHT, Suit.HEART));
		p1Cards.add(new Card(Face.NINE, Suit.CLUB));
		p1Cards.add(new Card(Face.SEVEN, Suit.HEART));
		p1Cards.add(new Card(Face.SIX, Suit.CLUB));
		p1Cards.add(new Card(Face.SIX, Suit.HEART));
		p1Cards.add(new Card(Face.JACK, Suit.CLUB));

		p2Cards.add(new Card(Face.EIGHT, Suit.DIAMOND));
		p2Cards.add(new Card(Face.TEN, Suit.DIAMOND));
		p2Cards.add(new Card(Face.KING, Suit.CLUB));
		p2Cards.add(new Card(Face.FIVE, Suit.HEART));
		p2Cards.add(new Card(Face.SEVEN, Suit.DIAMOND));


		Deck deck1 = new Deck(p1Cards);
		Deck deck2 = new Deck(p2Cards);
		War myWar = new War(deck1, deck2);
		System.out.println(myWar);
		myWar.playHand();
		System.out.println(myWar);
		}

	public static void main(String args[]) throws NumberFormatException {
		//WarTest();
		long randomize = 0;
		try {
			randomize = new Long(args[0]).longValue();
		} catch  (NumberFormatException e) {
			throw e;
		}
		War myWar = new War(randomize);
		while (!myWar.gameOver()) {
			myWar.playHand();
			myWar.myWarSize();
		}
		myWar = new War(randomize * 13, 2, 4, 5);
		System.out.println("New war, double deck, 8 jokers, play 5 cards for War");
		while (!myWar.gameOver()) {
			myWar.playHand();
			myWar.myWarSize();
		}
   }
}