import java.util.LinkedList;

class Task {
    String Desc;
    Boolean Status;

    public Task(String Desc) {
        this.Desc = Desc;
        this.Status = false;
    }
}

class Node {
    Task T1;
    Node NextNode;

    public Node(Task T1) {
        this.T1 = T1;
        this.NextNode = null;

    }
}

class todo {
    Node head;

    public void additems(String desc) {
        Task T1 = new Task(desc);
        Node newNode = new Node(T1);

        if (head == null) {
            this.head = newNode;

        } else {
            newNode.NextNode = head;
            this.head = newNode;
        }
    }

    public void Statuschange(String descreption){
       Node current = head;
       while ((current!=null)){
        if(current.T1.Desc.equals(descreption)){
            current.T1.Status = true;
            break;
        }
        current = current.NextNode;
       }}
    

    public void remove(String descreption) {
        if (head == null) {
            return;
        }
        if (head.T1.Desc.equals(descreption)) {
            head = head.NextNode;
        }
        Node prev = null;
        Node current = head;

        while ((current != null)) {
            if (current.T1.Desc.equals(descreption)) {
                prev.NextNode = current.NextNode;
                break;

            }
            prev = current;
            current = current.NextNode;
        }

    }
    public void printTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(
                    "Task: " + current.T1.Desc + " | Status: " + (current.T1.Status ? "Completed" : "Not Completed"));
            current = current.NextNode;
        }
    }
}

public class todolist {
    public static void main(String[] args) {
        todo todoList = new todo();

        // Adding tasks
        todoList.additems("Buy groceries");
        todoList.additems("Finish homework");
        todoList.additems("Go for a run");

        // Changing task status
        todoList.Statuschange("Finish homework");

        // Removing a task
        todoList.remove("Buy groceries");

        // Print the tasks and their statuses
        todoList.printTasks();
    }

}
