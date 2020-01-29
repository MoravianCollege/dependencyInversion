# dependencyInversion

## Overview

This repo contains an example of using polymorphism to invert the compile-time dependency to allow indepdendent deloyment of the core functionality of an app from a plug-in.

## The Big Application

Our goal is to allow the code that loads user options to be changed *without* having to recompile the overall application.  This would be useful when the overall application is large and takes a long time to build.

### Compile the Big Application

In the folder `app`:

* Compile the application by running `javac BigApp.java`
* Build a `jar` file for the application by running `jar -cvf BigApp.jar BigApp.class UserOptions.class`

Note that this jar file does not contain any implementation of the `UserOptions` interface.  It also does not contain a `main`.

In this example, compilation and making the jar will be fast, but in a real-life setting this build step could be *long* (hours, in extreme cases).

### Compile and Run Main with the Constant User Options

In the folder `constantMain`:

* Compile `Main` with `BigApp.jar` (this will also compile `ConstantUserOptions`) by running `javac -cp .:../app/BigApp.jar Main.java`
* Execute the application by running `java -cp .:../app/BigApp.jar Main`

This program runs successfully because `ConstantUserOptions` **IS-A** `UserOptions`.  Therefore, we have polymorphism in the constructor call in `main`:

```
ConstantUserOptions userOptions = new ConstantUserOptions();
BigApp app = new BigApp(userOptions);
```

### Compile and Run Main with the File User Options

NOTE: These steps are *exactly* the same as in the previous section!

In the folder `fileMain`:

* Compile `Main` with `BigApp.jar` (this will also compile `ConstantUserOptions`) by running `javac -cp .:../app/BigApp.jar Main.java`
* Execute the application by running `java -cp .:../app/BigApp.jar Main`

As with the previous example, in `main` we use polymorphism to pass an instance of `FileUserOptions` as the parameter to the constructor of `BigApp`.

## Discussion

This example demonstrates how a plugin (user options) can be changed *without re-compiling* the main application code.  It works because `UserOptions` defines the *interface* for reading options without providing and implementation.

Things to note:

* Compiling `BigApp` and making the `jar` file occured once.  If we wanted to change the format of the `options.txt` file, we would make the changes in `FileUserOptions.txt` and then recompile as in the previous section.  This change would *NOT* require us to recompile `BigApp`!  When the application is large, this can save a lot of time!
* `UserOptions.java` (the file that defines the interface) is present in both the application *and* the main program.  Changes to this interface would require recompilation of *both* the application and main - and so developers need to carefully define interfaces that create this type of plug-in structure.
* This design would also facilitate testing the application with various user options.  The folder `testing` contains `ParameterizedUserOptions.java`, which contains an implementation of `UserOptions` that could be used as follows:

   ```
   public void testApplicationWithEmptyUsername()
   {
      options = ParameterizedUserOptions("", "nano");
      BigApp app = new BigApp(options);
      
      // assert that behavior is correct
   }
   ```