Instrucrions:

Step 1: Shopping Cart

On this step CheckoutApp class with checkout() method were created.
To run it, you should provide names of selling items as a list of strings.
And it would return result price as BigDecimal.

Step 2: Simple OffersTo make it work next improvements were made in a code:

  -- Item class was added, which represents seperate selling item with its name and price
  
  -- ItemStorage class was added, which store all available items in the Store
  
  -- Offer interface was added
  
  -- NforMOffer class was added, which represemts specific offer of type NforM(e.g. 3 for 2);

  To run this app in this case you need to provide to checkout() method names of selling items as a list of strings, and Map<String, Offer>,
  where Key is a name of item  and Value is an Offer for this item.
  This method would return result price after applying all Offers as BigDecimal.
