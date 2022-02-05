package lesson_8_final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * -подобие чата, с реализацией переноса по словам, небольшим функционалом...
 * -тема не до конца понятна, поэтому tictactoy не стал реализовывать...
 * */
public class Chat_demo extends JFrame {

    public Chat_demo(){
        setBounds(200,100,550,610);
        setTitle("DEMO_chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        //Добавление txtArea (весь вывод) с прокруткой, переносом слов и табуляцией
        JTextArea output = new JTextArea("",20,40);
        output.setFont(new Font("Arial",Font.PLAIN,16));
        output.setTabSize(5);
        output.setLineWrap(true);//перенос слов
        output.setWrapStyleWord(true);//перенос слов
        output.setEditable(false); //делает поле не редактируемым

        //Добавление ввода txtArea
        JTextArea input = new JTextArea("",4,40);
        input.setFont(new Font("Arial",Font.PLAIN,16));
        input.setTabSize(5);
        input.setLineWrap(true);//перенос слов
        input.setWrapStyleWord(true);//перенос слов

        //группа кнопок
        JPanel btn = new JPanel();
        JButton send = new JButton("         Отправить         ");
        JRadioButton edit = new JRadioButton("edit");//разрешает редактирование output
        JRadioButton warning = new JRadioButton("warning");//блокировка кнопки clear
        JButton clear = new JButton("Очистить поле общего текста");
                clear.setBackground(Color.red);
                clear.setVisible(false);

        JTextArea help = new JTextArea("\"shift + enter\" - Отправить\n"
                +"\"edit\" - Редактировать поле вывода\n"
                +"\"warning\" - Очистка поля вывода");
        help.setEditable(false);
        help.setFont(new Font("Arial",Font.PLAIN,10));
        help.setBackground(Color.lightGray);

        input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_ENTER){
                    output.append("\n- " + String.valueOf(input.getText()));
                    input.setText("");
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.append("\n- " + String.valueOf(input.getText()));
                input.setText("");
                input.requestFocus();//запрос фокуса
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText("");
            }
        });
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(edit.isSelected())output.setEditable(true);
                else if (!edit.isSelected()) output.setEditable(false);
            }
        });
        warning.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(warning.isSelected())clear.setVisible(true);
                else if (!warning.isSelected()) clear.setVisible(false);
            }
        });

        btn.add(send);
        btn.add(edit);
        btn.add(warning);
        btn.add(clear);

        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contents.add(new JScrollPane(output));
        contents.add(help);
        contents.add(new JScrollPane(input));
        contents.add(btn);

        setContentPane(contents);
        setVisible(true);
    }
}
