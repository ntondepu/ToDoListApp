import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoGUI {
    private JFrame frame;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private ArrayList<Task> tasks;

    public ToDoGUI() {
        tasks = new ArrayList<>();
        frame = new JFrame("To-Do List");
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);

        // Layout
        frame.setLayout(new BorderLayout());

        // Task Input Panel
        JPanel inputPanel = new JPanel();
        JTextField taskField = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        inputPanel.add(taskField);
        inputPanel.add(addButton);

        // Task List Panel
        JScrollPane taskScrollPane = new JScrollPane(taskList);

        // Action Buttons Panel
        JPanel actionPanel = new JPanel();
        JButton completeButton = new JButton("Mark Complete");
        JButton removeButton = new JButton("Remove Task");
        actionPanel.add(completeButton);
        actionPanel.add(removeButton);

        // Add Panels to Frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(taskScrollPane, BorderLayout.CENTER);
        frame.add(actionPanel, BorderLayout.SOUTH);

        // Add Task Action
        addButton.addActionListener(e -> {
            String description = taskField.getText().trim();
            if (!description.isEmpty()) {
                Task task = new Task(description);
                tasks.add(task);
                taskListModel.addElement(task.toString());
                taskField.setText("");
            }
        });

        // Mark Complete Action
        completeButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                Task selectedTask = tasks.get(selectedIndex);
                selectedTask.setCompleted(true);
                taskListModel.set(selectedIndex, selectedTask.toString());
            }
        });

        // Remove Task Action
        removeButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                tasks.remove(selectedIndex);
                taskListModel.remove(selectedIndex);
            }
        });

        // Frame Settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoGUI::new);
    }
}
