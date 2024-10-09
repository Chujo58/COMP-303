package notes.chapter5;

import static org.junit.Assert.assertSame;

import org.junit.jupiter.api.Test;

public class TestCard {
	@Test
	void testGet_Normal() {
		Card card = Card.get(Rank.ACE, Suit.CLUBS);
		assertSame(Rank.ACE, card.getRank());
		assertSame(Suit.CLUBS, card.getSuit());
	}
	
	@Test
	void testGet_SuitOk() {
		assertSame(Suit.DIAMONDS, Card.get(Rank.ACE, Suit.DIAMONDS).getSuit());
	}
	
	@Test
	void testGet_RankOk() {
		assertSame(Rank.ACE, Card.get(Rank.ACE, Suit.DIAMONDS).getRank());
	}
}
