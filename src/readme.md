# Concurrent Sequence
## Project Overview
This project is designed to explore the performance comparison between multi thread and 
single-threaded processing in the context of generating random genomes using Java. 
The main objective is to identify the break-even point where 
the benefits of multi-threading start to outweigh the overhead associated with managing multiple threads.

## Functions
- RNG: Leverages Java’s random features to generate random genomes and print out by iteration.
- main: Utilize system time to compare the performance of multithreading and single-threaded approaches.
- generateInMultipleThreads: Creates threads that runs the function and end when all threads are done.
- generate: Utilize overload to achieve default arguments.

## Getting Started
- Prerequisites: Ensure you have Java installed on your system. This is on JDK 17.
- Clone the Repository: Clone this repository to your local machine.
- Run the Application: Navigate to the root directory of the project in your terminal and run the Main class.

## Result
With Intel i7 8750H, 10 character per sequence:
### Total 100, each thread 20: 
- Single thread took 18 milliseconds
- Multi-threads took 16 milliseconds
### Total 1000, each thread 20:
- Single thread took 67 milliseconds
- Multi-threads took 77 milliseconds
### Total 1000, each thread 50:
- Single thread took 46 milliseconds
- Multi-threads took 50 milliseconds
### Total 1000, each thread 100:
- Single thread took 57 milliseconds
- Multi-threads took 24 milliseconds
### Total 1000, each thread 200:
- Single thread took 101 milliseconds
- Multi-threads took 24 milliseconds