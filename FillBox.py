import time
import mouse


time.sleep(5)

print("Pos1")
x1, y1 = mouse.get_position()
time.sleep(2)
print("Pos2")
x2, y2 = mouse.get_position()
time.sleep(1)
for i in range(y1, y2):
    mouse.drag(x1, i, x2, i, absolute=True, duration=0.01)
    