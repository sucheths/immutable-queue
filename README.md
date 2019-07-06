**Immutable Queue Implementation**

- Implements interface Queue.
- Represented by class ImmutableQueue.
- Has a reverse() utility method that is used to reverse a stack. Runs in O(n) time.
- enQueue will add an element and returns a new queue, Runs in O(1) time.
- deQueue removes an element and returns a new queue, Runs in O(1) time worst case is 0(n).
- head() operation just returns the head of the forwards stack. Runs in O(1) time.
- returns true if the queue is empty, else returns false, runs at O(1) time

**Running test cases**

````
cd {project_dir}

./gradlew test
````