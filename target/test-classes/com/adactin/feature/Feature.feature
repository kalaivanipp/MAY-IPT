Feature: Adactin Hotel Booking System

@smokeTest
Scenario: Login page
Given Open Chrome and launch Browser
When user enters username in text field
And user enters password in textfield
Then user can succeffully enter into Homepage

@RegressionTest
Scenario: Search Hotel
Given user selects Location
When user selects the Hotel
And user selects Room Type
And user selects NumofRooms
And user enters Checkin & Checkout Date
And user selects AdultsperRoom
And user selects ChildrenperRoom
And user clicks searchButton to serach Hotel
And user selects the Hotel
Then user clicks contiune to Book the Hotel

Scenario: Book A Hotel
Given user enters first name
When user enters last name
And user enters Billing Address
And user enters Credit Card No
And user selects Credit card Type
And user selects Expiry Date
And user Enters CVV Number
And user clicks Book Now Button and take screen shotof the Booked page
Then user clicks the Log Out Button








