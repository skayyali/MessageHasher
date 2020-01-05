# MessageHasher
Demo project using Spring MVC &amp; Hibernate.


Provides 2 endpoints:
  1- '/message' POST mapping that adds a message, and calculated hash to DB. Returns digest.
  2- '/messages/{hash}' GET mapping that returns a message's digest from DB.
