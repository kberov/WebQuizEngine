
# WebQuizEngine

A project which I made during my course on learning Java at
https://hyperskill.org.  Bellow are the steps which I completed. I will add
description of the task for each step completeion together with the code
changes I have made for the specific step. I did not save the state of the code
for the first step so only the description of the step will be in the first
commit.

<hr/>

## About

In the Internet, you can often find sites where you need to answer some
questions. It can be educational sites, sites with psychological tests, job
search services, or just entertaining sites like web quests. The common thing
for them is the ability to answer questions (or quizzes) and then see some
results. In this project, you will develop a multi-users web service for
creating and solving quizzes.

## Learning outcomes

You will clearly understand what is the backend development and how to use many
modern technologies together to get a great result. If you would like to
continue the project, you could develop a web or mobile client for this web
service. You will learn about REST API, an embedded database, security, and
other technologies.

## Work on project. Stage 1/6: Solving a simple quiz

### About

In the Internet, you can often find sites where you need to answer questions:
educational sites, sites with psychological tests, job search services, or just
entertaining sites like web quests. Something they all have in common is that
they permit to answer questions (or quizzes) and then see the results.

In this project, you will develop a multi-user web service for creating and
solving quizzes using REST API, an embedded database, security, and other
technologies. Here we will concentrate on the server side ("engine") without a
user interface at all. The project stages are described in terms of the
client-server model, where the client can be a browser, the curl tool, a REST
client (like postman) or something else.

During the development of the web service, you will probably have to do some
Google searching and additional reading. This is a normal situation, just read
a few articles when implementing stages.

After you complete this project, you will have a clear understanding of backend
development. You'll also know how to combine various modern technologies to get
a great result. If you continue the work on the project, you can also develop a
web/mobile client for this web service.

### Description

At the first stage, you need to develop a simple JSON API that always returns
the same quiz to be solved. The API should support only two operations: getting
the quiz and solving it by passing an answer. Each operation is described in
more detail below.

Once the stage is completed, you will have a working web service with an
comprehensive API.

To test your API, you may write Spring Boot tests, or use a rest client like
postman or the curl tool. GET requests can be tested by accessing the URL in
your browser. You can also check your application in the browser using reqbin.

### Get the quiz

The quiz has exactly three fields: title (string) text (string) and options
(array). To get the quiz, the client sends the GET request to /api/quiz. The
server should return the following JSON structure:

    {
      "title": "The Java Logo",
      "text": "What is depicted on the Java logo?",
      "options": ["Robot","Tea leaf","Cup of coffee","Bug"]
    }

In your API, the names of attributes must be exactly the same (title, text,
options), but you can assign any values to them. The quiz should contain four
items in the options array. The correct answer must be the third option, but
since the indexes start from zero, its index is 2.

There is no need to force your server to respond a JSON with line breaks and
additional spaces. This is used only to demonstrate the response in a
human-readable format. Actually, your server returns a long single-line JSON:
`{"title":"The Java Logo","text":"What is depicted on the Java
logo?","options":["Robot","Tea leaf","Cup of coffee","Bug"]}`.

### Solve the quiz

To solve the quiz, the client need to pass the answer parameter using the POST
request to /api/quiz with content as parameter answer and value. This parameter
is the index of a chosen option from options array. We suppose that in our
service indexes start from zero.

The server should return JSON with two fields: success (true or false) and
feedback (just a string). There are two possible responses from the server:

    If the passed answer is correct (POST to /api/quiz with content answer=2):

    {"success":true,"feedback":"Congratulations, you're right!"}

    If the answer is incorrect (e.g., POST to /api/quiz with content answer=1):

    {"success":false,"feedback":"Wrong answer! Please, try again."}

You can write any other strings in the feedback field, but the names of the
fields and the true/false values must match this example.


### 87 / 87 Prerequisites

Introduction to OOP, External resources, Units of information, Frameworks,
Immutability, Computer algorithms, Introducing the first algorithm, The big O
notation, Data structures, Fixed-size array, Dynamic array, World Wide Web,
HyperText Transfer Protocol, HTTP URL, HTTP messages, REST, JSON, Postman,
Introduction to Java, Basic literals, Overview of the basic program, Printing
data, Types and variables, Sizes and ranges, Type casting, Comments, Naming
variables, Scanning the input, Arithmetic operations, Integer types and
operations, Boolean and logical operations, Relational operators, Increment and
decrement, Characters, Conditional statement, Ternary operator, The for-loop,
The while and do-while loops, Branching statements, Switch statement, Calling a
method, Declaring a method, The main method, Overloading, Functional
decomposition, Primitive and reference types, Array, Iterating over arrays,
String, Final variables, IDE, IntelliJ IDEA, Introduction to Spring Boot,
Write, compile, and run, JVM, JRE, and JDK, Errors in programs, Defining
classes, Package, Constructor, Objects, Instance methods, Access modifiers,
Getters and setters, Static members, Annotations, Multiple constructors,
Inheritance, The keyword super, Hiding and overriding, Build tools, What is an
exception, NPE, Boxing and unboxing, Generic programming, What are collections,
ArrayList, Introduction to operating systems, Command line overview, Parameters
and options, Java Archive, Gradle basics, Basic project with Gradle, Building
apps using Gradle, Dependency management, Getting started with Spring Boot,
Basic project structure, Rest controller


