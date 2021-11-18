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
To run the project an see the output, run the project as follows:
```
gradlew run
```
