# Code Challenge #
Your challenge is to validate that a json file input is a valid Fizz Buzz file

```json
{"lines":["1","2","FIZZ","4","BUZZ", "FIZZ", "7", "8", "FIZZ", "BUZZ", "11", "FIZZ", "13","14", "FIZZBUZZ", "16"]}
```

A valid fizz buzz file has to comply to the following rules:

Every line contains a string that should be the array index (the index starts on **1**) unless the index is a multiple 
of **3**, then it should be the string **FIZZ**. If the index is a multiple of **5**, then the string should be **BUZZ**. Finally, if the index is both a multiple of **3** and **5**, then the string should be **FIZZBUZZ**


## Your solution ## 
Aim to solve it in one or two hours. A simple solution that covers the requirements is
as impressive as a complex one.

Focus on providing unit tests that test several aspects of your code
- A Valid input file
- An invalid input file
- Any other test you may think of (within reason)

Your code should compile and your unit tests should be able to run from the command line, ideally passing. 
This project comes with a gradle wrapper that you can use, but if you prefer other kind of building tools, feel free to 
use them.

I suggest you fork the repository and submit your solution to us. But you can also download the project and just send us
a zip of your project if you so desire.

