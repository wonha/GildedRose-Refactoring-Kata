======================================
Gilded Rose Requirements Specification
======================================

Hi and welcome to team Gilded Rose. As you know, we are a [small inn](Inn) with a prime location in a
prominent city ran by a friendly innkeeper named [Allison](Owner). We also buy and sell only the [finest goods](Item).
Unfortunately, our goods are constantly degrading in [quality](Item.quality) as they approach their [sell by date](Item.sellIn). We
have a system in place that [updates](Inventory#updateQualities) our [inventory](Inventory.items) for us. It was developed by a no-nonsense type named
Leeroy, who has moved on to new adventures. Your task is to add the new feature to our system so that
we can [begin selling a new category of items](Inn#beginToSell). First an introduction to our system:

- All items have a SellIn value which denotes the number of days we have to sell the item
- All items have a Quality value which denotes how valuable the item is
- [At the end of each day](Trigger) our system [lowers both values for every item](Trigger#callUpdateQualities)

Pretty simple, right? Well this is where it gets interesting:

- Inventory#updateQualities
    - Once the sell by date has passed, Quality degrades twice as fast
    - The Quality of an item is never negative
    - "Aged Brie" actually increases in Quality the older it gets
    - The Quality of an item is never more than 50
    - "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    - "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
    Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
    Quality drops to 0 after the concert

We have recently signed a supplier of conjured items. This requires an update to our system:

- Inventory#updateQualities
    - ["Conjured"](Item.state) items degrade in Quality twice as fast as normal items

    - Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a
     legendary item and as such its Quality is 80 and it never alters.
     
Feel free to make any changes to the UpdateQuality method and add any new code as long as everything
still works correctly. However, __do not alter the Item class or Items property__ as those belong to the
goblin in the corner who will insta-rage and one-shot you as he doesn't believe in shared code
ownership (you can make the UpdateQuality method and Items property static if you like, we'll cover
for you).


# Solution
I will solve in following procedure
1. **Clarify requirement** and **model domain**
2. **Make test** cases with **big example**
3. **Design Algorithm**
4. Write Code
5. **Do test**

##  Clarify requirement and model domain
Domain Modeling : CRF
1. Component
2. Rule (Relationship)
3. Functionality (State)
## Make test cases with big example
## Design OO and Algorithm (imple)
OO Modeling : CRM
1. Class
2. Relationship
3. Method

Refactoring :
Make code paragraph with comments
Mark assignments which changes the state of program

## Write Code
## Do test
