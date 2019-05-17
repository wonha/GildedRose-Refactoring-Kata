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
    - [Once the sell by date has passed](Item.expirationState), Quality degrades twice as fast [](Domain Logic)
    - The Quality of an item is never negative [](validation)
    - ["Aged Brie"] actually increases in Quality [the older it gets](Domain Logic)
    - The Quality of an item is never more than 50 [](Domain Logic)
    - ["Sulfuras"], being a legendary item, [never has to be sold](Item.sellIn=-1 or 0) or [decreases in Quality](Domain Logic)
    - ["Backstage passes"], like aged brie, [increases in Quality as its SellIn value approaches;](Domain Logic)
    Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
    Quality drops to 0 [after the concert](Item.expirationState)

We have recently signed a supplier of conjured items. This requires an update to our system:

- Inventory#updateQualities
    - ["Conjured"](Item.confuredQualityFactor) items degrade in Quality twice as fast as normal items

    - Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a
     legendary item and as such its Quality is 80 and it never alters.
     
Feel free to make any changes to the UpdateQuality method and add any new code as long as everything
still works correctly. However, __do not alter the Item class or Items property__ as those belong to the
goblin in the corner who will insta-rage and one-shot you as he doesn't believe in shared code
ownership (you can make the UpdateQuality method and Items property static if you like, we'll cover
for you).

# Solution
I will solve in following procedure
1. **Clarify requirement**
    1. Who is going to use ? -> Inn
    1. How they are going to use ? -> Once per day, to update qualities of all the stock
1. **model domain**
    1. Component
        - -Inn-, -Owner-, Item, -Inventory-GiledRose, -Trigger-TestCode
    1. Relationship ()
        - GiledRose(1).Item(M), Unidirection
        - Item-sellIn, Item-quality
        - Item.State
    1. Functionality
        - Domain Logic VS Application Logic
        - GiledRose#updateQualities calls updateQuality on each item
        - GiledRose#beginToSell
1. **Make test** cases with **big example**
1. **Design Algorithm**
    1. Component
    1. Relationship
    1. Functionality
1. Write Code
1. **Do test**

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
end to end

Refactoring :
Make code paragraph with comments
Mark assignments which changes the state of program

## Write Code
## Do test
Common (Item class)
    scnario 1
    scnario 2
    ... (Prioritized)
NormalItem
    scnario 1
    scnario 2
    ... (Prioritized)
AgedBrie
    scnario 1
    scnario 2
    ... (Prioritized)
...



# Retrospective
1. Maybe we could you factory pattern instead of static factory method on Item class, with Dependency Inversion Pattern, concealing concrete Item classes
2. Or, if we can't touch the Item class at all, then we can make some ItemManager class compositing the Item class, and let ItemManager class contain all other attributes to handle the specific item