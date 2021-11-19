# ioetExercise-Solution

## Exercise

The company ACME offers their employees the flexibility to work the hours they want. But due to some external circumstances they need to know what employees have been at the office within the same time frame

The goal of this exercise is to output a table containing pairs of employees and how often they have coincided in the office.

**Input:** the name of an employee and the schedule they worked, indicating the time and hours. This should be a .txt file with at least five sets of data. You can include the data from our examples below:

### Example 1:

**INPUT**
```
RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00- 21:00
ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
ANDRES=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
```

**OUTPUT:**
```
ASTRID-RENE: 2
ASTRID-ANDRES: 3
RENE-ANDRES: 2
```

### Example 2:

**INPUT:**
```
RENE=MO10:15-12:00,TU10:00-12:00,TH013:00-13:15,SA14:00-18:00,SU20:00-21:00
ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
```

**OUTPUT:**
```
RENE-ASTRID: 3
```

## Cloning

Using HTTPS:
```
git clone https://github.com/rofarinango/ioetExercise-Solution.git
```

## Dependencies for Running Locally
* gradle >= 7.1
  * All OSes: [Click here for installation instructions](https://gradle.org/install/)
* Java JDK version 8 or higher
  * All OSes: [Click here for installation instructions](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)

## Compiling and Running

### Compiling
To compile the project, while in root directory:
```
gradlew build
```
```
gradlew test
```
To view summmary report of tests go to:
```
build/reports/tests/test/index.html
```
Open index.html on browser.

### Running
To run the project and see output, run the project as follows:
```
gradlew run
```

## Project Description and Overview of the solution

Our client ACME is a big company that would like to have a way to track schedules of their employees, particularly ACME needs a way to verify which employees have been at the office at the same time frame. The goal of this project is to provide a way to perform the tasks require by ACME and enable effective track of employees at ACME.

This will be a console application as our client stated that the solution shouldn't need any UI and this project will be split into a number of sprints that will be deliverable to our client in order to get feedback.

Development will be done with Java and we will follow a TDD (Test-Driven Development) methodology to proceed with the deliverables, we will write tests for the requirements in the specification before we proceed with the implementation.

## User Story

The user story will allow us to convey the requirements from natural language to a more technical representation after using UML Diagrams. The user stories for the cases that we found in the problem's description are the following:
 
 * As a COMPANY, I want to register an employee with their schedule, indicating the time and hours, so that I know  the schedule they worked.

 * As a COMPANY, I want to offer employees a schedule with flexibility to work the hours they want.
 
 * As a COMPANY, I want to know what EMPLOYEES have been at the office (work) within the same time frame, so that I can show how often they have coincided in the office.


With this user stories we can outline an early version of our system on the following UML Class diagram:

![UML Class Diagram - ioetExercise](https://user-images.githubusercontent.com/47066093/142556054-705b3538-6301-46f8-8546-333e10edc75b.png)

With this early version of the system we are applying the Single Responsibility Principle (SRP) which contributes to writing code that is easier to manage and maintain, SRP refers to a class should only do one thing and do that thing very well. Here we are apply SRP on our classes and our methods. How? The main class at first, had multiple responsabilities including:
 * Reading input
 * Parsing the input in a given format
 * Processing the result
 * Reporting the result

After we made the Parser class, the main class had no responsibility on parsing the input, delegating that to the Parser class, however we can do better and we will continue to improve our design on the following deliverables.


