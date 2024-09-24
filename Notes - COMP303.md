# COMP 303 - Software Design
> Chloé Legué

---

Table of Contents
1. [Chapter 2](#u1)
    1. [Lecture 2 (2024-09-03)](#l2) 
    1. [Lecture 3 (2024-09-05)](#l3) 
2. [Chapter 3](#u2)
    1. [Lecture 4 (2024-09-10)](#l4) 
    1. [Lecture 5 (2024-09-12)](#l5) 
    1. [Lecture 6 (2024-09-17)](#l6) 
3. [Chapter 4](#u4)
    1. [Lecture 7 (2024-09-19)](#l7)
    2. [Lecture 8 (2024-09-24)](#l8)

## Chapter 2 - Encapsulation<a name="u1"></a>
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

## Chapter 3 - Types and Interfaces
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

### Lecture 5 (2024-09-12) <a name="l5"></a>
#### JetUML
Instead of giving the attributes inside of the Class item in JetUML, we can make another box with the classes of those attributes and aggregate them to the Class item requiring them. On those arrows, you can have start, middle and end labels, the middle label is usually where we will place the variable name of the attributes and the end label will mention how many objects are required.

Using french quotes, you can also mention the type of class you are making, whether it is an interface, or an enumeration.

Not keeping track of the object (basically a pointer in a sense) but using its methods is a dependency. Whereas an aggregation implies that we keep track of the object.

### Lecture 6 (2024-09-17) <a name="l6"></a>
Today we want to sort our deck of cards in a specific order. We can use the `Collections.sort` method. Let's provide the `Card` class with a natural ordering. We can implement the `Comparable` interface which requires the `compareTo` method. The number returned by the `compareTo` method is useless, and only the polarity is used. Now how do we return the highest card in the deck? We grab the first card of the deck.

We might want to access all the elements, but using a `List` might be too big of an interface to use. Using an `Iterator` is a smaller point of contact to just get the current card and see if there is a next one.

To get our highest card, instead of a `for` loop checking with the `compareTo` method to see which card at every index is the highest, we need a `while` loop checking if there is a next card.
```Java
public static Card highestCard(Iterator<Card> pIterator){
    assert pIterator.hasNext();
    Card result = pIterator.next();
    
    while (pIterator.hasNext()){
        Card card = pIterator.next();
        if (card.compareTo(result) > 0){
            result = card;
        }
    }
    return result;
}
```

Instead of using `pIterator.next()` for the first result, we could make a method in the `Card` class to make the `lowest` card of the deck using `Rank.values()[0]` and `Suit.values()[0]`. This is hard coding the lowest card, based on the order of the enumerations `Rank` and `Suit`. The problem right now is that the `Iterator` works on `Card` instead of being on the deck itself. We can make a public method in the `Deck` class to return an `iterator` from the `ArrayList`.

The next problem we run into, we can't go around twice. We want an object that can supply iterators. An `Iterable`! You can get multiple iterators from the `Iterable`.
```Java
public static Card highestCard(Iterable<Card> pCards){
    Card result = Card.lowest();
    for (Card card : pCards){
        if (card.compareTo(result) > 0) result = card;
    }
    return result;
}
```

## Chapter 4 - Object State <a name="u4"></a>
### Lecture 7 (2024-09-19) <a name="l7"></a>
How to check if two objects are the same (unique or not)? Use the debugger and check the `id`. You could also use `==`. 

For `String`, creating a string with `String a = "test";` and then making another `String b = "test";` will point to the same object, but creating a `new String("test");` will not point to the same object, which is reassuring because the constructor should give a new object. `.substring` will also create a new object.

What about `Integer` are they unique? No matter how we create it, the `Integer` is not unique. (`valueOf`, `parseInt`, even subtraction). Once again you should never use `==` to compare `Integer`.

What about `Card`? Using `==` will not work.

#### `toString` method
#### `equals` method
Let's implement it for `Card`:
```Java
@Override
public boolean equals(Object pObject){ //Changing `Object` to `Card` is not a good fix.
    if (pObject == null) return false;
    if (pObject == this) return true;
    if (getClass() != pObject.getClass()) return false;
    //At this point we know that pObject is of class `Card`
    Card other = (Card) pObject;
    return aSuit == other.aSuit && aRank == other.aRank;
}
```

Now we have a way of checking if two `Card` objects are equal to one another.

#### `hashCode` method
It's there to be used for hastables. It's to have a number for an Object. You don't want all your objects to hash to the same code. If two objects are equals, they should have the same hashcode. 

If we don't have the hashcode implemented properly, then a hashset might have duplicate elements. Trying it with the current card class will let two ace of clubs inside the set, when both objects are equal.

```Java
@Override
public int hashCode(){
    return Objects.hash(aRank, aSuit); //This is the cheap trick
    return aSuit.ordinal() * 13 + aRank.ordinal(); //This will give a number between 0 and 51 which is great.
}
```

Now the hashset should work just fine and not have duplicate objects.

#### Flyweight Design Pattern
Part of the code manages how we create the objects. The first thing we need to do is to turn off the ability of the `Client` to create object. Basically making the constructor `private`. The alternative, a `static` factory!

```Java
//We have a private constructor
private Card(Rank pRank, Suit pSuit){
    aRank = pRank;
    aSuit = pSuit;
}

public static Card get(Rank pRank, Suit pSuit){
    return new Card(pRank, pSuit); //This doesn't do much for now.
}
```
Basically we want to create a new object if it doesn't exist. Else we return the existing object. 

```Java
public class Card implements Comparable<Card>{
    private static Map<Rank, Map<Suit, Card>> aCards = new HashMap<>(); //A double map

    private Rank aRank; 
    private Suit aSuit;

    private Card(Rank pRank, Suit pSuit){
        aRank = pRank;
        aSuit = pSuit;
    }

    public static Card get(Rank pRank, Suit pSuit){
        //Lazy implementation check if object exists, if not add to the double map.
        Map<Suit, Card> inner = aCards.get(pRank);
        if (inner == null) aCards.put(pRank, new HashMap<>());
        Card card = aCards.get(pRank).get(pSuit);
        if (card == null) inner.put(pSuit, new Card(pRank, pSuit));
        return inner.get(pSuit);

        //Eager implementation creates all 52 objects and returns them when needed.
    }
}
```

### Lecture 8 (2024-09-24) <a name="l8"></a>
Mutability and uniqueness are not the same concept. 

What is an abstract state space? It's a subdivision of the state space. What would be a state space for the class `Deck`? An empty deck, there is only one. Another would be a full deck with 52 cards with some math formula for the total number of arrangments.

#### State diagrams
Life cycle of a butterfly? We can apply the same idea for an object. It goes from newly created, to in use, to empty and when we stop refering to it, it gets garbage-collected.

What we can do is a UML state diagram. What's important to show are the `triggers` that show how an object transitions from one state to another. You can also add what triggers (the guard) the transition and its effects.

First thing to do if you design a state diagram is to find the triggers. You can copy the methods in a note to show potential triggers. You also need an inital state and `New` state. If the methods do not change the state of the object, then you do not need to show it. You also remove private methods.

For the `Deck` the only method that changes the object is the `draw()` method. It can return an `Incomplete` deck. To make sure the `Deck` is complete,  you can change `New` to `Complete`. Drawing more cards from the incomplete deck means we add an arrow going from `Incomplete` back to `Incomplete`. If the card in `Incomplete` is 1, then we go to `Empty`. The guard for such a trigger is `draw() [size()==1]`. For the other trigger from `Incomplete` to itself, we can add `[size()!=1]` as a guard. Then we had a final state.

What if we make `shuffle` a public method? We add a self-loop for each state with the method `shuffle()`. Do we need to have a `shuffle()` self-loop for `Empty Deck`. There is a mistake though, `shuffle()` fills up a deck, so using `shuffle()` instead of a self-loop, we go back to a `Complete` deck. One good thing about making the `shuffle()` method public is that we can reuse the `Empty` deck. Maybe `Empty` is not really the final state?

What about making an `initialize()` method to create the deck with all cards and let `shuffle()` simply shuffle.

We can aslo remove the `Complete` deck and call it `Not Empty` having 2 states instead of 3, meaning the only transition is `draw() [size() > 1]` to `Empty` and `suffle()` from `Empty` to `Not Empty`
![JetUML State Design for `Deck` class](image.png)
> JetUML State Design for `Deck` class

#### Interfaces again
You can extract an Interface using refactoring. Now making `draw()` and `isEmpty()` methods of an interface `CardSource`, `Deck` implements `CardSource`. You could also merge the two interfaces `CardSource` and `Iterable<Card>` by making `CardSource` extend `Iterable<Card>`.

![JetUML State Design for `Deck` and `MultiDeck`](image-1.png)

```Java
public class MultiDeck implements CardSource{
    private final List<Deck> aDecks = new ArrayList<>();//Final means we never change this specific List.

    public MultiDeck(Deck... pDeck){ //External input using var args.
        aDecks.addAll(Arrays.asList(pDecks));
    }

    @Override
    public Iterator<Card> iterator(){

    }
    
    @Override
    public Card draw(){

    }

    @Override
    public boolean isEmpty(){

    }
}
```