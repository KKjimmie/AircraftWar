package edu.hitsz.rank;

import java.io.IOException;
import java.util.List;

/**
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
     * 根据玩家名删除对应数据
     * @param name 玩家名
     * @throws IOException IO异常
     */
    void deleteByName(String name) throws IOException;


    /**
     * 排行榜排序
     * @throws IOException IO异常
     */
    void sort() throws IOException;
}
