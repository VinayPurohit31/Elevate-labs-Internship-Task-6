import java.awt.*;
import javax.swing.*;

public class SimpleToDoApp {

    public static void main(String[] args) {

       
        JFrame frame = new JFrame("Simple ToDo App");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

       
        JPanel inputPanel = new JPanel(new FlowLayout());
        JTextField taskField = new JTextField(20);
        JButton addButton = new JButton("Add");

        inputPanel.add(taskField);
        inputPanel.add(addButton);
        frame.add(inputPanel, BorderLayout.NORTH);

       
        JPanel taskListPanel = new JPanel();
        taskListPanel.setLayout(new BoxLayout(taskListPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(taskListPanel);
        frame.add(scrollPane, BorderLayout.CENTER);

       
        addButton.addActionListener(e -> {
            String taskText = taskField.getText().trim();
            if (!taskText.isEmpty()) {
                JCheckBox taskCheckBox = new JCheckBox(taskText);
                taskListPanel.add(taskCheckBox);
                taskField.setText("");
                taskListPanel.revalidate();
                taskListPanel.repaint();
            }
        });

  
        frame.setVisible(true);
    }
}
