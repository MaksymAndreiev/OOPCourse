import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooserTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ColorChooserFrame();
            frame.setTitle("ColorChooserTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ColorChooserFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ColorChooserFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // add color chooser panel to frame

        ColorChooserPanel panel = new ColorChooserPanel();
        add(panel);
    }
}

class ColorChooserPanel extends JPanel {
    JButton modalButton;
    JButton modelessButton;
    JButton immediateButton;

    public ColorChooserPanel() {
        modalButton = new JButton("Modal");
        modalButton.addActionListener(new ModalListener());
        add(modalButton);

        modelessButton = new JButton("Modeless");
        modelessButton.addActionListener(new ModelessListener());
        add(modelessButton);

        immediateButton = new JButton("Immediate");
        immediateButton.addActionListener(new ImmediateListener());
        add(immediateButton);
    }

    private class ModalListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Color defaultColor = getBackground();
            Color selected = JColorChooser.showDialog(ColorChooserPanel.this, "Set background",
                    defaultColor);
            if (selected != null) {
                modalButton.setBackground(selected);
                modelessButton.setBackground(selected);
                immediateButton.setBackground(selected);
            }
        }
    }

    private class ModelessListener implements ActionListener {
        private JDialog dialog;
        private JColorChooser chooser;

        public ModelessListener() {
            chooser = new JColorChooser();
            dialog = JColorChooser.createDialog(ColorChooserPanel.this, "Background Color",
                    false /* not modal */, chooser,
                    event -> {
                        modalButton.setForeground(chooser.getColor());
                        modelessButton.setForeground(chooser.getColor());
                        immediateButton.setForeground(chooser.getColor());
                    },
                    null /* no Cancel button listener */);
        }

        public void actionPerformed(ActionEvent event) {
            chooser.setColor(modalButton.getForeground());
            chooser.setColor(modelessButton.getForeground());
            chooser.setColor(immediateButton.getForeground());
            dialog.setVisible(true);
        }
    }

    private class ImmediateListener implements ActionListener {
        private JDialog dialog;
        private JColorChooser chooser;

        public ImmediateListener() {
            chooser = new JColorChooser();
            chooser.getSelectionModel().addChangeListener(
                    event -> setBackground(chooser.getColor()));

            dialog = new JDialog((Frame) null, false /* not modal */);
            dialog.add(chooser);
            dialog.pack();
        }

        public void actionPerformed(ActionEvent event) {
            chooser.setColor(getBackground());
            dialog.setVisible(true);
        }
    }
}

