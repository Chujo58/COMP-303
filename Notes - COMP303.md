# COMP 303 - Software Design
> Chloé Legué

---

Table of Contents
1. [Chapter 2](#u1)
    1. [Lecture 2 (2024-09-03)](#l2) 

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
