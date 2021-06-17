# MSCalculator

## In Command Prompt:
1. ### Enable Assertions
Simply by adding `-ea` to `-enableassertions` as *vm argument* at run configurations as
```
C:\> java -enableassertions -jar MSCalculator.jar
```

2. ### Enable Unicode
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
