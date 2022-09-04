# MSCalculator
Give a :star: if you *like it!*<br>
<br>
![Screenshot of MSCalculator ](/res/.readme/MSCalculator_home.png)

## Overview :
MSCalculator is a beginner-friendly java swing project, in which every *method* handle one particular task, every *class* handle one particular process and every package handle a part of this Calculator, besides this, every method, class and package has the documentation comment; which help me and other programmers to know the functionality.  All the calculation are done with help of the `BigInteger` and `BigDecimal` classes (So, there is no-any limit on the range of the integer or decimal). This calculator has `Theme.java` and `Style.java` *interface* which help to make any no. of themes and Styles for this project. The layout statements have reduced by using `GridBagPanel.java` and make the code simpler. There are *Assertions* (added with the help of `Assertion.java`) also in the code,

### Example
``` java
if(age <= 0) {
    Assertion.throwErrorMessage(new Throwable("Wrong age filled!"));
    return;
}
```

### Output
if the assertions are enabled.
```
Wrong age filled!
        at com.gmail.mohitsainiknl2.Project.agechecker(Project.java: 120)
```

which help in the debugging process.

### In Command Prompt:
- #### Enable Assertions
Simply by adding `-ea` to `-enableassertions` as *vm argument* at run configurations as
```
C:\> java -enableassertions -jar MSCalculator.jar
```
<br>




---
## Technical Details :

- **Full Setup Size :** 1.62 MB
- **Programming Language :** Java (JavaSE)
- **Framework Used :** AWT and Swing
- **Encoding Used :** UTF-8
<br>
<br>



---
## System Requirements :

- **Operating System :** Any (Platform Independent)
- **JRE version :** 1.8.0 or higher
- **Development Environment :** VS Code, Eclipse, IntelliJ IDEA
<br>
<br>

---
## Downloads : 
#### 1. Entire Repository
https://github.com/mohitsainiknl/MSCalculator/archive/refs/heads/master.zip <br>
#### 2. JAR File (Executable)
https://github.com/mohitsainiknl/MSCalculator/blob/master/publish/MSCalculator.jar <br>
#### 3. .exe File for Windows (not independent, require JRE to run)
https://github.com/mohitsainiknl/MSCalculator/blob/master/publish/MSCalculator.exe
<br>
<br>


---
**"Suggestions and project Improvements are Invited!"** <br>
 Thanks a lot <br>
 Mohit Saini
