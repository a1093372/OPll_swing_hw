import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

class myFrame extends JFrame {
    private JPanel basePanel;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    private JLabel lblCity;
    private JList<String> lst;
    private JTextArea txtShow;
    private static final String[] CITY = { "台北", "宜蘭", "桃園", "台中", "南投", "彰化", "高雄" };
    private static final String[] MOUNT = { "陽明山", "抹茶山", "拉拉山", "梨山", "合歡山", "八卦山", "柴山" };

    public myFrame() {

        // basePanel
        basePanel = new JPanel(new GridLayout(2, 1));

        // lblCity
        lblCity = new JLabel("找各地名山：");
        upperPanel = new JPanel(new FlowLayout());
        upperPanel.add(lblCity);

        // txtShow
        txtShow = new JTextArea("可選取地名...", 3, 8);
        JScrollPane lowerPanel = new JScrollPane(txtShow, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // lst
        lst = new JList<>(CITY);
        lst.setVisibleRowCount(4);
        lst.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String txt = "";
                for (int i : lst.getSelectedIndices()) {
                    txt += CITY[i] + " 名山： " + MOUNT[i] + "\n";
                    txtShow.setText(txt);
                }
            }
        });
        JScrollPane lstScrollPanel = new JScrollPane(lst, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        upperPanel.add(lstScrollPanel);

        // add subPanels to basePanel
        basePanel.add(upperPanel);
        basePanel.add(lowerPanel);

        // set frame props
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("各地名山");
        setContentPane(basePanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

public class W7_hw {
    public static void main(String[] args) 
    {
        new myFrame();
    }
}