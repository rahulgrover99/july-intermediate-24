## Backend LLD: OOP-4: Interfaces, Abstract Classes

### Recap
Wrapped up our discussion about 3 pillars of OOPs.
- Encapsulation
  - Classes and Objects
  - Access Modifiers
    - Public, Private, Protected, Default 
  - Constructors - copy, default, parametrized
  - Deep copy and shallow copy
- Inheritance
  - Diamond problem
  - `extends` keyword
  - Constructor chaining
  - `super` keyword
  - protected access modifier.
- Polymorphism
  - method overloading - compile time
    - method signature
  - method overriding - run time

### Agenda
- Interfaces
- Abstract Classes
- Static Keyword
- [Doubts] Problems in assignment and addn problems.

### Interfaces

-- A simple construct provided to clients

-- hiding internal implementation details


```java

class X {
    int a;
    int c;
    
    
    void fun() {
      System.out.println("Hello");
    }
}
// We have the function definitions
// We have the properties/attributes

```

Phonepe provides many banking services
UPI services.

Phonepe --> might be calling banks in the backend.
Send money via UPI.

@ybl

@okicic

Client side (App)

Backend side (App)

backend - bank( YesBank )

```java
class PhonePe{
    
//    PhonePe(YesBankApi api) {
//        this.api = api;
//    }

      PhonePe(ICICIBank api) {
        this.api = api;
        }
    
    
    void sendMoney(Account to, int amount) {
//        api.transferMoney(to, amount);
        api.sendMoneyToAccount(to.accountNumber, amount);
      }
    
    int checkBalance() {
//        api.getBalance();
      api.getAmountInSavings();
    }
    
}


```

What interface does?


- Simply provides the behaviours 
required to be implemented by a class
- Blueprint for a class

```java
interface Flyable {
    void fly();
}

class Bird implements Flyable {
    void fly() {
      System.out.println("Bird is flying");
    }
}

class Aeroplane implements Flyable {
    void fly() {
      System.out.println("Aeroplane flies.");
    }
}
```

The biggest benefit of using interfaces
is easy maintenance of codebases.

List<Integer> list = new ArrayList<>();

List is an interface.
ArrayList is an implementation.
Something that can be initialized.
Our classes always depend on the list, not
on the implementation of it.


Loose coupling v/s tight coupling




### Static keyword
- Static Methods
- Static variables.


Most common use case of having static variables is 
to store constant

```java
//static int PI = 3.14
```