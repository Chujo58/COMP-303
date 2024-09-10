# COMP 303 - Software Design
> Chloé Legué

---

Table of Contents
1. [Chapter 2](#u1)
    1. [Lecture 2 (2024-09-03)](#l2) 
    1. [Lecture 3 (2024-09-05)](#l3) 
    1. [Lecture 4 (2024-09-10)](#l4) 

## Chapter 2 <a name="u1"></a>
### Lecture 2 (2024-09-03) <a name="l2"></a>
Avoid primitive types if possible to avoid then issues down the line. (Also if a constructor isn't created, one is implicitly made for you.)

Instance method implies a parameter that the static class does not have. It can call on `this` object.

If nothing depends on the setter methods, removing it makes the class immutable in a sense. Immutable objects/classes are important to have (mostly for the security, avoids letting someone change important data). In the `Card` class example, the card ID is automatically set by the constructor, removing the need for a card ID setter. Another thing we can fix is to use a `Rank` and `Suit` instead of a card ID. Instead of using an int for `Suit` and `Rank`, we can make enumeration to hold our data.

An enumeration (`enum`) is a class with a private constructor (a class you cannot make objects out of) with constants inside of it. By default they extend the `Enum` class. The `Enum.ordinal() -> int` allows you to find the position of an item inside of an enumeration. `name()` is also a method we get from the `Enum` class which returns the name of the `enum`.

> Example for getting the next card, assuming the `Card` class has `Rank aRank` and `Suit aSuit` items:
```Java
public Card next(){
    // Increment the rank, if we go off the end of the ranks, increment the suit.
    Rank rank = Rank.values()[(aRank.ordinal()+1)%Rank.values().length];
    Suit suit = aSuit;
    if (rank == Rank.ACE) suit = Suit.values()[(aSuit.ordinal()+1)%Suit.values().length];

    return new Card(rank, suit);
}
```

It might be a better idea to code those two lines to increment into the `Rank` and `Suit` `enum` classes. You would replace `aRank` with `this`.

### Lecture 3 (2024-09-05) <a name="l3"></a>
Now we want to create a way to store all the 52 cards in a `"deck"` data structure. We could have an array of cards or a list or even a string containing all cards.

`assert` will throw errors depending on the condition following it.

### Lecture 4 (2024-09-10) <a name="l4"></a>
Now instead of simply making a reference to an existing object inside of the `Deck` class, we can make a new `ArrayList` to hold the cards as a private variable and copy the cards given to the constructor into it:
```Java
private ArrayList<Card> aCards = new ArrayList();

//Constructor:
public Deck(ArrayList<Card> pCards){
    aCards = new ArrayList<>(pCards);
}
```

If we wanted to make a deck without aces, we could make another constructor to the one we already have. But we want to avoid code repetition.
We can also use `Predicate` to avoid using interfaces for testing configuration for our decks. Especially in our case, there is a `removeIf` method in `ArrayList` letting us remove cards if they have a specific configuration. You can also `negate` the Predicate to avoid recoding stuff.
