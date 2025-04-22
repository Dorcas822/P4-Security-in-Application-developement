# P4-Security-in-Application-developement
Semester Project 4

#Problem Formulation: How to efficiently secure password (accounts), yet maintain user memorability, privacy, and
full access account control

The idea behind the design of solution is to use honey password to maintain password and account security high. 
At the same time Hash the user credetials and use the first four hash values as a unique logging-in key which is generated partially by the user themselves. 
The algorithm's key elements are : 
  1)using honey password to redirect the attacker away from the user's account.
  2)Make a unique 4 character  hash code to log-in from user's hashed password to maintain memorability.

the product is a simple gui which has log-i & Sign-in buttons. The task is to be able to create a new account and log-in using the 4 digit hash code.
