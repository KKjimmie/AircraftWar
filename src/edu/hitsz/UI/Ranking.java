package edu.hitsz.UI;

import edu.hitsz.application.Settings;
import edu.hitsz.rank.RankDaoImpl;
import edu.hitsz.rank.RankLine;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

/**
 * 排行榜界面
 * @author 柯嘉铭
 */
public class Ranking{
    public JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JButton deleteButton;
    private JTextField gameModeField;
    private JTable rankTable;
    private JScrollPane tableScrollPanel;
    private JLabel diffLabel;

    public Ranking() {

        // 排行榜行列数据设置
        DefaultTableModel model = setModel();

        // 删除按钮实现
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 弹窗询问是否删除
                int option = JOptionPane.showConfirmDialog(null, "请确定是否删除选中的玩家？",
                        "请选择一个选项", JOptionPane.YES_NO_CANCEL_OPTION);
                if (option == 0){
                    int row = rankTable.getSelectedRow();
                    if(row != -1){
                        String time = String.valueOf(model.getValueAt(row, 3));
                        model.removeRow(row);
                        boolean a = removeFromData(time);
                        System.out.println(a);
                        DefaultTableModel model = setModel();
                    }
                }
            }
        });
        diffLabel.setText(Settings.getInstance().getDiff());
    }

    /**
     * 获取排行榜文件中数据
     * @return 排行榜中数据，储存在二维String数组
     */
    private String[][] getTableData() {
        var rankDaoImpl = new RankDaoImpl();
        List<RankLine> rankLists = null;
        try {
            rankLists = rankDaoImpl.getAllRankLists();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[][] tableData = new String[rankLists.size()][4];
        int i = 0;
        for (RankLine rankList : rankLists) {
            tableData[i][0] = Integer.toString(i+1);
            tableData[i][1] = rankList.getName();
            tableData[i][2] = rankList.getScore() + "";
            tableData[i][3] = rankList.getTime();
            i ++;
        }
        return tableData;
    }

    /**
     * 根据时间（时间具有唯一性），删除排行榜中数据
     * @param time 时间参数
     * @return 删除成功返回true，失败返回false
     */
    private boolean removeFromData(String time) {
        RankDaoImpl rankDaoImpl = new RankDaoImpl();
        try {
            return rankDaoImpl.deleteByTime(time);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private DefaultTableModel setModel(){
        String[] columName = {"名次", "玩家名", "得分", "记录时间"};
        String[][] tableData = getTableData();
        DefaultTableModel model = new DefaultTableModel(tableData, columName){
            @Override
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        rankTable.setModel(model);
        tableScrollPanel.setViewportView(rankTable);
        return model;
    }
}
