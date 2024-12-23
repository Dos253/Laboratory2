import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MainFrame extends JFrame
{
    // Установка ширины окна
    private static final int WIDTH = 400;

    // Установка высота окна
    private static final int HEIGHT = 400;

    // Текстовое поле для ввода переменной X
    private final JTextField textFieldX;

    // Текстовое поле для ввода переменной Y
    private final JTextField textFieldY;

    // Текстовое поле для ввода переменной Z
    private final JTextField textFieldZ;

    // Текстовое поле для вывода результата
    private final JTextField textFieldResult;


    // Создаём группу радиокнопок для выбора формулы
    private final ButtonGroup formulaRadioButtons = new ButtonGroup();

    // Горизонтальный контейнер для радиокнопок формул
    private final Box horizontalBoxFormulaType = Box.createHorizontalBox();

    // Идентификатор выбранной формулы по умолчанию 1
    private int formulaId = 1;



    // Создаём группу для радиокнопок переменных памяти
    private final ButtonGroup memoryRadioButtons = new ButtonGroup();

    // Создаём горизонтальный контейнер для радиокнопок памяти
    private final Box horizontalBoxMemoryType = Box.createHorizontalBox();

    // Идентификатор переменной выбранной переменной памяти по умолчанию 1
    private int memoryId = 1;



    // Переменные памяти
    private Double mem1 = 0.0;
    private Double mem2 = 0.0;
    private Double mem3 = 0.0;



    // Метод для расчёта первой формулы
    public static Double calculate1(Double x, Double y, Double z)
    {
        double a = Math.pow((Math.cos(Math.exp(y)) + Math.exp(y * y) + Math.sqrt(1 / x)), 0.25);
        double b = Math.pow(((Math.cos(Math.PI * Math.pow(z, 3))) + Math.log(1 + z) * Math.log(1 + z)), Math.sin(y));
        return a / b;
    }

    // Метод для расчёта второй формулы
    public static Double calculate2(Double x, Double y, Double z)
    {
        double c = Math.pow((1 + x * x), (1 / y));
        double d = Math.exp(Math.sin(z) + x);
        return c / d;
    }



    // Метод для добавления радиокнопок для выбора формулы
    private void addFormulaRadioButton(String buttonName, final int formulaId)
    {
        JRadioButton button = new JRadioButton(buttonName); // Создание радиокнопки
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                MainFrame.this.formulaId = formulaId; // Установка идентификатора выбранной формулы
            }
        });
        formulaRadioButtons.add(button); // Добавление кнопки в группу
        horizontalBoxFormulaType.add(button); // Добавление кнопки в горизонтальный контейнер
    }


    // Метод для добавления радиокнопок для выбора переменной памяти
    private void addMemoryRadioButton(String buttonName, final int memoryId)
    {
        JRadioButton button = new JRadioButton(buttonName); // Создание радиокнопки
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                MainFrame.this.memoryId = memoryId; // Установка идентификатора выбранной переменной памяти
            }
        });
        memoryRadioButtons.add(button); // Добавление кнопки в группу
        horizontalBoxMemoryType.add(button); // Добавление кнопки в горизонтальный контейнер
    }


    // Конструктор для MainFrame
    public MainFrame()
    {
        super("Вычисление формулы"); // Установка заголовка окна

        setSize(WIDTH, HEIGHT); // Установка размера окна

        Toolkit kit = Toolkit.getDefaultToolkit(); // Получение стандартного инструментария

        setLocation((kit.getScreenSize().width - WIDTH) / 2,
                (kit.getScreenSize().height - HEIGHT) / 2); // Центрирование окна

        // Горизонтальный контейнер для выбора формулы
        horizontalBoxFormulaType.add(Box.createHorizontalGlue()); // Добавление пространства

        addFormulaRadioButton("Формула 1", 1); // Добавление первой опции формулы

        addFormulaRadioButton("Формула 2", 2); // Добавление второй опции формулы
        formulaRadioButtons.setSelected(
                formulaRadioButtons.getElements().nextElement().getModel(), true); // Установка выбора по умолчанию
        horizontalBoxFormulaType.add(Box.createHorizontalGlue()); // Добавление пространства
        horizontalBoxFormulaType.setBorder(
                BorderFactory.createLineBorder(Color.YELLOW)); // Установка цвета границы


        // Метки и текстовые поля для ввода пользователем
        JLabel labelForX = new JLabel("X:");
        textFieldX = new JTextField("0", 10);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize()); // Установка максимального размера
        JLabel labelForY = new JLabel("Y:");
        textFieldY = new JTextField("0", 10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize()); // Установка максимального размера
        JLabel labelForZ = new JLabel("Z:");
        textFieldZ = new JTextField("0", 10);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize()); // Установка максимального размера


        // Горизонтальный контейнер для ввода переменных
        Box horizontalBoxVariables = Box.createHorizontalBox();
        horizontalBoxVariables.setBorder(
                BorderFactory.createLineBorder(Color.RED)); // Установка цвета границы
        horizontalBoxVariables.add(Box.createHorizontalGlue()); // Добавление пространства
        horizontalBoxVariables.add(labelForX);
        horizontalBoxVariables.add(Box.createHorizontalStrut(10)); // Добавление отступа
        horizontalBoxVariables.add(textFieldX);
        horizontalBoxVariables.add(Box.createHorizontalStrut(10)); // Добавление отступа
        horizontalBoxVariables.add(labelForY);
        horizontalBoxVariables.add(Box.createHorizontalStrut(10)); // Добавление отступа
        horizontalBoxVariables.add(textFieldY);
        horizontalBoxVariables.add(Box.createHorizontalStrut(10)); // Добавление отступа
        horizontalBoxVariables.add(labelForZ);
        horizontalBoxVariables.add(Box.createHorizontalStrut(10)); // Добавление отступа
        horizontalBoxVariables.add(textFieldZ);
        horizontalBoxVariables.add(Box.createHorizontalGlue()); // Добавление пространства


        // Метка и текстовое поле для вывода результата
        JLabel labelForResult = new JLabel("Результат:");
        textFieldResult = new JTextField("0", 10);
        textFieldResult.setMaximumSize(
                textFieldResult.getPreferredSize()); // Установка максимального результата
        Box horizontalBoxResult = Box.createHorizontalBox();
        horizontalBoxResult.add(Box.createHorizontalGlue()); // Добавление пространства
        horizontalBoxResult.add(labelForResult);
        horizontalBoxResult.add(Box.createHorizontalStrut(10)); // Добавление отступа
        horizontalBoxResult.add(textFieldResult);
        horizontalBoxResult.add(Box.createHorizontalGlue()); // Добавление пространства
        horizontalBoxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE)); // Установка цвета границы


        // Кнопка для вычисления результата
        JButton buttonCalc = getjButton();


        // Кнопка для сброса полей ввода
        JButton buttonReset = new JButton("Очистить поля");
        buttonReset.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                // Сброс всех текстовых полей на "0"
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
                textFieldResult.setText("0");
            }
        });


        // Кнопка для очистки памяти
        JButton buttonMC = new JButton("MC");
        buttonMC.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                // Очистка выбранной переменной памяти
                if (memoryId == 1) mem1 = 0.0;
                if (memoryId == 2) mem2 = 0.0;
                if (memoryId == 3) mem3 = 0.0;
            }
        });


        // Кнопка для добавления результата в память
        JButton buttonMPlus = getButton();

        //Создание горизонтального контейнера для кнопок
        Box horizontalBoxButtons = Box.createHorizontalBox();

        // Добавление пространства для выранивания
        horizontalBoxButtons.add(Box.createHorizontalGlue());

        // Добавление кнопки вычисления
        horizontalBoxButtons.add(buttonCalc);

        // Добавление отступа
        horizontalBoxButtons.add(Box.createHorizontalStrut(30));

        // Добавление кнопки сброса
        horizontalBoxButtons.add(buttonReset);

        // Добавление отступа
        horizontalBoxButtons.add(Box.createHorizontalStrut(30));

        // Добавление кнопки очистки памяти
        horizontalBoxButtons.add(buttonMC);

        //Добавление отступа
        horizontalBoxButtons.add(Box.createHorizontalStrut(30));

        // Добавление кнопки добавления в память
        horizontalBoxButtons.add(buttonMPlus);

        // Добавление пространства для выравнивания
        horizontalBoxButtons.add(Box.createHorizontalGlue());

        //  Установка границы для контейнера кнопок
        horizontalBoxButtons.setBorder(
                BorderFactory.createLineBorder(Color.GREEN)); // Установка цвета границы

        horizontalBoxMemoryType.add(Box.createHorizontalGlue()); // Добавление пространства для выравнивания

        addMemoryRadioButton("Переменная 1", 1); // Добавление радиокнопки для первой переменной памяти

        addMemoryRadioButton("Переменная 2", 2); // Добавление радиокнопки для второй переменной памяти

        addMemoryRadioButton("Переменная 3", 3); // Добавление радиокнопки для третьей переменной памяти

        memoryRadioButtons.setSelected( // Установка выбора по умолчанию
                memoryRadioButtons.getElements().nextElement().getModel(), true); // Установка модели первой радиокнопки как выбранной

        horizontalBoxMemoryType.add(Box.createHorizontalGlue()); // Добавление пространства для выравнивания
        horizontalBoxMemoryType.setBorder( // Установка границы для контейнера переменных памяти

                BorderFactory.createLineBorder(Color.MAGENTA));// Установка цвета границы

        // Создание вертикального контейнера
        Box contentBox = Box.createVerticalBox();

        // Добавление пространства для выравнивания
        contentBox.add(Box.createVerticalGlue());

        // Добавление контейнера выбора формул
        contentBox.add(horizontalBoxFormulaType);

        // Добавление контейнера ввода переменных
        contentBox.add(horizontalBoxVariables);

        // Добавение контейнера вывода результата
        contentBox.add(horizontalBoxResult);

        // Добавление контейнера кнопок
        contentBox.add(horizontalBoxButtons);

        // Добавление контейнера выбора памяти
        contentBox.add(horizontalBoxMemoryType);

        // Добавление пространства для выравнивания
        contentBox.add(Box.createVerticalGlue());

        // Установка основного содержимого по центру
        getContentPane().add(contentBox, BorderLayout.CENTER);
    }

    private JButton getButton() {
        JButton buttonMPlus = new JButton("M+");
        buttonMPlus.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                try // Обработка исключений
                {
                    // Получение результата из текстового поля
                    double result = Double.parseDouble(textFieldResult.getText());

                    // Обновление выбранной переменной памяти
                    if (memoryId == 1) mem1 += result;
                    if (memoryId == 2) mem2 += result;
                    if (memoryId == 3) mem3 += result;

                    // Отображение обновленного значения памяти в поле результата
                    textFieldResult.setText(memoryId == 1 ? mem1.toString() :
                            memoryId == 2 ? mem2.toString() : mem3.toString());
                }
                catch (NumberFormatException ex) // Обработка исключений неверного формата об ошибке
                {
                    // Обработка неверного формата числа
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        return buttonMPlus;
    }

    private JButton getjButton() {
        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                try
                {
                    // Парсинг введенных значений
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldZ.getText());
                    Double result;
                    // Выполнение расчёта в зависимости от выбранной формулы
                    if (formulaId == 1)
                        result = calculate1(x, y, z);
                    else
                        result = calculate2(x, y, z);
                    textFieldResult.setText(result.toString()); // Отображение результата
                }
                catch (NumberFormatException ex)
                {
                    // Обработка неверного формата числа
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        return buttonCalc;
    }

    public static void main(String[] args)
    {
        // Создание экземпляра MainFrame
        MainFrame frame = new MainFrame();

        // Установка действия при закрытии окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Отображение окна
        frame.setVisible(true);
    }
}