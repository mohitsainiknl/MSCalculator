# MSCalculator
Give a :star: if you *like it!*<br>
<br>
![Screenshot of MSCalculator ](/res/.readme/MSCalculator1080p.png)

## Overview :
MSCalculator is a beginner-friendly java swing project, in which every *method* handle one particular task, every *class* handle one particular process and every package handle a part of this Calculator, besides this, every method, class and package has the [Documentation](https://github.com/mohitsainiknl/MSCalculator/blob/main/documentation/index.html%20-%20Shortcut.lnk) comment; which help me and other programmers to know the functionality.  All the calculation are done with help of the `BigInteger` and `BigDecimal` classes (So, there is no-any limit on the range of the integer or decimal). This calculator has `Theme.java` and `Style.java` *interface* which help to make any no. of themes and Styles for this project. The layout statements have reduced by using `GridBagPanel.java` and make the code simpler. There are *Assertions* (added with the help of `Assertion.java`) also in the code,

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
1. #### Enable Assertions
Simply by adding `-ea` to `-enableassertions` as *vm argument* at run configurations as
```
C:\> java -enableassertions -jar MSCalculator.jar
```

2. #### Enable Unicode
By default, the code-page using in the CMD of Windows is **437**. You can test by run this command in the prompt:

```
C:\>chcp
Active code page: 437
```
This code-page prevent you from showing Unicode characters properly! You have to change code page to **65001** AND using **-Dfile.encoding=UTF-8** for that purpose.
```
C:\>chcp 65001
Active code page: 65001
C:\>java -ea -jar -Dfile.encoding=UTF-8 path/to/your/runnable/jar
```
<br>




---
## Technical Details :

- **Full Setup Size :** 6 MB
- **Programming Language :** Java (JavaSE)
- **Interface :** Graphical User Interface
- **Framework Used :** AWT and Swing
- **Encoding Used :** UTF-8 (**'×'** is a Unicode Char.)
<br>
<br>



---
## System Requirements :

- **Operating System :** Any (Platform Independent)
- **JRE version :** 8.0 or higher
- **Development Environment :** VS Code, Eclipse, IntelliJ IDEA, etc
<br>
<br>

---
## Download : 
https://github.com/mohitsainiknl/MSCalculator/archive/refs/heads/main.zip
<br>
<br>


---
**"Suggestions and project Improvements are Invited!"** <br>
 Thanks a lot <br>
 Mohit Saini
