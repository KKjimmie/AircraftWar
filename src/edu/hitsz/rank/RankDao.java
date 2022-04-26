package edu.hitsz.rank;

import java.io.IOException;
import java.util.List;

/**
 * 数据操作DAO接口
 * @author 柯嘉铭
 */
public interface RankDao {
    /**
     * 根据玩家名查找对应数据
     * @param name 玩家名
     * @throws IOException IO异常
     */
    void findByName(String name) throws IOException;

    /**
     * 找到第一名，在控制台打印出来
     * @throws IOException IO异常
     */
    void findTop() throws IOException;

    /**
     * 读取文件中的排行榜
     * @return 具有排行榜信息的List
     * @throws IOException IO异常
     */
    List<RankLine> getAllRankLists() throws IOException;

    /**
     * 往排行榜中添加数据
     * @param rankList 一条排行数据
     * @throws IOException IO异常
     */
    void add(RankLine rankList) throws IOException;

    /**
     * 将列表中所有元素添加到文件中
     * @param rankLists 排行榜信息列表
     */
    void addAll(List<RankLine> rankLists) throws IOException;

    /**
     * 删除一行排行榜信息
     * @param rankLine 一行排行榜信息
     * @return 删除成功返回true，删除失败返回false
     */
    boolean remove(RankLine rankLine) throws IOException;

    /**
     * 根据玩家名删除对应数据
     * @param name 玩家名
     * @return 删除成功返回true，删除失败返回false
     * @throws IOException IO异常
     */
    boolean deleteByName(String name) throws IOException;


    /**
     * 排行榜排序
     * @throws IOException IO异常
     */
    void sort() throws IOException;

    /**
     * 根据日期删除数据
     * @return 成功返回1，不成功返回0
     */
    boolean deleteByTime(String time) throws IOException;

    /**
     * 清除文件原有内容，重写
     * @param rankLists
     */
    void rewrite(List<RankLine> rankLists) throws IOException;
}
