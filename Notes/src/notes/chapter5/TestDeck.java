package notes.chapter5;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;

import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

public class TestDeck {

	private final Deck aDeck = new Deck();
	
	@Test
	void testIsEmpty_False() {
		assertFalse(aDeck.isEmpty());
	}
	
	
	@Test
	void testIsEmpty_True() {
		clearDeck();
		assertTrue(aDeck.isEmpty());		
	}
	
	// Helper methods
	private void clearDeck() {
		for (int i = 0; i < 52; i++) {
			aDeck.draw();
		}
	}
	
	private int size() {
		int sum = 0;
		Iterator<Card> it = aDeck.iterator();
		while (it.hasNext()) {
			sum++;
		}
		return sum;
	}
	
	private Card top() {
		return aDeck.iterator().next();
	}
	
	@Test
	void testDraw_Empty() {
		clearDeck();
		assertThrows(AssertionError.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				aDeck.draw();
			}
		});
	}
	
	@Test
	void testDraw_NotEmpty() {
//		int before = size();
//		Card card = aDeck.draw();
//		assertEquals(before-1, size());
//		assertNotNull(card);
		Card expected = top();
		Card actual = aDeck.draw();
		assertSame(expected, actual);
	}
}
