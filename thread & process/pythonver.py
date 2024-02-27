import threading
import queue

import asyncio

q = queue.Queue()

def test():
    while True:
        item = q.get()
        print(f'Working on {item}')
        print(f'Finished {item}')
        q.task_done()

# activate test thread.
threading.Thread(target=test, daemon=True).start()

# send test requests
for item in range(10):
    q.put(item)

q.join()
print('task completed')
