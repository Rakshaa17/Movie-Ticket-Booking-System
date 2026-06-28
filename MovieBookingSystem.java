import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

class Booking {

    int id, tickets, total;
    String name, movie, seatType, dateTime;

    Booking(int id, String name, String movie,
            String seatType, int tickets,
            int total, String dateTime) {

        this.id = id;
        this.name = name;
        this.movie = movie;
        this.seatType = seatType;
        this.tickets = tickets;
        this.total = total;
        this.dateTime = dateTime;
    }
}

public class MovieBookingSystem extends JFrame implements ActionListener {

    JTextField nameField, ticketField;
    JComboBox<String> movieBox;
    JRadioButton normalBtn, vipBtn;

    JTextArea outputArea;

    JButton bookBtn, clearBtn, viewBtn;

    ArrayList<Booking> bookings = new ArrayList<>();

    MovieBookingSystem() {

        setTitle("🎬 Movie Ticket Booking System");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color bgColor = new Color(18, 18, 18);
        Color panelColor = new Color(35, 35, 35);
        Color redColor = new Color(229, 9, 20);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(bgColor);

        JPanel titlePanel = new JPanel();

        titlePanel.setBackground(redColor);
        titlePanel.setPreferredSize(new Dimension(900, 80));

        JLabel title = new JLabel("🎬 MOVIE TICKET BOOKING SYSTEM");

        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 28));

        titlePanel.add(title);

        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 20, 20));

        centerPanel.setBackground(bgColor);
        centerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel formPanel = new JPanel();

        formPanel.setLayout(new GridLayout(10, 1, 10, 10));
        formPanel.setBackground(panelColor);

        formPanel.setBorder(
                new CompoundBorder(
                        new LineBorder(redColor, 2),
                        new EmptyBorder(20, 20, 20, 20)
                )
        );

        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font fieldFont = new Font("Arial", Font.PLAIN, 15);

        JLabel nameLabel = new JLabel("Customer Name");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(labelFont);

        nameField = new JTextField();
        nameField.setFont(fieldFont);

        JLabel movieLabel = new JLabel("Select Movie");
        movieLabel.setForeground(Color.WHITE);
        movieLabel.setFont(labelFont);

        String movies[] = {
            "KGF",
            "Kantara",
            "Leo",
            "Avengers",
            "Pushpa",
            "Interstellar"
        };

        movieBox = new JComboBox<>(movies);
        movieBox.setFont(fieldFont);

        JLabel ticketLabel = new JLabel("Number of Tickets");
        ticketLabel.setForeground(Color.WHITE);
        ticketLabel.setFont(labelFont);

        ticketField = new JTextField();
        ticketField.setFont(fieldFont);

        JLabel seatLabel = new JLabel("Seat Type");
        seatLabel.setForeground(Color.WHITE);
        seatLabel.setFont(labelFont);

        JPanel seatPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        seatPanel.setBackground(panelColor);

        normalBtn = new JRadioButton("Normal ₹100");
        vipBtn = new JRadioButton("VIP ₹200");

        normalBtn.setBackground(panelColor);
        vipBtn.setBackground(panelColor);

        normalBtn.setForeground(Color.WHITE);
        vipBtn.setForeground(Color.WHITE);

        normalBtn.setFont(fieldFont);
        vipBtn.setFont(fieldFont);

        ButtonGroup group = new ButtonGroup();

        group.add(normalBtn);
        group.add(vipBtn);

        seatPanel.add(normalBtn);
        seatPanel.add(vipBtn);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));

        buttonPanel.setBackground(panelColor);

        bookBtn = createButton("🎟 Book");
        clearBtn = createButton("🧹 Clear");
        viewBtn = createButton("📋 View");

        buttonPanel.add(bookBtn);
        buttonPanel.add(clearBtn);
        buttonPanel.add(viewBtn);

        formPanel.add(nameLabel);
        formPanel.add(nameField);

        formPanel.add(movieLabel);
        formPanel.add(movieBox);

        formPanel.add(ticketLabel);
        formPanel.add(ticketField);

        formPanel.add(seatLabel);
        formPanel.add(seatPanel);

        formPanel.add(new JLabel());
        formPanel.add(buttonPanel);

        JPanel outputPanel = new JPanel(new BorderLayout());

        outputPanel.setBackground(panelColor);

        outputPanel.setBorder(
                new CompoundBorder(
                        new LineBorder(redColor, 2),
                        new EmptyBorder(20, 20, 20, 20)
                )
        );

        JLabel outputTitle = new JLabel("📄 Booking Details");

        outputTitle.setForeground(Color.WHITE);
        outputTitle.setFont(new Font("Arial", Font.BOLD, 22));

        outputArea = new JTextArea();

        outputArea.setEditable(false);

        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 15));

        outputArea.setBackground(new Color(245, 245, 245));

        outputArea.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(outputArea);

        outputPanel.add(outputTitle, BorderLayout.NORTH);
        outputPanel.add(scrollPane, BorderLayout.CENTER);

        centerPanel.add(formPanel);
        centerPanel.add(outputPanel);

        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        add(mainPanel);

        bookBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        viewBtn.addActionListener(this);

        setVisible(true);
    }

    JButton createButton(String text) {

        JButton btn = new JButton(text);

        btn.setFont(new Font("Arial", Font.BOLD, 15));

        btn.setBackground(new Color(52, 152, 219));

        btn.setForeground(Color.WHITE);

        btn.setFocusPainted(false);

        btn.setBorder(new EmptyBorder(12, 20, 12, 20));

        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.setOpaque(true);

        btn.setBorderPainted(false);

        btn.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {

                btn.setBackground(new Color(41, 128, 185));
            }

            public void mouseExited(MouseEvent e) {

                btn.setBackground(new Color(52, 152, 219));
            }

            public void mousePressed(MouseEvent e) {

                btn.setBackground(new Color(21, 101, 192));
            }

            public void mouseReleased(MouseEvent e) {

                btn.setBackground(new Color(41, 128, 185));
            }
        });

        return btn;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bookBtn) {

            String name = nameField.getText().trim();

            String ticketText = ticketField.getText().trim();

            if (name.isEmpty() || ticketText.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all details!"
                );

                return;
            }

            if (!normalBtn.isSelected() && !vipBtn.isSelected()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select seat type!"
                );

                return;
            }

            int tickets;

            try {

                tickets = Integer.parseInt(ticketText);

                if (tickets <= 0) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Enter valid ticket count!"
                    );

                    return;
                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Tickets must be numbers only!"
                );

                return;
            }

            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Confirm Booking?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm != JOptionPane.YES_OPTION) {

                return;
            }

            String movie = (String) movieBox.getSelectedItem();

            String seatType;
            int price;

            if (normalBtn.isSelected()) {

                seatType = "Normal";
                price = 100;

            } else {

                seatType = "VIP";
                price = 200;
            }

            int total = tickets * price;

            String offer = "No Discount";

            if (tickets > 5) {

                int discount = total * 10 / 100;

                total = total - discount;

                offer = "10% Discount Applied";
            }

            int bookingId = (int) (Math.random() * 10000);

            String dateTime = LocalDateTime.now().toString();

            bookings.add(
                    new Booking(
                            bookingId,
                            name,
                            movie,
                            seatType,
                            tickets,
                            total,
                            dateTime
                    )
            );

            outputArea.setText("");

            outputArea.append(
                    "========================================\n"
            );

            outputArea.append(
                    "        🎬 BOOKING CONFIRMED 🎬\n"
            );

            outputArea.append(
                    "========================================\n\n"
            );

            outputArea.append(
                    "Booking ID : " + bookingId + "\n\n"
            );

            outputArea.append(
                    "Customer   : " + name + "\n"
            );

            outputArea.append(
                    "Movie      : " + movie + "\n"
            );

            outputArea.append(
                    "Seat Type  : " + seatType + "\n"
            );

            outputArea.append(
                    "Tickets    : " + tickets + "\n"
            );

            outputArea.append(
                    "Total      : ₹" + total + "\n"
            );

            outputArea.append(
                    "Offer      : " + offer + "\n\n"
            );

            outputArea.append(
                    "Date & Time\n"
            );

            outputArea.append(
                    dateTime + "\n\n"
            );

            outputArea.append(
                    "Enjoy Your Movie 🍿✨\n"
            );
        }

        if (e.getSource() == clearBtn) {

            nameField.setText("");

            ticketField.setText("");

            outputArea.setText("");
        }

        if (e.getSource() == viewBtn) {

            outputArea.setText(
                    "=========== ALL BOOKINGS ===========\n\n"
            );

            if (bookings.isEmpty()) {

                outputArea.append(
                        "No bookings available!"
                );

            } else {

                for (Booking b : bookings) {

                    outputArea.append(
                            "ID: " + b.id
                            + " | " + b.name
                            + " | " + b.movie
                            + " | " + b.seatType
                            + " | ₹" + b.total + "\n"
                    );
                }
            }
        }
    }

    public static void main(String[] args) {

        try {

            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );

        } catch (Exception e) {

            System.out.println(e);
        }

        new MovieBookingSystem();
    }
}
