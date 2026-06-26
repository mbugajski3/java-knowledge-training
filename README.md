# GameStore CLI

GameStore CLI is a small Java console application created as a skills-check project during my progress through the University of Helsinki Java Programming MOOC.

The goal of this project is to practice object-oriented programming concepts by building a simple command-line program that allows the user to add games to a list, validate input data, prevent duplicate entries, and calculate the total value of the game collection.

## Features

* Add games through console input
* Store games in an `ArrayList`
* Prevent duplicate games based on game identifier
* Validate release date format
* Validate price format
* Display all added games
* Calculate total inventory value

## Practiced concepts

This project was created to reinforce the following Java concepts:

* Classes and objects
* Constructors
* Object variables
* Objects as method parameters
* Objects as return values
* `ArrayList`
* `Scanner`
* `toString()`
* `equals(Object compared)`
* `@Override`
* Input validation
* Immutable objects
* Basic CLI program structure

## Project structure

The project consists of the following classes:

### `GameStore`

Main class of the application.
Handles user input, creates game objects, stores them in a list, prevents duplicates, and prints the final summary.

### `Game`

Represents a game object.
Each game has an identifier, title, release date, and price.

Games are considered equal if they have the same identifier.

### `SimpleDate`

Represents a simplified date.
Each month is assumed to have exactly 30 days.

The class supports:

* date formatting
* equality comparison
* creating a new date advanced by a given number of days

### `Money`

Represents money using euros and cents instead of `double`.

The class is immutable, which means that money objects are not modified after creation. Operations such as addition and subtraction return new `Money` objects.

## Example usage

```text
Enter game identifier:
GTA5
Enter game title:
Grand Theft Auto V
Enter release date (day.month.year)
17.9.2013
Enter game price:
29.99

Enter game identifier:
W3
Enter game title:
The Witcher 3
Enter release date (day.month.year)
19.5.2015
Enter game price:
39.99

Enter game identifier:
GTA5
Enter game title:
GTA Five Duplicate
Enter release date (day.month.year)
1.1.2020
Enter game price:
10.00
The game is already on the list. Try again.

Enter game identifier:

=== GAMES LIST ===
GTA5: Grand Theft Auto V, released 17.9.2013, price 29.99 euro
W3: The Witcher 3, released 19.5.2015, price 39.99 euro

Total games in list: 2
Total inventory value: 69.98 euro
```

## Input format

### Date

The release date must be entered in the following format:

```text
day.month.year
```

Example:

```text
24.03.2017
```

The program assumes that every month has 30 days.

### Price

The price must be entered in the following format:

```text
euros.cents
```

Example:

```text
19.99
```

## Purpose

This project is not a production-ready application.
It was created as a learning project to check and reinforce my understanding of Java basics and object-oriented programming while working through the MOOC Java Programming course.
