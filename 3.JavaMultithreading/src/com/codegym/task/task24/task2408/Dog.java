package com.codegym.task.task24.task2408;

import java.util.Collections;
import java.util.Date;

/*
At times, you'll have to cast a class to some other class (not an interface). :)
The DogPet class uses 2 classes: SuperDog and Dog. Study the getName method in the DogPet class.
That'll be a lot easier than Copy+Paste!
 */
public class Dog implements Pet {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    /**
     * Suppose we have an existing A class (SuperDog) whose logic you want to use.
     * Three options are possible:
     * 1) copy the logic from class A (this is bad, because creating multiple copies of the same code is problematic)
     * 2) Create an instance of the A class inside our class and use it. This is a has-a relationship (not always suitable, since class A is independent).
     * 3) Create an inner class that inherits A. Use its methods together with
     * the methods and fields of our class, since as a descendent the inner class has access to its parent
     * and to all fields and methods, including the private fields and methods of the outer class.
     * <p/>
     * Let's take a look at Item 3:
     * In the toCanSpeak method, create a DogPet class that inherits SuperDog and implements the CanSpeak interface
     * Create the private String getName() method, which will use the logic of the two classes (Dog and SuperDog).
     * Let this method return the dog's name (Dog class), which is set off on both sides using getSuperQuotes (SuperDog class)
     * For example, " *** Barbossa *** "
     * The method's logic is this:
     * If i < 1, then use the getName method to display a message indicating that the dog is sleeping. For example, " *** Spot ***  is sleeping."'
     * Otherwise, display: "<dog name> says ruuuff! <today's date>". For example, for i=3: " *** Puppy ***  says ruuuff! Wed, 13-Nov-2013"
     * Use the SuperDog class's formatter to format the date.
     * <p/>
     * <b>Example output:</b>
     *  *** Barbossa ***  says ruuuuuff! Wed, 13-Nov-2013
     *  *** Puppy ***  says ruuff! Wed, 13-Nov-2013
     *  *** Rover ***  says ruuuff! Wed, 13-Nov-2013
     * The mouse squeaks.
     *  *** Spot ***  is sleeping.
     *
     * @param i the number of u's to use in "ruff"
     * @return an instance of the DogPet class
     */
    public CanSpeak toCanSpeak(final int i) {
        class DogPet extends SuperDog implements CanSpeak {
            @Override
            public String speak() {
                StringBuilder sb = new StringBuilder(getName());
                if (i < 1) sb.append(" is sleeping.");
                if (i > 0) sb.append(" says r").append(String.join("", Collections.nCopies(i, "u")))
                        .append("ff! ").append(formatter.format(new Date()));

                return sb.toString();
            }

            private String getName() {
                return getSuperQuotes() + name + getSuperQuotes();
            }
        }

        return new DogPet();
    }
}
