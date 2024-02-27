/* 
1. One of the main workhorse functions that makes multiprocessing possible is fork().
   fork() is a function in C/C++ that clones a process, spawning an identical copy. 
2. A process is an instance of a program. For example, when you open Spotify on your computer, 
   you’re launching a process that runs the Spotify program.
3. In the code below, "Hello, World!" gets printed twice.
   The sentence was first printed by child process, and then the parent process.
   reason: 
    - In the parent process, fork() return the process id (pid_t) of the child process.
    - In the child process, fork() returns 0.
    - Since both processes will reach the printf line, there are two outputs of Hello, World!, one from the parent process and one from the child.
4. waitpid(pid, NULL, 0)
    - is typically called in the parent process and allows a process to wait for the execution of a specific process to stop before continuing.
    - Since we’re in the parent process, pid is the process id of the child process. Therefore, we’re calling waitpid in order to wait on the child 
      process. waitpid will pause the execution of the parent child until the child process completes – in this case, print “Hello World!”
    - In this way, the execution of the parent and child process can be made to be deterministic. We can be guaranteed that the child process will print Hello, World! 
      before the parent process does, since the parent process is stalled until the child exits.
    - waitpid is commonly used to coordinate the execution of two processes by allowing a parent process to wait for its child process to change state (finish, stop, halt, etc.).
*/
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

int main(int argc, char **argv)
{
    // spawning a new process
    pid_t pid = fork ();
    // check if parent process
    if (pid != 0) {
        // wait for child process to stop
        waitpid (pid, NULL, 0);
    }
    printf ("Hello, World!\n");
}