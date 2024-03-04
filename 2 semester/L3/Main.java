import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.add(new LabPanel());
            frame.pack();
            frame.setTitle("Lab work 3");
            frame.setResizable(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class LabPanel extends JPanel {
    JPanel panelNorth;
    JPanel panelSouth;
    JPanel panelWest;
    JPanel panelEast;

    JLabel label;
    ImageComponent image;

    JButton gm;
    JButton gd;
    JButton ge;
    JButton gn;

    JCheckBox color1;
    JCheckBox color2;
    JCheckBox color3;

    Color c_morning = new Color(255, 223, 185);
    Color c_day = new Color(199, 210, 206);
    Color c_evening = new Color(242, 190, 194);
    Color c_night = new Color(185, 209, 221);

    JRadioButton button1;
    JRadioButton button2;
    JRadioButton button3;
    JRadioButton button4;
    ButtonGroup buttonGroup;

    public LabPanel() {
        setLayout(new BorderLayout());

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setPreferredSize(new Dimension(screenWidth / 2, screenHeight / 2));

        setBackground(c_morning);

        panelNorth = new JPanel();
        panelNorth.setBackground(c_morning);
        panelSouth = new JPanel();
        panelSouth.setBackground(c_morning);
        panelWest = new JPanel();
        panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.PAGE_AXIS));
        panelWest.setBackground(c_morning);
        panelEast = new JPanel();
        panelEast.setLayout(new BoxLayout(panelEast, BoxLayout.PAGE_AXIS));
        panelEast.setBackground(c_morning);


        label = new JLabel("Вітаю!");
        label.setFont(new Font("beer money", 0, 48));
        panelNorth.add(label);
        add(panelNorth, BorderLayout.NORTH);

        gm = new JButton("Доброго ранку", null);
        gd = new JButton("Доброго дня", null);
        ge = new JButton("Доброго вечора", null);
        gn = new JButton("Доброї ночі", null);

        gm.addActionListener(new ButtonAction("1.png"));
        gd.addActionListener(new ButtonAction("2.png"));
        ge.addActionListener(new ButtonAction("3.png"));
        gn.addActionListener(new ButtonAction("4.png"));

        panelSouth.add(gm);
        panelSouth.add(gd);
        panelSouth.add(ge);
        panelSouth.add(gn);

        add(panelSouth, BorderLayout.SOUTH);

        color1 = new JCheckBox("Color 1");
        color2 = new JCheckBox("Color 2");
        color3 = new JCheckBox("Color 3");

        color1.setBackground(c_morning);
        color2.setBackground(c_morning);
        color3.setBackground(c_morning);

        color1.addActionListener(new CheckBoxAction());
        color2.addActionListener(new CheckBoxAction());
        color3.addActionListener(new CheckBoxAction());

        panelWest.add(color1);
        panelWest.add(color2);
        panelWest.add(color3);

        add(panelWest, BorderLayout.WEST);

        button1 = new JRadioButton("Color 1");
        button2 = new JRadioButton("Color 2");
        button3 = new JRadioButton("Color 3");
        button4 = new JRadioButton("Color 4");

        button1.setBackground(c_morning);
        button2.setBackground(c_morning);
        button3.setBackground(c_morning);
        button4.setBackground(c_morning);

        button1.addActionListener(new RadioButtonAction(c_morning));
        button2.addActionListener(new RadioButtonAction(c_day));
        button3.addActionListener(new RadioButtonAction(c_evening));
        button4.addActionListener(new RadioButtonAction(c_night));

        buttonGroup = new ButtonGroup();

        buttonGroup.add(button1);
        buttonGroup.add(button2);
        buttonGroup.add(button3);
        buttonGroup.add(button4);

        panelEast.add(button1);
        panelEast.add(button2);
        panelEast.add(button3);
        panelEast.add(button4);

        add(panelEast, BorderLayout.EAST);

        image = new ImageComponent("1.png");
        add(image, BorderLayout.CENTER);

    }

    class ImageComponent extends JComponent {
        private Image image;

        public ImageComponent(String path) {
            image = new ImageIcon(path).getImage();
        }

        public void setImage(String path) {
            this.image = new ImageIcon(path).getImage();
            repaint();
        }

        public void paintComponent(Graphics g) {
            g.drawImage(image, (getWidth() - image.getWidth(null)) / 2, (getHeight() - image.getHeight(null)) / 2, null);
        }
    }

    private class ButtonAction implements ActionListener {
        String path;

        ButtonAction(String path) {
            this.path = path;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            label.setText(button.getText() + "!");
            image.setImage(path);
        }
    }

    private class CheckBoxAction implements ActionListener {
        private Color color;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (color1.isSelected() && color2.isSelected() && color3.isSelected()) {
                color = c_night.darker();
            } else if (color1.isSelected() && color2.isSelected()) {
                color = new Color((c_day.getRGB() + c_evening.getRGB()) / 2);
            } else if (color2.isSelected() && color3.isSelected()) {
                color = new Color((c_evening.getRGB() + c_night.getRGB()) / 2);
            } else if (color1.isSelected() && color3.isSelected()) {
                color = new Color((c_morning.getRGB() + c_night.getRGB()) / 2);
            } else if (color1.isSelected()) {
                color = c_day;
            } else if (color2.isSelected()) {
                color = c_evening;
            } else if (color3.isSelected()) {
                color = c_night;
            } else if (!color1.isSelected() && !color2.isSelected() && !color3.isSelected()) {
                color = c_morning;
            }
            setBackground(color);
            panelNorth.setBackground(color);
            panelSouth.setBackground(color);
            panelWest.setBackground(color);
            panelEast.setBackground(color);
            color1.setBackground(color);
            color2.setBackground(color);
            color3.setBackground(color);
            button1.setBackground(color);
            button2.setBackground(color);
            button3.setBackground(color);
            button4.setBackground(color);
        }
    }

    private class RadioButtonAction implements ActionListener {
        private Color color;

        RadioButtonAction(Color color) {
            this.color = color.darker();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setForeground(color);
        }
    }
}

