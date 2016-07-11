# Date Converter
Date converter is a java library that converts the date in A.D. to B.S. and vice versa

#Usage
###Converting A.D to B.S
```java
Date date = new Date();                             //default java Date object
DateBS dateBS = DateConverter.convertADToBS(date);  //returns corresponding DateBS
```

###Converting B.S to A.D
```java
DateBS dateBS = new DateBS();                       //returns current date in B.S
Date date = DateConverter.convertBSToAD(dateBS);    //returns corresponding Date object
```

###Add days in DateBS
```java
DateBS newDateBS = CalendarBS.addXDays(dateBS, daysToAdd)
```