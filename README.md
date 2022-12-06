# Data Structures  

## Description  

This library presents a collection of 9 data structures:  
ArrayList, LinkedList, TreeSet, HashMap, Queue, Deque, Stack,  
WeightedGraph and BinarySearchTree. All of them are simplified  
and include mostly basic methods.  

You can easily incorporate this into your project if you follow  
this sequence of steps:  
1. Clone and build the project with Maven
2. Compile jar and import it to your project.
3. You're great!

### Goal  

This is my study project. The main idea was in understanding the  
difference between data structures and in understanding use cases  
for each of them. Also, it was important to see how interfaces  
helps to abstract the concrete implementations. Project should be  
written with respective of OOD and SOLID principles.

### About each of the structures:  

#### Iterable  

This interface is one of the last, that I declared. But actually,  
it is the first step for big branch of collections. The main  
purpose of Iterable is to provide an 'iterating-through' feature.  
The Interface consist of one method - iterator. This is required  
to create a custom Iterator for classes, that inherit this  
interface.

#### Collection  

Collection is a bunch of objects. It is basic interface in  
collections hierarchy. Inherit Iterable. Collection not only  
collect the values, it allows you to search for a certain value  
in the collection.

#### List  

Inherit Collection. But if Collection is unordered, the List has  
a specific order. It means, that all elements in the List  
associate with certain positions. Because of this you can put or  
remove an element by integer index.

#### ArrayList  

ArrayList is an implementation of List. It's based on a primitive  
array. But one of main features is in increasing the size of the  
array, if it is almost full. Also important, that some operations  
in ArrayList, like: size, isEmpty, get, set, iterator and  
getCapacity; run in constant time.

#### LinkedList  

LinkedList is an implementation of List. It is Doubly-linked  
variant, that consists of nodes, and each node is connected to  
neighboring nodes. Indexing is counting inside the methods, and  
it is the reason why accessing the value by index is not as fast,  
as in ArrayList. The benefit of the LinkedList that it always  
requires only appropriate amount of memory. And unlike ArrayList,  
the data doesn't have to be stored at contiguous memory locations.  
This saves us from having to assign an initial size.

#### Set  

Inherit Collection. Unlike List, Set does not imply data ordering  
but collect only unique values.

#### TreeSet

TreeSet is an implementation of Set. TreeSet is based on the   
BinarySearchTree. It is a set of unique values sorted in a  
certain way.

#### Map  

Map is an associative array. You can consider Map like a table.  
It gets two arguments. First is a Key and second is a Value.  
You can put some Value in a table by a Key. And then get access  
to this Value by the Key.

#### HashMap  

This is an implementation of Map. The special quality of HashMap  
is the way it put Keys in the table. HashMap consists of Buckets,  
which are the cells of an array. And to calculate the Bucket  
index for Key placement, HashMap uses hash function. Now it has a  
capacity limit of 10 buckets. But it will be changed soon.

#### WeightedGraph  

WeightedGraph is set of verteces connected by edges. Each of edge  
has weight: a numeric value.

#### BinarySearchTree  

BST is a binary tree, that stores lesser values in the left  
children and stores larger in the right ones. Also, it is  
impossible to add not unique value.

## Methodology  

I decided to use Test Driven Development approach to organize  
the coding process. The main principe of TDD is in writing tests  
before implementing the methods. And I followed it.  

At first, I thought about the method. What kind of behavior do I  
expect from it? And then I tried to set all necessary conditions  
to test it.  

I paid attention to naming. The name of test should consist of: 
1. name of method which I test
2. condition which I use it
3. what behavior do I expect  

Example: Name_Condition_Behavior

There are three parts to the internal structure of a test. I use  
Gherkin syntax to define these modules. In the first part I make  
the preparations. For example, declare variables. In the middle  
part I call method, which I test. And in the final part I make an  
assertions. Sometimes, I merge calling and checking the results  
on the same line to shorten the test.  

I extracted some test regular constructs (like generating test  
models and helper logic) in separate methods to lower test  
complexity.  

## How to improve this project?

First of all, I want to reorganize the traversable package.  
I'm going to add traversable interface, complete tree and graph  
interfaces, make appropriate hierarchy.  

I'm going to add a few features in the near future. For details  
go to Issues for that project.  
