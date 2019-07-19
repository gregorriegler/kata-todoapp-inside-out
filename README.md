# TODO App Kata - for Inside Out TDD

This is a simple TodoApp Kata, but you are supposed to test-drive the application
from the inside out using chicago style TDD.

## Requirements

- return a list of tasks (DONE)
- create a new task (DONE)
- all features should be accessible via an http json api (infrastructure DONE)
- tasks should be persisted in-memory (infrastructure DONE)
- delete an existing task (DONE)
- make it possible to edit tasks (skipped, nothing new)
- make it possible to mark task as done (skipped, nothing new)

- register user with username
- create role "creator" whom should be the only one allowed to create tasks
- create role "doer" who should be the only one allowed to mark tasks as done
- add a simple login using with requestparam `?login=username`

### Further Requirements in case of getting bored

- add priorities to tasks (eg. high, medium, low)
- creator gets notified when a task was completed
- doer gets notified when a new task was created
- add 'sub-task' feature
- make the list of tasks persistent between subsequent runs. For the first iteration use a file.
- build a simple CLI
