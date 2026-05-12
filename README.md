# online-bookstore-backend-app
A Java Spring Boot backend for an online bookstore, featuring RESTful APIs for managing inventory of books and the purchase process.

# Overview
Assess object oriented analysis and modelling skills, Java coding skills, code structuring
and API design. Take your time on the task, but don't go too crazy. If you submit a
solution that is in any way incomplete, the parts that you decided to focus on are relevant.
Keeping the objective in mind, you are free to use whatever tools, libraries, frameworks at
your disposal.
Please include a README in any format about decisions you made along the way, what
you focused on, what you didn't focus on and why, as well as how to run and use the
program.

# The Problem - Online bookstore
For an online bookstore we want to create a system for managing the inventory and purchase
process. We want three primary functions.
1. Inventory of books
2. Purchase and book pricing
3. Keeping track of customer loyalty points

## Pricing
The price of the books is is their base price, with final purchasing price is modified according to:
1. Book type
2. Purchase size
3. Loyalty points

THE BOOKS ARE GROUPED IN THREE TYPES:
New Releases - Price is always 100% of the price.
Regular Price is 100% of the price, but can be deducted by 10% if bought in a bundle of 3
books and more.
Old editions - Price is discounted by 20%, can be additionally deducted by 5% if bought in a
bundle of 3 books and more.

LOYALTY POINTS
1 loyalty point is awarded on every purchased book. When 10 loyalty points are accumulated the
customer can get one regular or old edition book for free. Once the discount has been applied the
loyalty points go back to 0.

The program should expose a REST-ish HTTP API. The API should (at least) expose operations for:
- Returning the books available for purchase.
- Buying one or several books and calculating the price.
- Returning the loyalty points for a customer
