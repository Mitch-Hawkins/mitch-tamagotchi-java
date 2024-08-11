# Changelog

## 12/08/24

This document summarizes the steps taken to implement a clickable rectangle in a Java GUI, including different approaches and key learning points.

### 1. Initial Setup

#### 1.1 Creating the GUI Class

We began by creating a GUI class that extends JPanel and implements Runnable to manage drawing and updating the GUI.
A JFrame was created in the constructor, which added the JPanel and set basic properties like size and visibility.

```java
public class GUI extends JPanel implements Runnable {
    JFrame frame;
    public GUI() {
        frame = new JFrame();
        this.setBackground(Color.BLACK);
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
```

#### 1.2 Drawing a Rectangle

A rectangle was added to the paintComponent method of the JPanel.
The rectangle was drawn using the Graphics2D object.

```java
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(Color.blue);
    g2.fillRect(100, 100, 100, 100);
    g2.dispose();
}
```

### 2. Adding Interactivity: Handling Mouse Clicks

#### 2.1 Implementing MouseListener

To detect mouse clicks, we implemented a MouseListener by creating a MouseHandler class that implements the MouseListener interface.
The mouseClicked method was overridden to detect clicks and perform actions based on the coordinates of the click.

```java
public class MouseHandler implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
    int mouseX = e.getX();
    int mouseY = e.getY();
    System.out.println("Mouse clicked at: " + mouseX + ", " + mouseY);
    }
}
```

#### 2.2 Adding the MouseHandler to GUI

The MouseHandler was instantiated and added to the JPanel in the GUI constructor.

```java
MouseHandler mouseHandler = new MouseHandler(this);
this.addMouseListener(mouseHandler);
```

### 3. Detecting Clicks on the Rectangle

#### 3.1 Storing Rectangle Coordinates

We defined a Rectangle class to store the properties of the rectangle (position and size) and added it to the GUI class.
The rectangle's position and size were set in the paintComponent method.

```java
Rectangle rect = new Rectangle(100, 100, 100, 100);
```

#### 3.2 Checking if a Click is Inside the Rectangle

The MouseHandler was updated to check if the mouse click was within the bounds of the rectangle using a contains method.

```java
public class Rectangle {
    private int x, y, width, height;
    public boolean contains(int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
    }
}
```

In the 'mouseClicked' method, we retrieved the rectangle from the GUI class and checked if the click was inside it.

```java
if (rect.contains(mouseX, mouseY)) {
    System.out.println("Rectangle clicked!");
}
```

### 4. Scaling Up: Handling Multiple Clickable Objects

#### 4.1 Using a Clickable Interface

We introduced a Clickable interface with methods contains and onClick, allowing different shapes to implement their own click logic.

```java
public interface Clickable {
    boolean contains(int x, int y);
    void onClick();
}
```

#### 4.2 Implementing the Interface for Different Shapes

We implemented the Clickable interface for both Rectangle and Circle classes, allowing each to define its own logic for detecting clicks.

```java
public class Rectangle implements Clickable {
// Contains method and onClick implementation
}

public class Circle implements Clickable {
// Contains method and onClick implementation
}
```

#### 4.3 Managing Multiple Clickable Objects

We maintained a list of Clickable objects in the GUI class.
During each mouse click event, we iterated through the list to check which object was clicked and triggered the respective onClick method.

```java
List<Clickable> clickables = new ArrayList<>();
clickables.add(new Rectangle(100, 100, 100, 100));
clickables.add(new Circle(300, 300, 50));

for (Clickable clickable : clickables) {
    if (clickable.contains(mouseX, mouseY)) {
        clickable.onClick();
        break;
    }
}
```

### 5. Final Implementation

In the final implementation, we combined all the elements:

Scalable Design: We used an interface to define common behavior, allowing easy addition of new shapes and behaviors.
Interactivity: We implemented robust mouse event handling to detect clicks and trigger specific actions.
Encapsulation: Each shape's click logic was encapsulated within its own class, promoting maintainability and clarity.
