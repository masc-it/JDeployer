# JDeployer
Create JAR executable from .class files

# HOW TO USE
### PARAMS
* args[0]: Output JAR name
* args[1]: Main class name (obligatory) and other .class
* args[2]: Jar dependencies, if there


### EXECUTING
```
java -jar JDeployer.jar JARName.jar MainClassName.class,OtherClass.class,.. JARDependency1.jar,JARDependency2.jar,..
```

# TIPS
As about args[1], among specifing the main .class (I remember you that's compulsory), you can use '*.class' to include all the remaining .class files.